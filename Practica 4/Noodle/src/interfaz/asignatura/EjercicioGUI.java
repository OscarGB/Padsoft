package interfaz.asignatura;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;

import asignatura.Asignatura;
import contenido.Ejercicio;
import contenido.Pregunta;
import contenido.Tema;
import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;

/**
 * Clase EjercicioGUI
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
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
	
	/**
	 * Asignatura
	 */
	private Asignatura asignatura;
	
	/**
	 * Tema
	 */
	private Tema tema;

	/**
	 * Constructor del GUI del ejercicio
	 * @param anterior
	 * @param frame
	 * @param ejercicio
	 * @param tema
	 */
	public EjercicioGUI(NuestroPanel anterior, NoodleFrame frame, Ejercicio ejercicio, Tema tema) {
		super(anterior, frame);
		this.setSize(700,500);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());
		
		this.tema = tema;
		
		this.asignatura = tema.getAsignatura();
	
		
		this.menu = new Menu(frame);
		this.ejercicio = ejercicio;
		this.panel = new PreguntasPanel(this.frame, this.ejercicio);
		this.scroll = new JScrollPane(this.panel);
		this.derecha = new EjercicioMenuDer(frame, ejercicio, tema);
		
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
		this.frame.showEjercicioGUI(false, this.ejercicio, this.tema);
	}
	
	/**
	 * Setter de ejercicio
	 * @param ej
	 */
	public void setEjercicio(Ejercicio ej){
		this.ejercicio = ej;
	}
	
	/**
	 * Setter de tema
	 * @param tema
	 */
	public void setTema(Tema tema){
		this.tema = tema;
		this.asignatura = tema.getAsignatura();
	}
	
	/**
	 * Método que actualiza el panel
	 */
	public void refreshPanel(){
		this.remove(this.panel);
		this.panel = new PreguntasPanel(this.frame, this.ejercicio);
		this.remove(this.derecha);
		this.derecha = new EjercicioMenuDer(this.frame, this.ejercicio, this.tema);
		this.remove(this.scroll);
		this.scroll = new JScrollPane(this.panel);
		this.add(this.scroll, BorderLayout.CENTER);
		this.add(this.derecha, BorderLayout.EAST);
	}

}
