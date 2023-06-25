package Ventanas;

// Made by JosliBlue

import Complementos.ManejoComponentes;
import Principal.AdminPrograma;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    AdminPrograma ap = new AdminPrograma();
    ManejoComponentes mc = new ManejoComponentes();
    public Login() {
        this.initFrontend();
    }
// METODOS ---------------------------------------------------------------------
// <editor-fold defaultstate="collapsed" desc=" METODOS INICIADORES "> 
    public void initFrontend(){
        lookAndFeel(); /* Set the Nimbus look and feel */
        initComponents();
        setLocationRelativeTo(null);
        this.mc.crearBoton(this.btnCerrar, "ico_cerrar.png", "ico_cerrar_hover.png");
        this.mc.crearBoton(this.btnMinimizar, "ico_minimizar.png", "ico_minimizar_hover.png");
        this.mc.crearBoton(this.btnRegistrarme, "", "");
        this.txtContrasenia.setEchoChar('\u2022');
    }
// </editor-fold>
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JLabel();
        pnlDerechaRegistro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtContraseniaResgister = new javax.swing.JTextField();
        txtCedRegister = new javax.swing.JTextField();
        txtMailRegister = new javax.swing.JTextField();
        lblXD = new javax.swing.JLabel();
        lblXD3 = new javax.swing.JLabel();
        lblXD4 = new javax.swing.JLabel();
        btnIniciarSesion = new javax.swing.JButton();
        lblXD2 = new javax.swing.JLabel();
        btnRegistrarme = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblXD1 = new javax.swing.JLabel();
        lblMensajeErrores = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(750, 550));

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });
        pnlPrincipal.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 3, 27, 27));

        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
        });
        pnlPrincipal.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 3, 27, 27));

        pnlDerechaRegistro.setBackground(new java.awt.Color(153, 255, 153));
        pnlDerechaRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro");
        pnlDerechaRegistro.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 380, 100));

        txtContraseniaResgister.setBackground(new java.awt.Color(255, 255, 255));
        txtContraseniaResgister.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        txtContraseniaResgister.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 3, true));
        pnlDerechaRegistro.add(txtContraseniaResgister, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 250, 40));

        txtCedRegister.setBackground(new java.awt.Color(255, 255, 255));
        txtCedRegister.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        txtCedRegister.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 3, true));
        pnlDerechaRegistro.add(txtCedRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 250, 40));

        txtMailRegister.setBackground(new java.awt.Color(255, 255, 255));
        txtMailRegister.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        txtMailRegister.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 3, true));
        pnlDerechaRegistro.add(txtMailRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 250, 40));

        lblXD.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lblXD.setForeground(new java.awt.Color(51, 51, 51));
        lblXD.setText("Contraseña:");
        pnlDerechaRegistro.add(lblXD, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 340, -1, -1));

        lblXD3.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lblXD3.setForeground(new java.awt.Color(51, 51, 51));
        lblXD3.setText("Cedula:");
        pnlDerechaRegistro.add(lblXD3, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 180, -1, -1));

        lblXD4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lblXD4.setForeground(new java.awt.Color(51, 51, 51));
        lblXD4.setText("Correo electronico:");
        pnlDerechaRegistro.add(lblXD4, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 260, -1, -1));

        pnlPrincipal.add(pnlDerechaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 370, 550));

        btnIniciarSesion.setBackground(new java.awt.Color(153, 255, 153));
        btnIniciarSesion.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(0, 0, 0));
        btnIniciarSesion.setText("Iniciar Sesion");
        btnIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIniciarSesionMouseClicked(evt);
            }
        });
        pnlPrincipal.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 450, 160, 50));

        lblXD2.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lblXD2.setForeground(new java.awt.Color(51, 51, 51));
        lblXD2.setText("Contraseña:");
        pnlPrincipal.add(lblXD2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        btnRegistrarme.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnRegistrarme.setForeground(new java.awt.Color(51, 51, 51));
        btnRegistrarme.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnRegistrarme.setText("Registrarme");
        btnRegistrarme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarmeMouseClicked(evt);
            }
        });
        pnlPrincipal.add(btnRegistrarme, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 530, 70, -1));

        txtContrasenia.setBackground(new java.awt.Color(255, 255, 255));
        txtContrasenia.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        txtContrasenia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 3, true));
        txtContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraseniaKeyTyped(evt);
            }
        });
        pnlPrincipal.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 250, 40));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SmartHealth");
        pnlPrincipal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 370, 100));

        txtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtUsuario.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        txtUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 3, true));
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        pnlPrincipal.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 250, 40));

        lblXD1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lblXD1.setForeground(new java.awt.Color(51, 51, 51));
        lblXD1.setText("Cedula o correo electronico:");
        pnlPrincipal.add(lblXD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        lblMensajeErrores.setForeground(new java.awt.Color(255, 0, 0));
        lblMensajeErrores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMensajeErrores.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblMensajeErrores.setPreferredSize(new java.awt.Dimension(250, 50));
        pnlPrincipal.add(lblMensajeErrores, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 382, 250, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

// EVENTOS ---------------------------------------------------------------------
    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        dispose();
        System.exit(0);
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void btnIniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseClicked
        String respuesta = this.ap.compLogin(this.txtUsuario.getText().trim(), this.mc.claveToString(this.txtContrasenia));
        if(!respuesta.isBlank()){
            String error1 = "";
            String error2 = "";
            String error3 = "";
            String error4 = "";
            for(int i=0; i<respuesta.length(); i++){
                if(respuesta.charAt(i) == 'b'){
                    this.mc.colorTextFieldJ(this.txtUsuario, Color.RED,Color.GREEN);
                    error1 = "*Campo vacio<br>";
                }
                if(respuesta.charAt(i) == 'c' || respuesta.charAt(i) == 'd'){
                    this.mc.colorTextFieldJ(this.txtUsuario, Color.RED,Color.GREEN);
                    this.mc.colorTextFieldJ(this.txtContrasenia, Color.RED,Color.GREEN);
                    error2 = "*Usuario cedula incorrecto<br>";
                }
                if(respuesta.charAt(i) == 'm' || respuesta.charAt(i) == 'o'){
                    this.mc.colorTextFieldJ(this.txtUsuario, Color.RED,Color.GREEN);
                    this.mc.colorTextFieldJ(this.txtContrasenia, Color.RED,Color.GREEN);
                    error3 = "*Correo electronico incorrecto<br>";
                }
                if(respuesta.charAt(i) == 'p'){
                    this.mc.colorTextFieldJ(this.txtContrasenia, Color.RED,Color.GREEN);
                    error4 = "*Contraseña incorrecta";
                }
            }
            this.lblMensajeErrores.setText("<html>"+error1+error2+error3+error4+"</html>");
            return;
        }
        if(this.ap.intentarIngresar(this.txtUsuario.getText().trim(), this.mc.claveToString(this.txtContrasenia))){
            JOptionPane.showMessageDialog(this, "Ingresaste correctamente");
        }else{
            this.lblMensajeErrores.setText("Usuario y/o contraseña incorrecta");
        }
    }//GEN-LAST:event_btnIniciarSesionMouseClicked

    private void btnRegistrarmeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarmeMouseClicked
        if(this.pnlDerechaRegistro.isVisible()){
            this.pnlDerechaRegistro.setVisible(false);
        }else{
            this.pnlDerechaRegistro.setVisible(true);
        }
    }//GEN-LAST:event_btnRegistrarmeMouseClicked

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        this.lblMensajeErrores.setText("");
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtContraseniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseniaKeyTyped
        this.lblMensajeErrores.setText("");
    }//GEN-LAST:event_txtContraseniaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JLabel btnRegistrarme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblMensajeErrores;
    private javax.swing.JLabel lblXD;
    private javax.swing.JLabel lblXD1;
    private javax.swing.JLabel lblXD2;
    private javax.swing.JLabel lblXD3;
    private javax.swing.JLabel lblXD4;
    private javax.swing.JPanel pnlDerechaRegistro;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextField txtCedRegister;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtContraseniaResgister;
    private javax.swing.JTextField txtMailRegister;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables


// <editor-fold defaultstate="collapsed" desc=" look and feel "> 
    public static void lookAndFeel(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
// </editor-fold>   
}