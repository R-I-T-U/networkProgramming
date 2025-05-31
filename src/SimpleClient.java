import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClient {

    public static void main(String[] args) {
        String s = "localhost";
        int p = 5000;

        try (Socket ss = new Socket(s, p)) {
            OutputStream os = ss.getOutputStream();
            String m = "Hello from client!";
            os.write(m.getBytes());
            os.flush();

            System.out.println("Message sent: " + m);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
