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
            System.out.println("" + p1.x);
            System.out.println("Liste : " + L);

            // On écoute sur le Port 65530
            ServerSocket ecoute = new ServerSocket(65530);
            System.out.println("Serveur initialisé");
            Socket client = ecoute.accept();
            System.out.println("Client connected : "+client.getInetAddress().toString());
            System.out.println("Client connected (server) : "+client.getInetAddress().toString());
            MonThread P = new MonThread("Thread" + i, client);
            P.start();
            Ps.add(P);
            i++;

			/*


			OutputStream out = client.getOutputStream();
			ObjectOutputStream objOut = new ObjectOutputStream(out);


			InputStream in = client.getInputStream();
			ObjectInputStream objIn = new ObjectInputStream(in);

			Integer I= new Integer(3);
			objOut.writeObject(I);

			try {
				Integer O = (Integer)objIn.readObject();
				System.out.println("Paquet reçu (serveur) :"+O);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			client.close();*/


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


/*import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

public class Serveur {

    public static  int i = 0 ;
    static int tableauEntier[] = {0,1,2,3,4,5,6,7,8,9};
    static double tableauDouble[] = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0};
    static char tableauCaractere[] = {'a','b','c','d','e','f','g'};
    static String tableauChaine[] = {"chaine1", "chaine2", "chaine3" , "chaine4"};

    static Random rand = new Random() ;
    static int choix1 = tableauEntier[ rand.nextInt(tableauEntier.length)] ;
    static double choix2 = tableauDouble[ rand.nextInt(tableauDouble.length)] ;
    static char choix3 = tableauCaractere[ rand.nextInt(tableauCaractere.length)] ;
    static String choix4 = tableauChaine[ rand.nextInt(tableauChaine.length)] ;



    public static int j=0;
    public static ArrayList<MonThread> Ps = new ArrayList<MonThread>() ;

    //Liste d'Objet Quelconque
    public static LinkedList<Object> L = new LinkedList<Object>();

    //Liste des  attributs des Objets
    public static LinkedList<Object> Ls = new LinkedList<Object>();


    //Ports 65530

    public static void main(String[] args) throws UnknownHostException, IOException {

        for(j=0;j<5;j++)
        {
            L.add(j);
        }

        try {
            //On écoute sur le port <65530>
            ServerSocket ecoute = new ServerSocket(65530);
            while(true){
                System.out.println(">>>> Server :  Waiting for client connection on PORT "+65530);
                Socket client = ecoute.accept();
                System.out.println("Client connected : "+client.getInetAddress().toString());
                System.out.println("Client connected (server) : "+client.getInetAddress().toString());

                MonThread  P = new MonThread("Thread"+i,client) ;
                P.start();
                Ps.add(P);
                i++;

            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

    }
}*/