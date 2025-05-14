package URI;

import java.net.URI;
import java.net.URISyntaxException;

public class q16 {
    public static void main(String[] args) {
        try {
            // Define a URI string
            URI uri = new URI("https://www.example.com:8080/path/to/resource?query=123#section1");

            // Extract and display URI components
            System.out.println("Scheme: " + uri.getScheme()+
                    "\nAuthority: " + uri.getAuthority()+
                    "\nHost: " + uri.getHost()+
            "\nPort: " + uri.getPort()+
           "\nPath: " + uri.getPath()+
           "\nQuery: " + uri.getQuery()+
            "\nFragment: " + uri.getFragment());
        } catch (URISyntaxException e) {
            System.out.println("Invalid URI: " + e.getMessage());
        }
    }
}
