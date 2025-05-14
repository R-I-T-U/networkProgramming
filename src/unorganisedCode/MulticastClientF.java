package unorganisedCode;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
How to Run the Program
1. Start the Multicast Receiver (Client)
Open multiple terminals and run the MulticastClient class.
Each client will join the multicast group and start listening.
2. Start the Multicast Sender (Server)
Run MulticastServer.
Type a message and press Enter.
The message will be broadcasted to all clients.
3. Exit
Type exit in the server to terminate multicast communication.
All clients will receive exit and stop listening.
How It Works
The server sends data using DatagramSocket to a multicast address.
Each client joins the same multicast group using MulticastSocket and listens.
Messages are sent in DatagramPackets over UDP, which ensures low-latency broadcasting.
*/

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClientF {
    public static void main(String[] args) {
        String multicastAddress = "230.0.0.1"; // Same as sender
        int port = 5000;

        try (MulticastSocket socket = new MulticastSocket(port)) {
            InetAddress group = InetAddress.getByName(multicastAddress);
            socket.joinGroup(group);

            System.out.println("Multicast Client Started... Listening for messages...");

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + received);

                if ("exit".equalsIgnoreCase(received)) {
                    System.out.println("Exiting multicast client...");
                    break;
                }
            }
            socket.leaveGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
