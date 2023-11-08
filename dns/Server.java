package weblab.dns;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Random;
import java.util.Scanner;

public class Server {

    static String[] hosts = { "netflix.com", "zoho.com", "gmail.com", "google.com", "facebook.com",
            "amazon.com", "leetcode.com", "geeksforgeeks.com", "youtube.com", "hope3.org", "stackoverflow.com",
            "hackerrank.com", "codeforces.com", "codechef.com" };

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket();
        String[] IpAddress = getIpArray();

        String host = getHostName();
        int hostIndex = searchHost(host);
        // first parameter hostIp
        // second parameter size of hostIp
        // ip address of the server
        // port of the client
        InetAddress ip = InetAddress.getLocalHost();
        DatagramPacket datagramPacket = new DatagramPacket(
                (hostIndex != -1) ? IpAddress[hostIndex].getBytes() : "host not found".getBytes(),
                (hostIndex != -1) ? IpAddress[hostIndex].length() : 14, ip, 3000);

        socket.send(datagramPacket);
        socket.close();
    }

    private static int searchHost(String temHost) {
        for (int i = 0; i < hosts.length; i++) {
            if (temHost.equals(hosts[i])) {
                // return the index of host name in host array and ip in ip array
                return i;
            }

        }
        return -1;
    }

    private static String[] getIpArray() {

        String[] ip = new String[hosts.length];
        for (int i = 0; i < ip.length; i++) {
            String tem = "";
            for (int j = 0; j < 4; j++) {
                tem += new Random().nextInt(255) + ".";
            }
            tem += new Random().nextInt(255);
            ip[i] = tem;
        }
        return ip;
    }

    private static String getHostName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the host name:");
        return scan.nextLine();
    }
}
