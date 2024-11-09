package TCP.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket sersoc = new ServerSocket(9999);
        System.out.println("Server Started, waiting for client...");
        Socket clisoc = sersoc.accept();
        System.out.println("Client Connected");
        BufferedReader cliIp = new BufferedReader(new InputStreamReader(clisoc.getInputStream()));
        PrintWriter cliOp = new PrintWriter(clisoc.getOutputStream(), true);
        BufferedReader serIp = new BufferedReader(new InputStreamReader(System.in));
        String cliMsg, serMsg;
        while (true){
            cliMsg = cliIp.readLine();
            System.out.println("Client: " +cliMsg);
            if("quit".equalsIgnoreCase(cliMsg)) break;
            System.out.println("Server: ");
            serMsg = serIp.readLine();
            cliOp.println(serMsg);
        }

        clisoc.close();
        sersoc.close();
    }
}
