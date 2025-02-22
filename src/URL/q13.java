package InternetAddress;

import java.net.MalformedURLException;
import java.net.URL;

public class q13 {
    public static void main(String[] args) {

        try {
            URL ibiblio = new URL("http://www.google.com/");
            URL metalab = new URL("http://www.google.ca/");
            if (ibiblio.equals(metalab)) {
                System.out.println(ibiblio + " is the same as " + metalab);
            } else {
                System.out.println(ibiblio + " is not the same as " + metalab);
            }
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        }

    }

}
