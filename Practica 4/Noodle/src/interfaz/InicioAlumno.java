package interfaz;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Clase InicioAlumno
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 20/04/2017
 */
public class InicioAlumno extends NuestroPanel {
	
	// Variables
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Menu generico que se muestra en la parte superior
	 */
	private Menu menu;
	
	/**
	 * Panel con los cursos matriculados
	 */
	private MisAsignaturas cursos;
	
	//Constructor
	
	/**
	 * Constructor del inicio del alumno
	 * @param panel anterior
	 * @param frame
	 */
	public InicioAlumno(NuestroPanel anterior, NoodleFrame frame){
		super(anterior, frame);
		this.setSize(700,500);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());

		this.menu = new Menu(frame);
		this.cursos = new MisAsignaturas(frame);
		
		menu.setPreferredSize(new Dimension(10,10));
		
		this.add(this.menu, BorderLayout.NORTH);
		this.add(this.cursos, BorderLayout.CENTER);
		
		int h = this.getHeight();
		int w = this.getWidth();
		
		this.menu.setPreferredSize(new Dimension(w, 80));
		this.cursos.setPreferredSize(new Dimension(w, h));

	}
	
	// M�todos
	
	/**
	 * A�ade un ActionListener al InicioAlumno
	 * @param listener
	 */
	public void addListener(ActionListener listener){
		this.cursos.addListener(listener);
		return;
	}
	
	/**
	 * Hace que el frame muestre este panel
	 */
	public void muestraPanel(){
		this.frame.showInicioAlumno(false);
	}
	
}
