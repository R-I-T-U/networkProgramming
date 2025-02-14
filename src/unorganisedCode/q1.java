package unorganisedCode;

import java.io.IOException;
import java.net.InetAddress;

public class q1 {
    public static void main(String[] args) {
        try{
            //getLocalHost
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address.getHostAddress());    //getHostAddress
            System.out.println(address.getHostName());  //getHostName

            //getByName
            InetAddress address2 = InetAddress.getByName("www.chess.com");
            System.out.println(address2.getHostAddress());
            System.out.println(address2.getHostName());

            //getAllByName
            InetAddress sw[] = InetAddress.getAllByName("www.facebook.com");
            for (int i = 0; i < sw.length; i++) {
                System.out.println(sw[i]);
            }

            InetAddress add = InetAddress.getByName("example.com");
            System.out.println(add.getCanonicalHostName()+" is a FQDN");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
