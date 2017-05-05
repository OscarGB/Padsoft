package interfaz.asignatura.asignaturaGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import asignatura.Asignatura;
import interfaz.genericos.NoodleFrame;
import persona.Alumno;
import persona.Persona;

/**
 * Clase AsigAlumnoMenuIzqListener
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class AsigAlumnoMenuIzqListener implements ActionListener {

	/**
	 * Frame en el que se encuentra
	 */
	NoodleFrame frame;
	
	/**
	 * Notas de que alumno
	 */
	Alumno al;
	
	/**
	 * Asigntura
	 */
	Asignatura asig;
	
	
	/**
	 * Constructor del listener
	 * @param frame
	 * @param loggedAs
	 * @param asig
	 */
	public AsigAlumnoMenuIzqListener(NoodleFrame frame, Persona loggedAs, Asignatura asig) {
		this.frame = frame;
		this.al = (Alumno)loggedAs;
		this.asig = asig;
	}

	/**
	 * Método cuando se pulse el botón
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("notas")){
			frame.showEstadisticas(true, this.al, this.asig);
		}
	}

}
