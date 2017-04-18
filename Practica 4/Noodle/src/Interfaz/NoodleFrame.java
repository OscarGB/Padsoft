package Interfaz;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import plataforma.Plataforma;

public class NoodleFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoodleFrame(){
		super("Noodle");
		Dimension d = new Dimension();
		d.setSize(700, 500);
		
		Plataforma.openPlataforma();		
		
		JPanel panel = new PanelLogin();
		
		this.getContentPane().add(panel);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(d);
	}
	
}
