package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaz.NoodleFrame;
import interfaz.SolicitudesAlumno;

public class SolicitudesAlumnoListener implements ActionListener {

	SolicitudesAlumno solicitudes;
	
	NoodleFrame frame;
	
	public SolicitudesAlumnoListener(SolicitudesAlumno solicitudesAlumno, NoodleFrame noodleFrame) {
		this.solicitudes = solicitudesAlumno;
		this.frame = noodleFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
