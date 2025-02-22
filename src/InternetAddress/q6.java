package InternetAddress;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLOutput;
import java.util.Enumeration;
//Program to demonstrate The Network Interface class with factory.

public class q6 {
    public static void main(String[] args) {
        try{
            System.out.println("Name: Ritu , Roll: 36, Que no. 6");

            NetworkInterface ni = NetworkInterface.getByName("eth0");
            if(ni==null){
                System.out.println("No such interface.");
            }

            InetAddress ia = InetAddress.getByName("127.0.0.1");
            NetworkInterface ni2 = NetworkInterface.getByInetAddress(ia);
            if(ni2==null){
                System.err.println("No local loopback address.");
            }else {
                System.out.println("Local loopback address: "+ia);
            }

            Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
            while (n.hasMoreElements()) {
                System.out.println(n.nextElement());
            }
        } catch (SocketException e){
            System.err.println(e.getMessage());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
