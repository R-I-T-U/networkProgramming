import java.io.IOException;
import java.net.Socket;

public class PortScanner {
    public static void main(String[] args) {
        String host = "localhost";
        int startPort = 1;
        int endPort = 1024;

        System.out.println("Scanning ports on host: " + host);

        for (int port = startPort; port <= endPort; port++) {
            try (Socket socket = new Socket(host, port)) {
                System.out.println("Port " + port + " is open.");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
