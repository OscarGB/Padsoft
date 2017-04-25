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
		this.setBackground(Color.WHITE);
		
		BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(box);
		//TODO cambiar a spring layout
		this.menu1 = new Menu(frame);
		this.menu2 = new Menu(frame);
		
		//menu1.setAlignmentY(alignmentY);
		menu2.setAlignmentY(TOP_ALIGNMENT);
		
		menu1.setPreferredSize(new Dimension(10,10));
		
		this.add(this.menu1);
		this.add(this.menu2);
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
