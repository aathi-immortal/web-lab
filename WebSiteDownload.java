import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WebSiteDownload {
    static String host;
    static int port = 80;
    static String path = "/index.html";

    public static void main(String[] args) {
        downloadThePage();    
    }

    private static void downloadThePage() {
        getTheHost();
        try {
            Socket socket  = new Socket(host, port);
            // creating a output stream using this stream we can send request to the server
            // using printWriter using this class only we can write the data in the output stream
            
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream,true);
            // we are sending the get request to the host server for the index page
            // after the request it will send the response in the inputstreamBuffer

            // request to the server
            out.println("GET " + path + " HTTP/1.1");
            out.println("Host: " + host);
            out.println();
            // 

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            
            // response from the server
            writeIntoTheIndex(bufferedReader);
            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void writeIntoTheIndex(BufferedReader bufferedReader) {
        String line;
        
            try {

                

                while((line = bufferedReader.readLine()) != null)
                {
                    
                    // System.out.println("hi");
                    System.out.println(line);
                }
                
                System.out.println("done");
            } catch (IOException e) {
                System.out.println(e);
            }
    }

    private static void getTheHost() {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the host name:");
        host = scan.nextLine();
    }
    
}
