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
		
		PanelLogin panel = new PanelLogin();
		panel.addListener(new LoginListener());
		
		this.getContentPane().add(panel);
		
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(d);
	}
	
}
