package DAO;

import DataTable.JDataTable;
import Parametros.conf;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {


    Connection con = null;

    public DAO() throws ClassNotFoundException {
       System.out.println("Esta es la clase q usa dao " + conf.className);
      
            Class.forName(conf.className);
  

    }

    /**
     * Constructor expecifico, se le pasa el driver por parametro
     *
     * @param SQLClientDriver
     * @throws ClassNotFoundException
     */
    public DAO(String SQLClientDriver) throws ClassNotFoundException {
        Class.forName(SQLClientDriver);
    }

    /**
     * Activa la conexion a la BD si no esta conectada
     *
     * @throws SQLException
     */
    private void conectar() throws SQLException {
        if (con == null || con.isClosed()) {
            
           
            con = DriverManager.getConnection(conf.strconex  +"//"+ conf.ip +"/"+ conf.BD, conf.user, conf.passw);

          
        }
    }
    
    
    public boolean serverOnline(){
        try{
             this.conectar();
             System.out.println("Comprobando servidor "+conf.toStringto());
             this.con.close();
             return true;
        }catch(SQLException ex){
             System.out.println("No se puede conectar al servidor "+ex.getMessage());
            return false;
        }
        
        
    }

//    /**
//     * Activa la conexion a la BD si no esta conectada
//     *
//     * @throws SQLException
//     */
//    private void conectar(String stringConect, String user, String password) throws SQLException {
//        if (con == null || con.isClosed()) {
//            con = DriverManager.getConnection(stringConect, user, password);
//        }
//    }

    /**
     * Ejecuta la String SQL en el servidor BD
     *
     * @param SQL
     * @return numero de filas modificadas
     * @throws SQLException
     */
    public int insertar(String SQL) throws SQLException {
        int registro = 0;
        System.out.println(SQL+conf.toStringto());
        this.addLog(SQL);
        this.conectar();
        Statement stm = con.createStatement();

        registro = stm.executeUpdate(SQL);

//        if (registro > 0) {
//            System.out.println("ok" + registro);
//        }
        if (!con.isClosed()) {
            con.close();
        }
        return registro;
    }

    /**
     * Guarda el texto log en la tabla LOG
     *
     * @param log
     * @return numero de filas modificadas
     * @throws SQLException
     */
    public int addLog(String log) throws SQLException {
        int registro = 0;
        this.conectar();
        String sql = "INSERT INTO LOG(LOG)VALUES('" + log.replaceAll("'", "") + "')";
        System.out.println(sql +"\n"+ conf.toStringto());
        Statement stm = con.createStatement();
        registro = stm.executeUpdate(sql);

//        if (registro > 0) {
//            System.out.println("ok" + registro);
//        }
        if (!con.isClosed()) {
            con.close();
        }
        return registro;
    }

    /**
     * Retorna la tabla de la Consulta SELECT del SQL
     *
     * @param selectSQL
     * @return JDataTable
     * @throws SQLException
     * @throws Exception
     */
    public JDataTable getSelect(String selectSQL) throws SQLException, Exception {
        ResultSet rs;
        this.conectar();
        System.out.println(selectSQL +"\n"+ conf.toStringto());
        Statement stm = con.createStatement();
        rs = stm.executeQuery(selectSQL);
        JDataTable ta = new JDataTable(rs);
        if (!con.isClosed()) {
            con.close();
        }
        return ta;
    }

    
    /**
     * Ejecuta la String SQL en el Servidor BD
     *
     * @param SQL
     * @return numero de filas modificadas
     * @throws SQLException
     */
    public int modificar(String SQL) throws SQLException {
        int registro = 0;
        System.out.println(SQL+"\n"+ conf.toStringto());
        this.addLog(SQL);
        this.conectar();

        Statement stm = con.createStatement();

        registro = stm.executeUpdate(SQL);

//        if (registro > 0) {
//            System.out.println("ok " + registro);
//        }
        if (!con.isClosed()) {
            con.close();
        }
        return registro;
    }

    /**
     * Ejecuta la String SQL en el servidor BD
     *
     * @param SQL
     * @return numero de filas afectadas
     * @throws SQLException
     */
    public int eliminar(String SQL) throws SQLException {
        int registro = 0;
        System.out.println(SQL +"\n"+ conf.toStringto());
        this.addLog(SQL);
        this.conectar();

        Statement stm = con.createStatement();

        registro = stm.executeUpdate(SQL);

//        if (registro > 0) {
//            System.out.println("ok " + registro);
//        }
       if (!con.isClosed()) {
            con.close();
        }
        return registro;
    }

    /**
     * Retorna un solo valor entero util para consulta de conteo de filas
     *     
* @param selectSQL
     * @return Integer
     * @throws SQLException
     * @throws Exception
     */
    public Integer getCount(String selectSQL) throws SQLException, Exception {
        ResultSet rs;
        Integer valor = 0;
        this.conectar();
        Statement stm = con.createStatement();
        rs = stm.executeQuery(selectSQL);
        if (rs.next()) {
            valor = Integer.valueOf(rs.getString(1));
        }
        if (!con.isClosed()) {
            con.close();
        }
        return valor;
    }

   

    

}
