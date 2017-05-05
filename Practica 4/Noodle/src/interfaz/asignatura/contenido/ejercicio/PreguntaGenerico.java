package interfaz.asignatura.contenido.ejercicio;

import java.awt.BorderLayout;
import java.awt.Color;

import contenido.Ejercicio;
import contenido.Pregunta;
import contenido.Tema;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;

public class PreguntaGenerico extends NuestroPanel{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Panel anterior
	 */
	protected NuestroPanel anterior;
	
	/**
	 * Frame
	 */
	protected NoodleFrame frame;
	
	/**
	 * Menu de la derecha
	 */
//	protected PreguntaMenuDer derecha;
	
	/**
	 * Menu sur
	 */
	protected AddRespuesta sur;
	
	/**
	 * Ejercicio
	 */
	protected Ejercicio ejercicio;
	
	/**
	 * Pregunta
	 */
	protected Pregunta pregunta;
	
	//Constructor
	
	/**
	 * Constructor de PreguntaGenerico
	 * @param anterior
	 * @param frame
	 * @param ejercicio
	 */
	protected PreguntaGenerico(NuestroPanel anterior, NoodleFrame frame, Ejercicio ejercicio, Pregunta pregunta) {
		super(anterior, frame);
		this.anterior = anterior;
		this.frame = frame;
		this.ejercicio = ejercicio;
		this.pregunta = pregunta;
		
		this.setSize(400,350);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());
		
//		this.derecha = new PreguntaMenuDer();
		
		this.sur = new AddRespuesta(this.pregunta);
		
//		this.add(this.derecha, BorderLayout.EAST);
		this.add(this.sur, BorderLayout.SOUTH);
		
	}
	
	// Métodos
	
	public void refreshPanel(Pregunta pregunta){
		this.pregunta = pregunta;
		
//		this.remove(this.derecha);
//		this.derecha = new PreguntaMenuDer());
//		this.add(this.derecha, BorderLayout.EAST);
		
		this.remove(this.sur);
		this.sur = new AddRespuesta(this.pregunta);
		this.add(this.sur, BorderLayout.EAST);
	}
	
	/**
	 * Esconde el panel sur
	 */
	public void escondeSur(){
		this.sur.setVisible(false);
		
	}
	
	/**
	 * Metodo para mostrar el menu sur
	 * @param tema
	 */
	public void showLateral(){
		this.sur.setVisible(true);
	}

}
