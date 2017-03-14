package contenido;

public class Opciones {
	
	/**
	 * String de la opción
	 */
	private String respuesta;
	
	/**
	 * Si la respuesta escogida por el alumno es correcta o no
	 * Por defecto será false
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
