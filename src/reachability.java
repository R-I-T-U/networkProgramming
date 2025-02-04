import java.net.*;
import java.io.IOException;

public class reachability {
    public static void main(String[] args) {
        try {
            InetAddress inet = InetAddress.getByName("google.com");
            boolean reachable = inet.isReachable(5000);
            if (reachable) {
                System.out.println("google.com is reachable.");
            } else {
                System.out.println("google.com is NOT reachable.");
            }

            InetAddress inet1 = InetAddress.getByName("8.8.8.8");
            NetworkInterface netIf = NetworkInterface.getByName("eth0");

            boolean reachable1= inet.isReachable(netIf, 128, 5000);
            if (reachable1) {
                System.out.println("8.8.8.8 is reachable.");
            } else {
                System.out.println("8.8.8.8 is NOT reachable.");
            }

        } catch (UnknownHostException e) {
            System.out.println("Invalid host: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error checking reachability: " + e.getMessage());
        }
    }
}
