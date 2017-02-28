/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Datos.Conexion.modConexionDB;
import Logica.Cont_Emp;
import Logica.Cont_OB_v2;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alumnos
 */
public class FMenuCargo extends javax.swing.JFrame {

    /**
     * Creates new form FMenuCargo
     */
    public FMenuCargo() {
        initComponents();
        modConexionDB.conexionDB();
        this.setLocationRelativeTo(null);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        cmb_TipoBusqueda = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCargos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmb_CampoBusqueda = new javax.swing.JComboBox();
        txt_NumReg = new javax.swing.JLabel();
        txt_numreg = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txt_SelReg = new javax.swing.JLabel();
        txt_regsel = new javax.swing.JLabel();
        txt_BuscarCargo = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cmb_TipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Busqueda Parcial", "Busqueda Completa" }));
        cmb_TipoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_TipoBusquedaActionPerformed(evt);
            }
        });

        TablaCargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Cargo", "Nombre Cargo"
            }
        ));
        TablaCargos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaCargosMouseClicked(evt);
            }
        });
        TablaCargos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TablaCargosPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(TablaCargos);

        jLabel2.setText("Tipo de Busqueda");

        jLabel3.setText("Buscar Por:");

        cmb_CampoBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID Cargo", "Nombre Cargo" }));

        txt_NumReg.setText("Numero de Registros:");

        txt_numreg.setText("--");

        jButton3.setText("Borrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txt_SelReg.setText("Registro Seleccionado:");

        txt_regsel.setText("--");

        txt_BuscarCargo.setText("*");

        jButton2.setText("Cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/cargo.png"))); // NOI18N

        jLabel4.setText("Con  *  Lista todos los cargos.");

        jLabel5.setText("Buscar Cargo:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Cargos");

        jButton5.setText("Nuevo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Modificar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_BuscarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(cmb_TipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(cmb_CampoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_NumReg)
                        .addGap(6, 6, 6)
                        .addComponent(txt_numreg, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(334, 334, 334)
                        .addComponent(txt_SelReg)
                        .addGap(6, 6, 6)
                        .addComponent(txt_regsel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addComponent(jLabel4)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txt_BuscarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmb_TipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_CampoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_NumReg)
                    .addComponent(txt_numreg)
                    .addComponent(txt_SelReg)
                    .addComponent(txt_regsel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addGap(23, 23, 23)
                .addComponent(jLabel4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel tablatem = (DefaultTableModel) TablaCargos.getModel();
        Cont_OB_v2 BC = new Cont_OB_v2();
        ResultSet RS;
        
        if (txt_BuscarCargo.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Advertencia", null, WIDTH);
        }else{
        txt_regsel.setText("--");
        tablatem.setRowCount(0);
        TablaCargos.setModel(tablatem);
        try {
            if (txt_BuscarCargo.getText().equals("*")){
            RS = BC.Listar_C();
            }else{
            String CB ="" ;
            Boolean BP = false;
            if ( (String)cmb_TipoBusqueda.getSelectedItem() == "Busqueda Parcial"){
                BP = true;
            }
            if ( (String)cmb_CampoBusqueda.getSelectedItem() == "ID Cargo"){
                CB = "id_cargo";
            }else{
                CB = "nombre_cargo";
            }
         RS =  BC.Buscar_C(txt_BuscarCargo.getText(),CB ,BP );
         }
          Object [] fila;
            int contador = 0;
             while(RS.next()){ 
                 fila = new Object[3];/*Es para setearlo, reasignar nuevamente memoria*/
                     fila[0] = RS.getString("id_cargo");
                     fila[1] = RS.getString("nombre_cargo");
                 tablatem.addRow(fila);
             }
             TablaCargos.setModel(tablatem);
             txt_numreg.setText(Integer.toString(TablaCargos.getRowCount()));             
             //txt_regsel.setText(can);
        } catch (SQLException ex) {
            Logger.getLogger(FMenuCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        //ELSE
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
    private void cmb_TipoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_TipoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_TipoBusquedaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       //El Codigo del Boton 3
        Cont_OB_v2 COB = new Cont_OB_v2();
        
        DefaultTableModel tablatem = (DefaultTableModel) TablaCargos.getModel();
        
        String IDC = (String) TablaCargos.getValueAt(TablaCargos.getSelectedRow(), 0);
        
         if (COB.Borrar_C(IDC) == true){
             JOptionPane.showMessageDialog(rootPane, "El cargo se ha eliminado con Exito!", null, WIDTH); 
             tablatem.removeRow(TablaCargos.getSelectedRow());
             TablaCargos.setModel(tablatem);
           }else{
             JOptionPane.showMessageDialog(rootPane, "No ha sido posible borrar el Cargo. Puede ser debido a que este asociado a algun Empleado "+
             "y/o Funcion", null, WIDTH); 
           }
    }//GEN-LAST:event_jButton3ActionPerformed


    
    
    private void TablaCargosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCargosMouseClicked
         txt_regsel.setText(Integer.toString(TablaCargos.getSelectedRow()+1));
    }//GEN-LAST:event_TablaCargosMouseClicked

    private void TablaCargosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TablaCargosPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaCargosPropertyChange

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /*Metodo del Boton Insertar*/
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        FMenuNuevoCargo FMNC = new FMenuNuevoCargo();
        FMNC.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    
    /*Metodo para Boton Modificar*/
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        FMenuModCargo FMMC = new FMenuModCargo();
        FMMC.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(FMenuCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FMenuCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FMenuCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FMenuCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FMenuCargo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaCargos;
    private javax.swing.JComboBox cmb_CampoBusqueda;
    private javax.swing.JComboBox cmb_TipoBusqueda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_BuscarCargo;
    private javax.swing.JLabel txt_NumReg;
    private javax.swing.JLabel txt_SelReg;
    private javax.swing.JLabel txt_numreg;
    private javax.swing.JLabel txt_regsel;
    // End of variables declaration//GEN-END:variables
}
