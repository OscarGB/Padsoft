package interfaz.asignatura.contenido.ejercicio.resolucionPreguntas;

import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;
import respuestas.RespuestaPregunta;

public class ResponderPregunta extends NuestroPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param anterior
	 * @param frame
	 */
	protected ResponderPregunta(NuestroPanel anterior, NoodleFrame frame) {
		super(anterior, frame);
	}

	/**
	 * Devuelve las respuestas del panel
	 * @return
	 */
	public RespuestaPregunta getRespuesta(){
		return null;
	}
	
}
