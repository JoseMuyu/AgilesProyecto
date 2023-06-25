package Complementos;

// Made by JosliBlue

import java.awt.Cursor;
import java.util.ArrayList;
import javax.swing.JLabel;

public class ManejoComponentes {
    private final String rutaImagenes = "src\\main\\java\\Imagenes\\";
    
    
// <editor-fold defaultstate="collapsed" desc=" METODOS PARA LABELS ">
    public void crearlabel(JLabel label,String nombreImg) {
        rsscalelabel.RSScaleLabel.setScaleLabel(label, this.rutaImagenes+nombreImg);
    }
// </editor-fold>  
    
// <editor-fold defaultstate="collapsed" desc=" CONTROLES TXTFIELDS ">
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
}