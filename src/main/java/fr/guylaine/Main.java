package fr.guylaine;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static int askAction(Scanner scanner){
        System.out.println( "Please, which service is this terminal for ? \n");
        System.out.println( "1 - Server\n2 - Client\n0 - Exit the terminal");

        int action = scanner.nextInt(); //Read the next Integer from the User

        //Check of the action is valid
        while (action < 0 || action > 2) {
            System.out.println( action + " is not a valid choice !");
            System.out.println( "Please, which service is this terminal for ? \n");
            System.out.println(" 1 - Server\n2 - Client\n0 - Exit the terminal");
            action = scanner.nextInt();
        }

        return action;
    }
    public static int askPort (Scanner scanner){
        System.out.println( "Which port number do you want to use ? (0 to exit)");

        int port = scanner.nextInt(); //Read the next Integer from the User

        //Check of the port is valid
        while (port < 0 || 9999 < port) {
            System.out.println("The port number " + port + " is not accepted.");
            System.out.println("Please, select a valid number between 1-9999 !");
            port = scanner.nextInt();
        }

        return port;
    }
    public static void main(String[] args) throws IOException {


        //Create Scanner to read entries
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        int action = askAction(scanner); // Get action of the user

        if (action == Action.SHUTDOWN.getAction()) // Shutdown if action == shutdown
            return;

        int port = askPort(scanner); // Get port number

        if (port == Action.SHUTDOWN.getAction()) // Shutdown if action == shutdown
            return;

        //Creation of the service !
        System.out.println("Creation of the service...\n");

        if (action == Action.CREATE_SERVER.getAction())
            createServer(port);
        else if (action == Action.CREATE_CLIENT.getAction())
            createClient(port);

    }

    /**
     * Create a server on the specified port
     * @param port
     * @throws IOException
     */
    private static void createServer(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket((port));
        Server server = new Server(serverSocket);
        server.startServer();
    }

    /**
     * Create a client on the specified port
     * @param port
     * @throws IOException
     */
    private static void createClient(int port) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username for the group chat: ");
        String username = scanner.nextLine();
        Socket socket = new Socket("localhost", port);
        Client client = new Client(socket, username);
        client.listenForMessage();
        client.sendMessage();
        scanner.close();
    }


    /**
     * Enumeration of possible actions of the application
     */
    enum Action {

        SHUTDOWN(0),
        CREATE_SERVER(1),
        CREATE_CLIENT(2);

        private final int action;
        Action(int action) {
            this.action = action;
        }

        public int getAction() {
            return action;
        }
    }

}
