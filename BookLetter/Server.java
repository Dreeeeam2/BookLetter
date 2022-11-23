package BookLetter;

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Server {
    private ServerSocket server;
    private Socket socket;
    public void start(){
        try {
            server  = new ServerSocket(8998);
            System.out.println("The server is Ready");
            while (true){
                System.out.println("Wait for the Client...");
socket = server.accept();
BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Scanner sc =new Scanner(System.in);
                System.out.println("what's name of Client?");
                String  n = sc.nextLine();
                System.out.println("welcome!!"+n);
while(true){
    String msg = reader.readLine();
    if("exit".equals(msg)){
        System.out.println("Client is back...");
        break;
    }
    System.out.println(n+":"+msg);
}
reader.close();
socket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Server tcp = new Server();
        tcp.start();
    }
}