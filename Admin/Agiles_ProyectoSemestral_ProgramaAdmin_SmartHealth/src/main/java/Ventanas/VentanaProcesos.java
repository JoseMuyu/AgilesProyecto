package Ventanas;

// Made by JosliBlue
import Complementos.ManejoComponentes;
import Principal.AdminPrograma;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaProcesos extends javax.swing.JFrame {

    AdminPrograma ap = new AdminPrograma();
    ManejoComponentes mc = new ManejoComponentes();

    // variable pestania GestionarAlimentos
    Object[] GA_codigo, GA_nombre, GA_calorias, GA_tipo, GA_estado;
    String[] GA_tblModelTitulos = {"NOMBRE", "CALORIAS", "TIPO", "ESTADO"};
    DefaultTableModel GA_tblModel = new DefaultTableModel(this.GA_tblModelTitulos, 0);
    String[] GA_cmbModelTitulos = {"VERDURA", "FRUTA", "GRANO", "LEGUMBRE", "PROTEINA"};
    DefaultComboBoxModel<String> GA_cmbModel = new DefaultComboBoxModel<>(this.GA_cmbModelTitulos);

    // variables pestania VistaAlimentos
    private List<JButton> VA_botones;

    public VentanaProcesos() {
        this.initFrontend();
    }
// METODOS ---------------------------------------------------------------------

    public void initFrontend() {
        lookAndFeel();
        initComponents();
        setLocationRelativeTo(this);
        Image img = Toolkit.getDefaultToolkit().getImage("src\\main\\java\\Imagenes\\logo_App.png");
        this.setIconImage(img);
        this.mc.crearBoton(this.btnCerrar, "ico_cerrar.png", "ico_cerrar_hover.png");
        this.mc.crearBoton(this.btnMinimizar, "ico_minimizar.png", "ico_minimizar_hover.png");
        this.mc.crearBoton(this.btnCerrarSesion, "ico_cerrar.png", "ico_cerrarSesion_hover.png");
    }

    public void lanzarVentana(String userName) {
        this.lblUserNameGeneral.setText(userName);

        this.cargarDatosAlimentos();
        this.cargarVentanaVsitaAlimentos();
        
        setVisible(true);
    }

// <editor-fold defaultstate="collapsed" desc=" metodos pestania Gestionar Alimentos ">
    public void cargarDatosAlimentos() {
        this.mc.limpiarTabla(this.tbl_GA_alimentos, this.GA_tblModel);

        this.GA_codigo = this.ap.obtenerDatos("Alimentos", "ID");
        this.GA_nombre = this.ap.obtenerDatos("Alimentos", "NOM_ALI");
        this.GA_calorias = this.ap.obtenerDatos("Alimentos", "NUM_CAL_ALI");
        this.GA_tipo = this.ap.obtenerDatos("Alimentos", "TIP_ALI");
        this.GA_estado = this.ap.obtenerDatos("Alimentos", "EST_ALI");

        for (int i = 0; i < this.GA_codigo.length; i++) {
            String estado = "";
            if (this.GA_estado[i].equals(true)) {
                estado = "Habilitado";
            } else {
                estado = "Deshabilitado";
            }
            String[] fila = {this.GA_nombre[i].toString(),
                this.GA_calorias[i].toString(),
                this.GA_tipo[i].toString(),
                estado};
            this.GA_tblModel.addRow(fila);
        }
    }

    public void limpiarAlimentos() {
        this.btn_GA_guardar.setEnabled(true);
        this.btn_GA_actualizar.setEnabled(false);
        this.txt_GA_codigo.setText("");
        this.mc.defaultColorTxt(this.txt_GA_codigo);
        this.txt_GA_nombre.setText("");
        this.mc.defaultColorTxt(this.txt_GA_nombre);
        this.txt_GA_nombre.setBorder(new LineBorder(Color.WHITE));
        this.txt_GA_numCal.setText("");
        this.mc.defaultColorTxt(this.txt_GA_numCal);
        this.txt_GA_numCal.setBorder(new LineBorder(Color.WHITE));
        this.chk_GA_activo.setSelected(true);
        this.cmb_GA_tipos.setSelectedIndex(0);
    }

    public void guardarActualizarAlimentos(int opcion) {
        double number = 0;
        try {
            number = Double.valueOf(this.txt_GA_numCal.getText().trim());
        } catch (Exception e) {
        }
        String respuesta = this.ap.compAlimento(this.txt_GA_nombre.getText().trim(), number);
        if (!respuesta.isBlank()) {
            if (respuesta.contains("n")) {
                this.mc.colorTextFieldJ(this.txt_GA_nombre, Color.RED, Color.WHITE);
            }
            if (respuesta.contains("c")) {
                this.mc.colorTextFieldJ(this.txt_GA_numCal, Color.RED, Color.WHITE);
            }
            return;
        }
        boolean estado;
        if (this.chk_GA_activo.isSelected()) {
            estado = true;
        } else {
            estado = false;
        }
        try {
            Map<String, Object> datos = new HashMap<>();
            datos.put("EST_ALI", estado);
            datos.put("NOM_ALI", this.txt_GA_nombre.getText());
            datos.put("NUM_CAL_ALI", Double.valueOf(this.txt_GA_numCal.getText()));
            datos.put("TIP_ALI", this.cmb_GA_tipos.getSelectedItem().toString());
            if (opcion == 1) {
                this.ap.guardarAlimento("Alimentos", datos);
            } else {
                this.ap.actualizarAlimento("Alimentos", this.txt_GA_codigo.getText(), datos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error metodo guardar/actualizar alimento \n" + e);
        }
        this.cargarDatosAlimentos();
        this.limpiarAlimentos();
    }
// </editor-fold>   

// <editor-fold defaultstate="collapsed" desc=" metodos pestania Vista Alimentos ">
    public void cambiarVista(String opcion) {
        this.pnl_VA_vista.removeAll();
        this.pnl_VA_vista.revalidate();
        this.pnl_VA_vista.repaint();

        for (int i = 0; i < this.GA_codigo.length; i++) {
            JLabel cuadro = new JLabel();
            JLabel pintura = new JLabel();
            JLabel texto = new JLabel(this.GA_nombre[i].toString());
            // Establecer el tamaño y la posición del cuadro y la pintura
            cuadro.setSize(200, 200); // Establecer el tamaño deseado para el cuadro
            cuadro.setBorder(new EmptyBorder(10,10,10,10));
            pintura.setBounds(0, 0, cuadro.getWidth(), (int) (cuadro.getHeight() * 0.9)); // Establecer el tamaño del 90% del cuadro
            texto.setBounds(0, pintura.getHeight(), cuadro.getWidth(), (int) (cuadro.getHeight() * 0.1));
            if (!opcion.equals("TODOS")) {
                if (this.GA_tipo[i].equals(opcion)) {
                    this.mc.crearPintura(pintura, this.GA_codigo[i].toString() + ".png");
                    cuadro.add(pintura);
                    cuadro.add(texto);
                    this.pnl_VA_vista.add(cuadro);
                }
            } else {
                this.mc.crearPintura(pintura, this.GA_codigo[i].toString() + ".png");
                cuadro.add(pintura);
                cuadro.add(texto);
                this.pnl_VA_vista.add(cuadro);
            }
        }
        this.pnl_VA_vista.updateUI();
    }
    
    public void cargarVentanaVsitaAlimentos(){
        this.pnl_VA_botones.removeAll();
        this.pnl_VA_botones.revalidate();
        this.pnl_VA_botones.repaint();
        this.VA_botones = new ArrayList<JButton>();
        for (int i = 0; i < this.GA_cmbModelTitulos.length; i++) {
            final String opcion = this.GA_cmbModelTitulos[i];
            JButton boton = new JButton(this.GA_cmbModelTitulos[i]);
            boton.setSize(new Dimension(100, 40));
            boton.setPreferredSize(new Dimension(100, 40));
            Font font = new Font("Trebuchet MS", Font.PLAIN, 14);
            boton.setFont(font);
            boton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cambiarVista(opcion);
                }
            });
            this.pnl_VA_botones.add(boton);
            this.VA_botones.add(boton);
        }
        this.pnl_VA_botones.updateUI();
    }
