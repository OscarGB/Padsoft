package contenido;

import java.io.Serializable;

/**
 * Clase Opciones
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public class Opciones implements Serializable {
	
	//Variables
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * String de la opción
	 */
	private String respuesta;
	
	/**
	 * Si la respuesta correcta o no
	 */
	private boolean correcta;
	
	
	//Constructor
	
	/** 
	 * Constructor de Opciones
	 * @param respuesta
	 * @param correcta
	 */
	public Opciones (String respuesta, boolean correcta) {
		this.respuesta = respuesta;
		this.correcta = correcta;
	}

	
	//Getters y setters
	
	/**
	 * Get respuesta
	 * @return respuesta
	 */
	public String getRespuesta() {
		return respuesta;
	}
	
	/**
	 * Set respuesta
	 * @param respuesta
	 */
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * Get correcta
	 * @return true si es correcta
	 */
	public boolean esCorrecta() {
		return correcta;
	}

	/**
	 * Set correcta
	 * @param correcta the correcta to set
	 */
	public void setCorrecta(boolean correcta) {
		this.correcta = correcta;
	}
	
	//Override
	
	/**
	 * toString, Override
	 * @return String
	 */
	@Override
	public String toString(){
		return this.respuesta;
	}
	
	
	
}
