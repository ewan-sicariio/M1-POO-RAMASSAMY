import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Serveur {

    public static void main(String[] args) throws UnknownHostException, IOException {
        try {
            //On écoute sur le port <65530>
            ServerSocket ecoute = new ServerSocket(65530);
            while (true) {
                //On accepte une demande de connexion d'un client
                Socket client = ecoute.accept();
                InputStream in = client.getInputStream();
                OutputStream out = client.getOutputStream();
                ObjectInputStream objIn = new ObjectInputStream(in);
                ObjectOutputStream objOut = new ObjectOutputStream(out);
                Integer I = 3;
                objOut.writeObject(I);
                //UnObjet O = (UnObjet) objIn.readObject(I);
                client.close();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

    }
}