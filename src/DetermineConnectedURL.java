import java.net.HttpURLConnection;
import java.net.URL;

public class DetermineConnectedURL {
    public static void main(String[] args) {
        try {
            String originalUrl = "http://example.com";
            URL url = new URL(originalUrl);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.connect();

            URL finalURL = con.getURL();
            System.out.println("Connected to: " + finalURL);

            con.disconnect();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
