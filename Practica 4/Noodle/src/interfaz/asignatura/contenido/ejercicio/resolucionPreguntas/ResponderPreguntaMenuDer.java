package interfaz.asignatura.contenido.ejercicio.resolucionPreguntas;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import contenido.Ejercicio;
import contenido.Pregunta;
import interfaz.genericos.NoodleFrame;

public class ResponderPreguntaMenuDer extends JPanel {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Boton de guardar
	 */
	private JButton guardar = new JButton("Guardar");
	
	/**
	 * Boton de cancelar
	 */
	private JButton cancelar = new JButton("Cancelar");

	/**
	 * Ejercicio
	 */
	private Ejercicio ejercicio;
	
	/**
	 * Pregunta
	 */
	private Pregunta pregunta;
	
	/**
	 * Frame
	 */
	private NoodleFrame frame;
	
	/**
	 * Listener
	 */
	private ResponderPreguntaMenuDerListener list;
	
	/**
	 * Panel en el que se encuentra
	 */
	private ResponderPregunta panel;
	
	/**
	 * Constructor
	 * @param frame
	 * @param ejercicio
	 * @param tema
	 */
	public ResponderPreguntaMenuDer(NoodleFrame frame, Ejercicio ejercicio, Pregunta pregunta, ResponderPregunta panel){
		this.ejercicio = ejercicio;
		this.frame = frame;
		this.pregunta = pregunta;
		this.panel = panel;
				
		this.setBackground(Color.WHITE);
		
		SpringLayout spr = new SpringLayout();
		this.setLayout(spr);
		
		this.guardar.setPreferredSize(new Dimension(100, 30));
		this.cancelar.setPreferredSize(new Dimension(100, 30));
		
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.guardar, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.cancelar, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		spr.putConstraint(SpringLayout.SOUTH, this.guardar, -30, SpringLayout.NORTH, this.cancelar);
		spr.putConstraint(SpringLayout.SOUTH, this.cancelar, -30, SpringLayout.SOUTH, this);

		this.add(this.guardar);
		this.add(this.cancelar);
		
		this.guardar.setActionCommand("guardar");
		this.cancelar.setActionCommand("cancelar");
		
		this.list = new ResponderPreguntaMenuDerListener(this.frame, this.ejercicio, this, this.pregunta, panel);
		;
		this.guardar.addActionListener(list);
		this.cancelar.addActionListener(list);
		
		this.setPreferredSize(new Dimension(250, 400));
		this.repaint();
	}
	
}
