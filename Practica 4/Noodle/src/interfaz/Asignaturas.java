package interfaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import asignatura.Asignatura;
import persona.Alumno;
import plataforma.Plataforma;

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
	
	// M�todos
	
	 /**
	  * M�todo por si se pulsa
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

	NoodleFrame frame;
	
	public Asignaturas(NoodleFrame frame){
		this.frame = frame;
	}
	
	
	/**
	 * Listener para cuando se clique en una asignatura
	 * @param asig
	 */
	public void listenerListaAsignaturas(Asignatura asig){
		if(Plataforma.loggedAs() instanceof Alumno){
			if(asig.getAlumnos().contains(Plataforma.loggedAs())){
				frame.showAsignatura(true, asig);
			}
			else{
				frame.showAsignaturaNoMatriculada(true, asig);
			}
		}
		else{
			frame.showAsignatura(true, asig);
		}
	}
}
