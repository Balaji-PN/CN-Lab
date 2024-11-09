package TCP.Client;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        System.out.println("Connected to server");
        BufferedReader cliIp = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader serIp = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter serOp = new PrintWriter(socket.getOutputStream(), true);

        String cliMsg, serMsg;
        while (true){
            System.out.println("Client: ");
            cliMsg = cliIp.readLine();
            serOp.println(cliMsg);

            if("quit".equalsIgnoreCase(cliMsg)) break;

            serMsg = serIp.readLine();
            System.out.println("Server: "+ serMsg);
        }
        socket.close();
    }
}
