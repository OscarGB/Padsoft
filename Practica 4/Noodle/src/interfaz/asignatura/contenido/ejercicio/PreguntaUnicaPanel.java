package interfaz.asignatura.contenido.ejercicio;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import contenido.Opciones;
import contenido.Pregunta;
import contenido.PreguntaRespuestaUnica;

/**
 * Clase PreguntaUniaPanel
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class PreguntaUnicaPanel extends JPanel {

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
	 * Pregunta
	 */
	private PreguntaRespuestaUnica p;

	/**
	 * Constructor
	 * @param p, null si se quiere crear la pregunta
	 */
	public PreguntaUnicaPanel(PreguntaRespuestaUnica p){
		
		this.setBackground(Color.WHITE);
		
		this.area = new JTextArea(5,20);
		this.area.setSize(300, 50);
		
		grupo = new ButtonGroup();
		spr = new SpringLayout();
		setLayout(spr);
		
		if(p == null){
			this.p = new PreguntaRespuestaUnica("", false, 0, 0);
			this.opciones = new ArrayList<Opciones>();
			this.radios = new ArrayList<JRadioButton>();
			this.area.setText("prueba");
		}
		else{
			this.p = p;
			this.area.setText(p.getEnunciado());
			for(Opciones op : this.p.getOpciones()){
				JRadioButton aux = new JRadioButton(op.getRespuesta());
				radios.add(aux);
				grupo.add(aux);
				this.add(aux);
				
				spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, aux, 0, SpringLayout.HORIZONTAL_CENTER, this);
				
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
	public PreguntaRespuestaUnica getPregunta(){
		int aux = radios.indexOf(grupo.getSelection());
		for(Opciones op : this.p.getOpciones()){
			this.p.removeOpcion(op);
		}
		for(Opciones op : this.opciones){
			this.p.addOpcion(op);
			op.setCorrecta(false);
		}
//		this.p.getOpciones().get(aux).setCorrecta(true);
		return this.p;
	}
	
	/**
	 * Método para añadir una respuesta
	 * @param s
	 */
	public void addOpcion(String s){
		opciones.add(new Opciones(s,false));
		JRadioButton aux = new JRadioButton(s);
		radios.add(aux);
		grupo.add(aux);
		this.add(aux);
		
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, aux, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
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
