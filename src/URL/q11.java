package URL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
// Download a web page using URL.

public class q11 {
    public static void main(String[] argv) throws Exception {
        System.out.println("Name: Ritu , Roll: 36, Que no. 11");

        URL url = new URL("http://www.chess.com");

        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String str;
        while ((str = in.readLine()) != null) {
            System.out.println(str);
        }
        in.close();
    }
}
