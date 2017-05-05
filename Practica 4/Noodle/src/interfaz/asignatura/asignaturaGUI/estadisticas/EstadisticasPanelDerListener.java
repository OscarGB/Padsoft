package interfaz.asignatura.asignaturaGUI.estadisticas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import asignatura.Asignatura;
import interfaz.genericos.NoodleFrame;
import persona.Alumno;
import plataforma.Plataforma;

/**
 * Clase EstadisticasPanelDerListener
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */
public class EstadisticasPanelDerListener implements ActionListener {

	/**
	 * Frame
	 */
	NoodleFrame frame;
	
	/**
	 * Alumno
	 */
	Alumno al;
	
	/**
	 * Asignatura
	 */
	Asignatura asig;
	
	/**
	 * Constructor
	 * @param frame
	 * @param al
	 * @param asig
	 */
	public EstadisticasPanelDerListener(NoodleFrame frame, Alumno al, Asignatura asig) {
		this.al = al;
		this.asig = asig;
		this.frame = frame;
	}

	/**
	 * Método para cuando se pulse el botón
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.asig.expulsarAlumno(al);
		Plataforma.plat().saveData();
		frame.showAlumnosAsignatura(false, this.asig);
	}

}
