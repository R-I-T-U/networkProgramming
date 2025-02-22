package InternetAddress;

import java.net.*;
import java.io.IOException;
// Program to demonstrate testing reachability.

public class q7 {
    public static void main(String[] args) {
        try {
            System.out.println("Name: Ritu , Roll: 36, Que no. 7");

            InetAddress inet = InetAddress.getByName("www.google.com");
            boolean reachable = inet.isReachable(5000);
            if (reachable) {
                System.out.println("google.com is reachable.");
            } else {
                System.out.println("google.com is NOT reachable.");
            }

            NetworkInterface netIf = NetworkInterface.getByName("eth0");

            boolean reachable1= inet.isReachable(netIf, 128, 5000);
            if (reachable1) {
                System.out.println("eth0 is reachable.");
            } else {
                System.out.println("eth0 is NOT reachable.");
            }

        } catch (UnknownHostException e) {
            System.out.println("Invalid host: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error checking reachability: " + e.getMessage());
        }
    }
}
