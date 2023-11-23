package es.ieselcanaveral.dam2.aadd.lle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import es.ieselcanaveral.dam2.aadd.lle.utilidades.GestorConfiguracion;

public class GestorConexion {
    private Connection connect;

    private static String DRIVER_MYSQL = GestorConfiguracion.getInfoConfiguracion("driver.sql");
    private static String URL_MYSQL = GestorConfiguracion.getInfoConfiguracion("url.sql");
    private static String USUARIO_MYSQL = GestorConfiguracion.getInfoConfiguracion("usuario.sql");
    private static String CLAVE_MYSQL = GestorConfiguracion.getInfoConfiguracion("contraseña.sql");

    public GestorConexion() {
        try {
            Class.forName(DRIVER_MYSQL);
            connect = DriverManager.getConnection(URL_MYSQL, USUARIO_MYSQL, CLAVE_MYSQL);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connect;
    }

    public void cerrarConexion() {
        try {
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
