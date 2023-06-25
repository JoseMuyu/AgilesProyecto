package Ventanas;

// Made by JosliBlue

import Complementos.ManejoComponentes;
import Principal.AdminPrograma;
import static Ventanas.Login.lookAndFeel;

public class VentanaProcesos extends javax.swing.JFrame {
    AdminPrograma ap = new AdminPrograma();
    ManejoComponentes mc = new ManejoComponentes();

    public VentanaProcesos() {
        this.initFrontend();
    }
// METODOS ---------------------------------------------------------------------
    public void initFrontend(){
        lookAndFeel(); /* Set the Nimbus look and feel */
        initComponents();
        setLocationRelativeTo(null);
        this.mc.crearBoton(this.btnCerrar, "ico_cerrar.png", "ico_cerrar_hover.png");
        this.mc.crearBoton(this.btnMinimizar, "ico_minimizar.png", "ico_minimizar_hover.png");
        this.mc.crearBoton(this.btnCerrarSesion, "ico_cerrar.png", "ico_cerrarSesion_hover.png");
    }
    public void lanzarVentana(String userName){
        this.lblUserNameGeneral.setText(userName);
        setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBase = new javax.swing.JPanel();
        btnCerrarSesion = new javax.swing.JLabel();
        lblUserNameGeneral = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlBase.setPreferredSize(new java.awt.Dimension(900, 630));
        pnlBase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlBase.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(867, 596, 29, 29));

        lblUserNameGeneral.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        lblUserNameGeneral.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pnlBase.add(lblUserNameGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 596, 170, 29));

        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });
        pnlBase.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 3, 27, 27));

        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
        });
        pnlBase.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(838, 3, 27, 27));

        jPanel1.setBackground(new java.awt.Color(255, 0, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        pnlBase.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 7, 900, 583));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCerrar;
    public javax.swing.JLabel btnCerrarSesion;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblUserNameGeneral;
    private javax.swing.JPanel pnlBase;
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
            java.util.logging.Logger.getLogger(VentanaProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
// </editor-fold>   
}