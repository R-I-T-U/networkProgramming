package InternetAddress;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class q5{
    public static void main(String[] args) {
        System.out.println("Name: Ritu , Roll: 36, Que no. 5");

        try {
            InetAddress address = InetAddress.getByName("www.chess.com");

            byte buffer[] = address.getAddress();
            if (buffer.length <= 4) {
                System.out.println("IPv4 Address");
            } else {
                System.out.println("IPv6 Address");
            }

            InetAddress address1 = InetAddress.getByName("2001:0db8:85a3::8a2e:0370:7334");

            if (address1 instanceof Inet4Address) {
                System.out.println("IPv4 Address");
            } else {
                System.out.println("IPv6 Address");
            }
        } catch (UnknownHostException ex) {
            System.out.println(ex.getMessage());
        }
    }
}