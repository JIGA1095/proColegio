package BBDD;

import utilidades.DEF;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;

public class CONN {

    private static final String drivername = "com.mysql.jdbc.Driver";
    private static final String driver = "jdbc:mysql";
    private static final String port = "3306";

    public static String host = "localhost";
    private static final String user = "developer";
    private static final String pass = "123456..";

    public static String db = "pro_colegio";
    public static String ESQUEMA_OP = db + ".";

    /**
     *
     * @return
     */
    public static Connection getConn() {
        Connection con = null;
        try {
            Class.forName(drivername);
            String BaseDeDatos = driver + "://" + host + ":" + port + "/" + db + "?user=" + user + "&password=" + pass;

            con = DriverManager.getConnection(BaseDeDatos, user, pass);
            con.setAutoCommit(false);

        } catch (Exception e) {
//            DEF.log().log(Level.SEVERE, "Error al conectarse a la base de datos " + host + ":" + port + "/" + db, e);
        }

        return con;

    }

    /**
     *
     * @param con
     * @return
     */
    public static boolean desconectar(Connection con) {

        boolean flag = false;
        if (con == null) {
            return false;
        }
        try {

            if (con.isReadOnly()) {
                con.rollback();
            } else {
                con.commit();
            }

            con.close();

            con = null;
            flag = true;

        } catch (Exception e) {
//            DEF.log().log(Level.SEVERE, "Error al desconectar de la base de datos " + host + ":" + port + "/" + db, e);
        }

        return flag;
    }
  
    
}
