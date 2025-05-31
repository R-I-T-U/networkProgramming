import java.io.IOException;
import java.net.ServerSocket;

public class NonAnonymousPort {
    public static void main(String[] args) {
        int p = 5555;
        try {
            ServerSocket s = new ServerSocket(p);
            System.out.println("ServerSocket is running on port: " + s.getLocalPort());
            s.close();
        } catch (IOException e) {
            System.out.println("Port " + p + " is already in use or not available.");
        }
    }
}
