package InternetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
// Program to implement spamcheck and demonstrate the faults.

public class q9 {
    public static final String BLACKHOLE = "zen.spamhaus.org"; // Use a real DNSBL

    //    ip1= 192.168.1.1, ip2 = 195.128.126.165
    public static void main(String[] args) {
        System.out.println("Name: Ritu , Roll: 36, Que no. 9");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter IP Address: ");
        String ip = sc.nextLine();
        if (isSpammer(ip)) {
            System.out.println(ip + " is marked as spam.");
        } else {
            System.out.println(ip + " appears legitimate.");
        }

    }

    private static boolean isSpammer(String ip) {
        try {
            InetAddress address = InetAddress.getByName(ip);
            byte[] quad = address.getAddress();

            if (quad.length != 4) {
                System.out.println("Skipping non-IPv4 address: " + ip);
                return false;
            }

            String query = BLACKHOLE;
            for (byte octet : quad) {
                int unsignedByte = octet & 0xFF;
                query = unsignedByte + "." + query;
            }

            System.out.println("Querying: " + query);
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }
}
