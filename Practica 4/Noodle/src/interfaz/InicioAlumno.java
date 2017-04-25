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
	private Menu menu1;
	
	private Menu menu2;
	
	/**
	 * Constructor del inicio del alumno
	 * @param panel anterior
	 * @param frame
	 */
	public InicioAlumno(NuestroPanel anterior, NoodleFrame frame){
		super(anterior, frame);
//		this.setPreferredSize(new Dimension(50, 50));
//		this.setMaximumSize(new Dimension(50, 50));
		this.setSize(700, 500);
		this.setBackground(Color.WHITE);
		
		BorderLayout border = new BorderLayout();
		this.setLayout(border);
		
		this.menu1 = new Menu();
		this.menu2 = new Menu();
		
		this.add(this.menu1, BorderLayout.NORTH);
		
		int h = this.getHeight();
		int w = this.getWidth();
		
		this.menu1.setPreferredSize(new Dimension(w,100));
		//this.add(this.menu2);
		//TODO Falta añadir el contenido del inicio

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
		this.frame.showInicioAlumno();
	}
	
}
