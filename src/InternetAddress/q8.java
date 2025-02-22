package InternetAddress;

import java.net.*;
import java.net.UnknownHostException;
import java.util.Scanner;
//Program to test the nature of an address entered from the command line.

public class q8 {

    public static void main(String[] args) {
        System.out.println("Name: Ritu , Roll: 36, Que no. 8");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an IP address: ");
        String ipAddress = scanner.nextLine().trim();

        try {
            // Resolve the IP address
            InetAddress inetAddress = InetAddress.getByName(ipAddress);

            // Check if it's IPv4 or IPv6
            if (inetAddress instanceof Inet4Address) {
                System.out.println(ipAddress + " is a valid IPv4 address.");
            } else if (inetAddress instanceof Inet6Address) {
                System.out.println(ipAddress + " is a valid IPv6 address.");
            } else {
                System.out.println(ipAddress + " is not a valid IPv4 or IPv6 address.");
            }
        } catch (UnknownHostException ex) {
            System.out.println(ipAddress + " is not a valid IPv4 or IPv6 address.");
        }

        scanner.close();
    }
}