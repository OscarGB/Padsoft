package interfaz.asignatura.contenido.ejercicio.resolucionPreguntas;

import java.awt.BorderLayout;
import java.awt.Color;

import contenido.Ejercicio;
import contenido.PreguntaRespuestaSimple;
import interfaz.asignatura.contenido.ejercicio.genericosPreguntas.PreguntaSimplePanel;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;
import respuestas.RespuestaPregunta;
import respuestas.RespuestaSimple;

public class ResponderPreguntaSimple extends ResponderPregunta {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Pregunta que se está resolviendo
	 */
	private PreguntaRespuestaSimple preg;
	
	/**
	 * Panel derecho
	 */
	private ResponderPreguntaMenuDer derecha;
	
	/**
	 * Panel
	 */
	private PreguntaSimplePanel panel;
	
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
	public ResponderPreguntaSimple(NuestroPanel anterior, NoodleFrame frame, PreguntaRespuestaSimple preg, Ejercicio ej) {
		super(anterior, frame);
		
		this.ej = ej;
		this.preg = preg;
		
		this.setBackground(Color.WHITE);
		this.setSize(400,350);
		
		this.setLayout(new BorderLayout());
		
		this.derecha = new ResponderPreguntaMenuDer(frame, this.ej, this.preg, this);
		this.panel = new PreguntaSimplePanel(this.preg);
		
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
