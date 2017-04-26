package interfaz;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InicioAlumno extends NuestroPanel {
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Menu generico que se muestra en la parte superior
	 */
	private Menu menu;
	
	private MisAsignaturas cursos;
	private JScrollPane scroll;
	
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
		
		menu.setPreferredSize(new Dimension(10,10));
		
		this.add(this.menu, BorderLayout.NORTH);
		this.add(this.scroll, BorderLayout.CENTER);
		
		int h = this.getHeight();
		int w = this.getWidth();
		
		this.menu.setPreferredSize(new Dimension(w, 80));
		//this.cursos.setPreferredSize(new Dimension(w, h*2));

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
		this.frame.showInicioAlumno(false);
	}
	
}
