package Complementos;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;

// Made by JosliBlue
public class ManejoFB {

    Coneccion cn = Coneccion.cargarConexion();

    public boolean iniciarSesion(String user, String pass) {
        try {
            CollectionReference adminCollection = cn.getBd().collection("Admin");
            DocumentReference adminDoc = adminCollection.document("adminsito");

            DocumentSnapshot adminSnapshot = adminDoc.get().get();

            if (adminSnapshot.exists()) {
                String cedAdmFirestore = adminSnapshot.getString("CED_ADM");
                String mailAdmFirestore = adminSnapshot.getString("MAIL_ADM");
                String pasAdmFirestore = adminSnapshot.getString("PASS_ADM");

                if ((user.equals(cedAdmFirestore) || user.equals(mailAdmFirestore)) && pass.equals(pasAdmFirestore)) {
                    // Las propiedades coinciden, el documento existe en la colección "Admin"
                    return true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error metodo iniciarSesion(ManejoFB)\n" + e);
        }
        return false;
    }

    public boolean verificarCampoExistente(String nombreColeccion, String nombreCampo, Object datoCampo) {
        CollectionReference coleccion = cn.getBd().collection(nombreColeccion);

        // Construye la consulta para buscar documentos con el campo y valor especificados
        Query consulta = coleccion.whereEqualTo(nombreCampo, datoCampo).limit(1);

        try {
            // Ejecuta la consulta y obtiene los documentos que cumplen la condición
            List<QueryDocumentSnapshot> documentos = consulta.get().get().getDocuments();

            // Verifica si se encontraron documentos
            return !documentos.isEmpty();
        } catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();
            return false;
        }
    }

    public boolean RegistrarAdmin(String ced, String mail, String clave) {
        CollectionReference coleccion = cn.getBd().collection("Admin");

        // Crea un nuevo documento con los campos y valores especificados
        Map<String, Object> datos = new HashMap<>();
        datos.put("CED_ADM", ced);
        datos.put("MAIL_ADM", mail);
        datos.put("PASS_ADM", clave);

        ApiFuture<DocumentReference> resultado = coleccion.add(datos);

        try {
            DocumentReference documento = resultado.get();
            System.out.println("Documento insertado correctamente con ID: " + documento.getId());
            return true;
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al insertar el documento: " + e.getMessage());
        }
        return false;
    }
}
