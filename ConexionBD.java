package ejercicio.libro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	public Connection mySQLConnect() {

		String url = "jdbc:mysql://localhost:3306/biblioteca_db";
		String usuario = "root";
		String password = "";

		Connection conexion = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conexion = DriverManager.getConnection(url, usuario, password);
			System.out.println("Conexión exitosa a la base de datos");

		} catch (ClassNotFoundException e) {
			System.err.println("ERROR: No se encontró el driver de MySQL");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Error al conectar a la base de datos");
			e.printStackTrace();
		}

		return conexion;
	}

}
