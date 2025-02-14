/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unorganisedCode;
/**
 *
 * @author shree
 */
import java.net.*;
import java.io.*;

public class q12 {
    public static void main(String[] args) {
        URL wiki = null;
        BufferedReader in = null;
        try {
            wiki = new URL("https://www.facebook.com");
        } catch(MalformedURLException e) {
            System.out.println("Cannot find webpage " + wiki);
            System.exit(-1);
        }
        try {
            URLConnection  aConnection = wiki.openConnection();
            in = new BufferedReader(
                    new InputStreamReader(aConnection.getInputStream()));
        }
        catch (IOException e) {
            System.out.println("Cannot connect to webpage " + wiki);
            System.exit(-1);
        }
        try {
            // Now read the webpage file
            String lineOfWebPage;
            while ((lineOfWebPage = in.readLine()) != null)
                System.out.println(lineOfWebPage);
            in.close(); // Close the connection to the net
        } catch(IOException e) {
            System.out.println("Cannot read from webpage " + wiki);
        }
    }
}

