package interfaz;

import java.awt.*;

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
	
	/**
	 * Panel de scrolling
	 */
	private JScrollPane scroll;
	
	//Constructor
	
	/**
	 * Constructor del inicio del alumno
	 * @param panel anterior
	 * @param frame
	 */
	public InicioAlumno(NuestroPanel anterior, NoodleFrame frame){
		super(anterior, frame);
		this.setSize(400,350);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());

		this.menu = new Menu(frame);
		this.cursos = new MisAsignaturas(frame);
		this.scroll = new JScrollPane(cursos);
		
		this.add(this.menu, BorderLayout.NORTH);
		this.add(this.scroll, BorderLayout.CENTER);
		
		int w = this.getWidth();
		
		this.menu.setPreferredSize(new Dimension(w, 80));

	}
	
	// Métodos
	
	/**
	 * Hace que el frame muestre este panel
	 */
	public void muestraPanel(){
		this.frame.showInicioAlumno(false);
	}
	
}
