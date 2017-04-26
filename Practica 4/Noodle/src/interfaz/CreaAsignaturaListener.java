package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import asignatura.Asignatura;
import plataforma.Plataforma;

/**
 * Clase CreaAsignaturaListener
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class CreaAsignaturaListener implements ActionListener {
	
	// Variables
	
	/**
	 * Panel al que pertenece
	 */
	CreaAsignatura panel;
	
	//Constructor
	
	/**
	 * Constructor de CreaAsignaturaListener
	 * @param panel
	 */
	public CreaAsignaturaListener(CreaAsignatura panel){
		this.panel = panel;
	}

	/**
	 * Método para realizar una acción cuando se pulsa algún botón
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Crear")){
			panel.cambiarVisibilidad(true);
		}
		else if(arg0.getActionCommand().equals("Confirmar")){
			String name = panel.getNombre();
			Plataforma.addAsignatura(new Asignatura(name));
			panel.cambiarVisibilidad(false);
			System.out.println(Plataforma.plat());
		}

	}

}
