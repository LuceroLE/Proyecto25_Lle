package es.ieselcanaverla.dam2.aadd.lle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.mysql.cj.jdbc.CallableStatement;

import es.ieselcanaveral.dam2.aadd.lle.GestorConexion;
import es.ieselcanaveral.dam2.aadd.lle.dao.IPaisDAO;
import es.ieselcanaveral.dam2.aadd.lle.utilidades.GestorConfiguracion;




public class PaisDAOImpl implements IPaisDAO{

	private static GestorConexion gestorConexion;
	
	 
	 private static String DRIVER_MYSQL = GestorConfiguracion.getInfoConfiguracion("driver.sql");
	 private static String URL_MYSQL = GestorConfiguracion.getInfoConfiguracion("url.sql");
	 private static String USUARIO_MYSQL = GestorConfiguracion.getInfoConfiguracion("usuario.sql");
	 private static String CLAVE_MYSQL = GestorConfiguracion.getInfoConfiguracion("clave.sql");
	 

	   public PaisDAOImpl(GestorConexion gestorConexion) {
	        this.gestorConexion = gestorConexion;
	   }
	 
	 public void actualizarNombrePaisConCodigo107() {
		    Connection connect = null;
		    PreparedStatement statement = null;

		    try {
		        connect = gestorConexion.getConnection();

		        // Creamos la consulta SQL para actualizar el nombre del país con código 107
		        String updateSQL = "UPDATE T_PAIS SET nombre_pais = ?, capital = ? WHERE cod_continente = ? AND cod_pais = ?";
		        statement = connect.prepareStatement(updateSQL);
		        statement.setString(1, "Indonesia"); // Codigo nombre del país
		        statement.setString(2, "Capital city"); // Nuevo nombre de la capital
		        statement.setString(3, "03"); // Código del continente
		        statement.setString(4, "107"); // Código del país
		        int filasAfectadas = statement.executeUpdate();

		        // Verificamos si la actualización se realizó con éxito
		        if (filasAfectadas > 0) {
		            System.out.println("Actualización exitosa: El nombre del país con código 107 ha sido cambiado a 'Capital city'.");
		        } else {
		            System.out.println("Error: La actualización ha fallado. No se encontró el país con código 107.");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
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

	 
	 public void consultarPaisesContinenteSA() {
		    Connection connect = null;

		    try {
		        connect = gestorConexion.getConnection();

		        // Consulta SQL para obtener los países cuya capital comienza con 'Sa' en el continente con código '02'
		        String consultaSQL = "SELECT T_PAIS.nombre_pais, T_PAIS.capital " +
		                "FROM T_PAIS " +
		                "INNER JOIN T_CONTINENTE ON T_PAIS.cod_continente = T_CONTINENTE.cod_continente " +
		                "WHERE T_PAIS.capital LIKE 'Sa%' AND T_CONTINENTE.cod_continente = '02'";

		        PreparedStatement statement = connect.prepareStatement(consultaSQL);
		        ResultSet resultSet = statement.executeQuery();

		        while (resultSet.next()) {
		            String nombrePais = resultSet.getString("nombre_pais");
		            String capital = resultSet.getString("capital");

		            System.out.println(capital + " es capital de " + nombrePais);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (connect != null) {
		                connect.close();
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}

	


	 public void consultarPaisesPorCapital(String inicioCapital, String codigoContinente) {
		    Connection connect = null;

		    try {
		        connect = gestorConexion.getConnection();

		        // Llamada a la función almacenada
		        String sql = "{ ? = call consultarPaisesPorInicial(?, ?) }";
		        try (java.sql.CallableStatement callableStatement = connect.prepareCall(sql)) {

		            // Registro de parámetros de salida y entrada
		            callableStatement.registerOutParameter(1, Types.VARCHAR);
		            callableStatement.setString(2, inicioCapital);
		            callableStatement.setString(3, codigoContinente);

		            // Ejecutar la llamada a la función
		            callableStatement.execute();

		            // Obtener el resultado
		            String resultado = callableStatement.getString(1);

		            // Manejar el resultado según sea necesario
		            System.out.println(resultado);
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (connect != null) {
		                connect.close();
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}
		
	}

	





