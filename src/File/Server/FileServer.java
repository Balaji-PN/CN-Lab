package File.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serv = new ServerSocket(13267);
        while (true) {
            System.out.println("Waiting...");
            Socket cliSoc = serv.accept();
            File myFile = new File("src/File/Server/ex6.pkt");
            byte[] fileBt = new byte[(int) myFile.length()];
            FileInputStream fis = new FileInputStream(myFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            bis.read(fileBt, 0, fileBt.length);
            OutputStream os = cliSoc.getOutputStream();
            os.write(fileBt, 0, fileBt.length);
            os.flush();
            os.close();
        }
    }
}
