package contenido;

/**
 * Clase Apuntes
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */
public class Apuntes extends Contenido{
	/**
	 * Texto de los apuntes
	 */
	private String texto;
	
	/**
	 * Constructor para la clase Apuntes
	 * @param String texto
	 * @param String titulo
	 * @param boolean visibilidad
	 */
	public Apuntes(String texto, String titulo, boolean visibilidad) {
		super(titulo, visibilidad);
		this.texto = texto;
	}

	/**
	 * Getter de texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * Setter de texto
	 * @param texto
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	/**
	 * (Override) toString()
	 * Esribe en un string los datos de Apuntes
	 * @return String
	 */
	@Override
	public String toString() {
		return "Titulo de los apuntes: " + this.titulo + "\nTexto: " + this.texto + "\n";
	}
	
}
