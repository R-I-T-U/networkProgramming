package InternetAddress;
import java.net.*;
import java.util.Scanner;

public class q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter VM: ");
        String str = sc.nextLine();
        testProtocol(str);
//
//        testProtocol("http://www.google.com");
//        testProtocol("https://www.facebook.com");
//        testProtocol("ftp://ibiblio.org");
//        testProtocol("mailto:ritu@rrlc.org");
//        testProtocol("telnet://dibner.poly.edu/");
//        testProtocol("file:///etc/passwd");
//        testProtocol("gopher://gopher.anc.org.za/");
    }
    public static void testProtocol(String url){
        try{
            URL u = new URL(url);
            System.out.println(u.getProtocol()+" is supported by "+url);

        } catch (MalformedURLException e) {
            String protocol = url.substring(0, url.indexOf(":"));
            System.out.println(protocol+" is not supported by "+url);
        }
    }
}
