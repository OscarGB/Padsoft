package interfaz.asignatura;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import asignatura.Asignatura;
import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;

/**
 * Clase AlumnosAsignatura
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class AlumnosAsignatura extends NuestroPanel{
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Menu generico que se muestra en la parte superior
	 */
	private Menu menu;
	
	/**
	 * Asignatura a mostrar
	 */
	private Asignatura asignatura;
	
	/**
	 * Panel con los alumnos
	 */
	private Alumnos alumnos;
	
	/**
	 * Panel de scrolling
	 */
	private JScrollPane scroll;
	
	/**
	 * Botón para accedera a los alumnos expulsados
	 */
	private JButton expulsados = new JButton("Alumnos expulsados");
	
	
	//Constructor

	/**
	 * Constructor de AsignaturaGUI
	 * @param anterior
	 * @param frame
	 * @param asignatura
	 */
	public AlumnosAsignatura(NuestroPanel anterior, NoodleFrame frame, Asignatura asignatura){
		super(anterior, frame);
		this.setSize(700,500);
		this.setBackground(Color.WHITE);
		
		this.asignatura = asignatura;
		
		this.setLayout(new BorderLayout());
		
		this.menu = new Menu(frame);
		this.alumnos = new Alumnos(frame, asignatura);
		this.scroll = new JScrollPane(this.alumnos);
		
		this.add(this.menu, BorderLayout.NORTH);
		this.add(this.scroll, BorderLayout.CENTER);
		this.add(this.expulsados, BorderLayout.SOUTH);
		
		this.expulsados.addActionListener(new AlumnosAsignaturaListener(this.asignatura));
		
		int w = this.getWidth();
		
		this.menu.setPreferredSize(new Dimension(w, 80));
	}
	
	/**
	 * Hace que el frame muestre este panel
	 */
	public void muestraPanel(){
		this.frame.showAlumnosAsignatura(false, this.asignatura);
	}
	
	/**
	 * Método que actualiza el panel
	 */
	public void refreshPanel(){
		this.remove(this.scroll);
		this.alumnos = new Alumnos(frame, this.asignatura);
		this.scroll = new JScrollPane(this.alumnos);
		this.add(this.scroll, BorderLayout.CENTER);
	}	
	
}
