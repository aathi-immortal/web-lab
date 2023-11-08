import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    static String host = "localhost";
    static int port = 12345;

    public static void main(String[] args) throws UnknownHostException, IOException {

        Socket socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(outputStream, true);

        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Scanner scan = new Scanner(System.in);
        while (true) {

            writer.println(scan.nextLine());
            System.out.println(reader.readLine());

        }
    }

}
