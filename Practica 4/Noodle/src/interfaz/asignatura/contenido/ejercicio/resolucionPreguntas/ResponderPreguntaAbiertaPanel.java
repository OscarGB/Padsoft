package interfaz.asignatura.contenido.ejercicio.resolucionPreguntas;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import contenido.PreguntaRespuestaAbierta;
import respuestas.RespuestaAbierta;
import respuestas.RespuestaSimple;

public class ResponderPreguntaAbiertaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5070456134384061574L;
	
	/**
	 * Area para la respuesta
	 */
	private JTextArea respuesta;
	
	/**
	 * Area para el enunciado
	 */
	private JTextArea area;
	
	/**
	 * Layout
	 */
	private SpringLayout spr;
	
	/**
	 * Pregunta
	 */
	private PreguntaRespuestaAbierta p;

	/**
	 * Constructor
	 * @param p, null si se quiere crear la pregunta
	 */
	public ResponderPreguntaAbiertaPanel(PreguntaRespuestaAbierta p){
		
		this.setBackground(Color.WHITE);
		
		this.area = new JTextArea(5,20);
		this.area.setSize(300, 50);
		
		this.respuesta = new JTextArea(5,20);
		this.respuesta.setSize(300, 50);
		this.respuesta.setText("Introduzca su respuesta aqui");
		
		spr = new SpringLayout();
		setLayout(spr);
		
		this.p = p;
		this.area.setText(p.getEnunciado());
		this.area.setEditable(false);
		
	
		this.add(this.area);
		this.add(this.respuesta);
		
		spr.putConstraint(SpringLayout.NORTH, area, 5, SpringLayout.NORTH, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, area, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.NORTH, respuesta, 20, SpringLayout.SOUTH, area);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, respuesta, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
	}
	
	/**
	 * Devuelve la respuesta del alumno
	 * @return
	 */
	public RespuestaAbierta getRespuesta(){
		return new RespuestaAbierta(this.p, this.respuesta.getText());
	}
}
