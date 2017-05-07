package interfaz.asignatura.contenido.ejercicio.creacionPreguntas;

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
	protected PreguntaMenuDer derecha;
	
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
		
		this.derecha = new PreguntaMenuDer(this, this.frame, this.ejercicio, this.pregunta);
		
		this.sur = new AddRespuesta(this.pregunta, this);
		
		this.add(this.derecha, BorderLayout.EAST);
		this.add(this.sur, BorderLayout.SOUTH);
		
	}
	
	// Métodos
	
	public void refreshPanel(Pregunta pregunta, Ejercicio ejer){
		this.pregunta = pregunta;
		this.ejercicio = ejer;
		
		this.remove(this.derecha);
		this.derecha = new PreguntaMenuDer(this, this.frame, this.ejercicio, this.pregunta);
		this.add(this.derecha, BorderLayout.EAST);
		
		this.remove(this.sur);
		this.sur = new AddRespuesta(this.pregunta, this);
		this.add(this.sur, BorderLayout.SOUTH);
		
		this.revalidate();
		this.repaint();
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
	public void showSur(){
		this.sur.setVisible(true);
	}
	
	/**
	 * Método para ser sobreescrito
	 * @param s
	 */
	public void addOpcion(String s){
		return;
	}
	
	/**
	 * Método para hacer override
	 * @return
	 */
	public Pregunta getPregunta(){
		return null;
	}
	

}
