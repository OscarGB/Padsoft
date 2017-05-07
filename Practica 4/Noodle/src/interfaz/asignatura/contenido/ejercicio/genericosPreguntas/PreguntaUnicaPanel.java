package interfaz.asignatura.contenido.ejercicio.genericosPreguntas;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import contenido.Opciones;
import contenido.PreguntaRespuestaUnica;
import persona.Alumno;
import plataforma.Plataforma;
import respuestas.RespuestaUnica;

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
		
		boolean flag = (Plataforma.loggedAs() instanceof Alumno);
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
			this.area.setText("Introduzca aqu� el enunciado");
		}
		else{
			this.p = p;
			this.area.setText(p.getEnunciado());
			this.radios = new ArrayList<JRadioButton>();
			this.opciones = (ArrayList<Opciones>) this.p.getOpciones().clone();
			if(flag == true && this.p.getAleatorio() == true){
				Collections.shuffle(this.opciones);
			}
			for(Opciones op : this.opciones){
				JRadioButton aux = new JRadioButton(op.getRespuesta());
				if(flag == false){
					if(op.esCorrecta() == true){
						aux.setSelected(true);
					}
				}
				radios.add(aux);
				grupo.add(aux);
				this.add(aux);
				
				spr.putConstraint(SpringLayout.WEST, aux, 10, SpringLayout.WEST, this);
				
				if(radios.size() == 1){
					spr.putConstraint(SpringLayout.NORTH, aux, 20, SpringLayout.SOUTH, area);
				}else{
					spr.putConstraint(SpringLayout.NORTH, aux, 20, SpringLayout.SOUTH, radios.get(radios.indexOf(aux) - 1));
				}
			}
		}
		if(flag == true){
			this.area.setEditable(false);
		}
		this.add(this.area);
		
		spr.putConstraint(SpringLayout.NORTH, area, 5, SpringLayout.NORTH, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, area, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		this.setPreferredSize(new Dimension(500, area.getHeight() + 10 + (radios.size()>0?((radios.get(0).getHeight()+20)*radios.size()):0)));
		
	}
	
	/**
	 * M�todo que devuelve el enunciado
	 * @return
	 */
	public String getEnunciado(){
		return area.getText();
	}
	
	/**
	 * M�todo que devuelve la Pregunta
	 * @return
	 */
	public PreguntaRespuestaUnica getPregunta(){	
		int aux = -1;
		for(JRadioButton but: radios){
			if(but.isSelected()){
				aux = radios.indexOf(but);
				break;
			}
		}
		
		if(aux < 0){
			return null;
		}
		
		for(Iterator<Opciones> iter = this.p.getOpciones().iterator(); iter.hasNext();){
			iter.next();
			iter.remove();
		}
		
		for(Opciones op : this.opciones){
			this.p.addOpcion(op);
			op.setCorrecta(false);
		}
		this.p.getOpciones().get(aux).setCorrecta(true);
		this.p.setEnunciado(this.getEnunciado());
		return this.p;
	}
	
	/**
	 * M�todo para a�adir una respuesta
	 * @param s
	 */
	public void addOpcion(String s){
		opciones.add(new Opciones(s,false));
		JRadioButton aux = new JRadioButton(s);
		radios.add(aux);
		grupo.add(aux);
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
	
	/**
	 * Devuelve la respuesta del alumno
	 * @return
	 */
	public RespuestaUnica getRespuesta(){
		int aux = -1;
		for(JRadioButton but: radios){
			if(but.isSelected()){
				aux = radios.indexOf(but);
				break;
			}
		}
		
		if(aux < 0){
			return null;
		}
		return new RespuestaUnica(this.p, this.p.getOpciones().get(aux));
	}
	
}
