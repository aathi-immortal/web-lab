import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    static int port = 12345;
    static String host  = "localhost";
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(host,port);
            sendTheMessage(socket);
            socket.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    private static void sendTheMessage(Socket socket) {
        Scanner scan = new Scanner(System.in);
        try {
            OutputStream outputStream =  socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream,true);
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while(true)
            {
                System.out.println("enter the message:");
                writer.println(scan.nextLine());
                System.out.println("echo message from the server: " + reader.readLine());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
