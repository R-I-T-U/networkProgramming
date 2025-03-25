package unorganisedCode;

import java.io.*;
import java.net.*;

public class ServerSocketExample {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(12345); // Replace with your port

            // Listen for connections
            System.out.println("Server is listening...");
            Socket clientSocket = serverSocket.accept();

            // Receive data
            InputStream is = clientSocket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String request = in.readLine();
            System.out.println("Client says: " + request);

            // Send data
            OutputStream os = clientSocket.getOutputStream();
            PrintWriter out = new PrintWriter(os, true);
            out.println("Hello, Client!");

            // Close the connection
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}