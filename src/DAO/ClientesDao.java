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
public class ClientesDao {
   public static DAO dao;
    
     public static JDataTable loadBD() throws ClassNotFoundException, Exception {
        dao = new DAO();
        return dao.getSelect("SELECT * FROM CLIENTES");
    }

    public static JDataTable loadBD(String sql) throws ClassNotFoundException, Exception {
        dao = new DAO();
        return dao.getSelect(sql);
    }

    /**
     * busca en la base de datos los que coincida el nombre o el dni
     *
     * @param nombredni
     * @return
     * @throws ClassNotFoundException
     * @throws Exception
     */
    public static JDataTable buscarBD(String nombredni) throws ClassNotFoundException, Exception {
        dao = new DAO();
        String sql;//  ="SELECT IDCLIENTE,CLIENTE,NUMCARPETA,DNI,DIRECCION,TELEFONO,MOVIL,INFO,(DNI ||CLIENTE) AS DC   FROM CLIENTES WHERE DC LIKE '"+ nombredni +"'";    

       // sql = "SELECT * FROM (SELECT IDCLIENTE,CLIENTE,NUMCARPETA,DNI,DIRECCION,TELEFONO,MOVIL,INFO, (DNI ||CLIENTE) AS DC  FROM CLIENTES ) AS CLI WHERE UPPER(DC) LIKE UPPER('%" + nombredni + "%')";
        sql = conf.sql_select_find_clientes +"('%" + nombredni + "%')";
        return dao.getSelect(sql);
    }

    public static int delete(String clave) throws ClassNotFoundException, SQLException {
        dao = new DAO();
        return dao.eliminar("DELETE FROM CLIENTES WHERE IDCLIENTE=" + clave);
    }

    public static int delete(modelo.clientes cliente) throws ClassNotFoundException, SQLException, Exception {
        
        if(ProcedimientosDao.contarProcedimientos(cliente.getidcliente())>0){
            return -1;
        }else{
        dao = new DAO();
        return dao.eliminar("DELETE FROM CLIENTES WHERE IDCLIENTE=" + cliente.getidcliente());
        }
    }
    
    
    public static int add(modelo.clientes cliente) throws ClassNotFoundException, SQLException {
        dao = new DAO();
        String sql = "INSERT INTO CLIENTES (CLIENTE,NUMCARPETA,DNI,DIRECCION,TELEFONO,MOVIL,INFO) VALUES('" + cliente.getcliente() + "','" + cliente.getnumcarpeta() + "','" + cliente.getdni() + "','" + cliente.getdireccion() + "','" + cliente.gettelefono() + "','" + cliente.getmovil() + "','" + cliente.getinfo() + "')";
        return dao.insertar(sql);
    }

    public static int update(modelo.clientes cliente) throws ClassNotFoundException, SQLException {
        dao = new DAO();
        
        String sql = "UPDATE CLIENTES  SET CLIENTE='" + cliente.getcliente()
                + "',NUMCARPETA='" + cliente.getnumcarpeta()
                + "',DNI='" + cliente.getdni()
                + "',DIRECCION='" + cliente.getdireccion()
                + "',TELEFONO='" + cliente.gettelefono()
                + "',MOVIL='" + cliente.getmovil()
                + "',INFO='" + cliente.getinfo()
                + "' WHERE IDCLIENTE=" + cliente.getidcliente();

        return dao.modificar(sql);

    }
}
