/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataTable.JDataTable;
import Parametros.conf;
import java.sql.SQLException;

/**
 *
 * @author zeus
 */
public class ProcedimientosDao {
    public static DAO dao; 
//      /**
//     * Elimina de la base de datos el prodecimiento
//     *
//     * @param clave
//     * @return int con las filas afectadas
//     * @throws ClassNotFoundException
//     * @throws SQLException
//     */
//    public  int delete(modelo.procedimientos proce) throws ClassNotFoundException, SQLException {
//        dao = new DAO();
//        return dao.eliminar("DELETE FROM PROCEDIMIENTOS WHERE IDPROCEDIMIENTO=" + proce.getidprocedimiento());
//    }
    

    /**
     * Retorna una tabla con todos los procedimientos
     *
     * @return JDataTable
     * @throws ClassNotFoundException
     * @throws Exception
     */
    public static JDataTable loadBD() throws ClassNotFoundException, Exception {
        dao = new DAO();
        return dao.getSelect("SELECT * FROM PROCEDIMIENTOS");
    }

    /**
     * Retorna una tabla con los procedimientos del cliente pasado por parametro
     *
     * @param idCliente
     * @return JDataTable
     * @throws ClassNotFoundException
     * @throws Exception
     */
    public static JDataTable loadBD(Integer idCliente) throws ClassNotFoundException, Exception {
        dao = new DAO();
        return dao.getSelect("SELECT * FROM PROCEDIMIENTOS WHERE ID_CLIENTE=" + idCliente);
    }

     /**
     * Retorna una tabla con los procedimientos que coinciden con el
     * contenido de la variable bscproce
     * @param bscproce String
     * @return JDataTable
     * @throws ClassNotFoundException
     * @throws Exception
     */
    public static JDataTable loadBD(String bscproce) throws ClassNotFoundException, Exception {
        dao = new DAO();
//        return dao.getSelect("SELECT IDPROCEDIMIENTO,LOCALIDAD,NUMJUZGADO,PROCEDIMIENTO,PROCEDIMIENTOS.INFO,CONTRARIO,IDCLIENTE,RUTA_FICHEROS,CLIENTE,DNI "+  
//                                "FROM CLIENTES " +
//                                "INNER JOIN PROCEDIMIENTOS " +
//                                "ON CLIENTES.IDCLIENTE=PROCEDIMIENTOS.ID_CLIENTE "+ 
//                                "WHERE UPPER(PROCEDIMIENTO) LIKE UPPER('%"+bscproce  +"%') " );        
                                
    return dao.getSelect(conf.sql_select_find_procedimientos +"('%"+ bscproce  +"%') " );                     
                
                
                
                
                
              //  "SELECT *  FROM CLIENTES INNER JOIN PROCEDIMIENTOS ON CLIENTE.IDCLIENTE=PROCEDIMIENTOS.ID_CLIENTE WHERE UPPER(PROCEDIMIENTO) LIKE UPPER('%" +bscproce +"%')" );
    }

    
    
    /**
     * Retorna la cantidad de procedimientos que tiene un cliente
     *
     * @param idCliente
     * @return Integer
     * @throws ClassNotFoundException
     * @throws Exception
     */
    public static int contarProcedimientos(Integer idCliente) throws ClassNotFoundException, Exception {
        dao = new DAO();
        return dao.getCount("SELECT COUNT(*) FROM PROCEDIMIENTOS WHERE ID_CLIENTE = " + idCliente);
    }

    /**
     * Elimina de la base de datos el prodecimiento
     *
     * @param proce
     * @param clave
     * @return int con las filas afectadas
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static int delete(modelo.procedimientos proce) throws ClassNotFoundException, SQLException {
        dao = new DAO();
        return dao.eliminar("DELETE FROM PROCEDIMIENTOS WHERE IDPROCEDIMIENTO=" + proce.getidprocedimiento());
    }

    /**
     * Añade el Procedimiento a la base de datos
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static int add(modelo.procedimientos proce) throws ClassNotFoundException, SQLException {
        dao = new DAO();
        String sql = "INSERT INTO PROCEDIMIENTOS (LOCALIDAD,NUMJUZGADO,PROCEDIMIENTO,INFO,CONTRARIO,ID_CLIENTE,RUTA_FICHEROS) VALUES('"
                + proce.getlocalidad() + "'," + proce.getnumjuzgado() + ",'" + proce.getprocedimiento() + "','" + proce.getinfo() + "','" + proce.getcontrario() + "'," + proce.getid_cliente() + ",'" + proce.getruta_ficheros() + "')";
        return dao.insertar(sql);
    }

    /**
     * Actualiza el registro en la BD
     *
     * @return Integer con las filas afectadas
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static int update(modelo.procedimientos proce) throws ClassNotFoundException, SQLException {
        dao = new DAO();
        String sql = "UPDATE PROCEDIMIENTOS  SET LOCALIDAD='" + proce.getlocalidad()
                + "',NUMJUZGADO=" + proce.getnumjuzgado()
                + ",PROCEDIMIENTO='" + proce.getprocedimiento()
                + "',INFO='" + proce.getinfo()
                + "',CONTRARIO='" + proce.getcontrario()
                + "',ID_CLIENTE=" + proce.getid_cliente()
                + ",RUTA_FICHEROS='" + proce.getruta_ficheros()
                + "' WHERE IDPROCEDIMIENTO=" + proce.getidprocedimiento();

        return dao.modificar(sql);

    }

}
