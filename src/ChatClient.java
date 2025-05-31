import java.net.*;
import java.io.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 5000);
        System.out.println("Connected to server.");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        new Thread(() -> {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                String msg;
                while ((msg = br.readLine()) != null) out.println("Client: " + msg);
            } catch (IOException e) {}
        }).start();

        String l;
        while ((l = in.readLine()) != null) {
            System.out.println(l);
        }

        s.close();
    }
}
