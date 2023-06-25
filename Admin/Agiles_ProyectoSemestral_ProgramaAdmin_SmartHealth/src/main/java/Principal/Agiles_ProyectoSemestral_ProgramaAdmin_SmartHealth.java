package Principal;

import Complementos.Coneccion;
import Ventanas.Login;

public class Agiles_ProyectoSemestral_ProgramaAdmin_SmartHealth {

    public static void main(String[] args) {
        //tambien en la clase ManejoFB
        Coneccion cn = Coneccion.cargarConexion();
        
        Login ventanita = new Login();
        ventanita.setVisible(true);
    }
}
