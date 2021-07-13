import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        try {
            System.out.println("Server started and accepting........................");
            socket = new ServerSocket(9000).accept();
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);
            String filename = in.nextLine();
            System.out.println("File name " + filename);

            while (true) {
                Thread.sleep(1000);
                System.out.println(in.nextLine());
                pr.println("packets received");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}