package interfaz.asignatura.contenido.ejercicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import contenido.Ejercicio;
import contenido.Pregunta;
import interfaz.genericos.NoodleFrame;

/**
 * Clase PreguntaMenuDerListener
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class PreguntaMenuDerListener implements ActionListener {

	/**
	 * Ejercicio
	 */
	Ejercicio ej;
	
	/**
	 * Pregunta 
	 */
	Pregunta p;
	
	/**
	 * Constructor
	 * @param frame
	 * @param ej
	 * @param p, null si se quiere crear una nueva
	 */
	public PreguntaMenuDerListener(NoodleFrame frame, Ejercicio ej, Pregunta p) {
		this.ej = ej;
		this.p = p;
	}

	/**
	 * Método por si se pulsa algún botón
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Se ha pulsado en " + arg0.getActionCommand());

	}

}
