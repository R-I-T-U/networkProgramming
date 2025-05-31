import java.io.*;
import java.net.*;
import java.util.*;

public class LocalProxySelector extends ProxySelector {

    private List failed = new ArrayList();
    @Override
    public List<Proxy> select(URI uri) {
        List<Proxy> res = new ArrayList<Proxy>();
         if(failed.contains(uri) || "http".equalsIgnoreCase(uri.getScheme())) {
             res.add(Proxy.NO_PROXY);
         } else {
             SocketAddress pa =new InetSocketAddress("proxy.exmple.com", 8000);
             Proxy p = new Proxy(Proxy.Type.HTTP, pa);
             res.add(p);
         }
        return res;
    }

    @Override
    public void connectFailed(URI uri, SocketAddress s, IOException e) {
        failed.add(uri);
    }

    public static void main(String[] args) {
        ProxySelector.setDefault(new LocalProxySelector());

        try {
            URI uri = new URI("http://www.example.com");
            URL url = uri.toURL();
            URLConnection conn = url.openConnection();
            conn.connect();
            System.out.println("Connection succeeded using selected proxy!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
