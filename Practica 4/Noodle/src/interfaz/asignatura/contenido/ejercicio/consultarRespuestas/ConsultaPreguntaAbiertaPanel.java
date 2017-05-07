package interfaz.asignatura.contenido.ejercicio.consultarRespuestas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import contenido.Opciones;
import contenido.PreguntaRespuestaAbierta;
import contenido.PreguntaRespuestaUnica;
import respuestas.RespuestaAbierta;
import respuestas.RespuestaUnica;

public class ConsultaPreguntaAbiertaPanel extends ConsultaPregunta{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Respuesta
	 */
	private RespuestaAbierta respuesta;
	
	/**
	 * Pregunta
	 */
	private PreguntaRespuestaAbierta pregunta;
	
	/**
	 * Spring Layout
	 */
	private SpringLayout spr;
	
	/**
	 * Array de respuestas admitidas
	 */
	private ArrayList<String> correctas;
	
	/**
	 * Array de labels
	 */
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	
	/**
	 * Respuesta dada por el alumno
	 */
	private String respondida;
	
	/**
	 * Constructor
	 * @param respuesta
	 */
	public ConsultaPreguntaAbiertaPanel(RespuestaAbierta respuesta){
		this.respuesta = respuesta;
		this.pregunta = (PreguntaRespuestaAbierta) this.respuesta.getPregunta();
		
		this.setBackground(Color.WHITE);
		
		
		spr = new SpringLayout();
		setLayout(spr);
	
		this.correctas = this.pregunta.getRespuestas();
		this.respondida = this.respuesta.getRespondido();
		
		for(String resp: this.correctas){
			JLabel label = new JLabel(resp);
			this.labels.add(label);
			if(labels.indexOf(label) == 0){
				spr.putConstraint(SpringLayout.NORTH, label, 5, SpringLayout.NORTH, this);
			}else {
				spr.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.SOUTH, this.labels.get(this.labels.indexOf(label) - 1));
			}
			spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);
			if(this.respondida.equals(resp)){
				label.setForeground(Color.GREEN);
			}
			this.add(label);
		}
		JLabel label = new JLabel("Respuesta: " + this.respondida);
		if(this.respuesta.esCorrecta() == false){
			label.setForeground(Color.red);
		} else {
			label.setForeground(Color.green);
		}
		this.labels.add(label);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.NORTH, label, 30, SpringLayout.SOUTH, this.labels.get(this.labels.indexOf(label) - 1));
		this.add(label);
		
		this.setPreferredSize(new Dimension(500, (this.respuesta.getPregunta().getNumRespuestas() + 1)*(label.getHeight() + 10)));
	}
}
