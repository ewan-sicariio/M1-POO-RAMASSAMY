import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Serveur {

    public static int i = 0;
    private static final ArrayList<MonThread> thList = new ArrayList<MonThread>();

    public static void main(String[] args) throws UnknownHostException, IOException {
        try {
            //On écoute sur le port <65530>
            ServerSocket ecoute = new ServerSocket(65530);
            while(true){
                System.out.println(">>>> Server :  Waiting for client connection on PORT "+65530);
                Socket client = ecoute.accept();
                System.out.println("Client connected : "+client.getInetAddress().toString());
                System.out.println("Client connected (server) : "+client.getInetAddress().toString());

                MonThread  P = new MonThread(client);
                System.out.println("Thread"+i);
                P.start();
                i++;
                Serveur.thList.add(P);

            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

    }
}