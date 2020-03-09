import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Select 1 to run program as Server and 2 to run as Client.");
        String console_input = reader.readLine();

        if (console_input.equals("1")) {
            Server server = new Server();
            server.main(args);
        }
        else if (console_input.equals("2")) {
            Client client = new Client();
            client.main(args);
        }
        else {
            System.out.println("Unexpected input: " + console_input);
        }
    }
}
