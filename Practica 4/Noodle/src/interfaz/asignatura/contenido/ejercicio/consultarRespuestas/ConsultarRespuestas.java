package interfaz.asignatura.contenido.ejercicio.consultarRespuestas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import contenido.Ejercicio;
import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;

public class ConsultarRespuestas extends NuestroPanel{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Menu generico
	 */
	private Menu menu;
	
	/**
	 * Ejercicio
	 */
	private Ejercicio ejercicio;
	
	public ConsultarRespuestas(NuestroPanel anterior, NoodleFrame frame, Ejercicio ejercicio) {
		super(anterior, frame);
		this.setSize(700,500);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());
		
		this.ejercicio = ejercicio;
		
		this.menu = new Menu(frame);
		
		this.add(this.menu, BorderLayout.NORTH);
		
		int w = this.getWidth();
		
		this.menu.setPreferredSize(new Dimension(w, 80));
		
	}

}
