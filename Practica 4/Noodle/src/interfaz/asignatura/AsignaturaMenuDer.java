package interfaz.asignatura;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import asignatura.Asignatura;
import contenido.Contenido;
import contenido.Tema;
import interfaz.genericos.NoodleFrame;

/**
 * Clase ContenidoMenuDer
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class AsignaturaMenuDer extends JPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Botón de borrar
	 */
	private JButton borrar = new JButton("Borrar tema");
	
	/**
	 * Botón de editar
	 */
	private JButton apuntes = new JButton("Añadir apuntes");
	
	/**
	 * Botón de editar
	 */
	private JButton ejercicio = new JButton("Añadir ejercicio");
	
	/**
	 * Frame en el que se encuentra
	 */
	private NoodleFrame frame;
	
	/**
	 * Asignatura a la que ser refiere
	 */
	private Asignatura asignatura;
	
	/**
	 * Tema
	 */
	private Tema tema;
	
	/**
	 * Listener
	 */
	private AsignaturaMenuDerListener list;
	
	/**
	 * Creador de ContenidoMenuDer
	 * @param frame
	 * @param con
	 */
	public AsignaturaMenuDer(NoodleFrame frame, Asignatura asignatura, Tema tema){
		this.asignatura = asignatura;
		this.frame = frame;
		this.tema = tema;
		
		if(tema == null){
			System.out.println("NULLLL");
		}
		
		this.setBackground(Color.WHITE);
		
		SpringLayout spr = new SpringLayout();
		this.setLayout(spr);
		
		this.apuntes.setPreferredSize(new Dimension(150, 30));
		this.borrar.setPreferredSize(new Dimension(150, 30));
		this.ejercicio.setPreferredSize(new Dimension(150, 30));

		spr.putConstraint(SpringLayout.WEST, this.apuntes, 0, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.WEST, this.borrar, 0, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.WEST, this.ejercicio, 0, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.SOUTH, this.apuntes, -30, SpringLayout.VERTICAL_CENTER, this);
		spr.putConstraint(SpringLayout.NORTH, this.ejercicio, 30, SpringLayout.VERTICAL_CENTER, this.apuntes);
		spr.putConstraint(SpringLayout.NORTH, this.borrar, 60, SpringLayout.SOUTH, this.ejercicio);

		
//		spr.putConstraint(SpringLayout.EAST, this.editar, -5, SpringLayout.EAST, this);
//		spr.putConstraint(SpringLayout.EAST, this.borrar, -5, SpringLayout.EAST, this);
		
		this.add(this.ejercicio);
		this.add(this.apuntes);
		this.add(this.borrar);
		
		this.borrar.setActionCommand("borrar");
		this.ejercicio.setActionCommand("ejercicio");
		this.apuntes.setActionCommand("apuntes");
		
		this.list = new AsignaturaMenuDerListener(frame, tema);
		
		this.ejercicio.addActionListener(list);
		this.apuntes.addActionListener(list);
		this.borrar.addActionListener(list);
		
		this.setPreferredSize(new Dimension(200, 250));
	}
	
	/**
	 * Setter de tema
	 * @param tema
	 */
	public void setTema(Tema tema){
		this.tema = tema;
		if(tema == null){
			System.out.println("ASDFASDF");
		}
		this.list.listenerSetTema(tema);
	}
}

