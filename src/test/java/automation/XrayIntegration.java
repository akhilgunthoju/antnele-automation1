package automation;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class XrayIntegration {

	public static void updateXrayTestResult(String testKey, String status) throws IOException {
        // Jira URL for Xray API
        String jiraUrl = "https://akhilgunthoju123.atlassian.net/rest/api/2/issue/" + testKey + "/transitions";
        System.out.println("Final Jira API URL: " + jiraUrl);
        // Your Jira credentials
        String username = "akhilgunthoju@gmail.com";
        String apiToken = "ATATT3xFfGF0bfclavFqipdJ8seCM3D6ubQEyzFMjBQR9PzThtTcM0oXHop05po2rDHOKo7A86P_k8d_icloU_ZOUdnFZOfy04kJSyRo3EeDZwoh6R2XuONRo_STxvjdp5iWsPvoEBbBBDkaeiRy0asdFr9ZGp-I7Isrv47jHPYSvSODrFO0E3Y=3E348CEB";  // Replace with the generated API token

        // JSON Payload for Test Status
        String jsonPayload = "{ \"status\": \"" + status + "\" }";

        // Create HTTP Client
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(jiraUrl);
        httpPost.setHeader("Authorization", "Basic " + 
                Base64.getEncoder().encodeToString((username + ":" + apiToken).getBytes(StandardCharsets.UTF_8)));
        httpPost.setHeader("Content-Type", "application/json");

        // Set JSON Payload
        httpPost.setEntity(new StringEntity(jsonPayload));

        // Execute API Request
        CloseableHttpResponse response = client.execute(httpPost);
        System.out.println("Xray Test Result Updated: " + response.getStatusLine().getStatusCode());
        System.out.println("Response Message: " + EntityUtils.toString(response.getEntity()));

        // Close client
        client.close();
    }
}
