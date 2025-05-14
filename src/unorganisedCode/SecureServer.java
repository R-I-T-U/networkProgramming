package unorganisedCode;

import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SecureServer {
    public static void main(String[] args) {
        int port = 12345;

        try {
            // Load KeyStore (server's certificate and private key)
            KeyStore keyStore = KeyStore.getInstance("JKS");
            FileInputStream keyStoreFile = new FileInputStream("/home/ritu/Documents/folder/serverkeystore.jks");
            keyStore.load(keyStoreFile, "password".toCharArray());

            // Initialize KeyManagerFactory
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(keyStore, "password".toCharArray());

            // Create SSL Context
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kmf.getKeyManagers(), null, null);

            // Create SSL ServerSocket
            SSLServerSocketFactory serverSocketFactory = sslContext.getServerSocketFactory();
            SSLServerSocket serverSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(port);
            System.out.println("Secure Server is listening on port " + port + "...");

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected securely!");

                // Read from client
                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage = input.readLine();
                System.out.println("Received: " + clientMessage);

                // Send response
                output.println("Hello from Secure Server!");
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
