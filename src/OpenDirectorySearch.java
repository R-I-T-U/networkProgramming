import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OpenDirectorySearch {

    public static void main(String[] args) {
        try {
            String dir = "http://ftp.debian.org/debian/";

            URL url = new URL(dir);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;
            Pattern p = Pattern.compile("<a href=\"(.*?)\">");

            while ((inputLine = in.readLine()) != null) {
                Matcher m = p.matcher(inputLine);
                while (m.find()) {
                    String f = m.group(1);
                    if (!f.equals("../")) {
                        System.out.println(f);
                    }
                }
            }

            in.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
