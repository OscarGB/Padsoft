package interfaz.asignatura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import asignatura.Asignatura;
import interfaz.genericos.NoodleFrame;

/**
 * Clase AlumnosAsignaturaListener
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class AlumnosAsignaturaListener implements ActionListener {

	/**
	 * Asignatura
	 */
	Asignatura asig;
	
	public AlumnosAsignaturaListener(Asignatura asignatura) {
		this.asig = asignatura;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		NoodleFrame.getInstance().showExpulsados(true, this.asig);
	}

}
