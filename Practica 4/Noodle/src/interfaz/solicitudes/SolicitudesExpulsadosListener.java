package interfaz.solicitudes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaz.genericos.NoodleFrame;
import solicitud.Solicitud;

/**
 * Clase SolicitudesExpulsadosListener
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class SolicitudesExpulsadosListener implements ActionListener {

	//Variables
	
	/**
	 * Solicitud
	 */
	Solicitud sol;
	
	/**
	 * Panel
	 */
	SolicitudesExpulsados panel;
		
	//Constructor
	
	/**
	 * Constructor
	 * @param solicitud
	 * @param panel
	 */
	public SolicitudesExpulsadosListener(Solicitud solicitud, SolicitudesExpulsados panel) {
		this.sol = solicitud;
		this.panel = panel;
	}

	//Métodos

	/**
	 * Método cuando se pulsa el botón
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.sol.getAsignatura().readmitirAlumno(sol.getAlumno());
		NoodleFrame.getInstance().showExpulsados(false, panel.getAsignatura());
	}

}
