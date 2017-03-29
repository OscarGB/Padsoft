package contenido;

import asignatura.Asignatura;
import java.io.Serializable;

/**
 * Clase Apuntes
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */
public class Apuntes extends Contenido implements Serializable{
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;
	
	//Variables
	
	/**
	 * Texto de los apuntes
	 */
	private String texto;
	
	
	//Constructores
	/**
	 * Constructor para la clase Apuntes en directorio raiz
	 * @param String texto
	 * @param String titulo
	 * @param boolean visibilidad
	 * @param asignatura
	 */
	public Apuntes(String texto, String titulo, boolean visibilidad, Asignatura asig) {
		super(titulo, visibilidad, asig);
		this.texto = texto;
	}
	
	/**
	 * Constructor para la clase Apuntes como subcontenido
	 * @param String texto
	 * @param String titulo
	 * @param boolean visibilidad
	 * @param asignatura
	 * @param padre
	 */
	public Apuntes(String texto, String titulo, boolean visibilidad, Asignatura asig, Tema padre) {
		super(titulo, visibilidad, asig, padre);
		this.texto = texto;
	}

	
	//Getters y setters
	
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
	
	
	//Overrides
	
	/**
	 * (Override) toString()
	 * Esribe en un string los datos de Apuntes
	 * @return String
	 */
	@Override
	public String toString() {
		return "Titulo de los apuntes: " + this.titulo + "\n Texto: " + this.texto + "\n";
	}
	
}
