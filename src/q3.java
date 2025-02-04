import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Arrays;

public class q3 {
    public static void main(String[] args) throws IOException {
        InetAddress ip = Inet4Address.getByName("www.javapoint.com");
        System.out.println(ip);
        System.out.println(Arrays.toString(ip.getAddress()));   //getAddress


        InetAddress ip1[] = InetAddress.getAllByName("www.fb.com");
        System.out.println(Arrays.toString(ip1));   //toString

//getByAddress
        byte addr[] = {10, 21, 22, 10};
        InetAddress ip2 = InetAddress.getByAddress(addr);
        System.out.println(ip2);

        System.out.println(ip.isAnyLocalAddress());
        System.out.println(ip.isLinkLocalAddress());

        InetAddress ip3 = InetAddress.getByName("localhost");
        System.out.println(ip3.isLoopbackAddress());
        System.out.println(ip3.isMCGlobal());
        System.out.println(ip3.isSiteLocalAddress());
        System.out.println(ip3.isMulticastAddress());
        System.out.println(ip3.isMCLinkLocal());
        System.out.println(ip3.isMCNodeLocal());
        System.out.println(ip3.isMCOrgLocal());
        System.out.println(ip3.isMCSiteLocal());
        System.out.println(ip3.isMulticastAddress());

        System.out.println(ip.hashCode());  // hashCode

        System.out.println(ip.equals(ip1));  //equals

    }
}
