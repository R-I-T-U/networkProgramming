package unorganisedCode;//Java Program to illustrate various
//URI class methods
import java.net.*;
class q17
{
    public static void main(String[] args) throws Exception
    {
        String str = "https://www.google.co.in/?gws_rd=ssl#"+""
                + "q=networking+in+java+geeksforgeeks"+""
                +"&spf=1496918039682";

        // Constructor to create a new URI
        // by parsing the given string.
        URI uri = new URI(str);

        // getHost() method
        System.out.println("Host = " + uri.getHost());

        // getPort() method
        System.out.println("Port = " + uri.getPath());

        // getRawPath() method
        System.out.println("Raw Path = " + uri.getRawPath());

        // getPath() method
        System.out.println("Path = " + uri.getPath());

        // getQuery() method
        System.out.println("Query = " + uri.getQuery());

        // getRawQuery() method
        System.out.println("Raw Query = " + uri.getRawQuery());

        // getFragment() method
        System.out.println("Fragment = " + uri.getFragment());

        // getRawFragment() method
        System.out.println("Raw Fragment = " + uri.getRawFragment());

        URI uri2 = new URI(str + "fr");

        // compareTo() mrthod
        System.out.println("CompareTo =" + uri.compareTo(uri2));

        // equals() method
        System.out.println("Equals = " + uri.equals(uri2));

        // hashcode() method
        System.out.println("Hashcode : " + uri.hashCode());

        // toString() method
        System.out.println("toString : " + uri.toString());

        // toASCIIString() method
        System.out.println("toASCIIString : " + uri.toASCIIString());

    }
}
