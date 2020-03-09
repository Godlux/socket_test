import java.io.*;
import java.net.Socket;

public class Client {

    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            try {
                clientSocket = new Socket("localhost", 8001);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                // read user input
                System.out.print("Message to server: ");
                String word = reader.readLine();

                // send to server
                out.write(word + "\n");
                out.flush();

                // wait answer and print it
                String serverResponseWord = in.readLine();
                System.out.println(serverResponseWord);
            }
            finally {
                System.out.println("Client was closed");
                clientSocket.close();
                in.close();
                out.close();
            }
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }
}
