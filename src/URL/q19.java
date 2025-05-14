package URL;
// Program to post a form using URL Connections class and Query Strings.
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class q19 {
    public static void main(String[] args) {
        String targetUrl = "https://postman-echo.com/post"; // Change this to your actual form URL
        String formData = "name=JohnDoe&email=john@example.com&message=Hello";

        try {
            String response = sendPostRequest(targetUrl, formData);
            System.out.println("Server Response:\n" + response);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static String sendPostRequest(String targetUrl, String formData) throws IOException {
        URL url = new URL(targetUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Configure request
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        // Send form data
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = formData.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // Read server response
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }
            return response.toString();
        }
    }
}
