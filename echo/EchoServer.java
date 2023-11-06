import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    

    static ServerSocket serverSocket;
    static int port = 12345; 
    public static void main(String[] args) {
        createServer();
        echoMessage();
    }
    private static void echoMessage() {

        // echo server waiting for client connect after the connect it will excute the remaining line
        try
        {

        
        while(true)
        {
         
            Socket socket = serverSocket.accept();
        
            InputStream inputStream =  socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream,true);
            String line;
            while((line = reader.readLine()) != null)

            {
                System.out.println("message from the client: " + line);
                // echo back to the client
                writer.println(line);
            }

        }    
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
        

    }
    private static void createServer() {
        try {
            // creating the server in port 12345
            serverSocket = new ServerSocket(port);
  
            System.out.println("server is started");    


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
