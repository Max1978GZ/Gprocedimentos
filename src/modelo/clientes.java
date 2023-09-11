package modelo;

import java.sql.SQLException;
import DAO.DAO;
import DataTable.JDataTable;
import Parametros.conf;

public  class clientes {

    private static DAO dao;
    private Integer idcliente;

    private String cliente;

    private String numcarpeta;

    private String dni;

    private String direccion;

    private String telefono;

    private String movil;

    private String info;

    public Integer getidcliente() {

        return idcliente;

    }

    public void setidcliente(Integer idcliente) {

        this.idcliente = idcliente;

    }

    public String getcliente() {

        return cliente;

    }

    public void setcliente(String cliente) {

        this.cliente = cliente;

    }

    public String getnumcarpeta() {

        return numcarpeta;

    }

    public void setnumcarpeta(String numcarpeta) {
        if (numcarpeta.length() > 12) {
            this.numcarpeta = numcarpeta.substring(0, 12);
        } else {
            this.numcarpeta = numcarpeta;
        }

    }

    public String getdni() {

        return dni;

    }

    public void setdni(String dni) {
        if (dni.length() > 12) {
            this.dni = dni.substring(0, 12);
        } else {
            this.dni = dni;
        }

    }

    public String getdireccion() {

        return direccion;

    }

    public void setdireccion(String direccion) {
        if (dni.length() >150) {
            this.direccion = direccion.substring(0, 150);
        } else {
            this.direccion = direccion;
        }

    }

    public String gettelefono() {

        return telefono;

    }

    public void settelefono(String telefono) {
        if (telefono.length() > 12) {
            this.telefono = telefono.substring(0, 12);
        } else {
            this.telefono = telefono;
        }
    }

    public String getmovil() {

        return movil;

    }

    public void setmovil(String movil) {
        if (movil.length() > 12) {
            this.movil = movil.substring(0, 12);
        } else {
            this.movil = movil;
        }

    }

    public String getinfo() {

        return info;

    }

    public void setinfo(String info) {
        if (info.length() > 500) {
            this.info = info.substring(0, 500);
        } else {
            this.info = info;
        }

    }

    public clientes(Integer idcliente, String cliente,String dni) {
        this.setidcliente(idcliente);
        this.setcliente(cliente);
        this.setdni(dni);
    }

    
    
    public clientes(Integer idcliente, String cliente, String numcarpeta, String dni, String direccion, String telefono, String movil, String info) {

        this.setidcliente(idcliente);
        this.setcliente( cliente);
        this.setnumcarpeta( numcarpeta);
        this.setdni(dni);
        this.setdireccion( direccion);
        this.settelefono(telefono);
        this.setmovil(movil);
        this.setinfo (info);
    }

    public clientes() {

    }

//    public static JDataTable loadBD() throws ClassNotFoundException, Exception {
//        dao = new DAO();
//        return dao.getSelect("SELECT * FROM CLIENTES");
//    }
//
//    public static JDataTable loadBD(String sql) throws ClassNotFoundException, Exception {
//        dao = new DAO();
//        return dao.getSelect(sql);
//    }
//
//    /**
//     * busca en la base de datos los que coincida el nombre o el dni
//     *
//     * @param nombredni
//     * @return
//     * @throws ClassNotFoundException
//     * @throws Exception
//     */
//    public static JDataTable buscarBD(String nombredni) throws ClassNotFoundException, Exception {
//        dao = new DAO();
//        String sql;//  ="SELECT IDCLIENTE,CLIENTE,NUMCARPETA,DNI,DIRECCION,TELEFONO,MOVIL,INFO,(DNI ||CLIENTE) AS DC   FROM CLIENTES WHERE DC LIKE '"+ nombredni +"'";    
//
//       // sql = "SELECT * FROM (SELECT IDCLIENTE,CLIENTE,NUMCARPETA,DNI,DIRECCION,TELEFONO,MOVIL,INFO, (DNI ||CLIENTE) AS DC  FROM CLIENTES ) AS CLI WHERE UPPER(DC) LIKE UPPER('%" + nombredni + "%')";
//        sql = conf.sql_select_find_clientes +"('%" + nombredni + "%')";
//        return dao.getSelect(sql);
//    }
//
//    public static int delete(String clave) throws ClassNotFoundException, SQLException {
//        dao = new DAO();
//        return dao.eliminar("DELETE FROM CLIENTES WHERE IDCLIENTE=" + clave);
//    }
//
//    public int delete() throws ClassNotFoundException, SQLException, Exception {
//        
//        if(modelo.procedimientos.contarProcedimientos(this.getidcliente())>0){
//            return -1;
//        }else{
//        dao = new DAO();
//        return dao.eliminar("DELETE FROM CLIENTES WHERE IDCLIENTE=" + this.getidcliente());
//        }
//    }
//    
//    
//    public int add() throws ClassNotFoundException, SQLException {
//        dao = new DAO();
//        String sql = "INSERT INTO CLIENTES (CLIENTE,NUMCARPETA,DNI,DIRECCION,TELEFONO,MOVIL,INFO) VALUES('" + this.getcliente() + "','" + this.getnumcarpeta() + "','" + this.getdni() + "','" + this.getdireccion() + "','" + this.gettelefono() + "','" + this.getmovil() + "','" + this.getinfo() + "')";
//        return dao.insertar(sql);
//    }
//
//    public int update() throws ClassNotFoundException, SQLException {
//        dao = new DAO();
//        
//        String sql = "UPDATE CLIENTES  SET CLIENTE='" + this.getcliente()
//                + "',NUMCARPETA='" + this.getnumcarpeta()
//                + "',DNI='" + this.getdni()
//                + "',DIRECCION='" + this.getdireccion()
//                + "',TELEFONO='" + this.gettelefono()
//                + "',MOVIL='" + this.getmovil()
//                + "',INFO='" + this.getinfo()
//                + "' WHERE IDCLIENTE=" + this.getidcliente();
//
//        return dao.modificar(sql);
//
//    }

}
