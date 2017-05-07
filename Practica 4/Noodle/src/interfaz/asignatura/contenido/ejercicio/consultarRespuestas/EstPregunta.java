package interfaz.asignatura.contenido.ejercicio.consultarRespuestas;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;

import contenido.Ejercicio;
import contenido.Pregunta;
import interfaz.asignatura.contenido.ejercicio.genericosPreguntas.PreguntaUnicaPanel;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;
import respuestas.RespuestaMultiple;
import respuestas.RespuestaPregunta;
import respuestas.RespuestaUnica;

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
	private ConsultaPregunta panel;
	
	/**
	 * Scrolling pane
	 */
	private JScrollPane scroll;

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
		
		if(this.respuesta instanceof RespuestaUnica){
			this.panel = new ConsultaPreguntaUnicaPanel((RespuestaUnica)this.respuesta);
		}
		else if(this.respuesta instanceof RespuestaMultiple){
			this.panel = new ConsultaPreguntaMultiplePanel((RespuestaMultiple)this.respuesta);
		}
		
		this.scroll = new JScrollPane(this.panel);
		
		
		this.add(this.scroll, BorderLayout.CENTER);
		
	}

}
