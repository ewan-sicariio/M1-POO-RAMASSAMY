import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread.*;



 public class MonThread extends Thread {


     private Socket client;

     Scanner sc = new Scanner(System.in);
     char[] C;
     Object str;

     public MonThread(String name, Socket client) {
         super(name);
         ObjectOutputStream objOut;
         InputStream in;
         ObjectInputStream objIn;
         Integer I = 3;

         Random rand = new Random();

         synchronized (this) {

             try {
                 OutputStream out = client.getOutputStream();
                 objOut = new ObjectOutputStream(out);
                 //objOut.writeObject(Serveur.L.get(rand.nextInt(Serveur.L.size())));
                 objOut.writeObject((Serveur.L).getFirst());
                 System.out.println("Objet envoyé (" + this.getName() + ") :" + (Serveur.L).getFirst());
                 Serveur.L.remove();
                 System.out.println("Liste apres remove : " + Serveur.L);
             } catch (IOException e1) {
                 e1.printStackTrace();
             }

         }

         try {
             in = client.getInputStream();
             objIn = new ObjectInputStream(in);
             synchronized (this) {
                 Serveur.Ls.add((Object) objIn.readObject());
                 System.out.println("Objet reçu (" + this.getName() + ") :" + Serveur.Ls);
             }
         } catch (IOException | ClassNotFoundException e1) {
             e1.printStackTrace();
         }

         synchronized (this) {


             try {
                 in = client.getInputStream();
                 objIn = new ObjectInputStream(in);
                 //Integer O = (Integer)objIn.readObject();
                 Serveur.Ls.add((Object) objIn.readObject());
                 System.out.println("Objet reçu (" + this.getName() + ") :" + Serveur.Ls);
             } catch (IOException | ClassNotFoundException e1) {
                 e1.printStackTrace();
             }


         }
     }
 }
