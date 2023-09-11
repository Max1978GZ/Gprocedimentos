/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parametros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.swing.JOptionPane;
import modelo.TypeBd;

/**
 *
 * @author zeus
 */
public class conf {

    public static String tipoBd;
    public static String ip;
    public static String className;
    public static String BD;
    public static String user;
    public static String passw;
    public static String strconex;
   // public static String sql_select_clientes;
   // public static String sql_select_procedimientos;
   // public static String sql_select_procedimientos_where_cliente;
    public static String sql_select_find_clientes;
    public static String sql_select_find_procedimientos;
    public static String pathConfig;

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        conf.ip = ip;
    }

    public static String getClassName() {
        return className;
    }

    public static void setClassName(String className) {
        conf.className = className;
    }

    public static String getBD() {
        return BD;
    }

    public static void setBD(String BD) {
        conf.BD = BD;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        conf.user = user;
    }

    public static String getPassw() {
        return passw;
    }

    public static void setPassw(String passw) {
        conf.passw = passw;
    }

    public static String getStrconex() {
        return strconex;
    }

    public static void setStrconex(String strconex) {
        conf.strconex = strconex;
    }

    public static String getTipoBD() {
        return tipoBd;
    }

    public static void setTipoBD(TypeBd TipoBD) {
        conf.tipoBd = TipoBD.toString();
    }

    /**
     *
     * @return
     */
    public static String toStringto() {
        return "\n conf{" + conf.tipoBd + conf.BD + conf.className + conf.ip + conf.user + conf.passw + conf.strconex + "}\n";
    }

    /**
     * carga la configuracion del archivo de configuraciones
     *
     *
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public void getConf() throws FileNotFoundException, IOException {
//        try {
        //se crea una instancia a la clase Properties
        Properties propiedades = new Properties();
        Properties propiedadesSql = new Properties();

        File a = new File(".");

        // System.out.println("leyendo getabsolutepath " + a.getAbsolutePath());
        String pa = a.getAbsolutePath();
        pa = pa.substring(0, pa.length() - 1) + "conf";
        conf.pathConfig = pa;

        a = new File(pa);
        // Parametros.ConfMySql mysql = new ConfMySql();
        if (a.exists()) {
            System.out.println("LEYENDO EL ARCHIVO DE CONF\n" + pa);
            FileReader fr = new FileReader(a);
            propiedades.load(fr);
            getConf(propiedades);

        } else {
            System.out.println("NO EXISTE EL ARCHIVO DE CONF CARGAMOS EL POR DEFECTO \n" + a.getAbsolutePath());
            propiedades.load(this.getClass().getResourceAsStream("mysql"));
            propiedadesSql.load(this.getClass().getResourceAsStream("sqlmysql"));
            getConf(propiedades);
            System.out.println("CREAMOS EL ARCHIVO DE CONF");
            conf.crearFile(ip, user, passw, BD);
        }

        //si el archivo de propiedades NO esta vacio retornan las propiedes leidas
        if (!propiedades.isEmpty()) {
            copiarConf(propiedades);

            System.out.println("COPIAMOS CONFIGURACION DE Pro A CONF ");
            if (!propiedadesSql.isEmpty()) {
                this.copiarSQL( propiedadesSql);


            }
        } else {//sino  retornara NULL
            JOptionPane.showMessageDialog(null, "Se ha producido un error la configuración esta vacia.");
        }

    }

    private void getConf(Properties propiedades) {
        try {
            Properties propiedadesSql = new Properties();
            System.out.println("TIPO SERVER :"+propiedades.getProperty("TipoServidor").toLowerCase());
            
            propiedadesSql.load(this.getClass().getResourceAsStream("sql"+propiedades.getProperty("TipoServidor").toLowerCase()));

            if (!propiedades.isEmpty()) {

                if (!propiedadesSql.isEmpty()) {
                    this.copiarSQL( propiedadesSql);

                }
            } else {// si no hay configuracion ponemos la por defecto
                propiedades.load(this.getClass().getResourceAsStream("mysql"));
                propiedadesSql.load(this.getClass().getResourceAsStream("sqlmysql"));
                JOptionPane.showMessageDialog(null, "Se ha producido un error la configuración esta vacia.\n Se usara la configuración por defecto.");
                // System.out.println("Error al intentar obtener la configuración");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error al leer el archivo de configuración.");
            //System.out.println("Error al intentar leer el archivo de configuración");

        }
    }

    public static void crearFile(String ip, String usuario, String pass, String bd) {
        //  System.out.println(tipoSrvBD);
        String texto = "";
        texto = "#     CONFIGURACION PARA DERBY\n"
                + "#ClassName=org.apache.derby.jdbc.ClientDriver\n"
                + "#Conexion=jdbc:derby:\n"
                + "#TipoServidor=" + modelo.TypeBd.DerbyDb.toString() + "\n\n"
                + "#     CONFIGURACION PARA MYSQL\n"
                + "ClassName=com.mysql.jdbc.Driver\n"
                + "Conexion=jdbc:mysql:\n"
                + "Ip=" + ip + "\n"
                + "TipoServidor=" + modelo.TypeBd.MySql.toString() + "\n"
                + "Usuario=" + usuario + "\n"
                + "Pass=" + pass + "\n"
                + "BD=" + bd;

        System.out.println("GUARDAMOS LOS DATOS EN EL ARCHIVO DE CONF =[\n" + texto + "\n]EOF");
        String path = new File(".").getAbsolutePath();

        FileWriter fichero = null;

        PrintWriter pw = null;
        try {

            path = path.substring(0, path.length() - 1) + "conf";
            System.out.println("LA RUTA ES " + path);

            fichero = new FileWriter(path);
            pw = new PrintWriter(fichero);

            pw.println(texto);

            if (null != fichero) {
                fichero.close();
            }
        } catch (Exception e) {

            System.out.println("Se ha producido un error al guardar los datos de acceso a la BD\n"
                    + e.getMessage()
                    + path
            );
        }

    }

    private void copiarSQL(Properties propiedadesSql) {
//        conf.sql_select_clientes = propiedadesSql.getProperty("sql_select_clientes");
//        conf.sql_select_procedimientos = propiedadesSql.getProperty("sql_select_procedimientos");
        conf.sql_select_find_clientes = propiedadesSql.getProperty("sql_select_find_clientes");
        conf.sql_select_find_procedimientos = propiedadesSql.getProperty("sql_select_find_procedimientos");
       // conf.sql_select_procedimientos_where_cliente = propiedades.getProperty("sql_select_procedimientos_where_cliente");
        System.out.println("CARGADAS LAS SENTENCIAS SQL" + "\n"
//                + conf.sql_select_clientes + " CLI\n"
                + conf.sql_select_find_clientes + " FINCLI\n"
                + conf.sql_select_find_procedimientos + " FINPRO\n"
//                + conf.sql_select_procedimientos + "PRO\n"
               // + conf.sql_select_procedimientos_where_cliente + " PROCLI\n"
        );

    }

    private void copiarConf(Properties propiedades) {
        conf.tipoBd = propiedades.getProperty("TipoServidor");
        conf.ip = propiedades.getProperty("Ip");
        // System.out.println(conf.ip);
        conf.className = propiedades.getProperty("ClassName");
        // System.out.println(conf.className);
        conf.BD = propiedades.getProperty("BD");
        //  System.out.println(conf.BD);
        conf.user = propiedades.getProperty("Usuario");
        //  System.out.println(conf.user);
        conf.passw = propiedades.getProperty("Pass");
        //  System.out.println(conf.passw);
        conf.strconex = propiedades.getProperty("Conexion");
        //  System.out.println(conf.strconex);
        System.out.println("COPIAMOS LA CONFIGURACION");

    }

}// FIN CLASE

