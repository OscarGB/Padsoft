package interfaz.asignatura.contenido.ejercicio.resolucionEjercicio;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import contenido.Ejercicio;
import contenido.Tema;
import interfaz.genericos.NoodleFrame;

/**
 * Clase ResolverEjercicioMenuDer
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class ResolverEjercicioMenuDer extends JPanel {
	
	//Variables
	
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
	 * Tema
	 */
	private Tema tema;
	
	/**
	 * Frame
	 */
	private NoodleFrame frame;
	
	/**
	 * Listener
	 */
	private ResolverEjercicioMenuDerListener list;
	
	//Constructor
	
	/**
	 * Constructor
	 * @param frame
	 * @param ejercicio
	 * @param tema
	 */
	public ResolverEjercicioMenuDer(NoodleFrame frame, Ejercicio ejercicio, Tema tema){
		this.ejercicio = ejercicio;
		this.frame = frame;
		this.tema = tema;
				
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
		
		this.list = new ResolverEjercicioMenuDerListener(this.frame, this.ejercicio, this, this.tema);
		;
		this.guardar.addActionListener(list);
		this.cancelar.addActionListener(list);
		
		this.setPreferredSize(new Dimension(250, 400));
		this.repaint();
	}
	
}
