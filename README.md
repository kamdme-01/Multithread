# Multithread TCP
A multithreaded TCP server is a server application that is designed to handle multiple client connections concurrently using multiple threads. In this project, the focus is on developing a multithreaded TCP server and an appropriate client. The server will be responsible for accepting incoming client connections, managing the communication, and processing the received messages. On the other hand, the client will establish a connection with the server, send requests and receive responses.

### Implementation of the multithread TCP Server
To run this program you need to download the file "Multithread-1.0-SNAPSHOT".
After that run it with git bash by entering in the terminal the command :
```markdown
java -jar Multithread-1.0-SNAPSHOT.jar
```
Then choose a service "Server" or "Client" by typing 1 or 2
```markdown
1- Sever
2- Client
```
After that enter the port number between 1 and 9999 if it is a Client you see
```markdown
In which port do you want to connect?
```
And then you can enter a username for the Client if you have choose option 2 before
```markdown
Enter your username for the group chat:
```
We can visualize in the server that one client has been connected
```markdown
A new client has connected
```
And finally exchange messages between 02 clients (guylaine and joe) previously set up
```markdown
Enter your username for the group chat:
guylaine
SERVER: joe has entered the chat!
joe : 12 s'yug wolleh
```