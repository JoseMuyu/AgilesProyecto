package Complementos;

// Made by JosliBlue
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ManejoComponentes {

    private final String rutaImagenes = "src\\main\\java\\Imagenes\\";
    Coneccion conex = Coneccion.cargarConexion();

// <editor-fold defaultstate="collapsed" desc=" METODOS PARA LABELS ">
    public void crearlabel(JLabel label, String nombreImg) {
        rsscalelabel.RSScaleLabel.setScaleLabel(label, this.rutaImagenes + nombreImg);
    }
    public void crearPintura(JLabel label, String nombreImg) {
        conex.asignarImagenALabel(label, nombreImg);
    }

    public void crearBoton(JLabel label, String nombreImg, String nombreImgHover) {
        rsscalelabel.RSScaleLabel.setScaleLabel(label, rutaImagenes + nombreImg);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rsscalelabel.RSScaleLabel.setScaleLabel(label, rutaImagenes + nombreImgHover);
                label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rsscalelabel.RSScaleLabel.setScaleLabel(label, rutaImagenes + nombreImg);
                label.setCursor(Cursor.getDefaultCursor());
            }
        });
    }
    
    
// </editor-fold>

    public String claveToString(JPasswordField p) {
        char[] passwordChars = p.getPassword();
        String password = new String(passwordChars);
        return password;
    }

    public void colorTextFieldJ(JTextField txt, Color colorBad, Color colorGod) {
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if (colorGod.equals(Color.GREEN)) {
                    txt.setBorder(new LineBorder(new Color(153, 255, 153), 3));
                }else{
                    txt.setBorder(new LineBorder(colorGod));
                }
            }
        });
        txt.setBorder(new LineBorder(colorBad, 3));
    }

    public void defaultColorTxt(JTextField txt) {
        txt.setBackground(Color.WHITE);
    }

    public void crearVerPassword(JPasswordField pas, JToggleButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JToggleButton btn = (JToggleButton) e.getSource();
                if (btn.isSelected()) {
                    pas.setEchoChar((char) 0); // Mostrar texto sin ocultarlo
                } else {
                    pas.setEchoChar('\u2022'); // Ocultar texto
                }
            }
        });
    }

    public void limpiarTabla(JTable tbl, DefaultTableModel modelito) {
        int count = tbl.getRowCount();
        for (int i = count; i > 0; i--) {
            modelito.removeRow(i - 1);
        }
    }

    public void txtOnlyLetters(java.awt.event.KeyEvent evt) {
        if (!Character.isAlphabetic(evt.getKeyChar())) {
            evt.consume();
        }
    }

    public void txtOnlyNumbers(java.awt.event.KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }

    public void txtOnlyDoubles(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == '.')) {
            evt.consume(); // Ignorar el evento de teclado si no es un número, punto o coma
        }
    }

}
