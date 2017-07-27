/**
 * Created by betty on 7/22/17.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class SimpleHTTPServer {
        public static void main(String[] args) throws IOException {
             ServerSocket serve = new ServerSocket(3000);
            System.out.println("Listening for connection on port 9900 ....");
           Socket clientSocket = serve.accept();
            InputStreamReader isr =  new InputStreamReader(clientSocket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            String line = reader.readLine();

            while (!line.isEmpty()) {
                System.out.println(line);
                line = reader.readLine();
            }
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                clientSocket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
        }
            }