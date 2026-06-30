package ejercicio.libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LibroDAO {

	public static void insertarLibro(Libro libro, Connection conexion) {

		String query = "INSERT INTO libros (titulo, autor, genero, precio, disponible) VALUES (?, ?, ?, ?, ?)";

		try {

			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, libro.getTitulo());
			ps.setString(2, libro.getAutor());
			ps.setString(3, libro.getGenero());
			ps.setDouble(4, libro.getPrecio());
			ps.setBoolean(5, libro.isDisponible());

			int resultado = ps.executeUpdate();

			if (resultado > 0) {
				System.out.println("Se ha añadido correctamente el libro a la base de datos");
			} else {
				System.err.println("ERROR: No se ha podido añadir el libro");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void mostrarLibros(Connection conexion) {

		String query = "SELECT * FROM libros";

		try {

			Statement comando = conexion.createStatement();

			ResultSet resultado = comando.executeQuery(query);

			System.out.println("LISTA DE LIBROS:");
			while (resultado.next()) {
				System.out.println(
						"ID: " + resultado.getInt("id") + " Título: " + resultado.getString("titulo") + " Autor: "
								+ resultado.getString("autor") + " Género: " + resultado.getString("genero") + " Precio: "
								+ resultado.getDouble("precio") + " Disponible: " + resultado.getBoolean("disponible"));

				System.out.println("----------------------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void buscarLibrosPorAutor(String autor, Connection conexion) {

		String query = "SELECT * FROM libros WHERE autor LIKE ?";

		try {

			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, autor);

			ResultSet resultado = ps.executeQuery();

			System.out.println("LISTA DE LIBROS DE: " + autor);
			while (resultado.next()) {

				System.out.println("ID: " + resultado.getInt("id") + " Título: " + resultado.getString("titulo")
						+ " Autor: " + resultado.getString("autor") + " Género: " + resultado.getString("genero")
						+ " Precio: " + resultado.getDouble("precio") + " Disponible: "
						+ resultado.getBoolean("disponible"));

				System.out.println("----------------------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void actualizarPrecio(int id, double nuevoPrecio, Connection conexion) {

		String query = "UPDATE libros SET precio = ? WHERE id = ?";

		try {

			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			ps.setDouble(2, nuevoPrecio);

			int resultado = ps.executeUpdate();

			if (resultado > 0) {
				System.out.println("Precio actualizado con ÉXITO");
			} else {
				System.err.println("ERROR: No se ha podido actualizar");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void eliminarLibro(int id, Connection conexion) {

		String query = "DELETE FROM libros WHERE id = ?";

		try {

			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);

			int resultado = ps.executeUpdate();

			if (resultado > 0) {
				System.out.println("Libro eliminado con ÉXITO");
			} else {
				System.err.println("ERROR: No se ha podido eliminar");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
