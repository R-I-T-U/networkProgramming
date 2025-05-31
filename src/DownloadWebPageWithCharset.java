import java.io.*;
import java.net.*;
import java.util.regex.*;

public class DownloadWebPageWithCharset {
    public static void main(String[] args) {
        try {
            String url1 = "http://example.com";
            URL url = new URL(url1);
            URLConnection conn = url.openConnection();

            String c = conn.getContentType();
            String charset = "UTF-8";

            if (c != null) {
                Pattern p = Pattern.compile("charset=([^;]+)");
                Matcher m = p.matcher(c);
                if (m.find()) {
                    charset = m.group(1);
                }
            }

            BufferedReader r = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), charset)
            );

            String l;
            while ((l = r.readLine()) != null) {
                System.out.println(l);
            }

            r.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
