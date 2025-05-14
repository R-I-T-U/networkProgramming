package unorganisedCode;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class MulticastServerF {
    public static void main(String[] args) {
        String multicastAddress = "230.0.0.1"; // Multicast IP (Class D)
        int port = 5000;

        try (DatagramSocket socket = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) {

            InetAddress group = InetAddress.getByName(multicastAddress);

            System.out.println("Multicast Server Started...");
            while (true) {
                System.out.print("Enter message to send: ");
                String message = scanner.nextLine();

                byte[] buffer = message.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
                socket.send(packet);

                System.out.println("Message sent: " + message);

                if ("exit".equalsIgnoreCase(message)) {
                    System.out.println("Exiting multicast server...");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
