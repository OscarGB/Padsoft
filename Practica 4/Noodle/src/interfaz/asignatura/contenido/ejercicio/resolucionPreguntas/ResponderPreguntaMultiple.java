package interfaz.asignatura.contenido.ejercicio.resolucionPreguntas;

import java.awt.BorderLayout;
import java.awt.Color;

import contenido.Ejercicio;
import contenido.PreguntaRespuestaMultiple;
import interfaz.asignatura.contenido.ejercicio.genericosPreguntas.PreguntaMultiplePanel;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;
import respuestas.RespuestaPregunta;

/**
 * Clase ResponderPreguntaMultiple
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class ResponderPreguntaMultiple extends ResponderPregunta {
	
	//Variables
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Pregunta que se est� resolviendo
	 */
	private PreguntaRespuestaMultiple preg;
	
	/**
	 * Panel derecho
	 */
	private ResponderPreguntaMenuDer derecha;
	
	/**
	 * Panel
	 */
	private PreguntaMultiplePanel panel;
	
	/**
	 * Ejercicio
	 */
	private Ejercicio ej;
	
	//Constructor
	
	/**
	 * Constructor
	 * @param anterior
	 * @param frame
	 * @param preg
	 * @param ej
	 */
	public ResponderPreguntaMultiple(NuestroPanel anterior, NoodleFrame frame, PreguntaRespuestaMultiple preg, Ejercicio ej) {
		super(anterior, frame);
		
		this.ej = ej;
		this.preg = preg;
		
		this.setBackground(Color.WHITE);
		this.setSize(400,350);
		
		this.setLayout(new BorderLayout());
		
		this.derecha = new ResponderPreguntaMenuDer(frame, this.ej, this.preg, this);
		this.panel = new PreguntaMultiplePanel(this.preg);
		
		this.add(this.derecha, BorderLayout.EAST);
		this.add(this.panel, BorderLayout.CENTER);
	}
	
	/**
	 * Devuelve las respuestas del panel
	 * @return
	 */
	@Override
	public RespuestaPregunta getRespuesta(){
		return panel.getRespuesta();
	}
}
