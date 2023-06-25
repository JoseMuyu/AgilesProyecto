package Principal;

// Made by JosliBlue

import Complementos.*;

public class AdminPrograma {
    private Encripteishon en = new Encripteishon();
    private ManejoFB mfb = new ManejoFB();
    
    public boolean intentarIngresar(String mail, String pass){
        return this.mfb.iniciarSesion(mail, this.en.Encriptar(pass));
    }
}