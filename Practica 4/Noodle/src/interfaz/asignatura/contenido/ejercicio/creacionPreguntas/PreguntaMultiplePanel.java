package interfaz.asignatura.contenido.ejercicio.creacionPreguntas;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import asignatura.Asignatura;
import contenido.Opciones;
import contenido.Pregunta;
import contenido.PreguntaRespuestaMultiple;
import contenido.PreguntaRespuestaUnica;

/**
 * Clase PreguntaMultiplePanel
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class PreguntaMultiplePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5070456134326061574L;
	
	/**
	 * Array de opciones
	 */
	private ArrayList<Opciones> opciones;
	
	/**
	 * Array de radiobuttons
	 */
	private ArrayList<JCheckBox> radios;
	
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
	private PreguntaRespuestaMultiple p;

	/**
	 * Constructor
	 * @param p, null si se quiere crear la pregunta
	 */
	public PreguntaMultiplePanel(PreguntaRespuestaMultiple p){
		
		this.setBackground(Color.WHITE);
		
		this.area = new JTextArea(5,20);
		this.area.setSize(300, 50);
		
		spr = new SpringLayout();
		setLayout(spr);
		
		if(p == null){
			this.p = new PreguntaRespuestaMultiple("", false, 0, 0);
			this.opciones = new ArrayList<Opciones>();
			this.radios = new ArrayList<JCheckBox>();
			this.area.setText("prueba");
		}
		else{
			this.p = p;
			this.area.setText(p.getEnunciado());
			this.radios = new ArrayList<JCheckBox>();
			this.opciones = (ArrayList<Opciones>) this.p.getOpciones().clone();
			for(Opciones op : this.opciones){
				JCheckBox aux = new JCheckBox(op.getRespuesta());
				if(op.esCorrecta() == true){
					aux.setSelected(true);
				}
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
	public PreguntaRespuestaMultiple getPregunta(){
		boolean flag = false;
		for(int i = 0; i < radios.size(); i++){
			if(radios.get(i).isSelected()){
				this.opciones.get(i).setCorrecta(true);
				flag = true;
			}
			else{
				this.opciones.get(i).setCorrecta(false);
			}
		}		
		if(flag == false){
			return null;
		}
		
		for(Iterator<Opciones> iter = this.p.getOpciones().iterator(); iter.hasNext();){
			iter.next();
			iter.remove();
		}
		
		for(Opciones op : this.opciones){
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
		opciones.add(new Opciones(s,false));
		JCheckBox aux = new JCheckBox(s);
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
