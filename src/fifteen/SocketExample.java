package unorganisedCode;

import java.io.*;
import java.net.Socket;

public class SocketExample {
    public static void main(String[] args) {
        try {
            // Create a socket
            Socket socket = new Socket("localhost", 12345); // Replace with your host and port

            // Send data
            OutputStream os = socket.getOutputStream();
            PrintWriter out = new PrintWriter(os, true);
            out.println("Hello, Server!");

            // Receive data
            InputStream is = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String response = in.readLine();
            System.out.println("Server says: " + response);

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
