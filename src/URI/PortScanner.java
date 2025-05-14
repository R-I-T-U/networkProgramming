package URI;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class PortScanner {
    public static void main(String[] args) {
        String host = "localhost"; // Change to the target host or IP
        int startPort = 1, endPort = 1024;

        System.out.println("Scanning ports on host: " + host);

        for (int port = startPort; port <= endPort; port++) {
            try (Socket socket = new Socket(host, port)) {
                System.out.println("Port " + port + " is open.");
            } catch (UnknownHostException e) {
                System.out.println("Unknown host: " + host);
                break;
            } catch (IOException e) {
                // Port is closed, so we ignore the exception
            }
        }

        System.out.println("Port scanning completed.");
    }
}
