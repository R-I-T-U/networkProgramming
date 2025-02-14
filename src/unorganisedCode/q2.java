package unorganisedCode;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class q2
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Host Name: ");
        String host = sc.nextLine();

        try
        {
            InetAddress ip = InetAddress.getByName(host);

            System.out.println("IP Adress of Computer is:"+ip.getHostAddress());
        }
        catch(UnknownHostException e)
        {
            System.out.print(e);
        }

    }
}