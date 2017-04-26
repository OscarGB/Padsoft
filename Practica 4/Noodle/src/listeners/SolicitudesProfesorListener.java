package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaz.NoodleFrame;
import interfaz.SolicitudesProfesor;

public class SolicitudesProfesorListener implements ActionListener {

	SolicitudesProfesor solicitudes;
	NoodleFrame frame;
	
	public SolicitudesProfesorListener(SolicitudesProfesor solicitudesProfesor, NoodleFrame noodleFrame) {
		this.solicitudes = solicitudesProfesor;
		this.frame = noodleFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
