package interfaz.asignatura.contenido.ejercicio;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;

import contenido.Ejercicio;
import contenido.Pregunta;
import interfaz.genericos.NoodleFrame;

/**
 * Clase PreguntaMenuDer
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class PreguntaMenuDer extends JPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1619308189668563054L;
	
	/**
	 * Label "peso"
	 */
	private JLabel peso = new JLabel("Peso acierto");
	
	/**
	 * Spinner para el peso
	 */
	private JSpinner pesoSpinner;
	
	/**
	 * Label "peso fallo"
	 */
	private JLabel pesoFallo = new JLabel("Peso fallo");
	
	/**
	 * Spinner para el peso del fallo
	 */
	private JSpinner pesoFalloSpinner;
	
	/**
	 * Botón para borrar
	 */
	private JButton borrar = new JButton("Borrar pregunta");
	
	/**
	 * Botón para guardar
	 */
	private JButton guardar = new JButton("Guardar");
	
	/**
	 * Botón para cancelar
	 */
	private JButton cancelar = new JButton("Cancelar");
	
	/**
	 * Ejercicio en el que se va a guardar
	 */
	private Ejercicio ej;
	
	/**
	 * Frame global
	 */
	private NoodleFrame frame;
	
	/**
	 * Pregunta
	 */
	private Pregunta p;
	
	/**
	 * Constructor
	 * @param frame
	 * @param ej
	 * @param p, null si se quiere crear una nueva
	 */
	public PreguntaMenuDer(NoodleFrame frame, Ejercicio ej, Pregunta p){
		this.ej = ej;
		this.p = p;
		this.frame = frame;
		
		this.setBackground(Color.WHITE);
		
		SpringLayout spr = new SpringLayout();
		this.setLayout(spr);
		
		int actualPeso = 1;
		int actualPesoFallo = 0;
		
		if(p != null){
			actualPeso = (int)p.getValorPregunta();
			actualPesoFallo = (int)p.getPenalizacion();
		}
	
		this.pesoSpinner = new JSpinner(new SpinnerNumberModel(actualPeso,0,10,1));
		this.pesoFalloSpinner = new JSpinner(new SpinnerNumberModel(actualPesoFallo,0,10,1));
		
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.borrar, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.cancelar, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.guardar, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.EAST, this.peso, -10, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.EAST, this.pesoFallo, -10, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.WEST, this.pesoSpinner, 10, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.WEST, this.pesoFalloSpinner, 10, SpringLayout.HORIZONTAL_CENTER, this);
		
		spr.putConstraint(SpringLayout.NORTH, this.borrar, 15, SpringLayout.VERTICAL_CENTER, this);
		spr.putConstraint(SpringLayout.SOUTH, this.pesoFallo, -15, SpringLayout.VERTICAL_CENTER, this);
		spr.putConstraint(SpringLayout.SOUTH, this.pesoFalloSpinner, -15, SpringLayout.VERTICAL_CENTER, this);
		spr.putConstraint(SpringLayout.SOUTH, this.peso, -30, SpringLayout.NORTH, this.pesoFallo);
		spr.putConstraint(SpringLayout.SOUTH, this.pesoSpinner, -30, SpringLayout.NORTH, this.pesoFalloSpinner);
		spr.putConstraint(SpringLayout.NORTH, this.guardar, 30, SpringLayout.SOUTH, this.borrar);
		spr.putConstraint(SpringLayout.NORTH, this.cancelar, 30, SpringLayout.SOUTH, this.guardar);
		
		this.add(this.peso);
		this.add(this.pesoSpinner);
		this.add(this.pesoFallo);
		this.add(this.pesoFalloSpinner);
		this.add(this.borrar);
		this.add(this.guardar);
		this.add(this.cancelar);
		
		PreguntaMenuDerListener list = new PreguntaMenuDerListener(this.frame, this.ej, this.p);
		
		this.borrar.addActionListener(list);
		this.guardar.addActionListener(list);
		this.cancelar.addActionListener(list);
		
		this.borrar.setActionCommand("borrar");
		this.guardar.setActionCommand("guardar");
		this.cancelar.setActionCommand("cancelar");
		
		this.setPreferredSize(new Dimension(250,400));
		this.repaint();
		
		
	}
	
}
