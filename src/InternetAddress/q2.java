package InternetAddress;

import java.net.*;

public class q2 {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println("Name: Ritu , Roll: 36, Que no. 2");
            InetAddress ia = InetAddress.getByName("www.chess.com");
        System.out.println(ia);

            if(ia.isAnyLocalAddress()){
                System.out.println("it is wildcard address");
            }
        if(ia.isLoopbackAddress()){
            System.out.println("it is loopback address");
        }
        if(ia.isLinkLocalAddress()){
            System.out.println("it is link-local address");
        }
       else if(ia.isSiteLocalAddress()){
            System.out.println("it is site-local address");
        }
       else
            System.out.println("it is global address");

       if(ia.isMulticastAddress()){
           if(ia.isMCGlobal())
               System.out.println("it is global multicast address");
           else if(ia.isMCOrgLocal())
               System.out.println("it is organization wide multicast address");
           else if(ia.isMCSiteLocal())
               System.out.println("it is site wide multicast address");
           else if(ia.isMCLinkLocal())
               System.out.println("it is organization subnet wide multicast address");
           else if(ia.isMCNodeLocal())
               System.out.println("it is interface-local multicast address");
           else
               System.out.println("it is unknown multicast address");
       }  else{
           System.out.println("it is unicast address");
       }


    }
}
