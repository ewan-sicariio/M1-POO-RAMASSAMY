import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;

public class MonThread extends Thread{
    private final Socket client ;
    Scanner sc = new Scanner(System.in);
    char[] C;
    Object str ;

    public MonThread(String s, Socket client) throws IOException{
        this.client = client;
        ObjectInputStream objIn = new ObjectInputStream(client.getInputStream());
        ObjectOutputStream objOut = new ObjectOutputStream(client.getOutputStream());
    }
    public void run() {
        System.out.println("Client connecté ("+this.getName()+"): "+client.getInetAddress().toString());

            OutputStream out;
            ObjectOutputStream objOut;
            InputStream in;
            ObjectInputStream objIn;
            Integer I = 3;

            Random rand = new Random();

            synchronized (this) {
                try {
                    out = client.getOutputStream();
                    objOut = new ObjectOutputStream(out);
                    //objOut.writeObject(Serveur.L.get(rand.nextInt(Serveur.L.size())));
                    objOut.writeObject((Serveur.L).getFirst());
                    System.out.println("Objet envoyé (" + this.getName() + ") :" + (Serveur.L).getFirst());
                    Serveur.L.remove();
                    System.out.println("Liste apres remove : " + Serveur.L);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    out = client.getOutputStream();
                    objOut = new ObjectOutputStream(out);
                    synchronized (this) {
                        objOut.writeObject((Serveur.L).getFirst());
                        System.out.println("Objet envoyé (" + this.getName() + ") :" + (Serveur.L).getFirst());
                        Serveur.L.remove();
                        System.out.println("Liste apres remove : " + Serveur.L);
                    }
                } catch (IOException e1) {
                    throw new RuntimeException(e1);
                }
            }
        }
    }
