package listeners;

import java.awt.event.*;

import interfaz.*;

public class InicioAlumnoListener implements ActionListener{

	//Variables
	
	/**
	 * Panel sobre el que actua
	 */
	private InicioAlumno panel;
	
	/**
	 * Cuerpo del programa
	 */
	private NoodleFrame frame;
	
	//Constructor
	
	/**
	 * Constructor de InicioAlumnoListener
	 * @param panel
	 */
	public InicioAlumnoListener(InicioAlumno panel, NoodleFrame frame){
		this.panel = panel;
		this.frame = frame;
	}
	
	/** 
	 * M�todo para realizar la acci�n al realizarse una acci�n en el panel
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
