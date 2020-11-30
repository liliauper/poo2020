package tienda.connectors;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String vendor = "mysql";
    private static String server = "localhost";
    private static String port = "3306";
    private static String db = "tiendaMinimo";
    private static String params = "";
    private static String user = "lilia";
    private static String pass = "aspire70";

    private static String url = "jdbc:" + vendor + "://" + server + ":" + port + "/" + db + params;
    private static Connection con = null;

    private Connector() {
    }

    public synchronized static Connection getConnection() {
        try {

            if (con == null || con.isClosed()) {
                Class.forName(driver);
                con = DriverManager.getConnection(url, user,pass);
            }

        } catch (Exception e) {e.printStackTrace();}

        return con;
    }
}
