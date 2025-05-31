import java.io.*;
import java.net.*;

public class PostForm {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://httpbin.org/post");

            String data = "name=ritu&email=ritu@gmail.com";

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(data.length()));
            try (OutputStream os = conn.getOutputStream()) {
                os.write(data.getBytes());
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            System.out.println("Server Response:");
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();

        } catch (Exception e) {
e.printStackTrace();        }
    }
}
