package Principal;

// Made by JosliBlue

import Complementos.*;

public class AdminPrograma {
    private Encripteishon en = new Encripteishon();
    private ManejoFB mfb = new ManejoFB();
    
    public boolean intentarIngresar(String user, String pass){
        return this.mfb.iniciarSesion(user, this.en.Encriptar(pass));
    }
}