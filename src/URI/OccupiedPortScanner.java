package URI;

import java.io.IOException;
import java.net.ServerSocket;

public class OccupiedPortScanner {
    public static void main(String[] args) {
        int startPort = 1, endPort = 1024;

        System.out.println("Scanning for occupied ports on local machine...");

        for (int port = startPort; port <= endPort; port++) {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                // If no exception, port is free
                serverSocket.close();
            } catch (IOException e) {
                // Port is in use
                System.out.println("Port " + port + " is occupied.");
            }
        }

        System.out.println("Port scanning completed.");
    }
}
