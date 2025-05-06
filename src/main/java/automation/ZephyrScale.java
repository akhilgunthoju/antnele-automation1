package automation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZephyrScale {
	
//	public static void updateTestExecution(String testCaseKey, String status) {
//        String apiUrl = "https://api.zephyrscale.smartbear.com/v2/testexecutions";
//        String apiToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb250ZXh0Ijp7ImJhc2VVcmwiOiJodHRwczovL2FraGlsZ3VudGhvanUxMjMuYXRsYXNzaWFuLm5ldCIsInVzZXIiOnsiYWNjb3VudElkIjoiNjM1ZjZlMWZhMDRlOTA2MjUwYzhhNTU2IiwidG9rZW5JZCI6IjU0MzBkZmEwLTEzNGMtNDhkZC04MzhmLTIwNDU1NjFkODNiYSJ9fSwiaXNzIjoiY29tLmthbm9haC50ZXN0LW1hbmFnZXIiLCJzdWIiOiJhMmZkZmMwNy1jN2FmLTNkMDAtYWFhMy0zZGQzM2Y2ODYzNGEiLCJleHAiOjE3NzQ2MDMyNjcsImlhdCI6MTc0MzA2NzI2N30.TndCmcHqSNkXfm19XTWZLUesyATAn3PCUH5xtxhFBxU"; // Replace with your API token
//
//        try {
//            URL url = new URL(apiUrl);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("POST");
//            connection.setRequestProperty("Authorization", "Bearer " + apiToken);
//            connection.setRequestProperty("Content-Type", "application/json");
//            connection.setDoOutput(true);
//
//            // JSON Payload
//            String jsonPayload = "{ \"testCaseKey\": \"" + testCaseKey + "\", \"status\": \"" + status + "\" }";
//
//            try (OutputStream os = connection.getOutputStream()) {
//                os.write(jsonPayload.getBytes());
//                os.flush();
//            }
//
//            int responseCode = connection.getResponseCode();
//            System.out.println("Response Code: " + responseCode);
//
//            if (responseCode == 200 || responseCode == 201) {
//                System.out.println("Test result updated successfully for: " + testCaseKey);
//            } else {
//                System.out.println("Failed to update test result. Response Code: " + responseCode);
//            }
//
//            connection.disconnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
		
		private static final String BASE_URL = "https://api.zephyrscale.smartbear.com/v2/";
	    private static final String API_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb250ZXh0Ijp7ImJhc2VVcmwiOiJodHRwczovL2FraGlsZ3VudGhvanUxMjMuYXRsYXNzaWFuLm5ldCIsInVzZXIiOnsiYWNjb3VudElkIjoiNjM1ZjZlMWZhMDRlOTA2MjUwYzhhNTU2IiwidG9rZW5JZCI6IjU0MzBkZmEwLTEzNGMtNDhkZC04MzhmLTIwNDU1NjFkODNiYSJ9fSwiaXNzIjoiY29tLmthbm9haC50ZXN0LW1hbmFnZXIiLCJzdWIiOiJhMmZkZmMwNy1jN2FmLTNkMDAtYWFhMy0zZGQzM2Y2ODYzNGEiLCJleHAiOjE3NzQ2MDMyNjcsImlhdCI6MTc0MzA2NzI2N30.TndCmcHqSNkXfm19XTWZLUesyATAn3PCUH5xtxhFBxU"; // Replace with your actual API token
	    private static final String EXECUTED_BY_ID = "635f6e1fa04e906250c8a556"; // Static executedById
	    private static final int ENVIRONMENT_ID = 8256224; // Static environmentId
	    private static final String TEST_CYCLE_KEY = "AAT-R4";
	    private static final String PROJECT_KEY = "AAT";

	    // Fetch test execution ID
//	    public static String getExecutionId(String testCaseKey) {
//	        try {
//	            //URL url = new URL(BASE_URL + "testexecutions?testCaseKey=" + testCaseKey);
//	        	URL url = new URL(BASE_URL + "testexecutions?projectKey=AAT&maxResults=200");
//	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//	            connection.setRequestMethod("GET");
//	            connection.setRequestProperty("Authorization", "Bearer " + API_TOKEN);
//	            connection.setRequestProperty("Content-Type", "application/json");
//
//	            int responseCode = connection.getResponseCode();
//	            if (responseCode == 200) {
//	                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//	                StringBuilder response = new StringBuilder();
//	                String line;
//	                while ((line = reader.readLine()) != null) {
//	                    response.append(line);
//	                }
//	                reader.close();
//
//	                // Extract executionId (assuming first execution found)
//	                String responseBody = response.toString();
//	                String executionId = extractExecutionId(responseBody);
//	                return executionId;
//	            } else {
//	                System.out.println("Failed to fetch execution ID. Response Code: " + responseCode);
//	            }
//	            connection.disconnect();
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	        return null;
//	    }
	    
//	    public static String getExecutionId(String testCaseKey) {
//	        try {
//	            int startAt = 50;
//	            int maxResults = 200; // Increase if needed
//	            String executionId = null;
//
//	            while (true) {
//	                String urlStr = BASE_URL + "testexecutions?testCycleKey=" + TEST_CYCLE_KEY + 
//	                                "&projectKey=AAT" + "&startAt=" + startAt + "&maxResults=" + maxResults;
//	                URL url = new URL(urlStr);
//	                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//	                connection.setRequestMethod("GET");
//	                connection.setRequestProperty("Authorization", "Bearer " + API_TOKEN);
//	                connection.setRequestProperty("Content-Type", "application/json");
//
//	                int responseCode = connection.getResponseCode();
//	                if (responseCode == 200) {
//	                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//	                    StringBuilder response = new StringBuilder();
//	                    String line;
//	                    while ((line = reader.readLine()) != null) {
//	                        response.append(line);
//	                    }
//	                    reader.close();
//
//	                    // Extract test execution ID manually
//	                    String responseString = response.toString();
//	                    if (responseString.contains(testCaseKey)) {
//	                        int index = responseString.indexOf("\"id\":"); // Locate "id" field
//	                        if (index != -1) {
//	                            int start = index + 5; // Move past "id": characters
//	                            int end = responseString.indexOf(",", start); // Find the next comma
//	                            executionId = responseString.substring(start, end).trim();
//	                            return executionId; // Return execution ID when found
//	                        }
//	                    }
//	                    
//	                    // If no execution found, check if more pages exist
//	                    if (responseString.length() < maxResults) {
//	                        break; // No more pages, exit loop
//	                    }
//
//	                    startAt += maxResults; // Go to next page
//	                } else {
//	                    System.out.println("Failed to fetch execution ID. Response Code: " + responseCode);
//	                    break;
//	                }
//	                connection.disconnect();
//	            }
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	        return null;
//	    }
	    
//	    public static String getExecutionId(String testCaseKey) {
//	        try {
//	            int startAt = 0;
//	            int maxResults = 200;
//
//	            while (true) {
//	                String urlStr = BASE_URL + "testexecutions?testCycleKey=" + TEST_CYCLE_KEY +
//	                                "&projectKey=AAT&startAt=" + startAt + "&maxResults=" + maxResults;
//	                URL url = new URL(urlStr);
//	                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//	                connection.setRequestMethod("GET");
//	                connection.setRequestProperty("Authorization", "Bearer " + API_TOKEN);
//	                connection.setRequestProperty("Content-Type", "application/json");
//
//	                int responseCode = connection.getResponseCode();
//	                System.out.println("Fetching executions - URL: " + urlStr + ", Response Code: " + responseCode);
//
//	                if (responseCode == 200) {
//	                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//	                    StringBuilder response = new StringBuilder();
//	                    String line;
//	                    while ((line = reader.readLine()) != null) {
//	                        response.append(line);
//	                    }
//	                    reader.close();
//
//	                    String responseString = response.toString();
//	                    System.out.println("API Response: " + responseString); // Log for debugging
//
//	                    // Find the "values" array
//	                    int valuesStart = responseString.indexOf("\"values\":");
//	                    if (valuesStart == -1) {
//	                        System.out.println("No 'values' array found in response");
//	                        break;
//	                    }
//
//	                    // Look for the testCase URL containing the testCaseKey
//	                    String testCaseSearch = "\"testCase\":{\"self\":\"https://api.zephyrscale.smartbear.com/v2/testcases/" + testCaseKey + "/versions/";
//	                    int testCaseIndex = responseString.indexOf(testCaseSearch, valuesStart);
//	                    if (testCaseIndex != -1) {
//	                        // Find the "id" field before the testCase (in the same object)
//	                        int idStart = responseString.lastIndexOf("\"id\":", testCaseIndex);
//	                        if (idStart != -1 && idStart > valuesStart) {
//	                            int valueStart = idStart + 5; // Skip past "id":
//	                            int valueEnd = responseString.indexOf(",", valueStart);
//	                            if (valueEnd == -1 || valueEnd > responseString.indexOf("}", testCaseIndex)) {
//	                                valueEnd = responseString.indexOf("}", valueStart);
//	                            }
//	                            String executionId = responseString.substring(valueStart, valueEnd).trim();
//	                            System.out.println("Found executionId: " + executionId + " for " + testCaseKey);
//	                            return executionId;
//	                        } else {
//	                            System.out.println("No 'id' field found for " + testCaseKey);
//	                        }
//	                    } else {
//	                        System.out.println("Test case " + testCaseKey + " not found in this page");
//	                    }
//
//	                    // Check for pagination
//	                    if (!responseString.contains("\"hasNext\":true") || responseString.contains("\"total\":0")) {
//	                        System.out.println("No more pages or no results found.");
//	                        break;
//	                    }
//	                    startAt += maxResults;
//	                } else {
//	                    BufferedReader errorReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
//	                    StringBuilder errorResponse = new StringBuilder();
//	                    String line;
//	                    while ((line = errorReader.readLine()) != null) {
//	                        errorResponse.append(line);
//	                    }
//	                    errorReader.close();
//	                    System.out.println("Failed to fetch execution ID. Response Code: " + responseCode + ", Error: " + errorResponse.toString());
//	                    break;
//	                }
//	                connection.disconnect();
//	            }
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	        return null;
//	    }
	    
	    //AAT-E13 shown code
	    
	    
//	    public static String getExecutionKey(String testCaseId) {
//	        try {
//	            String urlStr = "https://api.zephyrscale.smartbear.com/v2/testexecutions?projectKey=AAT&maxResults=200";
//	            URL url = new URL(urlStr);
//	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//	            connection.setRequestMethod("GET");
//	            connection.setRequestProperty("Authorization", "Bearer " + API_TOKEN);
//	            connection.setRequestProperty("Content-Type", "application/json");
//
//	            // Read API Response
//	            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//	            StringBuilder response = new StringBuilder();
//	            String line;
//	            while ((line = reader.readLine()) != null) {
//	                response.append(line);
//	            }
//	            reader.close();
//
//	            // ✅ Print full API response for debugging
//	            System.out.println("🔍 API Response: " + response.toString());
//
//	            // ✅ Search for execution key
//	            String responseBody = response.toString();
//	            Pattern pattern = Pattern.compile("\"key\":\\s*\"(AAT-E\\d+)\".*?\"testCase\":\\s*\\{\"self\":\\s*\"https://api.zephyrscale.smartbear.com/v2/testcases/" + testCaseId);
//	            Matcher matcher = pattern.matcher(responseBody);
//	            
//	            if (matcher.find()) {
//	                return matcher.group(1);  // ✅ Return Execution Key
//	            } else {
//	                System.out.println("❌ Execution Key not found for test case: " + testCaseId);
//	                return null;
//	            }
//
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            return null;
//	        }
//	    }
	    
	    public static String getExecutionKey(String testCaseId) {
	        try {
	            // ✅ Step 1: Fetch test executions
	            String urlStr = "https://api.zephyrscale.smartbear.com/v2/testexecutions?projectKey=AAT&maxResults=200";
	            URL url = new URL(urlStr);
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");
	            connection.setRequestProperty("Authorization", "Bearer " + API_TOKEN);
	            connection.setRequestProperty("Content-Type", "application/json");

	            // ✅ Step 2: Read API response
	            int responseCode = connection.getResponseCode();
	            if (responseCode != 200) {
	                System.out.println("❌ Failed to fetch test executions. Response Code: " + responseCode);
	                return null;
	            }

	            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
	            StringBuilder response = new StringBuilder();
	            String responseLine;
	            while ((responseLine = br.readLine()) != null) {
	                response.append(responseLine.trim());
	            }
	            br.close();

	            // ✅ Step 3: Convert response to string
	            String jsonResponse = response.toString();

	            // ✅ Step 4: Extract Execution Key for the Given Test Case ID
	            String[] executions = jsonResponse.split("\\},\\{");  // Splitting JSON array manually
	            for (String execution : executions) {
	                if (execution.contains("\"testCase\":") && execution.contains(testCaseId)) {  
	                    // Extract Execution Key (AAT-EXX)
	                    String executionKey = execution.split("\"key\":\"")[1].split("\"")[0];

	                    System.out.println("🔹 Found Execution Key for Test Case " + testCaseId + ": " + executionKey);
	                    return executionKey;
	                }
	            }

	            System.out.println("❌ Execution Key not found for test case: " + testCaseId);
	            return null;

	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    
	    // Update test execution status
//	    public static void updateTestExecution1(String testCaseKey, String status) {
//	        String executionId = getExecutionId(testCaseKey);
//	        System.out.println(executionId);
//	        if (executionId == null) {
//	            System.out.println("Execution ID not found for test case: " + testCaseKey);
//	            return;
//	        }
//
//	        try {
//	            URL url = new URL(BASE_URL + "testexecutions/" + executionId);
//	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//	            connection.setRequestMethod("PUT");
//	            connection.setRequestProperty("Authorization", "Bearer " + API_TOKEN);
//	            connection.setRequestProperty("Content-Type", "application/json");
//	            connection.setDoOutput(true);
//
//	            // JSON Payload
//	            String jsonPayload = "{ \"statusName\": \"" + status + "\", \"executedById\": \"" + EXECUTED_BY_ID + "\", \"environmentId\": " + ENVIRONMENT_ID + " }";
//
//	            try (OutputStream os = connection.getOutputStream()) {
//	                os.write(jsonPayload.getBytes());
//	                os.flush();
//	            }
//
//	            int responseCode = connection.getResponseCode();
//	            System.out.println("Response Code: " + responseCode);
//
//	            if (responseCode == 200 || responseCode == 201) {
//	                System.out.println("Test result updated successfully for: " + testCaseKey);
//	            } else {
//	                System.out.println("Failed to update test result. Response Code: " + responseCode);
//	            }
//
//	            connection.disconnect();
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	    }
	    
	   
//	    public static void updateTestExecutionStatus(String testCaseId, String status) {
//	        try {
//	            // ✅ Step 1: Get Execution Key
//	            String executionKey = getExecutionKey(testCaseId);
//	            System.out.println(executionKey);
//	            
//	            if (executionKey == null) {
//	                System.out.println("❌ Execution Key not found for test case: " + testCaseId);
//	                return;
//	            }
//
//	            // ✅ Step 2: Send POST request to update status
//	            String urlStr = "https://api.zephyrscale.smartbear.com/v2/testexecutions/" + executionKey;
//	            URL url = new URL(urlStr);
//	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//	            connection.setRequestMethod("PUT");  // ✅ Use PUT instead of POST for update
//	            connection.setRequestProperty("Authorization", "Bearer " + API_TOKEN);
//	            connection.setRequestProperty("Content-Type", "application/json");
//	            connection.setDoOutput(true);
//
//	            // ✅ JSON request body
//	            String jsonInputString = "{"
//	                    + "\"statusName\": \"" + status + "\","
//	                    + "\"executedById\": \"635f6e1fa04e906250c8a556\","
//	                    + "\"environmentId\": 8256224"
//	                    + "}";
//
//	            try (OutputStream os = connection.getOutputStream()) {
//	                byte[] input = jsonInputString.getBytes("utf-8");
//	                os.write(input, 0, input.length);
//	            }
//
//	            // ✅ Step 3: Read response
//	            int responseCode = connection.getResponseCode();
//	            System.out.println("📢 Update Status Response Code: " + responseCode);
//
//	            if (responseCode == 200) {
//	                System.out.println("✅ Test case " + testCaseId + " updated successfully with status: " + status);
//	            } else {
//	                System.out.println("❌ Failed to update test case: " + testCaseId);
//	            }
//
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	    }
//	    
	    public static void updateTestExecutionStatus(String testCaseId, String status) {
	        try {
	            // ✅ Step 1: Get Execution Key for the Given Test Case
	            String executionKey = getExecutionKey(testCaseId);
	            
	            if (executionKey == null) {
	                System.out.println("❌ Execution Key not found for test case: " + testCaseId);
	                return;
	            }

	            // ✅ Step 2: Send PUT request to update status
	            String urlStr = "https://api.zephyrscale.smartbear.com/v2/testexecutions/" + executionKey;
	            URL url = new URL(urlStr);
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("PUT");
	            connection.setRequestProperty("Authorization", "Bearer " + API_TOKEN);
	            connection.setRequestProperty("Content-Type", "application/json");
	            connection.setDoOutput(true);

	            // ✅ JSON request body
	            String jsonInputString = "{"
	                    + "\"statusName\": \"" + status + "\","
	                    + "\"executedById\": \"635f6e1fa04e906250c8a556\","
	                    + "\"environmentId\": 8256224"
	                    + "}";

	            try (OutputStream os = connection.getOutputStream()) {
	                byte[] input = jsonInputString.getBytes("utf-8");
	                os.write(input, 0, input.length);
	            }

	            // ✅ Step 3: Read Response
	            int responseCode = connection.getResponseCode();
	            System.out.println("📢 Update Status Response Code: " + responseCode);

	            if (responseCode == 200) {
	                System.out.println("✅ Test case " + testCaseId + " updated successfully with status: " + status);
	            } else {
	                System.out.println("❌ Failed to update test case: " + testCaseId);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    // Helper method to extract executionId from API response
	    private static String extractExecutionId(String responseBody) {
	        try {
	            int index = responseBody.indexOf("\"id\":");
	            if (index != -1) {
	                int start = index + 5;
	                int end = responseBody.indexOf(",", start);
	                return responseBody.substring(start, end).replaceAll("\"", "").trim();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    // Main method to test the API call
	    public static void main(String[] args) {
	        //updateTestExecution1("AAT-T139", "Pass");
	    	updateTestExecutionStatus("AAT-T137", "Fail");
	    }

}
