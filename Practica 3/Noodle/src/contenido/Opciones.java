package contenido;

public class Opciones {
	
	//Variables
	
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
	
	
	
}
