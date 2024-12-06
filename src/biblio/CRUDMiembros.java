/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package biblio;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
/**
 *
 * @author gordi
 */
public class CRUDMiembros extends javax.swing.JFrame {
Connection conn;
Statement sent;
String folio,fecha;
DefaultTableModel model;
    /**
     * Creates new form GestionProducto
     */
    public CRUDMiembros() {
        initComponents();
        Llenar();
        fecha();
        setLocationRelativeTo(null);
        
    }

    void fecha(){
        LocalDateTime hoy = LocalDateTime.now();
        int dia = hoy.getDayOfMonth();
        int mes = hoy.getMonthValue();
        int anio = hoy.getYear();
        fecha= dia+"-"+mes+"-"+anio;
        //lblfecha.setText(fecha);
    }
    
    void Limpiar(){
        txtnombre.setText("");
        txttelefono.setText("");
        lblfecha.setText(fecha);
        lblID.setText("");
    }
    
void Nueva(){
    if(txtnombre.getText().equals("") || txttelefono.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos");
    }else{
        try{
            conn = DB.Mysql.getConnection();
            String sql = "insert into Miembros (NOMBRE_MIEMBRO,FECHA_MIEMBRO,TEL_MIEMBRO)"
                    +"values("
                    +"'"+txtnombre.getText()+"',"
                    +"'"+fecha+"',"
                    +"'"+txttelefono.getText()+"')";
            sent = conn.createStatement();
            int n = sent.executeUpdate(sql);
            if(n>0){
                JOptionPane.showMessageDialog(null,"Datos guardados");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"No se pudieron guardar los datos");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        Llenar();
}
}
void Editar(){
    if(txtnombre.getText().equals("") || txttelefono.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos");
    }else{
        try{
            conn = DB.Mysql.getConnection();
            String sql = "UPDATE Miembros SET NOMBRE_MIEMBRO="
                    +"'"+txtnombre.getText()+"',FECHA_MIEMBRO="
                    +"'"+fecha+"',TEL_MIEMBRO="
                    +"'"+txttelefono.getText()+"' WHERE ID_MIEMBRO='"+lblID.getText()+"'";
            sent = conn.createStatement();
            int n = sent.executeUpdate(sql);
            if(n>0){
                JOptionPane.showMessageDialog(null,"Datos guardados");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"No se pudieron guardar los datos");
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        Llenar();
}
}
void Eliminar(){
    try{
            String sql = "DELETE from Miembros WHERE ID_MIEMBRO='"
                    +lblID.getText()+"'";
            conn = DB.Mysql.getConnection();
            sent = conn.createStatement();
            int n = sent.executeUpdate(sql);
            
            if(n>0){
                JOptionPane.showMessageDialog(null,"Miembro eliminado correctamente");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"No se eliminó el registro");
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    Llenar();
}

void Llenar(){
        JTableHeader header = tblDB.getTableHeader();
        Font headerFont = new Font("Times New Roman", Font.BOLD, 14); 
        header.setFont(headerFont);
        try {
            conn = DB.Mysql.getConnection();
            String[] titulos ={"ID","Nombre","Fecha de modificacion","Telefono"};
            String sql = "Select * from Miembros";
            model = new DefaultTableModel(null, titulos);
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            String[] fila = new String[4];
            while (rs.next()){
                fila[0]=rs.getString("ID_MIEMBRO");
                fila[1]=rs.getString("NOMBRE_MIEMBRO");
                fila[2]=rs.getString("FECHA_MIEMBRO");
                fila[3]=rs.getString("TEL_MIEMBRO");
                model.addRow(fila);
            }
            tblDB.setModel(model);
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDB = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        lblbuscar = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDB.setBorder(new javax.swing.border.MatteBorder(null));
        tblDB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDBMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDB);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 368, 590, 140));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnnuevo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btneditar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btneliminar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        lblbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/descargar.png"))); // NOI18N
        lblbuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblbuscarMouseClicked(evt);
            }
        });

        jLabel9.setText("Buscar por ID:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btneditar, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblbuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblbuscar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 180, 160));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setText("Número Telefónico:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setText("Fecha de última modificación:");

        lblID.setBackground(new java.awt.Color(204, 204, 204));
        lblID.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblfecha.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblfecha.setForeground(new java.awt.Color(255, 255, 255));
        lblfecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(lblfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(103, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblTitulo.setBackground(new java.awt.Color(51, 102, 0));
        lblTitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Gestión de Miembros");
        lblTitulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/library-7720589_960_720.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDBMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==1){
            int fila = tblDB.getSelectedRow();
            try{
                conn = DB.Mysql.getConnection();
                String sql = "Select * from Miembros where ID_MIEMBRO='" + tblDB.getValueAt(fila, 0)+"'";
                sent = conn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                if(rs.getString("NOMBRE_MIEMBRO")!=""){
                    lblID.setText(rs.getString("ID_MIEMBRO"));
                    txtnombre.setText(rs.getString("NOMBRE_MIEMBRO"));
                    lblfecha.setText(rs.getString("FECHA_MIEMBRO"));
                    txttelefono.setText(rs.getString("TEL_MIEMBRO"));

                }else{
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_tblDBMouseClicked

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        Nueva();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        // TODO add your handling code here:
        Editar();
    }//GEN-LAST:event_btneditarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog (null, "¿Está seguro de eliminar este registro?","Alerta",1);
        if(dialogResult == JOptionPane.YES_OPTION){
            Eliminar();
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void lblbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbuscarMouseClicked
        // TODO add your handling code here:
        try{
            conn = DB.Mysql.getConnection();
            String sql = "Select * from Miembros where ID_MIEMBRO='" + txtID.getText()+"'";
            sent = conn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            rs.next();
            String a = rs.getString(1);
            if(rs!=null){
                //JOptionPane.showMessageDialog(null, "Registro encontrado con éxito");
                lblID.setText(rs.getString("ID_MIEMBRO"));
                    txtnombre.setText(rs.getString("NOMBRE_MIEMBRO"));
                    lblfecha.setText(rs.getString("FECHA_MIEMBRO"));
                    txttelefono.setText(rs.getString("TEL_MIEMBRO"));

            }else{
                JOptionPane.showMessageDialog(null, "Error");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Registro no encontrado");
            e.printStackTrace();
        }
    }//GEN-LAST:event_lblbuscarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CRUDMiembros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDMiembros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDMiembros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDMiembros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDMiembros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnnuevo;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblbuscar;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JTable tblDB;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
