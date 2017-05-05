package interfaz.asignatura.contenido.ejercicio;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;

import contenido.Ejercicio;
import contenido.Pregunta;
import contenido.PreguntaRespuestaUnica;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;

/**
 * Clase PreguntaUnica
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class PreguntaUnica extends PreguntaGenerico {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 56568986574L;
	
	/**
	 * Panel padre
	 */
	private PreguntaUnicaPanel panel;
	
	/**
	 * Panel para hacer scroll
	 */
	private JScrollPane scroll;

	/**
	 * constructor
	 * @param anterior
	 * @param frame
	 * @param ejercicio
	 * @param pregunta
	 */
	public PreguntaUnica(NuestroPanel anterior, NoodleFrame frame, Ejercicio ejercicio, Pregunta pregunta) {
		super(anterior, frame, ejercicio, pregunta);
		
		this.panel = new PreguntaUnicaPanel((PreguntaRespuestaUnica) this.pregunta);
		scroll = new JScrollPane(panel);
		this.add(this.scroll, BorderLayout.CENTER);
		
	}
	
	public PreguntaRespuestaUnica getPregunta(){
		return panel.getPregunta();
	}
	
	/**
	 * Método pare hacer refresh
	 * @param pregunta
	 * @param ejer
	 */
	@Override
	public void refreshPanel(Pregunta pregunta, Ejercicio ejer){
		super.refreshPanel(pregunta, ejer);
		this.remove(this.scroll);
		this.panel = new PreguntaUnicaPanel((PreguntaRespuestaUnica) this.pregunta);
		scroll = new JScrollPane(panel);
		this.add(this.scroll, BorderLayout.CENTER);
	}
	
	/**
	 * Método para añadir una opcion
	 * @param s
	 */
	@Override
	public void addOpcion(String s){
		panel.addOpcion(s);
	}

}
