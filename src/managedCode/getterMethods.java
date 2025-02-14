package managedCode;

import java.net.*;

public class getterMethods {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress me = InetAddress.getLocalHost();
        System.out.println("My address is "+me.getHostAddress());
        System.out.println("and hostname is "+me.getHostName());

        byte[] address = me.getAddress();
        if(address.length == 4)
            System.out.println("it is ipv4 address.");
        else if(address.length == 6)
            System.out.println("it is ipv6 address.");


        InetAddress ia = InetAddress.getByName("104.21.79.8");
        System.out.println("FQDN of 104.21.79.8 is "+ia.getCanonicalHostName());

        byte addr[] = {10, 21, 22, 100};
        InetAddress ip2 = InetAddress.getByAddress(addr);
        System.out.println("getByAddress: "+ip2);

        //getAllByName
        InetAddress sw[] = InetAddress.getAllByName("www.chess.com");
        for (int i = 0; i < sw.length; i++) {
            System.out.println(sw[i]);
        }
    }
}
