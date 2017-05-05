package interfaz.asignatura.asignaturaGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
	 * Botón para añadir un subtema
	 */
	private JButton subtema = new JButton("Añadir subtema");
	
	/**
	 * Texto para el nombre del subtema
	 */
	private JTextField nombreSubtema = new JTextField(13);
	
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
		
		this.setBackground(Color.WHITE);
		
		SpringLayout spr = new SpringLayout();
		this.setLayout(spr);
		
		Dimension d = new Dimension(150, 30);
		
		this.apuntes.setPreferredSize(d);
		this.borrar.setPreferredSize(d);
		this.nombreSubtema.setPreferredSize(d);
		this.subtema.setPreferredSize(d);
		this.ejercicio.setPreferredSize(d);

		spr.putConstraint(SpringLayout.WEST, this.apuntes, 0, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.WEST, this.borrar, 0, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.WEST, this.subtema, 0, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.WEST, this.nombreSubtema, 0, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.WEST, this.ejercicio, 0, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.SOUTH, this.apuntes, -30, SpringLayout.VERTICAL_CENTER, this);
		spr.putConstraint(SpringLayout.SOUTH, this.subtema, -55, SpringLayout.NORTH, this.apuntes);
		spr.putConstraint(SpringLayout.SOUTH, this.nombreSubtema, -30, SpringLayout.VERTICAL_CENTER, this.subtema);
		spr.putConstraint(SpringLayout.NORTH, this.ejercicio, 30, SpringLayout.VERTICAL_CENTER, this.apuntes);
		spr.putConstraint(SpringLayout.NORTH, this.borrar, 60, SpringLayout.SOUTH, this.ejercicio);
		
		this.add(this.ejercicio);
		this.add(this.apuntes);
		this.add(this.borrar);
		this.add(this.subtema);
		this.add(this.nombreSubtema);
		
		this.borrar.setActionCommand("borrar");
		this.ejercicio.setActionCommand("ejercicio");
		this.apuntes.setActionCommand("apuntes");
		this.subtema.setActionCommand("subtema");
		
		this.list = new AsignaturaMenuDerListener(frame, tema, this, this.asignatura);
		
		this.ejercicio.addActionListener(list);
		this.apuntes.addActionListener(list);
		this.borrar.addActionListener(list);
		this.subtema.addActionListener(list);
		
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
			return;
		}
		this.list.listenerSetTema(tema);
	}
	
	/**
	 * Método que devuelve el nombre del subtema
	 * @return
	 */
	public String getText(){
		return this.nombreSubtema.getText();
	}
}

