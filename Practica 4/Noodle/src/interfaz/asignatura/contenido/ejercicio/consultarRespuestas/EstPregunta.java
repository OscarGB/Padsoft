package interfaz.asignatura.contenido.ejercicio.consultarRespuestas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;

import contenido.Ejercicio;
import contenido.Pregunta;
import interfaz.asignatura.contenido.ejercicio.genericosPreguntas.PreguntaUnicaPanel;
import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;
import respuestas.RespuestaAbierta;
import respuestas.RespuestaMultiple;
import respuestas.RespuestaPregunta;
import respuestas.RespuestaSimple;
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
	 * Menu
	 */
	private Menu menu;

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
		this.menu = new Menu(frame);
		
		this.setBackground(Color.WHITE);
		this.setSize(700,500);
		
		this.setLayout(new BorderLayout());
		
		if(this.respuesta instanceof RespuestaUnica){
			this.panel = new ConsultaPreguntaUnicaPanel((RespuestaUnica)this.respuesta);
		}
		else if(this.respuesta instanceof RespuestaMultiple){
			this.panel = new ConsultaPreguntaMultiplePanel((RespuestaMultiple)this.respuesta);
		}
		else if(this.respuesta instanceof RespuestaAbierta){
			this.panel = new ConsultaPreguntaAbiertaPanel((RespuestaAbierta)this.respuesta);
		}
		else if(this.respuesta instanceof RespuestaSimple){
			this.panel = new ConsultaPreguntaSimplePanel((RespuestaSimple)this.respuesta);
		}
		
		this.scroll = new JScrollPane(this.panel);
		
		this.add(this.scroll, BorderLayout.CENTER);
		this.add(this.menu, BorderLayout.NORTH);
		
		int w = this.getWidth();
		
		this.menu.setPreferredSize(new Dimension(w, 80));
		
	}

}
