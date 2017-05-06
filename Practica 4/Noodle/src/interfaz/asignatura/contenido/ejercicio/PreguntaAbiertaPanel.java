package interfaz.asignatura.contenido.ejercicio;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import asignatura.Asignatura;
import contenido.Opciones;
import contenido.Pregunta;
import contenido.PreguntaRespuestaAbierta;
import contenido.PreguntaRespuestaUnica;

/**
 * Clase PreguntaUniaPanel
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class PreguntaAbiertaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5070456134326061574L;
	
	/**
	 * Array de opciones
	 */
	private ArrayList<String> opciones;
	
	/**
	 * Array de radiobuttons
	 */
	private ArrayList<JLabel> radios;
	
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
	public PreguntaAbiertaPanel(PreguntaRespuestaAbierta p){
		
		this.setBackground(Color.WHITE);
		
		this.area = new JTextArea(5,20);
		this.area.setSize(300, 50);
		
		spr = new SpringLayout();
		setLayout(spr);
		
		if(p == null){
			this.p = new PreguntaRespuestaAbierta("", false, 0, 0);
			this.opciones = new ArrayList<String>();
			this.radios = new ArrayList<JLabel>();
			this.area.setText("prueba");
		}
		else{
			this.p = p;
			this.area.setText(p.getEnunciado());
			this.radios = new ArrayList<JLabel>();
			this.opciones = (ArrayList<String>) this.p.getRespuestas().clone();
			for(String op : this.opciones){
				JLabel aux = new JLabel(op);
				radios.add(aux);
				this.add(aux);
				
				spr.putConstraint(SpringLayout.WEST, aux, 10, SpringLayout.WEST, this);
				
				if(radios.size() == 1){
					spr.putConstraint(SpringLayout.NORTH, aux, 20, SpringLayout.SOUTH, area);
				}else{
					spr.putConstraint(SpringLayout.NORTH, aux, 20, SpringLayout.SOUTH, radios.get(radios.indexOf(aux) - 1));
				}
			}
		}
	
		this.add(this.area);
		
		spr.putConstraint(SpringLayout.NORTH, area, 5, SpringLayout.NORTH, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, area, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		this.setPreferredSize(new Dimension(500, area.getHeight() + 10 + (radios.size()>0?((radios.get(0).getHeight()+20)*radios.size()):0)));
		
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
	public PreguntaRespuestaAbierta getPregunta(){
		if(radios.size() == 0){
			return null;
		}
		
		for(Iterator<String> iter = this.p.getRespuestas().iterator(); iter.hasNext();){
			iter.next();
			iter.remove();
		}
		
		for(String op : this.opciones){
			this.p.addOpcion(op);
		}
		this.p.setEnunciado(this.getEnunciado());
		return this.p;
	}
	
	/**
	 * Método para añadir una respuesta
	 * @param s
	 */
	public void addOpcion(String s){
		opciones.add(s);
		JLabel aux = new JLabel(s);
		radios.add(aux);
		this.add(aux);
		
		spr.putConstraint(SpringLayout.WEST, aux, 10, SpringLayout.WEST, this);
		
		if(radios.size() == 1){
			spr.putConstraint(SpringLayout.NORTH, aux, 20, SpringLayout.SOUTH, area);
		}else{
			spr.putConstraint(SpringLayout.NORTH, aux, 20, SpringLayout.SOUTH, radios.get(radios.indexOf(aux) - 1));
		}
		
		this.setPreferredSize(new Dimension(500, area.getHeight() + 10 + (radios.size()>0?((radios.get(0).getHeight()+20)*radios.size()):0)));
		this.revalidate();
		this.repaint();
	}
	
}
