/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Clientes;

import DAO.ClientesDao;
import DataTable.JDataTable;
import GUI.oldprincipal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author zeus
 */
public class BscCliente extends javax.swing.JDialog {
     private java.awt.Frame Fabuelo;
     private javax.swing.JDialog Dpadre;
     private modelo.clientes cli ;
    /**
     * Creates new form BscCliente
     */
    public BscCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.Fabuelo= parent;
        this.Dpadre = null;
        this.JTCLIENTES.setModel((new JDataTable("a")).getDefaultTableModel());
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TxtBuscar = new javax.swing.JTextField();
        JBtnBuscar = new javax.swing.JButton();
        JBnVer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTCLIENTES = new javax.swing.JTable();
        JBtnNuevo = new javax.swing.JButton();
        JBtnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Buscar por Dni/Nombre:");

        JBtnBuscar.setText("Buscar");
        JBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnBuscarActionPerformed(evt);
            }
        });

        JBnVer.setText("Ver Cliente");
        JBnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBnVerActionPerformed(evt);
            }
        });

        JTCLIENTES.setModel(new javax.swing.table.DefaultTableModel(
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
        JTCLIENTES.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTCLIENTESMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTCLIENTES);

        JBtnNuevo.setText("Nuevo Cliente");
        JBtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnNuevoActionPerformed(evt);
            }
        });

        JBtnEliminar.setText("Eliminar Cliente");
        JBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JBnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JBtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBtnBuscar)
                    .addComponent(JBnVer)
                    .addComponent(JBtnNuevo)
                    .addComponent(JBtnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnBuscarActionPerformed
        // TODO add your handling code here:
        
        this.cargarBDClientes();
//          try {
//            // TODO add your handling code here:
//            this.JTCLIENTES.setModel(modelo.clientes.buscarBD(this.TxtBuscar.getText()).getDefaultTableModel());
//          
//        } catch (Exception ex) {
//            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_JBtnBuscarActionPerformed

    private void JBnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBnVerActionPerformed
        // TODO add your handling code here:
        
         if (this.JTCLIENTES.getSelectedRow() > -1) {
            String id = (String) this.JTCLIENTES.getModel().getValueAt(this.JTCLIENTES.getSelectedRow(), 0);
            String cliente = (String) this.JTCLIENTES.getModel().getValueAt(this.JTCLIENTES.getSelectedRow(), 1);
            String numcarpe = (String) this.JTCLIENTES.getModel().getValueAt(this.JTCLIENTES.getSelectedRow(), 2);
            String dni = (String) this.JTCLIENTES.getModel().getValueAt(this.JTCLIENTES.getSelectedRow(), 3);
            String dir = (String) this.JTCLIENTES.getModel().getValueAt(this.JTCLIENTES.getSelectedRow(), 4);
            String telf = (String) this.JTCLIENTES.getModel().getValueAt(this.JTCLIENTES.getSelectedRow(), 5);
            String movil = (String) this.JTCLIENTES.getModel().getValueAt(this.JTCLIENTES.getSelectedRow(), 6);
            String info = (String) this.JTCLIENTES.getModel().getValueAt(this.JTCLIENTES.getSelectedRow(), 7);

            modelo.clientes c = new modelo.clientes(Integer.valueOf(id), cliente, numcarpe, dni, dir, telf, movil, info);
            this.setVisible(false);
            GUI.Clientes.ClientesMod cli = new GUI.Clientes.ClientesMod(this.Fabuelo,this, true, c);
            cli.setVisible(true);
            this.cargarBDClientes();
           

        }
        
        
    }//GEN-LAST:event_JBnVerActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
          this.salir();
     
    }//GEN-LAST:event_formWindowClosing

    private void salir(){
        
            if (this.Dpadre != null) {
                this.Dpadre.setVisible(true);
            } else {
                
                if(this.Fabuelo!=null)
                    this.Fabuelo.setVisible(true);
                
            }

        this.dispose();
        
    }
    
    
    
    private void JBtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnNuevoActionPerformed
        // TODO add your handling code here:
        GUI.Clientes.ClientesAdd f= new GUI.Clientes.ClientesAdd(this.Fabuelo,this,true);
        this.setVisible(false);
        f.setVisible(true);
