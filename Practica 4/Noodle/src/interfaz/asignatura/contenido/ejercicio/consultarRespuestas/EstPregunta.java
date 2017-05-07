package interfaz.asignatura.contenido.ejercicio.consultarRespuestas;

import java.awt.BorderLayout;
import java.awt.Color;

import contenido.Ejercicio;
import contenido.Pregunta;
import interfaz.asignatura.contenido.ejercicio.genericosPreguntas.PreguntaUnicaPanel;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;
import respuestas.RespuestaPregunta;

public class EstPregunta extends NuestroPanel{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Respuesta
	 */
	private RespuestaPregunta respuesta;
	
	/**
	 * Pregunta
	 */
	private Pregunta pregunta;
	
	/**
	 * Ejercicio
	 */
	private Ejercicio ejercicio;
	
	/**
	 * Panel
	 */
	private ConsultaPreguntaUnicaPanel panel;

	/**
	 * Constructor de EstPreguntaUnica
	 * @param anterior
	 * @param frame
	 * @param respuesta
	 * @param ejercicio
	 */
	public EstPregunta(NuestroPanel anterior, NoodleFrame frame, RespuestaPregunta respuesta, Ejercicio ejercicio) {
		super(anterior, frame);
		this.ejercicio = ejercicio;
		this.respuesta = respuesta;
		
		this.setBackground(Color.WHITE);
		this.setSize(400,350);
		
		this.setLayout(new BorderLayout());
		
		this.panel = new ConsultaPreguntaUnicaPanel(this.respuesta);
		
		this.add(this.panel, BorderLayout.CENTER);
		
	}

}
