package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import asignatura.Asignatura;

/**
 * Clase RatonList
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
class RatonList extends MouseAdapter{
	
	// Variables
	
	/**
	 * Panel al que pertenece
	 */
	Asignaturas panel;
	
	/**
	 * Asignatura a la que hace referencia
	 */
	Asignatura asig;
	
	// Creador
	
	/**
	 * Constructor de RatonList
	 * @param a
	 * @param panel
	 * @param asig
	 */
	RatonList(Asignaturas panel, Asignatura asig){
		this.panel = panel;
		this.asig = asig;
	}
	
	// Métodos
	
		 /**
		  * Método por si se pulsa
		  * @param e
		  */
		public void mouseClicked(MouseEvent e) {
			 panel.listenerListaAsignaturas(asig);
		 } 
	}

public class Asignaturas extends JPanel{
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;


	public Asignaturas(){
		
	}
	
	
	/**
	 * Listener para cuando se clique en una asignatura
	 * @param asig
	 */
	public void listenerListaAsignaturas(Asignatura asig){
		System.out.println("Has pulsado en " + asig.getNombre());
	}
}
