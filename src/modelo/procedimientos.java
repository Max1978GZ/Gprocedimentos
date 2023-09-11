package modelo;

import java.sql.SQLException;
import DAO.DAO;
import DataTable.JDataTable;
import Parametros.conf;

public class procedimientos {

    private static DAO dao;

    private Integer idprocedimiento;

    private String localidad;

    private Integer numjuzgado;

    private String procedimiento;

    private String info;

    private String contrario;

    private Integer id_cliente;

    private String ruta_ficheros;

    public Integer getidprocedimiento() {

        return idprocedimiento;

    }

    public void setidprocedimiento(Integer idprocedimiento) {

        this.idprocedimiento = idprocedimiento;

    }

    public String getlocalidad() {

        return localidad;

    }

    public void setlocalidad(String localidad) {
        if (localidad.length() > 20) {
            this.localidad = localidad.substring(0, 20);
        } else {
            this.localidad = localidad;
        }

    }

    public Integer getnumjuzgado() {

        return numjuzgado;

    }

    public void setnumjuzgado(Integer numjuzgado) {

        this.numjuzgado = numjuzgado;

    }

    public String getprocedimiento() {

        return procedimiento;

    }

    public void setprocedimiento(String procedimiento) {
        if (procedimiento.length() >20) {
            this.procedimiento = procedimiento.substring(0, 20);
        } else {
            this.procedimiento = procedimiento;
        }

    }

    public String getinfo() {

        return info;

    }

    public void setinfo(String info) {
        if (info.length() >500) {
            this.info = info.substring(0, 500);
        } else {
            this.info = info;
        }

    }

    public String getcontrario() {

        return contrario;

    }

    public  void setcontrario(String contrario) {
        if (contrario.length() >100) {
            this.contrario = contrario.substring(0, 100);
        } else {
            this.contrario = contrario;
        }

    }

    public Integer getid_cliente() {

        return id_cliente;

    }

    public void setid_cliente(Integer id_cliente) {

        this.id_cliente = id_cliente;

    }

    public String getruta_ficheros() {

        return ruta_ficheros;

    }

    public void setruta_ficheros(String ruta_ficheros) {
        if (ruta_ficheros.length() > 20) {
          
            this.ruta_ficheros = ruta_ficheros.substring(0, 20);
        } else {
            this.ruta_ficheros = ruta_ficheros;
        }

    }

