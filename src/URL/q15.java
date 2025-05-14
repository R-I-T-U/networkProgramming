package URL;
//  Program to demonstrate a proxyselector that rembember to what it
//can be connected to.
import java.io.IOException;
import java.net.*;
import java.util.*;

public class q15 extends ProxySelector {
    private final List<Proxy> proxies;
    private final Set<SocketAddress> failedProxies = new HashSet<>();

    public q15(List<Proxy> proxies) {
        this.proxies = proxies;
    }

    @Override
    public List<Proxy> select(URI uri) {
        List<Proxy> availableProxies = new ArrayList<>();
        for (Proxy proxy : proxies) {
            if (!failedProxies.contains(proxy.address())) {
                availableProxies.add(proxy);
            }
        }
        return availableProxies.isEmpty() ? List.of(Proxy.NO_PROXY) : availableProxies;
    }

    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        failedProxies.add(sa);
        System.out.println("Connection failed for: " + sa + ". Marking as unavailable.");
    }

    public static void main(String[] args) throws Exception {
        List<Proxy> proxyList = List.of(
                new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.1.1", 8080)),
                new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.1.2", 8080)),
                Proxy.NO_PROXY
        );

        q15 proxySelector = new q15(proxyList);
        ProxySelector.setDefault(proxySelector);

        testConnection(new URI("http://example.com"));
        testConnection(new URI("http://example.com")); // Second attempt with memory
    }

    private static void testConnection(URI uri) {
        try {
            URL url = uri.toURL();
            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(2000);
            conn.connect();
            System.out.println("Connected successfully to " + uri);
        } catch (IOException e) {
            System.out.println("Failed to connect to " + uri);
        }
    }
}
