package unorganisedCode;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*

  @author shree
 */
import java.net.URL;
import java.net.URLConnection;

public class q11 {
    public static void main(String[] argv) throws Exception {
        URL url = new URL("https://www.facebook.com");
        URLConnection conn = url.openConnection();

        for (int i = 0;; i++) {
            String headerName = conn.getHeaderFieldKey(i);
            String headerValue = conn.getHeaderField(i);

            if (headerName == null && headerValue == null) {
                break;
            }
            if ("Set-Cookie".equalsIgnoreCase(headerName)) {
                String[] fields = headerValue.split(";\\s*");
                for (int j = 1; j < fields.length; j++) {
                    if ("secure".equalsIgnoreCase(fields[j])) {
                        System.out.println("secure=true");
                    } else if (fields[j].indexOf('=') > 0) {
                        String[] f = fields[j].split("=");
                        if ("expires".equalsIgnoreCase(f[0])) {
                            System.out.println("expires"+ f[1]);
                        } else if ("domain".equalsIgnoreCase(f[0])) {
                            System.out.println("domain"+ f[1]);
                        } else if ("path".equalsIgnoreCase(f[0])) {
                            System.out.println("path"+ f[1]);
                        }
                    }
                }
            }
        }
    }
}