package Principal;

// Made by JosliBlue
import Complementos.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminPrograma {

    private Encripteishon en = new Encripteishon();
    private ManejoFB mfb = new ManejoFB();

    public String compLogin(String user, String clave) {
        String resultado = "";
        String puerta = "";

        if (user.isBlank()) {
            resultado += "b";
            return resultado;
        }
        try {
            int number = Integer.valueOf(user);
            puerta = "number";
        } catch (NumberFormatException e) {
            puerta = "texto";
        }
        if (puerta.equals("number")) {
            if (!this.ctrCedula(user)) {
                resultado += "c";
            } else {
                if (!this.mfb.verificarCampoExistente("Admin", "CED_ADM", user)) {
                    resultado += "d";
                }
            }
        }
        if (puerta.equals("texto")) {
            if (!this.compMail(this.mailToLowercase(user))) {
                resultado += "m";
            } else {
                if (!this.mfb.verificarCampoExistente("Admin", "MAIL_ADM", this.mailToLowercase(user))) {
                    resultado += "o";
                }
            }
        }

        if (clave.isBlank()) {
            resultado += "p";
        }

        return resultado;
    }

    public String compRegistro(String ced, String mail, String clave) {
        String resultado = "";

        if (!this.ctrCedula(ced)) {
            resultado += "c";
        } else {
            if (this.mfb.verificarCampoExistente("Admin", "CED_ADM", ced)) {
                resultado += "d";
            }
        }
        if (!this.compMail(this.mailToLowercase(mail))) {
            resultado += "m";
        } else {
            if (this.mfb.verificarCampoExistente("Admin", "MAIL_ADM", this.mailToLowercase(mail))) {
                resultado += "o";
            }
        }
        if (clave.isBlank()) {
            resultado += "p";
        }

        return resultado;
    }

    public boolean intentarIngresar(String user, String pass) {
        return this.mfb.iniciarSesion(this.mailToLowercase(user), this.en.Encriptar(pass));
    }
    
    public boolean intentarRegistrar(String ced, String mail, String clave){
        return this.mfb.RegistrarAdmin(ced, this.mailToLowercase(mail), clave);
    }

// <editor-fold defaultstate="collapsed" desc=" metodos complementarios "> 
    private boolean ctrCedula(String ced) {
        int a, e, i, o, cont, j, u = 0, y = 0, r = 0, s = 0;
        double z = 0, k = 100000000;
        String ced1 = null;
        ced = ced.trim();
        try {
            ced1 = ced.substring(0, 9);        //*1 *2 *3 *4 *5 *6 *7 *8 *9
            cont = ced1.length();
            //--------------------------------------
            a = Integer.parseInt(ced.substring(0, 2));           //*1 *2
            e = Integer.parseInt(ced.substring(2, 3));           //*3
            i = Integer.parseInt(ced.substring(3, 9));           //*4 *5 *6 *7 *8 *9
            o = Integer.parseInt(ced.substring(9, 10));          //*10
            //--------------------------------------
        } catch (Exception w) {
            return false;
        }
        if (a >= 0 && a <= 24) {
            if (e >= 0 && e < 6) {
                for (j = 0; j < cont; j++) {
                    if (j % 2 == 0) {
                        y = 2;
                    } else {
                        y = 1;
                    }
                    ced1 = ced.substring(j, j + 1);
                    z = Integer.parseInt(ced1);
                    u = (int) (z * y);
                    if (u >= 10) {
                        u = u - 9;
                    }
                    r = r + u;
                }
                s = r;
                //System.out.println(z+"   "+y+"    "+u+"    "+r);
                for (j = 0; s % 10 != 0; j++) {
                    s = s + 1;
                }
                r = s - r;
                //System.out.println(r);
                if (r == 10) {
                    r = 0;
                }
                if (r == o) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    private static boolean compMail(String email) {
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            System.out.println("mail valido");
            return true;
        }
        System.out.println("mail no valido");
        return false;
    }
    
    private String mailToLowercase(String mail){
        String newMail = "";
        
        for(int i=0; i<mail.length(); i++){
            if(Character.isAlphabetic(mail.charAt(i))){
                newMail = newMail + Character.toLowerCase(mail.charAt(i));
            }else{
                newMail = newMail + mail.charAt(i);
            }
        }
        return newMail;
    }
// </editor-fold>   
}
