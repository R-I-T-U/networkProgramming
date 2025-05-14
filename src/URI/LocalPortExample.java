package URI;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LocalPortExample {
    public static void main(String[] args) {
        int port = 5000; // Non-anonymous port

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port: " + serverSocket.getLocalPort());

            // Accept a client connection (optional)
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from: " + clientSocket.getInetAddress());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
