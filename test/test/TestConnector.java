package test;

import tienda.connectors.Connector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class TestConnector {

    public static void main(String[] args) throws SQLException {
        Connection con = Connector.getConnection();
        String query = "insert into productos(cod_productos, nombre, precio, cantidad,imagen,disponible)values (1004, 'Rosa rosada', 200, 120, 'url','SI')";

        Statement st = con.createStatement();
        st.execute(query);

        Connector.getConnection()
                .createStatement()
                .execute("insert into productos(cod_productos, nombre, precio, cantidad,imagen,disponible)values (2002, 'Ramo de rosas blancas', 1500, 10, 'url','SI')");

        Connector.getConnection()
                .createStatement()
                .execute("delete  from productos where id=1");

        ResultSet rs = Connector
                .getConnection()
                .createStatement()
                .executeQuery("select id, nombre, precio, cantidad from productos");

        while (rs.next()) {

            System.out.println(
                    rs.getInt("id") + ","
                    + rs.getString("nombre") + ","
                    + rs.getFloat("precio") + ","
                    + rs.getInt("cantidad")
            );
        }

        Connector
                .getConnection()
                .createStatement()
                .execute("insert into clientes (nombre,apellido,dni_cuit,direccion,usuario_registrado,contrasenia) values ('juan','perez','12345678','peru 323','si','12345678')");
        ResultSet rs2 = Connector
                .getConnection()
                .createStatement()
                .executeQuery("Select* from clientes");

        while (rs2.next()) {
            System.out.println(
                    rs2.getInt("id") + ","
                    + rs2.getString("nombre") + ","
                    + rs2.getString("apellido") + ","
                    + rs2.getString("pais")
            );

        }

    }
}
