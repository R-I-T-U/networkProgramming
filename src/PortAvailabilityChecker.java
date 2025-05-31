import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;

public class PortAvailabilityChecker {
    public static void main(String[] args) {

        for (int port = 1; port <= 1024; port++) {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                serverSocket.close();
            } catch (BindException ex) {
                System.out.println("Port " + port + " is in use.");
            } catch (IOException e) {
                System.out.println("Port " + port + " could not be tested.");
            }
        }
    }
}
