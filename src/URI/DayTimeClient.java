package URI;

import java.io.*;
import java.net.*;

public class DayTimeClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Server address
        int port = 5000; // Port number

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Read and display the date and time from the server
            String response = in.readLine();
            System.out.println("Server Response: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
