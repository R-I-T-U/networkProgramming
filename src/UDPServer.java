import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket s = new DatagramSocket(9876);
            byte[] b = new byte[1024];

            while (true) {
                DatagramPacket p = new DatagramPacket(b, b.length);
                s.receive(p);

                String msg = new String(p.getData(), 0, p.getLength());
                System.out.println("Client says: " + msg);

                String reply = msg;
                byte[] buf = reply.getBytes();

                DatagramPacket sp = new DatagramPacket(
                        buf,
                        buf.length,
                        p.getAddress(),
                        p.getPort()
                );

                s.send(sp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