    public procedimientos(Integer idprocedimiento, String localidad, Integer numjuzgado, String procedimiento, String info, String contrario, Integer id_cliente, String ruta_ficheros) {

        this.setidprocedimiento(idprocedimiento);
        this.setlocalidad(localidad);
        this.setnumjuzgado(numjuzgado);
        this.setprocedimiento(procedimiento);
        this.setinfo(info);
        this.setcontrario(contrario);
        this.setid_cliente(id_cliente);
        this.setruta_ficheros(ruta_ficheros);
    }
    
//    /**
//     * Elimina de la base de datos el prodecimiento
//     *
//     * @param clave
//     * @return int con las filas afectadas
//     * @throws ClassNotFoundException
//     * @throws SQLException
//     */
//    public  int delete() throws ClassNotFoundException, SQLException {
//        dao = new DAO();
//        return dao.eliminar("DELETE FROM PROCEDIMIENTOS WHERE IDPROCEDIMIENTO=" + this.getidprocedimiento());
//    }
//    
//
//    /**
//     * Retorna una tabla con todos los procedimientos
//     *
//     * @return JDataTable
//     * @throws ClassNotFoundException
//     * @throws Exception
//     */
//    public static JDataTable loadBD() throws ClassNotFoundException, Exception {
//        dao = new DAO();
//        return dao.getSelect("SELECT * FROM PROCEDIMIENTOS");
//    }
//
//    /**
//     * Retorna una tabla con los procedimientos del cliente pasado por parametro
//     *
//     * @param idCliente
//     * @return JDataTable
//     * @throws ClassNotFoundException
//     * @throws Exception
//     */
//    public static JDataTable loadBD(Integer idCliente) throws ClassNotFoundException, Exception {
//        dao = new DAO();
//        return dao.getSelect("SELECT * FROM PROCEDIMIENTOS WHERE ID_CLIENTE=" + idCliente);
//    }
//
//     /**
//     * Retorna una tabla con los procedimientos que coinciden con el
//     * contenido de la variable bscproce
//     * @param bscproce String
//     * @return JDataTable
//     * @throws ClassNotFoundException
//     * @throws Exception
//     */
//    public static JDataTable loadBD(String bscproce) throws ClassNotFoundException, Exception {
//        dao = new DAO();
////        return dao.getSelect("SELECT IDPROCEDIMIENTO,LOCALIDAD,NUMJUZGADO,PROCEDIMIENTO,PROCEDIMIENTOS.INFO,CONTRARIO,IDCLIENTE,RUTA_FICHEROS,CLIENTE,DNI "+  
////                                "FROM CLIENTES " +
////                                "INNER JOIN PROCEDIMIENTOS " +
////                                "ON CLIENTES.IDCLIENTE=PROCEDIMIENTOS.ID_CLIENTE "+ 
////                                "WHERE UPPER(PROCEDIMIENTO) LIKE UPPER('%"+bscproce  +"%') " );        
//                                
//    return dao.getSelect(conf.sql_select_find_procedimientos +"('%"+ bscproce  +"%') " );                     
//                
//                
//                
//                
//                
//              //  "SELECT *  FROM CLIENTES INNER JOIN PROCEDIMIENTOS ON CLIENTE.IDCLIENTE=PROCEDIMIENTOS.ID_CLIENTE WHERE UPPER(PROCEDIMIENTO) LIKE UPPER('%" +bscproce +"%')" );
//    }
//
//    
//    
//    /**
//     * Retorna la cantidad de procedimientos que tiene un cliente
//     *
//     * @param idCliente
//     * @return Integer
//     * @throws ClassNotFoundException
//     * @throws Exception
//     */
//    public static int contarProcedimientos(Integer idCliente) throws ClassNotFoundException, Exception {
//        dao = new DAO();
//        return dao.getCount("SELECT COUNT(*) FROM PROCEDIMIENTOS WHERE ID_CLIENTE = " + idCliente);
//    }
//
//    /**
//     * Elimina de la base de datos el prodecimiento
//     *
//     * @param clave
//     * @return int con las filas afectadas
//     * @throws ClassNotFoundException
//     * @throws SQLException
//     */
//    public static int delete(String clave) throws ClassNotFoundException, SQLException {
//        dao = new DAO();
//        return dao.eliminar("DELETE FROM PROCEDIMIENTOS WHERE IDPROCEDIMIENTO=" + clave);
//    }
//
//    /**
//     * Añade el Procedimiento a la base de datos
//     *
//     * @return
//     * @throws ClassNotFoundException
//     * @throws SQLException
//     */
//    public int add() throws ClassNotFoundException, SQLException {
//        dao = new DAO();
//        String sql = "INSERT INTO PROCEDIMIENTOS (LOCALIDAD,NUMJUZGADO,PROCEDIMIENTO,INFO,CONTRARIO,ID_CLIENTE,RUTA_FICHEROS) VALUES('"
//                + this.getlocalidad() + "'," + this.getnumjuzgado() + ",'" + this.getprocedimiento() + "','" + this.getinfo() + "','" + this.getcontrario() + "'," + this.getid_cliente() + ",'" + this.getruta_ficheros() + "')";
//        return dao.insertar(sql);
//    }
//
//    /**
//     * Actualiza el registro en la BD
//     *
//     * @return Integer con las filas afectadas
//     * @throws ClassNotFoundException
//     * @throws SQLException
//     */
//    public int update() throws ClassNotFoundException, SQLException {
//        dao = new DAO();
//        String sql = "UPDATE PROCEDIMIENTOS  SET LOCALIDAD='" + this.getlocalidad()
//                + "',NUMJUZGADO=" + this.getnumjuzgado()
//                + ",PROCEDIMIENTO='" + this.getprocedimiento()
//                + "',INFO='" + this.getinfo()
//                + "',CONTRARIO='" + this.getcontrario()
//                + "',ID_CLIENTE=" + this.getid_cliente()
//                + ",RUTA_FICHEROS='" + this.getruta_ficheros()
//                + "' WHERE IDPROCEDIMIENTO=" + this.getidprocedimiento();
//
//        return dao.modificar(sql);
//
//    }

}
