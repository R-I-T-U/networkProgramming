package URL;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
// Program to implement x-www-form-urlencoded strings.

public class q14 {
    public static void main(String[] args) throws MalformedURLException, UnsupportedEncodingException {
        // Original data
        System.out.println("Name: Ritu , Roll: 36, Que no. 14");

        String data = "http://www.baidu.com";

        // Encoding the data
        String encodedData = URLEncoder.encode(data, "UTF-8");
        System.out.println("Encoded url: " + encodedData);

        // Decoding the data
        String decodedData = URLDecoder.decode(encodedData, "UTF-8");
        System.out.println("Decoded url: " + decodedData);

    }
}