//        System.out.println("vamos a cargar la base de datos clientes:");
//        this.cargarBDClientes();
        
    }//GEN-LAST:event_JBtnNuevoActionPerformed

    private void JBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnEliminarActionPerformed
        // TODO add your handling code here:
        if(this.JTCLIENTES.getSelectedRow()>-1){
        try {
            
            int confirmado  =JOptionPane.showConfirmDialog(this.JBtnEliminar,"¿Realmente desea eliminar al cliente " +this.cli.getcliente() + "?","Atención",JOptionPane.YES_NO_OPTION);

          if (JOptionPane.OK_OPTION == confirmado){       
            // TODO add your handling code here:
             if (this.JTCLIENTES.getSelectedRow() > -1){
                 if( ClientesDao.delete(  this.cli)>0){
                    this.cargarBDClientes();
                 }else{
                     
                     JOptionPane.showMessageDialog(null, "No se puede eliminar el cliente\n contiene procedimientos asociados.");
                  System.out.println("No es posible eliminar al cliente.")   ;
                 }
             }
            }
             
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "La clase de acceso a la BD no es correcta.");
            //Logger.getLogger(oldprincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Hay un error en la consulta.");
            //Logger.getLogger(oldprincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
              JOptionPane.showMessageDialog(null,"Se ha producido un error.");
            //Logger.getLogger(oldprincipal.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
            
            
        }
        
        
    }//GEN-LAST:event_JBtnEliminarActionPerformed

    private void JTCLIENTESMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTCLIENTESMouseClicked
        // TODO add your handling code here:
        this.asignarCliente();
    }//GEN-LAST:event_JTCLIENTESMouseClicked

    
     private void asignarCliente() {
//          if (this.JTCLIENTES.getSelectedRow() > -1) {
        String id = (String) this.JTCLIENTES.getModel().getValueAt(this.JTCLIENTES.getSelectedRow(), 0);
        String cliente = (String) this.JTCLIENTES.getModel().getValueAt(this.JTCLIENTES.getSelectedRow(), 1);
        String numcarpe = (String) this.JTCLIENTES.getModel().getValueAt(this.JTCLIENTES.getSelectedRow(), 2);
        String dni = (String) this.JTCLIENTES.getModel().getValueAt(this.JTCLIENTES.getSelectedRow(), 3);
        String dir = (String) this.JTCLIENTES.getModel().getValueAt(this.JTCLIENTES.getSelectedRow(), 4);
        String telf = (String) this.JTCLIENTES.getModel().getValueAt(this.JTCLIENTES.getSelectedRow(), 5);
        String movil = (String) this.JTCLIENTES.getModel().getValueAt(this.JTCLIENTES.getSelectedRow(), 6);
        String info = (String) this.JTCLIENTES.getModel().getValueAt(this.JTCLIENTES.getSelectedRow(), 7);

        cli= new modelo.clientes(Integer.valueOf(id), cliente, numcarpe, dni, dir, telf, movil, info);

//          }
    }

    
    public void cargarBDClientes(){
        
         try {
            // TODO add your handling code here:
            this.JTCLIENTES.setModel(ClientesDao.buscarBD(this.TxtBuscar.getText()).getDefaultTableModel());
            modelo.util.ocultarColumnas(JTCLIENTES, new String[]{"IdCliente","Telefono","DC"});
          
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a  la base de datos\n revise configuración y estado del servidor \n"+ ex.getMessage());
           //Logger.getLogger(oldprincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(BscCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(BscCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(BscCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(BscCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                BscCliente dialog = new BscCliente(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBnVer;
    private javax.swing.JButton JBtnBuscar;
    private javax.swing.JButton JBtnEliminar;
    private javax.swing.JButton JBtnNuevo;
    private javax.swing.JTable JTCLIENTES;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
