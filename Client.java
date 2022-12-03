import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Client {
    static boolean n = true;
    public static int i ;

    public static int m ;

    static Scanner sct = new Scanner(System.in);
    static Object strg ;

    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s = null;
        int i =0;
        try {

            ArrayList<Object> La = new ArrayList<Object>();
            ArrayList<Object> Attrs = new ArrayList<Object>();
            s = new Socket("127.0.0.1", 65530); //Création du socket
            System.out.println("Connexion");


            //Récupération du flux d'entrée/sortie
            InputStream in = s.getInputStream();
            ObjectInputStream objIn = new ObjectInputStream(in);
            OutputStream out = s.getOutputStream();
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            Integer O = 6;
            objOut.writeObject(O);
            System.out.println("Objet envoyé (client" + i + ") :" + O);

            try{
                Integer I= (Integer)objIn.readObject();
                System.out.println("Objet reçu (client"+i+""+ ") :"+I);
                strg= (Object)objIn.readObject();
                System.out.println("Objet reçu (client"+i+""+ ") :"+strg);

                Class strgclass = strg.getClass();
                Field[] attrs = strgclass.getFields();



                La.add("Objet : "+strg);
                La.add("ObjetClass : "+strgclass);
                for( i=0 ; i < attrs.length; i++)
                {
                    Field f = attrs[i];
                    String ClassName = f.getName() ;
                    Class SuperClass = f.getClass().getSuperclass();
                    Class Type=f.getType();


                    Attrs.add("["+i+"]"+f);
                    Attrs.add("ClassNameA["+i+"] : "+ClassName);
                    Attrs.add("SuperClassA["+i+"] : "+SuperClass);
                    Attrs.add("TypeA["+i+"] : "+Type);
                    m=i+1;
                }
                La.add("NBRattributs = "+m) ;
                La.add("Attributs : "+Attrs);

                System.out.println(""+strg);
                //Fenetre fen = new Fenetre(m);

            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            /*
			     System.out.println("Saisissez les attributs de la liste d'objet :");
				 strg = sct.nextLine();
				 for(int x=0;x<str.length();x++){
				     C[x] = str.charAt(x);
				 }
				 System.out.println("Vous avez saisi  : " + strg);
				 */

            objOut.writeObject(La);
            System.out.println("Objet envoyé (client"+i+") :"+La);
            i++;
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




        /*try{
            assert s != null;

            ObjectInput objIn = new ObjectInputStream(in);
            Integer I = (Integer)objIn.readObject();
            System.out.println("Objet reçu (client)"+i+":"+I);
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }*/







    }
}
