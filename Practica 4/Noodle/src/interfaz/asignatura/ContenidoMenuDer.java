package interfaz.asignatura;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import contenido.Contenido;
import interfaz.genericos.NoodleFrame;

/**
 * Clase ContenidoMenuDer
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class ContenidoMenuDer extends JPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Botón de borrar
	 */
	private JButton borrar = new JButton("Borrar");
	
	/**
	 * Botón de editar
	 */
	private JButton editar = new JButton("Editar");
	
	/**
	 * Frame en el que se encuentra
	 */
	private NoodleFrame frame;
	
	/**
	 * Contenido al que ser refiere
	 */
	private Contenido con;
	
	/**
	 * Creador de ContenidoMenuDer
	 * @param frame
	 * @param con
	 */
	public ContenidoMenuDer(NoodleFrame frame, Contenido con){
		this.con = con;
		this.frame = frame;
		
		this.setBackground(Color.WHITE);
		
		SpringLayout spr = new SpringLayout();
		this.setLayout(spr);
		
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.editar, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.NORTH, this.editar, 5, SpringLayout.NORTH, this);
		spr.putConstraint(SpringLayout.NORTH, this.borrar, 10, SpringLayout.SOUTH, this.editar);
		
//		spr.putConstraint(SpringLayout.EAST, this.editar, -5, SpringLayout.EAST, this);
//		spr.putConstraint(SpringLayout.EAST, this.borrar, -5, SpringLayout.EAST, this);
		
		this.add(this.editar);
		this.add(this.borrar);
		
		this.borrar.setActionCommand("borrar");
		this.editar.setActionCommand("editar");
		
		ActionListener list = new ContenidoMenuDerListener(frame, con);
		
		this.editar.addActionListener(list);
		this.borrar.addActionListener(list);
		
		this.setPreferredSize(new Dimension(this.getWidth(), 200));
		
	}
}
