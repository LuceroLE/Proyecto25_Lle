package es.ieselcanaverla.dam2.aadd.lle.dao.impl;

import  es.ieselcanaveral.dam2.aadd.lle.GestorConexion;


import es.ieselcanaveral.dam2.aadd.lle.dao.IContinenteDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import es.ieselcanaveral.dam2.aadd.lle.utilidades.GestorConfiguracion;


public class ContinenteDAOImpl implements IContinenteDAO {

	private GestorConexion gestorConexion;
	
	 
	 private static String DRIVER_MYSQL = GestorConfiguracion.getInfoConfiguracion("driver.sql");
	 private static String URL_MYSQL = GestorConfiguracion.getInfoConfiguracion("url.sql");
	 private static String USUARIO_MYSQL = GestorConfiguracion.getInfoConfiguracion("usuario.sql");
	 private static String CLAVE_MYSQL = GestorConfiguracion.getInfoConfiguracion("clave.sql");
	 
	 
	 
	   public ContinenteDAOImpl(GestorConexion gestorConexion) {
	        this.gestorConexion = gestorConexion;
	   }
	 
 
	   public void agregarContinenteAntartida() {
		    Connection connect = null;
		    PreparedStatement statement = null;

		    try {
		        connect = gestorConexion.getConnection();

		        // Crear la consulta SQL para insertar el continente 'Antártida'
		        String insertSQL = "INSERT INTO T_CONTINENTE (nombre_continente, cod_continente) VALUES (?, ?)";
		        statement = connect.prepareStatement(insertSQL);
		        statement.setString(1, "Antártida");
		        statement.setString(2, "06"); 
		        int filasAfectadas = statement.executeUpdate();

		        // Verificar si la inserción se realizó con éxito
		        if (filasAfectadas > 0) {
		            System.out.println("Inserción exitosa: 'Antártida' ha sido añadida a la tabla.");
		        } else {
		            System.out.println("Error: La inserción ha fallado.");
		        }
		        
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    //CERRAMOS
		    finally {
		        try {
		            if (statement != null) {
		                statement.close();
		            }
		            if (connect != null) {
		                connect.close();
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}

	
	
	   public void eliminarContinenteConCodigo02() {
		    Connection connect = null;
		    PreparedStatement statement = null;

		    try {
		        connect = gestorConexion.getConnection();

		        // Borrar todos los países contenidos en el continente con código 02
		        String deleteCountriesSQL = "DELETE FROM T_PAIS WHERE cod_continente = ?";
		        statement = connect.prepareStatement(deleteCountriesSQL);
		        statement.setString(1, "02");
		        statement.executeUpdate();

		        // Borrar el continente con código 02
		        String deleteContinentSQL = "DELETE FROM T_CONTINENTE WHERE cod_continente = ?";
		        statement = connect.prepareStatement(deleteContinentSQL);
		        statement.setString(1, "02");
		        int filasAfectadas = statement.executeUpdate();

		        // Verificar si la eliminación se realizó con éxito
		        if (filasAfectadas > 0) {
		            System.out.println("Eliminación exitosa: El continente con código 02 y todos sus países han sido borrados.");
		        } else {
		            System.out.println("Error: La eliminación ha fallado. No se encontró el continente con código 02.");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    //CERRAMOS
		    finally {
		        try {
		            if (statement != null) {
		                statement.close();
		            }
		            if (connect != null) {
		                connect.close(); 
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}

	
	
}
