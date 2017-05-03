package interfaz.asignatura;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;

import asignatura.Asignatura;
import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;

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
		
		int w = this.getWidth();
		
		this.menu.setPreferredSize(new Dimension(w, 80));
	}
	
	/**
	 * Hace que el frame muestre este panel
	 */
	public void muestraPanel(){
		this.frame.showAlumnosAsignatura(true, this.asignatura);
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
