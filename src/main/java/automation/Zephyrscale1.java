package automation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Zephyrscale1 {

	private static final String BASE_URL = "https://api.zephyrscale.smartbear.com/v2/";
    private static final String API_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb250ZXh0Ijp7ImJhc2VVcmwiOiJodHRwczovL2FraGlsZ3VudGhvanUxMjMuYXRsYXNzaWFuLm5ldCIsInVzZXIiOnsiYWNjb3VudElkIjoiNjM1ZjZlMWZhMDRlOTA2MjUwYzhhNTU2IiwidG9rZW5JZCI6IjU0MzBkZmEwLTEzNGMtNDhkZC04MzhmLTIwNDU1NjFkODNiYSJ9fSwiaXNzIjoiY29tLmthbm9haC50ZXN0LW1hbmFnZXIiLCJzdWIiOiJhMmZkZmMwNy1jN2FmLTNkMDAtYWFhMy0zZGQzM2Y2ODYzNGEiLCJleHAiOjE3NzQ2MDMyNjcsImlhdCI6MTc0MzA2NzI2N30.TndCmcHqSNkXfm19XTWZLUesyATAn3PCUH5xtxhFBxU";
    private static final String EXECUTED_BY_ID = "635f6e1fa04e906250c8a556";
    private static final int ENVIRONMENT_ID = 8256224;
    private static final String TEST_CYCLE_KEY = "AAT-R4";

    public static String getExecutionId(String testCaseKey) {
        try {
            int startAt = 0;
            int maxResults = 200;

            while (true) {
                String urlStr = BASE_URL + "testexecutions?testCycleKey=" + TEST_CYCLE_KEY +
                                "&projectKey=AAT&startAt=" + startAt + "&maxResults=" + maxResults;
                URL url = new URL(urlStr);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Authorization", "Bearer " + API_TOKEN);
                connection.setRequestProperty("Content-Type", "application/json");

                int responseCode = connection.getResponseCode();
                System.out.println("Fetching executions - URL: " + urlStr + ", Response Code: " + responseCode);

                if (responseCode == 200) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();

                    String responseString = response.toString();
                    // System.out.println("API Response: " + responseString); // Uncomment for full response

                    // Find the "values" array
                    int valuesStart = responseString.indexOf("\"values\":");
                    if (valuesStart == -1) {
                        System.out.println("No 'values' array found in response");
                        return null;
                    }
                    int arrayStart = responseString.indexOf("[", valuesStart);
                    int arrayEnd = responseString.lastIndexOf("]");

                    if (arrayStart == -1 || arrayEnd == -1) {
                        System.out.println("Invalid 'values' array structure");
                        return null;
                    }

                    String valuesContent = responseString.substring(arrayStart + 1, arrayEnd);
                    int searchIndex = 0;

                    // Search for test case within "values"
                    String testCaseSearch = "\"testCase\":{\"self\":\"https://api.zephyrscale.smartbear.com/v2/testcases/" + testCaseKey + "/versions/";
                    while (searchIndex < valuesContent.length()) {
                        int testCaseIndex = valuesContent.indexOf(testCaseSearch, searchIndex);
                        if (testCaseIndex == -1) {
                            break; // No more occurrences
                        }

                        // Backtrack to find the start of this execution object
                        int braceCount = 0;
                        int objectStart = testCaseIndex;
                        while (objectStart >= 0) {
                            char c = valuesContent.charAt(objectStart);
                            if (c == '}') {
                                braceCount++;
                            } else if (c == '{') {
                                braceCount--;
                                if (braceCount == 0) {
                                    System.out.println("Execution object start found at index: " + (arrayStart + 1 + objectStart));
                                    break;
                                }
                            }
                            objectStart--;
                        }

                        if (objectStart < 0) {
                            System.out.println("Could not find execution object start for " + testCaseKey);
                            searchIndex = testCaseIndex + 1;
                            continue;
                        }

                        // Find the first "id" after objectStart
                        int idStart = valuesContent.indexOf("\"id\":", objectStart);
                        if (idStart != -1 && idStart < testCaseIndex) {
                            int valueStart = idStart + 5; // Skip past "id":
                            int valueEnd = valuesContent.indexOf(",", valueStart);
                            if (valueEnd == -1 || valueEnd > valuesContent.indexOf("}", testCaseIndex)) {
                                valueEnd = valuesContent.indexOf("}", valueStart);
                            }
                            String executionId = valuesContent.substring(valueStart, valueEnd).trim();
                            System.out.println("Extracted ID: " + executionId);

                            // Validate it's a 10-digit execution ID
                            if (executionId.matches("\\d{10}")) {
                                System.out.println("Found executionId: " + executionId + " for " + testCaseKey);
                                return executionId;
                            } else {
                                System.out.println("Extracted ID " + executionId + " is not a 10-digit execution ID");
                            }
                        }
                        searchIndex = testCaseIndex + 1; // Move to next potential match
                    }

                    // Check for pagination
                    if (responseString.contains("\"isLast\":true")) {
                        System.out.println("No more pages or test case not found.");
                        break;
                    }
                    startAt += maxResults;
                } else {
                    BufferedReader errorReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                    StringBuilder errorResponse = new StringBuilder();
                    String line;
                    while ((line = errorReader.readLine()) != null) {
                        errorResponse.append(line);
                    }
                    errorReader.close();
                    System.out.println("Failed to fetch execution ID. Response Code: " + responseCode + ", Error: " + errorResponse.toString());
                    break;
                }
                connection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateTestExecution(String testCaseKey, String status) {
        String executionId = getExecutionId(testCaseKey);
        System.out.println("Execution ID for " + testCaseKey + ": " + executionId);
        if (executionId == null) {
            System.out.println("Execution ID not found for test case: " + testCaseKey);
            return;
        }

        try {
            URL url = new URL(BASE_URL + "testexecutions/" + executionId);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Authorization", "Bearer " + API_TOKEN);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String jsonPayload = "{ \"statusName\": \"" + status + "\", \"executedById\": \"" + EXECUTED_BY_ID + "\", \"environmentId\": " + ENVIRONMENT_ID + " }";
            System.out.println("Sending payload: " + jsonPayload);

            try (OutputStream os = connection.getOutputStream()) {
                os.write(jsonPayload.getBytes());
                os.flush();
            }

            int responseCode = connection.getResponseCode();
            System.out.println("Update Response Code: " + responseCode);

            if (responseCode == 200 || responseCode == 201) {
                System.out.println("Test result updated successfully for: " + testCaseKey);
            } else {
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                StringBuilder errorResponse = new StringBuilder();
                String line;
                while ((line = errorReader.readLine()) != null) {
                    errorResponse.append(line);
                }
                errorReader.close();
                System.out.println("Failed to update test result. Response Code: " + responseCode + ", Error: " + errorResponse.toString());
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        updateTestExecution("AAT-T139", "Pass");
    }
    
}
