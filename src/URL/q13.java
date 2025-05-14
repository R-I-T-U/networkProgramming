package URL;

import java.net.MalformedURLException;
import java.net.URL;
// Program to check the equality of URLs.
public class q13 {
    public static void main(String[] args) {
        System.out.println("Name: Ritu , Roll: 36, Que no. 13");

        try {
            URL u1 = new URL("http://www.example.com/");
            URL u2 = new URL("http://www.exam.ca/");
            if (u1.equals(u2)) {
                System.out.println("Same URLs ");
            } else {
                System.out.println("Not same URLs");
            }

            if (u1.sameFile(u2)) {
                System.out.println("Both URLs point to same file.");
            } else {
                System.out.println("URLs point to different files.");
            }
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        }

    }

}
