/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gprocedimientos;

import GUI.Inicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author zeus
 */
public class GProcedimientos {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
        
        Parametros.conf c= new Parametros.conf();
        c.getConf();
        
        
        try{
        GUI.Inicio fa = new GUI.Inicio();
        fa.setVisible(true);
        }catch(Exception ex){
              Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, "Se ha producido un error al intentar iniciar la aplicacion\n " +ex.getMessage());
        }
    }

}
