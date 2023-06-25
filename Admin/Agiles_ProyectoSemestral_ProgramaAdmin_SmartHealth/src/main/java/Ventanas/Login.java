package Ventanas;

// Made by JosliBlue

import Complementos.ManejoComponentes;
import Principal.AdminPrograma;
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
    }
// </editor-fold>
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JLabel();
        pnlDerechaDefault = new javax.swing.JPanel();
        txtClave = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

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

        pnlDerechaDefault.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout pnlDerechaDefaultLayout = new javax.swing.GroupLayout(pnlDerechaDefault);
        pnlDerechaDefault.setLayout(pnlDerechaDefaultLayout);
        pnlDerechaDefaultLayout.setHorizontalGroup(
            pnlDerechaDefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        pnlDerechaDefaultLayout.setVerticalGroup(
            pnlDerechaDefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        pnlPrincipal.add(pnlDerechaDefault, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 380, 550));

        txtClave.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        txtClave.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 255, 204), 2, true));
        pnlPrincipal.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 250, 40));

        txtUsuario.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        txtUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 255, 204), 2, true));
        pnlPrincipal.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 250, 40));

        jButton1.setText("Iniciar Sesion");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        pnlPrincipal.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, -1, -1));

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

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if(this.ap.intentarIngresar(this.txtUsuario.getText().trim(), this.txtClave.getText().trim())){
            JOptionPane.showMessageDialog(this, "Iniciaste");
        }
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel pnlDerechaDefault;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextField txtClave;
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