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
            Integer O = 5;
            objOut.writeObject(O);

            try{
                Integer I = (Integer)objIn.readObject();

                System.out.println("Objet reçu (client) "+I);
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }



            //Voiture V = new Voiture();
            //objOut.writeObject(V);
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
