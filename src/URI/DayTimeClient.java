package URI;

import java.io.*;
import java.net.*;

public class DayTimeClient {
    public static void main(String[] args) {
        String addr = "localhost";
        int port = 5000;

        try (Socket s = new Socket(addr, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()))) {

            String res = in.readLine();
            System.out.println("Server Response: " + res);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
