package interfaz.asignatura.contenido.ejercicio.creacionPreguntas;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import asignatura.Asignatura;
import contenido.Opciones;
import contenido.Pregunta;
import contenido.PreguntaRespuestaSimple;
import contenido.PreguntaRespuestaUnica;

/**
 * Clase PreguntaUniaPanel
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class PreguntaSimplePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5070456134326061574L;
	
	/**
	 * Array de opciones
	 */
	private ArrayList<Opciones> opciones;
	
	/**
	 * radiobuttons
	 */
	private JRadioButton verdadero;
	private JRadioButton falso;
	
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
	 * Pregunta
	 */
	private PreguntaRespuestaSimple p;

	/**
	 * Constructor
	 * @param p, null si se quiere crear la pregunta
	 */
	public PreguntaSimplePanel(PreguntaRespuestaSimple p){
		
		this.setBackground(Color.WHITE);
		
		this.area = new JTextArea(5,20);
		this.area.setSize(300, 50);
		
		grupo = new ButtonGroup();
		verdadero = new JRadioButton("Veradero");
		grupo.add(verdadero);
		this.add(verdadero);
		falso = new JRadioButton("Falso");
		grupo.add(falso);
		this.add(falso);
		spr = new SpringLayout();
		setLayout(spr);
		
		if(p == null){
			this.p = new PreguntaRespuestaSimple("", false, 0, 0, false);
			this.opciones = new ArrayList<Opciones>();
			this.area.setText("prueba");
		}
		else{
			this.p = p;
			this.area.setText(p.getEnunciado());
			if(this.p.getRespuesta() == true){
				verdadero.setSelected(true);
			}
			else{
				falso.setSelected(true);
			}
		}
	
		this.add(this.area);
		
		spr.putConstraint(SpringLayout.NORTH, area, 5, SpringLayout.NORTH, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, area, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.WEST, verdadero, 10, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.WEST, falso, 10, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.NORTH, verdadero, 20, SpringLayout.SOUTH, area);
		spr.putConstraint(SpringLayout.NORTH, falso, 20, SpringLayout.SOUTH, verdadero);
		
		this.setPreferredSize(new Dimension(500, area.getHeight() + 50 + verdadero.getHeight()));
		
	}
	
	/**
	 * Método que devuelve el enunciado
	 * @return
	 */
	public String getEnunciado(){
		return area.getText();
	}
	
	/**
	 * Método que devuelve la Pregunta
	 * @return
	 */
	public PreguntaRespuestaSimple getPregunta(){
		
		if(verdadero.isSelected()){
			this.p.setRespuesta(true);
		}
		else if(falso.isSelected()){
			this.p.setRespuesta(false);
		}
		else{
			return null;
		}
		this.p.setEnunciado(this.getEnunciado());
		return this.p;
	}
}
