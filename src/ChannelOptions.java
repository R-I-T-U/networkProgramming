import java.net.*;
import java.nio.channels.*;

public class ShortChannelOptions {
    public static void main(String[] args) throws Exception {
        System.out.println("SocketChannel: " + SocketChannel.open().socket().getReceiveBufferSize());
        System.out.println("ServerSocketChannel: " + ServerSocketChannel.open().socket().getReuseAddress());
        System.out.println("DatagramChannel: " + DatagramChannel.open().socket().getSendBufferSize());
    }
}
