package URL;
// Program to download a web page with the corrected character set in
//URL connection.
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class q17 {
    public static void main(String[] args) {
        String webpageUrl = "https://example.com"; // Change to target URL
        String outputFile = "downloaded_page.html";

        try {
            downloadWebPage(webpageUrl, outputFile);
            System.out.println("Page downloaded successfully: " + outputFile);
        } catch (Exception e) {
            System.err.println("Error downloading page: " + e.getMessage());
        }
    }

    public static void downloadWebPage(String webpageUrl, String outputFile) throws IOException {
        URL url = new URL(webpageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        // Detect correct encoding
        String contentType = connection.getContentType();
        String encoding = getCharsetFromContentType(contentType);

        if (encoding == null) {
            encoding = detectCharsetManually(connection);
        }

        System.out.println("Using encoding: " + encoding);

        // Read and save file
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    private static String getCharsetFromContentType(String contentType) {
        if (contentType == null) return null;
        Pattern pattern = Pattern.compile("charset=([a-zA-Z0-9-]+)");
        Matcher matcher = pattern.matcher(contentType);
        return matcher.find() ? matcher.group(1) : null;
    }

    private static String detectCharsetManually(HttpURLConnection connection) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.defaultCharset()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Pattern pattern = Pattern.compile("<meta[^>]+charset=['\"]?([a-zA-Z0-9-]+)['\"]?", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    return matcher.group(1);
                }
            }
        }
        return Charset.defaultCharset().name(); // Default if not detected
    }
}
