package interfaz;

import java.awt.Dimension;

import javax.swing.*;

import listeners.*;
import plataforma.Plataforma;

/**
 * Clase NoodleFrame
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 20/04/2017
 */
public class NoodleFrame extends JFrame{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Variables para patron singleton;
	 */
	private PanelLogin login = null;
	private InicioAlumno inicioAlumno = null;
	
	/**
	 * Constructor de NoodleFrame
	 */
	public NoodleFrame(){
		super("Noodle");
		Plataforma.openPlataforma();
		showPanelLogin();
		//this.showInicioAlumno();
	}
	
	/**
	 * Muestra el Panel de login
	 */
	public void showPanelLogin(){
		
		NuestroPanel anterior = null; //this.ini();
		
		Dimension d = new Dimension();
		d.setSize(700, 500);		
		
		if(this.login == null){
			this.login = new PanelLogin(anterior, this);
			this.login.addListener(new LoginListener(this.login, this));
		}
		else{
			this.login.setAnterior(anterior);
		}
		
		this.getContentPane().add(this.login);

		this.fin(d);
		
	}
	
	/**
	 * Muestra el Panel de Inicio del Alumno
	 */
	public void showInicioAlumno(){
		
		NuestroPanel anterior = null; //this.ini();
		
		Dimension d = new Dimension();
		d.setSize(700, 500);		
		
		if(this.inicioAlumno == null){
			this.inicioAlumno = new InicioAlumno(anterior, this);
			this.inicioAlumno.addListener(new InicioAlumnoListener(this.inicioAlumno, this));
		}
		else{
			this.inicioAlumno.setAnterior(anterior);
		}
		
		this.getContentPane().add(this.inicioAlumno);
		
		this.fin(d);
	}
	
	/**
	 * Método a llamar antes de cualquier show
	 * @return
	 */
	private NuestroPanel ini(){
		NuestroPanel anterior = (NuestroPanel) this.getContentPane().getComponent(0);
		this.getContentPane().removeAll();
		return anterior;
	}
	
	/**
	 * Método a llamar después de cualquier show
	 * @param d
	 */
	private void fin(Dimension d){
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(d);
		this.repaint();
	}
	
}
