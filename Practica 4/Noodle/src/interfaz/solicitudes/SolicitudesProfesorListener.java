package interfaz.solicitudes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaz.genericos.NoodleFrame;
import plataforma.Plataforma;
import solicitud.Solicitud;

/**
 * Clase SolicitudesProfesorListener
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 20/04/2017
 */
public class SolicitudesProfesorListener implements ActionListener {

	/**
	 * Frame en el que se encuentra
	 */
	NoodleFrame frame;
		
	/**
	 * Solicitud que afecta 
	 */
	Solicitud sol;
	
	/**
	 * Creador de SolicitudesProfesorListener
	 * @param solicitudesProfesor
	 * @param noodleFrame
	 * @param sol
	 */
	public SolicitudesProfesorListener(NoodleFrame frame, Solicitud sol) {
		this.frame = frame;
		this.sol = sol;
	}

	/**
	 * Método para cuando se pulsa en el botón
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("aceptar")){
			Plataforma.profesor().aceptarSolicitud(sol);
		}
		else if(e.getActionCommand().equals("cancelar")){
			Plataforma.profesor().denegarSolicitud(sol);
		}
		frame.showSolicitudesProfesor(false);
		Plataforma.plat().saveData();
	}

}
