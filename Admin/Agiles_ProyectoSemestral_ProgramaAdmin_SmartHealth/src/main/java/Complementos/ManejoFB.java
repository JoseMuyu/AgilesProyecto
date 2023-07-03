package Complementos;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

// Made by JosliBlue
public class ManejoFB {

    Coneccion cn = Coneccion.cargarConexion();

// <editor-fold defaultstate="collapsed" desc=" METODOS VENTANA LOGIN ">
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
// </editor-fold> 

// <editor-fold defaultstate="collapsed" desc=" METODOS PESTANIA ALIMENTOS ">
// </editor-fold> 
    public void guardarRegistro(String coleccion, String documento, Map<String, Object> data) {
        try {
            DocumentReference docRef = cn.getBd().collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(data);
            if (result.isDone()) {
                JOptionPane.showMessageDialog(null, "Registro agregado con exito");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error guardarAlimento(ManejoFB) \n" + e);
        }
    }

    public void guardarRegistroImg(String coleccion, String documento, Map<String, Object> data, String urlImg) {
        try {
            DocumentReference docRef = cn.getBd().collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(data);
            
            String nombreArchivo = documento + ".png";
            BlobId blobId = BlobId.of(cn.getRaiz().getName(), "imgAlimentos/" + nombreArchivo);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType("png")  // Establecer el tipo de contenido como "image/png"
                .build();
            Blob blob = cn.getRaiz().create(blobInfo.getName(), new FileInputStream(urlImg));
            if (blob.exists()) {
                System.out.println("Info e Imagen almacenada exitosamente en Firebase");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error guardarAlimento(ManejoFB) \n" + e);
        }
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

    public Object[] obtenerDatos(String nomCollection, String nombreColumna) {
        try {
            CollectionReference coleccion = cn.getBd().collection(nomCollection);
            ApiFuture<QuerySnapshot> querySnap = coleccion.get();
            QuerySnapshot querySnapshot = querySnap.get();

            // Crear arreglo para almacenar los valores de la columna
            Object[] valoresColumna = new Object[querySnapshot.size()];

            // Iterar sobre los documentos
            int i = 0;
            for (DocumentSnapshot document : querySnapshot.getDocuments()) {
                // Obtener el valor de la columna específica
                Object columnaValue;
                if (nombreColumna.equalsIgnoreCase("ID")) {
                    columnaValue = document.getId();
                } else {
                    columnaValue = document.get(nombreColumna);
                }

                // Agregar el valor al arreglo
                if (columnaValue != null) {
                    valoresColumna[i] = columnaValue;
                } else {
                    valoresColumna[i] = ""; // Agregar un valor vacío si la columna es null
                }
                i++;
            }

            return valoresColumna;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos de la columna (ManejoFB)\n" + e);
        }

        return null; // Si ocurre un error, devolvemos un arreglo vacío
    }

    public String[] obtenerDatosDocumento(String nombreColeccion, String idDocumento) {
        try {
            DocumentReference docRef = cn.getBd().collection(nombreColeccion).document(idDocumento);
            ApiFuture<DocumentSnapshot> future = docRef.get();
            DocumentSnapshot document = future.get();

            if (document.exists()) {
                Map<String, Object> datos = new LinkedHashMap<>(document.getData());

                String[] arrayDatos = new String[datos.size()];
                int i = 0;

                for (Map.Entry<String, Object> entry : datos.entrySet()) {
                    /*arrayDatos[i] = entry.getKey() + ": " + entry.getValue();*/
                    arrayDatos[i] = entry.getValue().toString();
                    i++;
                }

                return arrayDatos;
            } else {
                System.out.println("El documento no existe.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new String[0];
    }

    public void asignarImagenALabel(JLabel label, String nombreImagen) {
        try {
            // Obtener referencia al archivo de imagen en Firebase Cloud Storage
            Blob blob = cn.getRaiz().get("imgAlimentos/" + nombreImagen);

            if (blob != null) {
                // Obtener los bytes de la imagen del blob
                byte[] bytes = blob.getContent();

                // Crear una imagen desde los bytes
                ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
                BufferedImage bufferedImage = ImageIO.read(inputStream);

                // Redimensionar la imagen para que ocupe todo el label
                Image resizedImage = bufferedImage.getScaledInstance(160, 125, Image.SCALE_SMOOTH);

                // Crear un ImageIcon a partir de la imagen redimensionada
                ImageIcon icon = new ImageIcon(resizedImage);

                // Asignar la imagen al componente de etiqueta
                FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 0, 0);
                label.setLayout(layout);

                // Centrar la imagen en el JLabel
                //label.setVerticalAlignment(SwingConstants.CENTER);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setIcon(icon);
            } else {
                System.out.println("El archivo de imagen no existe en Firebase Cloud Storage.");
            }
        } catch (IOException e) {
            System.out.println("Error al obtener la imagen desde Firebase Cloud Storage: " + e.getMessage());
        }
    }
}
