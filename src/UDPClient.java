import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket s = new DatagramSocket();
            InetAddress a = InetAddress.getByName("localhost");
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.print("Enter message: ");
                String m = sc.nextLine();

                if (m.equalsIgnoreCase("exit")) {
                    break;
                }

                byte[] b = m.getBytes();
                DatagramPacket p = new DatagramPacket(b, b.length, a, 9876);
                s.send(p);

                byte[] rb = new byte[1024];
                DatagramPacket rp = new DatagramPacket(rb, rb.length);
                s.receive(rp);

                String reply = new String(rp.getData(), 0, rp.getLength());
                System.out.println(reply);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
