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
	
	/**
	 * constructor de MenuListener
	 * @param menu
	 * @param frame
	 */
	public MenuListener(Menu menu, NoodleFrame frame) {
		this.frame = frame;
		this.menu = menu;
	}

	/**
	 * Método para realizar una acción en caso de que los botones del menú sean pulsados
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Logout")){
			System.out.println("Ha pulsado logout");
			Plataforma.logout();
			frame.logout();
			return;
		}
		else if(arg0.getActionCommand().equals("Atras")){
			System.out.println("Ha pulsado atras");
			frame.atras();
			return;
		}

	}

}
