package Complementos;

// Made by JosliBlue
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;

import com.google.firebase.cloud.StorageClient;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Blob;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class Coneccion {

    private Firestore bd;
    private Bucket raiz;
    private String archivo = "fileConection.json";
    private String nombreBucket = "agil-f6e9c.appspot.com";
    private FirebaseApp fba = null;

// <editor-fold defaultstate="collapsed" desc=" Codigo iniciador "> 
    /*
    Inicializa un objeto Conexion dentro del mismo para utilizar uno y solo uno
    durante toda la ejecucion del programa
     */
    private static Coneccion conex;

    private Coneccion() {
        this.conectarFB();
        this.conectarFC();
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

    public void setRaiz(Bucket raiz) {
        this.raiz = raiz;
    }

    public Bucket getRaiz() {
        return this.raiz;
    }
// </editor-fold>

    private void conectarFB() {
        try {
            FileInputStream sa = new FileInputStream(this.archivo);

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(sa))
                    .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
                    .build();

            this.fba.initializeApp(options);
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

    private void conectarFC() {
        try {
            FileInputStream serviceAccount = new FileInputStream(this.archivo);

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            // Verificar si ya existe una instancia de FirebaseApp con el nombre "DEFAULT"
            if (this.fba.getApps().isEmpty()) {
                this.fba.initializeApp(options);
            }

            this.setRaiz(StorageClient.getInstance().bucket(this.nombreBucket));
            if (this.raiz != null) {
                System.out.println("Conectado a Firebase Cloud Storage");
            }
            // Verificar la conexión listando los nombres de los archivos en el bucket
//            System.out.println("Archivos en el bucket:");
//            for (Blob blob : this.getRaiz().list().iterateAll()) {
//                System.out.println(blob.getName());
//            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado en el método conectarFC: " + e);
        } catch (Exception e) {
            System.out.println("Error al comunicarse con Firebase Cloud Storage en el método conectarFC: " + e);
        }
    }

    public void asignarImagenALabel(JLabel label, String nombreImagen) {
    try {
        // Obtener referencia al archivo de imagen en Firebase Cloud Storage
        Blob blob = raiz.get(nombreImagen);

        if (blob != null) {
            // Obtener los bytes de la imagen del blob
            byte[] bytes = blob.getContent();

            // Crear una imagen desde los bytes
            ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
            BufferedImage bufferedImage = ImageIO.read(inputStream);

            // Redimensionar la imagen para que ocupe todo el label
            Image resizedImage = bufferedImage.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);

            // Crear un ImageIcon a partir de la imagen redimensionada
            ImageIcon icon = new ImageIcon(resizedImage);

            // Asignar la imagen al componente de etiqueta
            label.setIcon(icon);
        } else {
            System.out.println("El archivo de imagen no existe en Firebase Cloud Storage.");
        }
    } catch (IOException e) {
        System.out.println("Error al obtener la imagen desde Firebase Cloud Storage: " + e.getMessage());
    }
}

}
