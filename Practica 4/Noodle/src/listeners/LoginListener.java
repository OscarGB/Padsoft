package listeners;

import java.awt.event.*;

import interfaz.PanelLogin;
import plataforma.Plataforma;

/**
 * Clase LoginListener
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class LoginListener implements ActionListener{
	
	//Variables
	
	/**
	 * Panel sobre el que actua
	 */
	private PanelLogin panel;
	
	//Constructor
	
	/**
	 * Constructor de LoginListener
	 * @param panel
	 */
	public LoginListener(PanelLogin panel){
		this.panel = panel;
	}
	
	//M�todos
	
	/** 
	 * M�todo para realizar la acci�n al pulsar el bot�n
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Login") == false){
			return;
		}
		if(Plataforma.login(panel.getUser(), panel.getPassword()) == false){
			panel.setFailPasswordVisibility(true);
		}
		else{
			panel.setFailPasswordVisibility(false);
		}
		
	}
	
}
