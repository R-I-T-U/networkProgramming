package URL;
// Program to determine the URL connection is connected to which URL.

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class q18 {
    public static void main(String[] args) {
        String inputUrl = "http://example.com"; // Change this URL

        try {
            URL finalUrl = getFinalConnectedURL(inputUrl);
            System.out.println("Connected to: " + finalUrl);
        } catch (IOException e) {
            System.err.println("Failed to connect: " + e.getMessage());
        }
    }

    public static URL getFinalConnectedURL(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setInstanceFollowRedirects(true); // Auto-follow redirects
        connection.setRequestMethod("HEAD"); // Use HEAD for faster response
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        connection.connect();

        // Check if redirected
        int status = connection.getResponseCode();
        if (status >= 300 && status < 400) { // Redirect response codes
            String newUrl = connection.getHeaderField("Location");
            if (newUrl != null) {
                return getFinalConnectedURL(newUrl); // Recursively follow redirects
            }
        }

        return connection.getURL(); // Return final URL
    }
}
