package ejercicio.libro;

public class Libro {

	private int id;
	private String titulo;
	private String autor;
	private String genero;
	private double precio;
	private boolean disponible;

	/**
	 * @param titulo
	 * @param autor
	 * @param genero
	 * @param precio
	 * @param disponible
	 */
	public Libro(String titulo, String autor, String genero, double precio, boolean disponible) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.precio = precio;
		this.disponible = disponible;
	}

	/**
	 * @param id
	 * @param titulo
	 * @param autor
	 * @param genero
	 * @param precio
	 * @param disponible
	 */
	public Libro(int id, String titulo, String autor, String genero, double precio, boolean disponible) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.precio = precio;
		this.disponible = disponible;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the disponible
	 */
	public boolean isDisponible() {
		return disponible;
	}

	/**
	 * @param disponible the disponible to set
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", genero=" + genero + ", precio="
				+ precio + ", disponible=" + disponible + "]";
	}

}
