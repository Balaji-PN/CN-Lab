package File.Client;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class FileClient {
    public static void main(String[] args) throws IOException {
        Socket sc = new Socket("127.0.0.1", 13267);
        System.out.println("Connected to server, Receiving File");

        InputStream is= sc.getInputStream();
        FileOutputStream fos = new FileOutputStream("Something");
        is.transferTo(fos);

        System.out.println("File Received Finally!");
        fos.close();
        is.close();
        sc.close();
    }
}
