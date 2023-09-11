/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Clientes;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author zeus
 */
public class ClientesMod extends javax.swing.JDialog {

    java.awt.Frame Fabuelo;
    javax.swing.JDialog Dpadre;
    private modelo.clientes cliente = null;
    private boolean update = false;

    /**
     * Creates new form Clientes
     * @param parent
     * @param madre
     * @param modal
     */
    public ClientesMod(java.awt.Frame parent, javax.swing.JDialog padre, boolean modal) {
        super(parent, modal);
        initComponents();
        this.Fabuelo = parent;
        this.Dpadre = padre;
        this.cliente = new modelo.clientes();
        this.cliente.setidcliente(0);
        update = false;
    }

    /**
     * Creates new form Clientes
     */
    public ClientesMod(java.awt.Frame parent, javax.swing.JDialog padre, boolean modal, modelo.clientes cliente) {
        super(parent, modal);
        initComponents();
        this.Fabuelo = parent;
        this.Dpadre  =  padre;
        this.cliente = cliente;
        this.TxtIDCliente.setText(this.cliente.getidcliente().toString());
        this.TxtDNI.setText(this.cliente.getdni());
        this.TxtNombre.setText(this.cliente.getcliente());
        this.TxtCarpeta.setText(this.cliente.getnumcarpeta());
        this.TxtDireccion.setText(this.cliente.getdireccion());
        this.TxtInfo.setText(this.cliente.getinfo());
        this.TxtTelf.setText(this.cliente.gettelefono());
        this.TxtMovil.setText(this.cliente.getmovil());
        // this..setText(this.cliente.getdni());
        update = true;

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtDNI = new javax.swing.JTextField();
        TxtNombre = new javax.swing.JTextField();
        TxtDireccion = new javax.swing.JTextField();
        TxtTelf = new javax.swing.JTextField();
        TxtMovil = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtInfo = new javax.swing.JTextArea();
        BtnSalir = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        TxtIDCliente = new javax.swing.JTextField();
        TxtCarpeta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel2.setText("DNI:");

        jLabel3.setText("NOMBRE:");

        jLabel4.setText("DIRECCION:");

        jLabel5.setText("TELF:");

        jLabel6.setText("MOVIl:");

        TxtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtDNIKeyTyped(evt);
            }
        });

        TxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNombreKeyTyped(evt);
            }
        });

        TxtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtDireccionKeyTyped(evt);
            }
        });

        TxtTelf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtTelfKeyTyped(evt);
            }
        });

        TxtMovil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtMovilKeyTyped(evt);
            }
        });

        TxtInfo.setColumns(20);
        TxtInfo.setRows(5);
        TxtInfo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtInfoKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(TxtInfo);

        BtnSalir.setText("Salir");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        TxtIDCliente.setEditable(false);
        TxtIDCliente.setBackground(new java.awt.Color(253, 128, 2));
        TxtIDCliente.setForeground(new java.awt.Color(42, 35, 18));
        TxtIDCliente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        TxtCarpeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCarpetaKeyTyped(evt);
            }
        });

        jLabel7.setText("Carpeta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnGuardar)
                .addGap(27, 27, 27)
                .addComponent(BtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(TxtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TxtCarpeta, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TxtIDCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TxtTelf, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(TxtMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCarpeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtTelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGuardar)
                    .addComponent(BtnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        // TODO add your handling code here:
        //cliente.setidcliente();
        try {
            cliente.setcliente(this.TxtNombre.getText());
            cliente.setnumcarpeta(this.TxtCarpeta.getText());
            cliente.setdni(this.TxtDNI.getText());
            cliente.setdireccion(this.TxtDireccion.getText());
            cliente.settelefono(this.TxtTelf.getText());
            cliente.setmovil(this.TxtMovil.getText());
            cliente.setinfo(this.TxtInfo.getText());
          
                if (DAO.ClientesDao.update(cliente) > 0) {
                    this.dispose();
                } else {
                    javax.swing.JOptionPane.showConfirmDialog(this, "Ha habido un error no se ha podido actualizar los datos.");
                }

           
           this.salir();

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se han podido guardar los cambios\nrevise la configuración y el estado del servidor.");
           // Logger.getLogger(ClientesMod.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        // TODO add your handling code here:
       this.salir();
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.salir();
    }//GEN-LAST:event_formWindowClosing

    private void TxtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDNIKeyTyped
        // TODO add your handling code here:
       if(this.TxtDNI.getText().length()>11){
           evt.consume();
       }
       
    }//GEN-LAST:event_TxtDNIKeyTyped

    public void salir(){
        
         this.setVisible(false);
        if (this.Dpadre != null) {
            this.Dpadre.setVisible(true);
        } else {
            this.Fabuelo.setVisible(true);
        }
        this.dispose();
    }
    
    
    private void TxtCarpetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCarpetaKeyTyped
        // TODO add your handling code here:
          if(this.TxtCarpeta.getText().length()>11){
           evt.consume();
       }
       
    }//GEN-LAST:event_TxtCarpetaKeyTyped

    private void TxtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNombreKeyTyped
        // TODO add your handling code here:
          if(this.TxtNombre.getText().length()>49){
           evt.consume();
       }
       
    }//GEN-LAST:event_TxtNombreKeyTyped

    private void TxtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDireccionKeyTyped
        // TODO add your handling code here:
          if(this.TxtDireccion.getText().length()>149){
           evt.consume();
       }
       
    }//GEN-LAST:event_TxtDireccionKeyTyped

    private void TxtTelfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtTelfKeyTyped
        // TODO add your handling code here:
         if(this.TxtTelf.getText().length()>11){
           evt.consume();
       }
    }//GEN-LAST:event_TxtTelfKeyTyped

    private void TxtMovilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtMovilKeyTyped
        // TODO add your handling code here:
         if(this.TxtMovil.getText().length()>11){
           evt.consume();
       }
    }//GEN-LAST:event_TxtMovilKeyTyped

    private void TxtInfoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtInfoKeyTyped
        // TODO add your handling code here:
        
         if(this.TxtInfo.getText().length()>499){
           evt.consume();
       }
    }//GEN-LAST:event_TxtInfoKeyTyped

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Clientes dialog = new Clientes(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JTextField TxtCarpeta;
    private javax.swing.JTextField TxtDNI;
    private javax.swing.JTextField TxtDireccion;
    private javax.swing.JTextField TxtIDCliente;
    private javax.swing.JTextArea TxtInfo;
    private javax.swing.JTextField TxtMovil;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtTelf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
