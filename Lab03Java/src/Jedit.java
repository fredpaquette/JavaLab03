import java.io.Console;

/**
 * Created by Razma on 2015-02-09.
 */
public class Jedit {

   private void WithNumber(String fileName) {
       int compteur = 0;
       java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
       String ligne = new String();
       String buffer = new String();

          if(Verif(fileName)) {
              try {
                  java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.BufferedWriter(new java.io.FileWriter(fileName)));
                  ligne = reader.readLine();
                  while (!ligne.isEmpty()) {
                      if (!buffer.isEmpty()) {
                          writer.println(compteur + ": " + buffer);
                      }
                      buffer=ligne;
                      ligne = reader.readLine();
                      compteur++;
                  }
                  if (!buffer.isEmpty())
                  {
                      writer.print(compteur + ": " + buffer);
                  }
                  writer.close();
              }
              catch (java.io.IOException e) {
                  System.out.println("Erreur lors de la lectureS");
                  System.exit(1);
              }
          }
   }
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void WithoutNumber(String fileName) {

        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String ligne = new String();
        String buffer = new String();

        if(Verif(fileName)) {
            try {
                java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.BufferedWriter(new java.io.FileWriter(fileName)));
                ligne = reader.readLine();
                while (!ligne.isEmpty()) {
                    if(!buffer.isEmpty()) {
                        writer.println(buffer);
                    }
                    buffer = ligne;
                    ligne = reader.readLine();
                }
                if (!buffer.isEmpty())
                {
                writer.print(buffer);
                }
                writer.close();

            } catch (java.io.IOException e) {
                System.out.println("Erreur lors de la lectureS");
                System.exit(1);
            }
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void editer( String args[] ) {
        if(args.length > 0 && args.length < 3)
        {
            if(args[0].equals("-n") &&args.length == 2 )
                WithNumber(args[1]);
           else
            if(args.length == 1 )
                WithoutNumber(args[0]);
       }
    }
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private boolean Verif(String fileName) {
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        java.io.File file = new java.io.File(fileName);
        String line = new String();

        if(file.exists()) {
            System.out.println("le fichier existe deja voulez vous l'écraser O(Oui) N(Non): ");

            try {
                line = reader.readLine();
            } catch (java.io.IOException e) {
                System.out.println(e);
                System.exit(1);
            }
            if (line.equals("O") || line.equals("o")) {
                file.delete();
                return true;
            } else
                return false;
        }
        else
           return true;
    }
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main( String args[] ) {
        Jedit app = new Jedit();
        app.editer( args );
    }

}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////