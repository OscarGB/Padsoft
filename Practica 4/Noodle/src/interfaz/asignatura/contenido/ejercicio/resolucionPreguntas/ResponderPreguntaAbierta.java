package interfaz.asignatura.contenido.ejercicio.resolucionPreguntas;

import java.awt.BorderLayout;
import java.awt.Color;

import contenido.Ejercicio;
import contenido.PreguntaRespuestaAbierta;
import contenido.PreguntaRespuestaMultiple;
import interfaz.asignatura.contenido.ejercicio.genericosPreguntas.PreguntaMultiplePanel;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;
import respuestas.RespuestaAbierta;
import respuestas.RespuestaMultiple;
import respuestas.RespuestaPregunta;

public class ResponderPreguntaAbierta extends ResponderPregunta {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Pregunta que se está resolviendo
	 */
	private PreguntaRespuestaAbierta preg;
	
	/**
	 * Panel derecho
	 */
	private ResponderPreguntaMenuDer derecha;
	
	/**
	 * Panel
	 */
	private ResponderPreguntaAbiertaPanel panel;
	
	/**
	 * Ejercicio
	 */
	private Ejercicio ej;
	
	/**
	 * Constructor
	 * @param anterior
	 * @param frame
	 * @param preg
	 * @param ej
	 */
	public ResponderPreguntaAbierta(NuestroPanel anterior, NoodleFrame frame, PreguntaRespuestaAbierta preg, Ejercicio ej) {
		super(anterior, frame);
		
		this.ej = ej;
		this.preg = preg;
		
		this.setBackground(Color.WHITE);
		this.setSize(400,350);
		
		this.setLayout(new BorderLayout());
		
		this.derecha = new ResponderPreguntaMenuDer(frame, this.ej, this.preg, this);
		this.panel = new ResponderPreguntaAbiertaPanel(this.preg);
		
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
