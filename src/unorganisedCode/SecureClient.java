package unorganisedCode;

import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SecureClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;

        try {
            // Load TrustStore (server's certificate)
            KeyStore trustStore = KeyStore.getInstance("JKS");
            FileInputStream trustStoreFile = new FileInputStream("/home/ritu/Documents/folder/clienttruststore.jks");
            trustStore.load(trustStoreFile, "password".toCharArray());

            // Initialize TrustManagerFactory
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(trustStore);

            // Create SSL Context
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);

            // Create SSL Socket
            SSLSocketFactory socketFactory = sslContext.getSocketFactory();
            SSLSocket clientSocket = (SSLSocket) socketFactory.createSocket(host, port);
            System.out.println("Connected securely to server!");

            // Send message to server
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            output.println("Hello Secure Server!");
            System.out.println("Server Response: " + input.readLine());

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
