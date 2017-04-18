package interfaz;

import java.awt.Dimension;

import javax.swing.*;

import listeners.*;
import plataforma.Plataforma;

public class NoodleFrame extends JFrame{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	public NoodleFrame(){
		super("Noodle");
		Dimension d = new Dimension();
		d.setSize(700, 500);
		
		Plataforma.openPlataforma();		
		
		PanelLogin login = new PanelLogin();
		login.addListener(new LoginListener(login));
		
		this.getContentPane().add(login);
				
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(d);
	}
	
}
