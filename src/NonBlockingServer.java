import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NonBlockingServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel sc = ServerSocketChannel.open();
        sc.bind(new InetSocketAddress(5000));
        sc.configureBlocking(false);
        Selector s = Selector.open();
        sc.register(s, SelectionKey.OP_ACCEPT);

        while (true) {
            s.select();
            Set<SelectionKey> keys = s.selectedKeys();
            Iterator<SelectionKey> i = keys.iterator();

            while (i.hasNext()) {
                SelectionKey key = i.next();

                if (key.isAcceptable()) {
                    SocketChannel c = sc.accept();
                    c.configureBlocking(false);
                    c.register(s, SelectionKey.OP_READ);
                    System.out.println("Connection Accepted: " + c);
                }

                if (key.isReadable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer b = ByteBuffer.allocate(256);
                    int read = client.read(b);

                    if (read == -1) {
                        client.close();
                        System.out.println("Connection close");
                    } else {
                        String msg = new String(b.array()).trim();
                        System.out.println("Message received: " + msg);
                    }
                }

                i.remove();
            }
        }
    }
}
