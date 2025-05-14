package URL;
// Program to implement an open directory search.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class q16 {
    private static final String TARGET_URL = "http://example.com"; // Change to your target
    private static final List<String> COMMON_DIRS = List.of(
            "admin", "uploads", "backup", "images", "logs", "data", "private", "config"
    );

    public static void main(String[] args) {
        System.out.println("Scanning " + TARGET_URL + " for open directories...\n");

        for (String dir : COMMON_DIRS) {
            String testUrl = TARGET_URL + "/" + dir + "/";
            if (isAccessible(testUrl)) {
                System.out.println("[+] Found open directory: " + testUrl);
            } else {
                System.out.println("[-] No access: " + testUrl);
            }
        }
    }

    private static boolean isAccessible(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(2000); // Timeout in 2 seconds
            connection.setReadTimeout(2000);
            connection.connect();

            int responseCode = connection.getResponseCode();
            return responseCode == 200 || responseCode == 403; // 200 = Open, 403 = Forbidden (Exists)
        } catch (Exception e) {
            return false;
        }
    }
}
