package URI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class SecureHttpClient {
    public static void main(String[] args) {
        String httpsURL = "https://www.example.com"; // Change to the desired HTTPS URL

        try {
            // Create a URL object
            URL url = new URL(httpsURL);

            // Open HTTPS connection
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET"); // Set request type to GET

            // Read and print the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            System.out.println("Response from server:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Close resources
            reader.close();
            connection.disconnect();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
