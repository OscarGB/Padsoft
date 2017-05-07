package interfaz.asignatura.contenido.ejercicio.consultarRespuestas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import contenido.Ejercicio;
import contenido.Pregunta;
import contenido.PreguntaRespuestaAbierta;
import contenido.PreguntaRespuestaMultiple;
import contenido.PreguntaRespuestaSimple;
import contenido.PreguntaRespuestaUnica;
import interfaz.asignatura.contenido.ejercicio.genericosPreguntas.PreguntasPanel;
import interfaz.genericos.NoodleFrame;
import persona.Alumno;
import persona.Profesor;
import plataforma.Plataforma;
import respuestas.RespuestaEjercicio;
import respuestas.RespuestaPregunta;

/**
 * Clase RespuestaList
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
class RespuestaList extends MouseAdapter{
	
	// Variables
	
	/**
	 * Panel al que pertenece
	 */
	RespuestasPanel panel;
	
	/**
	 * Pregunta a la que hace referencia
	 */
	Pregunta pregunta;
	
	// Creador
	
	/**
	 * Constructor de RatonList
	 * @param panel
	 * @param pregunta
	 */
	RespuestaList(RespuestasPanel panel, Pregunta pregunta){
		this.panel = panel;
		this.pregunta = pregunta;
	}
	
	// Métodos
	
	 /**
	  * Método por si se pulsa
	  * @param e
	  */
	public void mouseClicked(MouseEvent e) {
		 this.panel.listenerRespuestas(this.pregunta);
	 } 
}

public class RespuestasPanel extends JPanel{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Frame
	 */
	private NoodleFrame frame;
	
	/**
	 * Array de preguntas
	 */
	private ArrayList<Pregunta> preguntas;
	
	/**
	 * Array de labels
	 */
	private ArrayList<JLabel> labels;
	
	/**
	 * Ejercicio
	 */
	private Ejercicio ejercicio;
	
	/**
	 * Alumno
	 */
	private Alumno alumno;
	
	/**
	 * Respuesta respondida
	 */
	private RespuestaEjercicio respuesta;
	
	/**
	 * Constructor de RespuestasPanel
	 * @param frame
	 * @param ejercicio
	 * @param alumno
	 */
	public RespuestasPanel(NoodleFrame frame, RespuestaEjercicio respuesta, Ejercicio ejercicio, Alumno alumno){
		this.frame = frame;
		this.respuesta = respuesta;
		this.ejercicio = ejercicio;
		this.alumno = alumno;
		this.preguntas = ejercicio.getPreguntas();
		this.labels = new ArrayList<JLabel>();
		this.setBackground(Color.WHITE);
		
		SpringLayout spr = new SpringLayout();
		setLayout(spr);
				
		int size = this.preguntas.size();

		if(size == 0){
			JLabel label = new JLabel("No hay preguntas en el ejercicio");
			this.labels.add(label);
			spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
			spr.putConstraint(SpringLayout.VERTICAL_CENTER, label, 0, SpringLayout.VERTICAL_CENTER, this);
		}
		else if(size > 0){
			JLabel label = new JLabel("Pulse sobre una respuesta para visualizarla.");
			labels.add(label);
			label.setFont(new Font("Arial", Font.ITALIC, 15));
			spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
			spr.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);
		
			for(int i = 1, j = 0; j < size; i++, j++){
				label = new JLabel(preguntas.get(j).getEnunciado());
				JLabel previous = labels.get(i-1);
				labels.add(label);
				spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
				spr.putConstraint(SpringLayout.NORTH, label, 50, SpringLayout.NORTH, previous);
				//Añadimos un MouseListener para poder clicar en los labels de las
				//asignaturas
				labels.get(i).addMouseListener(new RespuestaList(this, preguntas.get(j)));
				label.setFont(new Font("Arial", Font.BOLD, 20));
			}
		}
		
		for(JLabel lab:labels){
			this.add(lab);
		}
		
		this.setPreferredSize(new Dimension(300, (labels.get(0).getHeight() + 50)*(size + 1)));
	}
	
	/**
	 * Listener para cuando se clique en una respuesta
	 * @param pregunta
	 */
	public void listenerRespuestas(Pregunta pregunta){
		RespuestaPregunta respuestaPregunta = null;
		for(RespuestaPregunta res: this.respuesta.getRespuestas()){
			if(res.getPregunta().equals(pregunta)){
				respuestaPregunta = res;
			}
		}
		if(pregunta instanceof PreguntaRespuestaUnica){
			frame.showEstPregunta(true, respuestaPregunta, this.ejercicio);
		}
		else if(pregunta instanceof PreguntaRespuestaMultiple){
			frame.showEstPregunta(true, respuestaPregunta, this.ejercicio);

		}
		else if(pregunta instanceof PreguntaRespuestaAbierta){
			frame.showEstPregunta(true, respuestaPregunta, this.ejercicio);

		}
		else if(pregunta instanceof PreguntaRespuestaSimple){
			frame.showEstPregunta(true, respuestaPregunta, this.ejercicio);

		}
	}

}
