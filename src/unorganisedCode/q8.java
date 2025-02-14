package unorganisedCode;

import java.net.*;

public class q8 {

    public static int getVersion(InetAddress ia) {
        byte[] address = ia.getAddress();
        switch (address.length) {
            case 4:
                return 4;
            case 16:
                return 6;
            default:
                return -1;
        }
    }


    public static void main(String[] args) throws UnknownHostException {
        //InetAddress ipv4Address = InetAddress.getByName("8.8.8.8");
        InetAddress ipv6Address = InetAddress.getByName("2001:4860:4860::8888");

        //System.out.println("IPv4 Address: " + ipv4Address + " - Version: " + getVersion(ipv4Address));
        System.out.println("IPv6 Address: " + ipv6Address + " - Version: " + getVersion(ipv6Address));
    }
}
