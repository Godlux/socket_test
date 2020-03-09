import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(8001);
                System.out.println("Server started");
                clientSocket = server.accept(); // ждём подключения

                try {
                    // обрабатываем подключение
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    // обрабатываем входящие данные
                    String word = in.readLine();
                    System.out.println(word);

                    // отвечаем серверу
                    out.write("Hello, i am a server! You send me: " + word + "\n");
                    out.flush();
                }
                finally {
                    clientSocket.close();
                    in.close();
                    out.close();
                }

            } finally {
                server.close();
            }
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }
}
