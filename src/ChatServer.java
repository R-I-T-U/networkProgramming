import java.net.*;
import java.io.*;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = ss.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        new Thread(() -> {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                String msg;
                while ((msg = br.readLine()) != null) out.println("Server: " + msg);
            } catch (IOException e) {}
        }).start();

        String l;
        while ((l = in.readLine()) != null) {
            System.out.println(l);
        }

        s.close();
        ss.close();
    }
}
