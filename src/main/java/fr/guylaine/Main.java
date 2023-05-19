package fr.guylaine;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main (String[] args)  {
        ServerSocket serverSocket = new ServerSocket(1234); //port 1234
        Server server = new Server (serverSocket);
        server.startServer();

        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter your username for the group chat: ");
        String username = scanner.nextLine();
        Socket socket = new Socket ("localhost", 1234);
        Client client = new Client(socket, username);
        client.listenForMessage();
        client.sendMessage();
        ServerSocket serverSocket = new ServerSocket(1234); //port 1234
        Server server = new Server (serverSocket);
        server.startServer();
    }
}
