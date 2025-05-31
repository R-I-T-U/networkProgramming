package URI;

import java.io.*;
import java.net.*;
import java.util.Date;

public class DaytimeServer {
    public static void main(String[] args) {
        int port = 5000;
        try (ServerSocket s = new ServerSocket(port)) {
            System.out.println("Server started. Waiting clients...");

            while (true) {
                Socket cs = s.accept();
                System.out.println("Client connected: " + cs.getInetAddress());

                PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
                out.println("Current Date and Time: " + new Date());

                cs.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
