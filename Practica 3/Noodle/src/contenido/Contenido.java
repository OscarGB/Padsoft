package contenido;

/**
 * Clase Contenido
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */
/**
 * @author Nacho
 *
 */
public abstract class Contenido {
	/**
	 * Titulo del contenido
	 */
	protected String titulo;
	
	/**
	 * Visibilidad del contenido
	 */
	protected boolean visibilidad;
	
	/**
	 * Constructor de Contenido
	 * @param titulo
	 * @param visibilidad
	 */
	public Contenido(String titulo, boolean visibilidad){
		this.titulo = titulo;
		this.visibilidad = visibilidad;
	}

	/**
	 * Getter de titulo
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Setter de titulo
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Getter de visibilidad
	 * @return
	 */
	public boolean getVisibilidad() {
		return visibilidad;
	}

	/**
	 * Setter de visibilidad
	 * @param visibilidad
	 */
	public void setVisibilidad(boolean visibilidad) {
		this.visibilidad = visibilidad;
	}
}
