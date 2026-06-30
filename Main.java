package ejercicio.libro;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {


	public static Libro crearLibro() {

		String titulo = MetodosComunes.introduceTexto("Introduzca el título:");

		String autor = MetodosComunes.introduceTexto("Introduzca el autor:");

		String genero = MetodosComunes.introduceTexto("Introduzca el género:");

		double precio = MetodosComunes.introduceDecimal("Introduzca el precio:");

		boolean disponible = MetodosComunes.introduceBoolean("Introduzca si está disponible: (true/false)");

		Libro libro = new Libro(titulo, autor, genero, precio, disponible);

		return libro;
	}

	public static void main(String[] args) {

		ConexionBD bd = new ConexionBD();
		Connection conexion = bd.mySQLConnect();

		int opcion = 0;

		do {

			opcion = MetodosComunes.introduceNumero(
					"===== MENÚ BIBLIOTECA =====\n" + "1. Insertar libro\n" + "2. Mostrar todos los libros\n"
							+ "3. Buscar libros por autor\n" + "4. Actualizar precio de un libro\n"
							+ "5. Eliminar libro\n" + "0. Salir\n" + "Elige una opción:");

			switch (opcion) {
			case 1:
				Libro libro = crearLibro();
				LibroDAO.insertarLibro(libro, conexion);
				break;
			case 2:
				LibroDAO.mostrarLibros(conexion);
				break;
			case 3:
				String autor = MetodosComunes.introduceTexto("Introduzca el nombre del autor:");
				LibroDAO.buscarLibrosPorAutor(autor, conexion);
				break;
			case 4:
				int id = MetodosComunes.introduceNumero("Introduzca el id:");
				double precioActual = MetodosComunes.introduceDecimal("Introduzca el precio actual:");
				LibroDAO.actualizarPrecio(id, precioActual, conexion);
				break;
			case 5:
				int id2 = MetodosComunes.introduceNumero("Introduzca el id:");
				LibroDAO.eliminarLibro(id2, conexion);
				break;
			case 0:
				System.out.println("Fin del programa - Cerrando conexión...");

				try {
					conexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.err.println("Opción no válida");
				break;
			}
		} while (opcion != 0);
	}

}
