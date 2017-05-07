package interfaz.asignatura.contenido.ejercicio.resolucionPreguntas;

import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;
import respuestas.RespuestaPregunta;

/**
 * Clase ResponderPregunta
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class ResponderPregunta extends NuestroPanel {

	//Variables
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	//Constructor
	
	/**
	 * Constructor
	 * @param anterior
	 * @param frame
	 */
	protected ResponderPregunta(NuestroPanel anterior, NoodleFrame frame) {
		super(anterior, frame);
	}

	//Métodos
	
	/**
	 * Devuelve las respuestas del panel
	 * @return
	 */
	public RespuestaPregunta getRespuesta(){
		return null;
	}
	
}
