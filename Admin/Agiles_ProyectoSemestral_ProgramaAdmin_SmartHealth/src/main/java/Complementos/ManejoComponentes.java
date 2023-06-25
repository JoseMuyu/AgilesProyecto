package Complementos;

// Made by JosliBlue

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ManejoComponentes {
    private final String rutaImagenes = "src\\main\\java\\Imagenes\\";
    
    
// <editor-fold defaultstate="collapsed" desc=" METODOS PARA LABELS ">
    public void crearlabel(JLabel label,String nombreImg) {
        rsscalelabel.RSScaleLabel.setScaleLabel(label, this.rutaImagenes+nombreImg);
    }

    public void crearBoton(JLabel label,String nombreImg, String nombreImgHover) {
        rsscalelabel.RSScaleLabel.setScaleLabel(label, rutaImagenes+nombreImg);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rsscalelabel.RSScaleLabel.setScaleLabel(label, rutaImagenes+nombreImgHover);
                label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rsscalelabel.RSScaleLabel.setScaleLabel(label, rutaImagenes+nombreImg);
                label.setCursor(Cursor.getDefaultCursor());
            }
        });
    }
// </editor-fold>
    
    public String claveToString(JPasswordField p){
        char[] passwordChars = p.getPassword();
        String password = new String(passwordChars);
        return password;
    }
    
    public void colorTextFieldJ(JTextField txt, Color colorBad, Color colorGod){
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if(colorGod.equals(Color.GREEN)){
                    txt.setBorder(new LineBorder(new Color(153,255,153), 3));
                }
            }
        });
        txt.setBorder(new LineBorder(colorBad, 3));
    }
}