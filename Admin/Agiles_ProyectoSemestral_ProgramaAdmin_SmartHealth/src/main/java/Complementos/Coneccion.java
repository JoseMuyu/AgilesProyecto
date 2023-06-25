package Complementos;

// Made by JosliBlue

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Coneccion {
    
    private Firestore bd;

// <editor-fold defaultstate="collapsed" desc=" Codigo iniciador "> 
    /*
    Inicializa un objeto Conexion dentro del mismo para utilizar uno y solo uno
    durante toda la ejecucion del programa
     */
    private static Coneccion conex;

    private Coneccion() {
        this.conectarFB();
    }
    static {
        conex = new Coneccion();
    }
    public static Coneccion cargarConexion() {
        return conex;
    }
    private void setBd(Firestore bd) {
        this.bd = bd;
    }
    public Firestore getBd() {
        return this.bd;
    }
// </editor-fold>

    private void conectarFB() {
        try {
            FileInputStream sa = new FileInputStream("fileConection.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(sa))
                    .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);
            this.setBd(FirestoreClient.getFirestore());
            if (this.getBd() != null) {
                System.out.println("Conectado a FireBase. . .");
            } else {
                System.out.println("No conectado a FireBase. . .");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error archivo no encontrado\nen el metodo conectarFD\n" + e);
        } catch (Exception e) {
            System.out.println("Error al comunicarse con la bd\nen el metodo conectarFB\n" + e);
        }
    }

}