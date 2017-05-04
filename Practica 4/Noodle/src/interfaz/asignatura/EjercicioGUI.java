package interfaz.asignatura;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;

import contenido.Ejercicio;
import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;

public class EjercicioGUI extends NuestroPanel{
	
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
	
	/**
	 * Subpanel con las preguntas
	 */
	private PreguntasPanel panel;
	
	/**
	 * Panel de scrolling
	 */
	private JScrollPane scroll;
	
	/**
	 * Menu de gestion de ejercicio
	 */
	private EjercicioMenuDer derecha;

	public EjercicioGUI(NuestroPanel anterior, NoodleFrame frame, Ejercicio ejercicio) {
		super(anterior, frame);
		this.setSize(700,500);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());
		
		this.menu = new Menu(frame);
		this.ejercicio = ejercicio;
		this.panel = new PreguntasPanel(this.frame, this.ejercicio);
		this.scroll = new JScrollPane(this.panel);
		this.derecha = new EjercicioMenuDer(frame, ejercicio);
		
		this.add(this.menu, BorderLayout.NORTH);
		this.add(this.scroll, BorderLayout.CENTER);
		this.add(this.derecha, BorderLayout.EAST);
		
		int w = this.getWidth();
		
		this.menu.setPreferredSize(new Dimension(w, 80));
		
	}
	
	/**
	 * Hace que el frame muestre este panel
	 */
	public void muestraPanel(){
		this.frame.showEjercicioGUI(false, this.ejercicio);
	}
	
	/**
	 * M�todo que actualiza el panel
	 */
	public void refreshPanel(){
		this.remove(this.scroll);
		this.panel = new PreguntasPanel(frame, this.ejercicio);
		this.scroll = new JScrollPane(this.panel);
		this.add(this.scroll, BorderLayout.CENTER);
	}

}
