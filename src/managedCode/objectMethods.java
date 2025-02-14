package managedCode;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class objectMethods {
    public static void main(String[] args) {
        try{
            InetAddress ip1 = InetAddress.getByName("www.facebook.com");
            InetAddress ip2 = InetAddress.getByName("www.fb.com");

            if(ip1.equals(ip2))
                System.out.println("IP 1 and IP 2 are the same");
            else
                System.out.println("IP 1 and IP 2 are not the same");


            System.out.println("hashcode of ip1 is "+ip1.hashCode()+" and ip2 is "+ip2.hashCode());

            InetAddress ip[] = InetAddress.getAllByName("www.google.com");
            System.out.println(Arrays.toString(ip));
        } catch (UnknownHostException ex){
            System.out.println(ex.getMessage());
        }
    }
}
