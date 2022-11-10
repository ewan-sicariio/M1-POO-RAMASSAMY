import java.io.*;
import java.net.Socket;

public class MonThread extends Thread{
    private Socket client = null;
    public MonThread(String s, Socket client) throws IOException{
        this.client = client;
        ObjectInputStream objIn = new ObjectInputStream(client.getInputStream());
        ObjectOutputStream objOut = new ObjectOutputStream(client.getOutputStream());
    }
    public void run() {
        System.out.println("Client connecté ("+this.getName()+"): "+client.getInetAddress().toString());

        OutputStream out ;
        ObjectOutputStream objOut ;
        InputStream in ;
        ObjectInputStream objIn ;
        Integer I= 3;

        try {
            out = client.getOutputStream();
            objOut = new ObjectOutputStream(out);
            objOut.writeObject(I);
            System.out.println("Objet envoyé ("+this.getName()+") :"+I);

            in = client.getInputStream();
            objIn = new ObjectInputStream(in);
            Integer O = (Integer)objIn.readObject();
            System.out.println("Objet reçu ("+this.getName()+") :"+O);


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}