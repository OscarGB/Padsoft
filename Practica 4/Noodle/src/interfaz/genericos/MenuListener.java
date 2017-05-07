package interfaz.genericos;

import java.awt.event.*;

import plataforma.Plataforma;

/**
 * Clase para implementar el listener del menu generico
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class MenuListener implements ActionListener {

	//Variables
	
	/**
	 * Panel menu
	 */
	Menu menu;
	
	/**
	 * Frame en el que est�
	 */
	NoodleFrame frame;
	
	//Constructor
	
	/**
	 * constructor de MenuListener
	 * @param menu
	 * @param frame
	 */
	public MenuListener(Menu menu, NoodleFrame frame) {
		this.frame = frame;
		this.menu = menu;
	}
	
	//M�todos

	/**
	 * M�todo para realizar una acci�n en caso de que los botones del men� sean pulsados
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Logout")){
			Plataforma.logout();
			frame.logout();
			return;
		}
		else if(arg0.getActionCommand().equals("Atras")){
			frame.atras();
			return;
		}

	}

}
