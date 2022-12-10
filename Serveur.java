import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;


public class Serveur {

    public static int i = 0;
    public static int j = 0;
    public static Point p1 = new Point(1, 2, "a");
    public static Point p2 = new Point(3, 4, "b");
    public static Point p3 = new Point(5, 6, "c");


    public static ArrayList<MonThread> Ps = new ArrayList<MonThread>();

    //Liste d'Objet Quelconque
    public static LinkedList<Object> L = new LinkedList<Object>();

    //Liste des  attributs des Objets
    public static LinkedList<Object> Ls = new LinkedList<Object>();

    public static void main(String[] args) {
        for (j = 0; j < 5; j++) {
            L.add(j);
        }

        try {
            L.add(p1);
            L.add(p2);
            L.add(p3);
            System.out.println("Bienvenue sur le serveur");
            System.out.println("Voici une liste d'objet : " + L);

            // On écoute sur le Port 65530
            ServerSocket ecoute = new ServerSocket(65530);
            System.out.println("Serveur initialisé !");
            Socket client = ecoute.accept();
            System.out.println("Client connected : "+client.getInetAddress().toString());
            MonThread P = new MonThread("Thread" + i, client);
            P.start();
            Ps.add(P);
            i++;




        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
