package interfaz.asignatura;

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
public class AsignaturaMenuIzq extends JPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Botón de borrar
	 */
	private JButton borrar = new JButton("Borrar asignatura");
	
	/**
	 * Botón de editar
	 */
	private JButton tema = new JButton("Añadir tema");
	
	/**
	 * Boton de alumnos
	 */
	private JButton alumnos = new JButton("Ver alumnos");
	
	/**
	 * Nombre del tema
	 */
	private JTextField nombreTema = new JTextField(13);
	
	
	/**
	 * Frame en el que se encuentra
	 */
	private NoodleFrame frame;
	
	/**
	 * Asignatura a la que ser refiere
	 */
	private Asignatura asignatura;

	
	/**
	 * Creador de ContenidoMenuDer
	 * @param frame
	 * @param con
	 */
	public AsignaturaMenuIzq(NoodleFrame frame, Asignatura asignatura){
		this.asignatura = asignatura;
		this.frame = frame;
		
		this.setBackground(Color.WHITE);
		
		SpringLayout spr = new SpringLayout();
		this.setLayout(spr);
		
		this.tema.setPreferredSize(new Dimension(150, 30));
		this.borrar.setPreferredSize(new Dimension(150, 30));
		this.nombreTema.setPreferredSize(new Dimension(150, 30));
		this.alumnos.setPreferredSize(new Dimension(150, 30));
		

		spr.putConstraint(SpringLayout.WEST, this.tema, 10, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.WEST, this.alumnos, 10, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.WEST, this.nombreTema, 10, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.WEST, this.borrar, 10, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.NORTH, this.alumnos, -90, SpringLayout.VERTICAL_CENTER, this.nombreTema);
		spr.putConstraint(SpringLayout.NORTH, this.tema, -50, SpringLayout.VERTICAL_CENTER, this);
		spr.putConstraint(SpringLayout.SOUTH, this.nombreTema, -30, SpringLayout.VERTICAL_CENTER, this.tema);
		spr.putConstraint(SpringLayout.NORTH, this.borrar, 30, SpringLayout.VERTICAL_CENTER, this);

		
		this.add(this.tema);
		this.add(this.nombreTema);
		this.add(this.borrar);
		this.add(this.alumnos);
		
		this.borrar.setActionCommand("borrar");
		this.tema.setActionCommand("tema");
		this.alumnos.setActionCommand("alumnos");
		
		ActionListener list = new AsignaturaMenuIzqListener(frame, asignatura, this);
		
		this.tema.addActionListener(list);
		this.borrar.addActionListener(list);
		this.alumnos.addActionListener(list);
		
		this.setPreferredSize(new Dimension(200, 250));
	}
	
	/**
	 * Método que devuelve el texto introducido en el campo del tema
	 * @return
	 */
	public String getText(){
		return this.nombreTema.getText();
	}
}