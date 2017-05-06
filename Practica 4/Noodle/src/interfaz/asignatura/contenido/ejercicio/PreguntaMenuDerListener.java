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
	private Ejercicio ej;
	
	/**
	 * Pregunta 
	 */
	private Pregunta p;
	
	/**
	 * Panel
	 */
	private PreguntaGenerico panel;
	
	/**
	 * Constructor
	 * @param frame
	 * @param ej
	 * @param p, null si se quiere crear una nueva
	 */
	public PreguntaMenuDerListener(PreguntaGenerico panel, NoodleFrame frame, Ejercicio ej, Pregunta p) {
		this.ej = ej;
		this.p = p;
		this.panel = panel;
	}

	/**
	 * Método por si se pulsa algún botón
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("guardar")){
			System.out.println("guardar");
			System.out.println(this.panel.getPregunta());
		}
		else if(arg0.getActionCommand().equals("borrar")){
			System.out.println("borrar");
		}
		else if(arg0.getActionCommand().equals("cancelar")){
			System.out.println("cancelar");
		}
	}

}
