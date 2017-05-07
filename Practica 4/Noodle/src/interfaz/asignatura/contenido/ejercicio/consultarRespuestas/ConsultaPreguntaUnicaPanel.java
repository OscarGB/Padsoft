package interfaz.asignatura.contenido.ejercicio.consultarRespuestas;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import contenido.Opciones;
import contenido.Pregunta;
import contenido.PreguntaRespuestaUnica;
import respuestas.RespuestaPregunta;
import respuestas.RespuestaUnica;

public class ConsultaPreguntaUnicaPanel extends JPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Array de opciones
	 */
	private ArrayList<Opciones> opciones;
	
	/**
	 * Array de radiobuttons
	 */
	private ArrayList<JRadioButton> radios;
	
	/**
	 * Grupo de Radiobuttons
	 */
	private ButtonGroup grupo;
	
	/**
	 * Area para el enunciado
	 */
	private JTextArea area;
	
	/**
	 * Layout
	 */
	private SpringLayout spr;
	
	/**
	 * Respuesta
	 */
	private RespuestaUnica respuesta;
	
	/**
	 * Pregunta
	 */
	private PreguntaRespuestaUnica pregunta;
	
	/**
	 * Constructor
	 * @param respuesta
	 */
	public ConsultaPreguntaUnicaPanel(RespuestaUnica respuesta){
		this.respuesta = respuesta;
		this.pregunta = (PreguntaRespuestaUnica) this.respuesta.getPregunta();
		
		this.setBackground(Color.WHITE);
		
		this.area = new JTextArea(5,20);
		this.area.setSize(300, 50);
		
		grupo = new ButtonGroup();
		spr = new SpringLayout();
		setLayout(spr);
		
		this.pregunta = pregunta;
		this.area.setText(pregunta.getEnunciado());
		this.radios = new ArrayList<JRadioButton>();
		this.opciones = (ArrayList<Opciones>) this.p.getOpciones().clone();
		
	}

}
