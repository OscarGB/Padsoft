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
	
	// TODO pila máxima de retrocesos
	// TODO clase NuestroPanel para comodidad

	public NoodleFrame(){
		super("Noodle");
		Plataforma.openPlataforma();
		showPanelLogin();
	}
	
	public void showPanelLogin(){
		
		this.getContentPane().removeAll();
		
		Dimension d = new Dimension();
		d.setSize(700, 500);		
		
		PanelLogin login = new PanelLogin();
		login.addListener(new LoginListener(login, this));
		
		this.getContentPane().add(login);
		
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(d);
		this.repaint();
		
	}
	
	public void showInicioAlumno(){
		this.getContentPane().removeAll();
		
		Dimension d = new Dimension();
		d.setSize(700, 500);		
		
		InicioAlumno inicio = new InicioAlumno();
		inicio.addListener(new InicioAlumnoListener(inicio, this));
		
		this.getContentPane().add(inicio);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(d);
		this.repaint();
	}
	
}
