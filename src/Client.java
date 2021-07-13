import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        System.out.println("Client started........................");
        try (Socket socket = new Socket("192.168.43.79", 9000)) {
            Scanner in = new Scanner(socket.getInputStream());
            String fileName = "E:\\workspace-ij\\filetransferusingsocket\\src\\sample.txt";
            File myFile = new File(fileName);
            FileReader fr = new FileReader(myFile);
            BufferedReader br = new BufferedReader(fr);
            PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);
            pr.println(fileName);

            String line;
            while ((line = br.readLine()) != null) {
                Thread.sleep(1000);
                pr.println(line);
                System.out.println(in.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}