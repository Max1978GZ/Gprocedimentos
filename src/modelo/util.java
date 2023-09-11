/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JTable;

/**
 *
 * @author zeus
 */
public class util {
    
    
    
    /**
     * Oculta las columnas de un JTable 
     * modelo.util.ocultarColumnas(this.JT, new String[]{"IDPROCEDIMIENTO", "ID_CLIENTE", "RUTA_FICHEROS", "INFO"});
     * @param Jt
     * @param columnName 
     */
     public static void ocultarColumnas(JTable Jt, String columnName[]) {
        for (int i = 0; i < Jt.getColumnCount(); i++) {

            if (existe(Jt.getColumnName(i), columnName)) {

                Jt.getColumn(Jt.getColumnName(i)).setMinWidth(0);
                Jt.getColumn(Jt.getColumnName(i)).setMaxWidth(0);

            }

        }

      //  System.out.println(this.JTCLIENTES.getColumnName(0));

    }

    private static  boolean existe(String n, String m[]) {
        for (String a : m) {

            if (a.equalsIgnoreCase(n)) {
                return true;
            }

        }
        return false;

    }
    
}
