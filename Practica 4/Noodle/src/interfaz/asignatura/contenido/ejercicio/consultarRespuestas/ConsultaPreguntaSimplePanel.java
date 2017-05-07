package interfaz.asignatura.contenido.ejercicio.consultarRespuestas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import contenido.Opciones;
import contenido.PreguntaRespuestaSimple;
import contenido.PreguntaRespuestaUnica;
import respuestas.RespuestaSimple;
import respuestas.RespuestaUnica;

public class ConsultaPreguntaSimplePanel extends ConsultaPregunta {

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
	private RespuestaSimple respuesta;
	
	/**
	 * Pregunta
	 */
	private PreguntaRespuestaSimple pregunta;
	
	/**
	 * Constructor
	 * @param respuesta
	 */
	public ConsultaPreguntaSimplePanel(RespuestaSimple respuesta){
		this.respuesta = respuesta;
		this.pregunta = (PreguntaRespuestaSimple) this.respuesta.getPregunta();
		
		this.setBackground(Color.WHITE);
		
		this.area = new JTextArea(5,20);
		this.area.setSize(300, 50);
		
		grupo = new ButtonGroup();
		spr = new SpringLayout();
		setLayout(spr);
	
		this.area.setText(pregunta.getEnunciado());
		this.radios = new ArrayList<JRadioButton>();
		
		JRadioButton aux = new JRadioButton("Verdadero");
		if(this.pregunta.getRespuesta() == true){
			aux.setBackground(Color.GREEN);
		}
		if(this.respuesta.getRespondido() == true){
			aux.setSelected(true);
			if(this.pregunta.getRespuesta() == false){
				aux.setBackground(Color.RED);
			}
		}
		
		aux.setEnabled(false);
		radios.add(aux);
		grupo.add(aux);
		this.add(aux);
		
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, aux, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		if(radios.size() == 1){
			spr.putConstraint(SpringLayout.NORTH, aux, 20, SpringLayout.SOUTH, area);
		}else{
			spr.putConstraint(SpringLayout.NORTH, aux, 20, SpringLayout.SOUTH, radios.get(radios.indexOf(aux) - 1));
		}
		
		aux = new JRadioButton("False");
		if(this.pregunta.getRespuesta() == false){
			aux.setBackground(Color.GREEN);
		}
		if(this.respuesta.getRespondido() == false){
			aux.setSelected(true);
			if(this.pregunta.getRespuesta() == true){
				aux.setBackground(Color.RED);
			}
		}
		
		aux.setEnabled(false);
		radios.add(aux);
		grupo.add(aux);
		this.add(aux);
		
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, aux, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		if(radios.size() == 1){
			spr.putConstraint(SpringLayout.NORTH, aux, 20, SpringLayout.SOUTH, area);
		}else{
			spr.putConstraint(SpringLayout.NORTH, aux, 20, SpringLayout.SOUTH, radios.get(radios.indexOf(aux) - 1));
		}
		
		
		this.area.setEditable(false);
		
		this.add(this.area);
		
		this.area.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		
		spr.putConstraint(SpringLayout.NORTH, area, 5, SpringLayout.NORTH, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, area, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		this.setPreferredSize(new Dimension(500, area.getHeight() + 10 + (radios.size()>0?((radios.get(0).getHeight()+20)*radios.size()):0)));
		
	}

}
