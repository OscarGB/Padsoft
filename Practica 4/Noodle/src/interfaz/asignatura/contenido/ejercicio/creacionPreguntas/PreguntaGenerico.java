package interfaz.asignatura.contenido.ejercicio.creacionPreguntas;

import java.awt.BorderLayout;
import java.awt.Color;

import contenido.Ejercicio;
import contenido.Pregunta;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;

/**
 * Clase PreguntaGenerico
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class PreguntaGenerico extends NuestroPanel{

	//Variables
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 954654897L;

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
	 * @param pregunta
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
	
	/**
	 * Método que refresca el panel
	 * @param pregunta
	 * @param ejer
	 */
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
	 */
	public void showSur(){
		this.sur.setVisible(true);
	}
	
	/**
	 * Método que añade una opcion
	 * @param s
	 */
	public void addOpcion(String s){
		return;
	}
	
	/**
	 * Método que devuelve la pregunta
	 * @return
	 */
	public Pregunta getPregunta(){
		return null;
	}
}
