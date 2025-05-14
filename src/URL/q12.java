package URL;

import java.net.URL;
// Program to determine parts of a URLs.

public class q12 {

    public static void main(String args[]) throws Exception {
        System.out.println("Name: Ritu , Roll: 36, Que no. 12");

        URL u = new URL("http://www.ritu.com:80/index.html?id=5#top");
        System.out.println("The URL is " + u);
        System.out.println("The scheme/Protocal is " + u.getProtocol());

        String host = u.getHost();
        if (host != null) {
            int atSign = host.indexOf('@');
            if (atSign != -1)
                host = host.substring(atSign + 1);
            System.out.println("The host is " + host);
        } else {
            System.out.println("The host is null.");
        }

        System.out.println("The port is " + u.getPort());
        System.out.println("The path is " + u.getPath());
        System.out.println("The ref is " + u.getRef());
        System.out.println("The query string is " + u.getQuery());
    }

}
