package interfaz.asignatura.contenido.ejercicio.creacionPreguntas;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;

import contenido.Ejercicio;
import contenido.Pregunta;
import contenido.PreguntaRespuestaSimple;
import interfaz.asignatura.contenido.ejercicio.genericosPreguntas.PreguntaSimplePanel;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;

/**
 * Clase PreguntaSimple
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class PreguntaSimple extends PreguntaGenerico {

	//Variables
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 56568986574L;
	
	/**
	 * Panel padre
	 */
	private PreguntaSimplePanel panel;
	
	/**
	 * Panel para hacer scroll
	 */
	private JScrollPane scroll;

	//Constructor
	
	/**
	 * Constructor
	 * @param anterior
	 * @param frame
	 * @param ejercicio
	 * @param pregunta
	 */
	public PreguntaSimple(NuestroPanel anterior, NoodleFrame frame, Ejercicio ejercicio, Pregunta pregunta) {
		super(anterior, frame, ejercicio, pregunta);
		
		this.panel = new PreguntaSimplePanel((PreguntaRespuestaSimple) this.pregunta);
		scroll = new JScrollPane(panel);
		this.add(this.scroll, BorderLayout.CENTER);
		
		this.remove(this.sur);
		
	}
	
	//M�todos
	
	/**
	 * M�todo que devuelve la pregunta creada en el panel
	 */
	@Override
	public Pregunta getPregunta(){
		return panel.getPregunta();
	}
	
	/**
	 * M�todo pare hacer refresh
	 * @param pregunta
	 * @param ejer
	 */
	@Override
	public void refreshPanel(Pregunta pregunta, Ejercicio ejer){
		
		this.pregunta = pregunta;
		this.ejercicio = ejer;
		
		this.remove(this.derecha);
		this.derecha = new PreguntaMenuDer(this, this.frame, this.ejercicio, this.pregunta);
		this.add(this.derecha, BorderLayout.EAST);
		
		this.remove(this.scroll);
		this.panel = new PreguntaSimplePanel((PreguntaRespuestaSimple) this.pregunta);
		scroll = new JScrollPane(panel);
		this.add(this.scroll, BorderLayout.CENTER);
		
		this.revalidate();
		this.repaint();
	}
	
	/**
	 * M�todo para a�adir una opcion
	 * @param s
	 */
	@Override
	public void addOpcion(String s){
		System.out.println("No deberias haber llegado aqui");
	}

}