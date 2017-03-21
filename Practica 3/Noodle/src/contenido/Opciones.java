package contenido;

public class Opciones {
	
	/**
	 * String de la opci�n
	 */
	private String respuesta;
	
	/**
	 * Si la respuesta correcta o no
	 */
	private boolean correcta;
	
	/** 
	 * Constructor de Opciones
	 * @param respuesta
	 * @param correcta
	 */
	public Opciones (String respuesta, boolean correcta) {
		this.respuesta = respuesta;
		this.correcta = correcta;
	}
}
