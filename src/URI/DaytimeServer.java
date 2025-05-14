package URI;

import java.io.*;
import java.net.*;
import java.util.Date;

public class DaytimeServer {
    public static void main(String[] args) {
        int port = 5000; // Port number for the server
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Daytime Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Send current date and time to the client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Current Date and Time: " + new Date());

                // Close the client socket
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