// </editor-fold>   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpchk_GA_grupo = new javax.swing.ButtonGroup();
        pnlBase = new javax.swing.JPanel();
        btnCerrarSesion = new javax.swing.JLabel();
        lblUserNameGeneral = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JLabel();
        pnlAlimentos = new javax.swing.JTabbedPane();
        pnlGestionAlimentos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_GA_alimentos = new javax.swing.JTable();
        txt_GA_nombre = new javax.swing.JTextField();
        lbl_GA_nombre = new javax.swing.JLabel();
        lbl_GA_numCal = new javax.swing.JLabel();
        txt_GA_numCal = new javax.swing.JTextField();
        lbl_GA_tipAlimento = new javax.swing.JLabel();
        lbl_GA_estado = new javax.swing.JLabel();
        btn_GA_guardar = new javax.swing.JButton();
        btn_GA_limpiar = new javax.swing.JButton();
        btn_GA_actualizar = new javax.swing.JButton();
        lbl_GA_titulo = new javax.swing.JLabel();
        lbl_GA_codigo = new javax.swing.JLabel();
        txt_GA_codigo = new javax.swing.JTextField();
        cmb_GA_tipos = new javax.swing.JComboBox<>();
        chk_GA_activo = new javax.swing.JRadioButton();
        chk_GA_inactivo = new javax.swing.JRadioButton();
        pnlVistaAlimentos = new javax.swing.JPanel();
        pnl_VA_botones = new javax.swing.JPanel();
        btn_VA_todos = new javax.swing.JButton();
        pnl_VA_vista = new javax.swing.JPanel();
        pnlReportes = new javax.swing.JPanel();
        pnlGestionarUsuarios = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SmartHealth | Home");
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

        pnlGestionAlimentos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_GA_alimentos.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tbl_GA_alimentos.setModel(GA_tblModel);
        tbl_GA_alimentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_GA_alimentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_GA_alimentos);

        pnlGestionAlimentos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 6, 550, 533));

        txt_GA_nombre.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txt_GA_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_GA_nombreKeyTyped(evt);
            }
        });
        pnlGestionAlimentos.add(txt_GA_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 170, 30));

        lbl_GA_nombre.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lbl_GA_nombre.setText("Nombre:");
        pnlGestionAlimentos.add(lbl_GA_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 130, 30));

        lbl_GA_numCal.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lbl_GA_numCal.setText("Numero de calorias:");
        pnlGestionAlimentos.add(lbl_GA_numCal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 130, 30));

        txt_GA_numCal.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txt_GA_numCal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_GA_numCalKeyTyped(evt);
            }
        });
        pnlGestionAlimentos.add(txt_GA_numCal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 170, 30));

        lbl_GA_tipAlimento.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lbl_GA_tipAlimento.setText("Tipo de alimento:");
        pnlGestionAlimentos.add(lbl_GA_tipAlimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 130, 30));

        lbl_GA_estado.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lbl_GA_estado.setText("Estado:");
        pnlGestionAlimentos.add(lbl_GA_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 130, 30));

        btn_GA_guardar.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btn_GA_guardar.setText("Guardar");
        btn_GA_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_GA_guardarMouseClicked(evt);
            }
        });
        pnlGestionAlimentos.add(btn_GA_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 350, 100, 40));

        btn_GA_limpiar.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btn_GA_limpiar.setText("Limpiar");
        btn_GA_limpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_GA_limpiarMouseClicked(evt);
            }
        });
        pnlGestionAlimentos.add(btn_GA_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 350, 100, 40));

        btn_GA_actualizar.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btn_GA_actualizar.setText("Actualizar");
        this.btn_GA_actualizar.setEnabled(false);
        btn_GA_actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_GA_actualizarMouseClicked(evt);
            }
        });
        pnlGestionAlimentos.add(btn_GA_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 350, 100, 40));

        lbl_GA_titulo.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_GA_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_GA_titulo.setText("Base de datos de los alimentos");
        pnlGestionAlimentos.add(lbl_GA_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 300, 50));

        lbl_GA_codigo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lbl_GA_codigo.setText("Codigo:");
        pnlGestionAlimentos.add(lbl_GA_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 130, 30));

        txt_GA_codigo.setEnabled(false);
        txt_GA_codigo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        pnlGestionAlimentos.add(txt_GA_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 170, 30));

        cmb_GA_tipos.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        cmb_GA_tipos.setModel(GA_cmbModel);
        pnlGestionAlimentos.add(cmb_GA_tipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 170, 30));

        grpchk_GA_grupo.add(chk_GA_activo);
        chk_GA_activo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        chk_GA_activo.setText("Activo");
        chk_GA_activo.setSelected(true);
        pnlGestionAlimentos.add(chk_GA_activo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, 30));

        grpchk_GA_grupo.add(chk_GA_inactivo);
        chk_GA_inactivo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        chk_GA_inactivo.setText("Inactivo");
        pnlGestionAlimentos.add(chk_GA_inactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, -1, 30));

        pnlAlimentos.addTab("Gestion Alimentos", pnlGestionAlimentos);

        pnlVistaAlimentos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_VA_botones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_VA_botones.setLayout(new java.awt.GridLayout(0, 1));
        pnlVistaAlimentos.add(pnl_VA_botones, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 120, -1));

        btn_VA_todos.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btn_VA_todos.setText("TODOS");
        btn_VA_todos.setPreferredSize(new java.awt.Dimension(100, 40));
        btn_VA_todos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_VA_todosMouseClicked(evt);
            }
        });
        pnlVistaAlimentos.add(btn_VA_todos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 120, 40));

        pnl_VA_vista.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_VA_vista.setLayout(new java.awt.GridLayout(0, 4));
        pnlVistaAlimentos.add(pnl_VA_vista, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 710, 520));

        pnlAlimentos.addTab("Vista Alimentos", pnlVistaAlimentos);

        javax.swing.GroupLayout pnlReportesLayout = new javax.swing.GroupLayout(pnlReportes);
        pnlReportes.setLayout(pnlReportesLayout);
        pnlReportesLayout.setHorizontalGroup(
            pnlReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        pnlReportesLayout.setVerticalGroup(
            pnlReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        pnlAlimentos.addTab("Reportes", pnlReportes);

        javax.swing.GroupLayout pnlGestionarUsuariosLayout = new javax.swing.GroupLayout(pnlGestionarUsuarios);
        pnlGestionarUsuarios.setLayout(pnlGestionarUsuariosLayout);
        pnlGestionarUsuariosLayout.setHorizontalGroup(
            pnlGestionarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        pnlGestionarUsuariosLayout.setVerticalGroup(
            pnlGestionarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        pnlAlimentos.addTab("Gestion Usuarios", pnlGestionarUsuarios);

        pnlBase.add(pnlAlimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 7, 900, 585));

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
// <editor-fold defaultstate="collapsed" desc=" eventos pestania Gestionar Alimentos ">
    private void btn_GA_limpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GA_limpiarMouseClicked
        this.limpiarAlimentos();
        this.cargarDatosAlimentos();
    }//GEN-LAST:event_btn_GA_limpiarMouseClicked

    private void tbl_GA_alimentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_GA_alimentosMouseClicked
        this.limpiarAlimentos();
        this.btn_GA_guardar.setEnabled(false);
        this.btn_GA_actualizar.setEnabled(true);
        int index = tbl_GA_alimentos.getSelectedRow();
        this.txt_GA_codigo.setText(this.GA_codigo[index].toString());
        this.txt_GA_nombre.setText(this.GA_nombre[index].toString());
        this.txt_GA_numCal.setText(this.GA_calorias[index].toString());
        this.cmb_GA_tipos.setSelectedItem(this.GA_tipo[index]);
        if (this.GA_estado[index].toString().equals("true")) {
            this.chk_GA_activo.setSelected(true);
        } else {
            this.chk_GA_inactivo.setSelected(true);
        }
    }//GEN-LAST:event_tbl_GA_alimentosMouseClicked

    private void btn_GA_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GA_guardarMouseClicked
        this.guardarActualizarAlimentos(1);
    }//GEN-LAST:event_btn_GA_guardarMouseClicked

    private void txt_GA_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_GA_nombreKeyTyped
        this.mc.txtOnlyLetters(evt);
    }//GEN-LAST:event_txt_GA_nombreKeyTyped

    private void txt_GA_numCalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_GA_numCalKeyTyped
        this.mc.txtOnlyDoubles(evt);
    }//GEN-LAST:event_txt_GA_numCalKeyTyped

    private void btn_GA_actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GA_actualizarMouseClicked
        this.guardarActualizarAlimentos(2);
    }//GEN-LAST:event_btn_GA_actualizarMouseClicked
