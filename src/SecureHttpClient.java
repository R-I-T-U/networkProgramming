import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class SecureHttpClient {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com");

            HttpsURLConnection c = (HttpsURLConnection) url.openConnection();
            c.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));

            String l;
            StringBuilder res = new StringBuilder();
            while ((l = in.readLine()) != null) {
                res.append(l).append("\n");
            }
            in.close();
            System.out.println("Server Response:\n" + res.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
