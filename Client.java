import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
       Socket s = null;
       try{
           s = new Socket("127.0.0.1", 65530); //Création du socket
           //Récupération du flux d'entrée/sortie
           InputStream in = s.getInputStream();
           OutputStream out = s.getOutputStream();
           ObjectOutputStream objOut = new ObjectOutputStream(out);
           ObjectInputStream objIn = new ObjectInputStream(in);
           Integer I = (Integer)objIn.readObject();
           I.toString();
            System.out.println(I);
           //Voiture V = new Voiture();
           //objOut.writeObject(V);
           s.close();
       } catch (IOException | ClassNotFoundException e) {
           System.err.println(e);
       }

    }
}