// </editor-fold>  
    
// <editor-fold defaultstate="collapsed" desc=" eventos pestania vista Alimentos ">
    private void btn_VA_todosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_VA_todosMouseClicked
        this.cambiarVista("TODOS");
    }//GEN-LAST:event_btn_VA_todosMouseClicked
// </editor-fold>  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCerrar;
    public javax.swing.JLabel btnCerrarSesion;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JButton btn_GA_actualizar;
    private javax.swing.JButton btn_GA_guardar;
    private javax.swing.JButton btn_GA_limpiar;
    private javax.swing.JButton btn_VA_todos;
    private javax.swing.JRadioButton chk_GA_activo;
    private javax.swing.JRadioButton chk_GA_inactivo;
    private javax.swing.JComboBox<String> cmb_GA_tipos;
    private javax.swing.ButtonGroup grpchk_GA_grupo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUserNameGeneral;
    private javax.swing.JLabel lbl_GA_codigo;
    private javax.swing.JLabel lbl_GA_estado;
    private javax.swing.JLabel lbl_GA_nombre;
    private javax.swing.JLabel lbl_GA_numCal;
    private javax.swing.JLabel lbl_GA_tipAlimento;
    private javax.swing.JLabel lbl_GA_titulo;
    private javax.swing.JTabbedPane pnlAlimentos;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JPanel pnlGestionAlimentos;
    private javax.swing.JPanel pnlGestionarUsuarios;
    private javax.swing.JPanel pnlReportes;
    private javax.swing.JPanel pnlVistaAlimentos;
    private javax.swing.JPanel pnl_VA_botones;
    private javax.swing.JPanel pnl_VA_vista;
    private javax.swing.JTable tbl_GA_alimentos;
    private javax.swing.JTextField txt_GA_codigo;
    private javax.swing.JTextField txt_GA_nombre;
    private javax.swing.JTextField txt_GA_numCal;
    // End of variables declaration//GEN-END:variables

// <editor-fold defaultstate="collapsed" desc=" look and feel "> 
    public static void lookAndFeel() {
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
