package listeners;

import java.awt.event.*;

import javax.swing.JPanel;

import interfaz.*;
import persona.*;
import plataforma.Plataforma;

/**
 * Clase para implementar el listener del menu generico
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 */
public class MenuListener implements ActionListener {

	/**
	 * Panel menu
	 */
	Menu menu;
	
	/**
	 * Frame en el que está
	 */
	NoodleFrame frame;
	
	public MenuListener(Menu menu, NoodleFrame frame) {
		this.frame = frame;
		this.menu = menu;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Logout")){
			Plataforma.logout();
			frame.logout();
			return;
		}
		else if(arg0.getActionCommand().equals("Inicio")){
			if(Plataforma.loggedAs() instanceof Alumno){
				frame.showInicioAlumno(true);
			}
			else if(Plataforma.loggedAs() instanceof Profesor){
				frame.showInicioProfesor(true);
			}
			return;
		}
		else if(arg0.getActionCommand().equals("Asignaturas")){
			if(Plataforma.loggedAs() instanceof Alumno){
				frame.showAsignaturas(true);
			}
			else if(Plataforma.loggedAs() instanceof Profesor){
				frame.showAsignaturas(true);
			}
			return;
		}
		else if(arg0.getActionCommand().equals("Solicitudes")){
			if(Plataforma.loggedAs() instanceof Alumno){
				frame.showSolicitudesAlumno(true);
			}
			else if(Plataforma.loggedAs() instanceof Profesor){
				frame.showSolicitudesProfesor(true);
			}
			return;
		}
		else if(arg0.getActionCommand().equals("Atras")){
			frame.atras();
			return;
		}

	}

}
