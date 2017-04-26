package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

public class SolicitudesAlumno extends NuestroPanel {
	/**
	 * Menu generico que se muestra en la parte superior
	 */
	private Menu menu;
	
	private MisAsignaturas cursos;
	
	/**
	 * Constructor del inicio del alumno
	 * @param panel anterior
	 * @param frame
	 */
	public SolicitudesAlumno(NuestroPanel anterior, NoodleFrame frame){
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
	
	/**
	 * Añade un ActionListener al InicioAlumno
	 * @param listener
	 */
	public void addListener(ActionListener listener){
		//TODO añadir los listeners
		return;
	}
	
	/**
	 * Hace que el frame muestre este panel
	 */
	public void muestraPanel(){
		this.frame.showSolicitudesAlumno(false);
	}
}
