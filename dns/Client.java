package weblab.dns;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Client
 */
public class Client {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(3000);
        byte[] arr = new byte[30];
        // used to store the received data in datagramPacket
        DatagramPacket dp = new DatagramPacket(arr, 30);
        // receive the data form the server
        socket.receive(dp);
        System.out.println("ip:" + new String(dp.getData()));

    }
}