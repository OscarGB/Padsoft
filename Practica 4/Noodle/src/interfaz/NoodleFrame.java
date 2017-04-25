package interfaz;

import java.awt.Dimension;

import javax.swing.*;

import listeners.*;
import persona.Alumno;
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
	private InicioProfesor inicioProfesor = null;
	private ListaAsignaturas listaAsignaturas = null;
	private AsignaturaAlumno asignaturaAlumno = null;
	private Menu menu = null;
	
	/**
	 * Constructor de NoodleFrame
	 */
	public NoodleFrame(){
		super("Noodle");
		Plataforma.openPlataforma();
//		this.showPanelLogin();
		this.showInicioAlumno();
		//this.showListaAsignaturas();
	}
	
	/**
	 * Muestra el Panel de login
	 */
	public void showPanelLogin(){
		
		NuestroPanel anterior = null;
		
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
		
		NuestroPanel anterior = this.ini();
		
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
	 * Muestra el Panel de Inicio del Profesor
	 */
	public void showInicioProfesor(){
		
		NuestroPanel anterior = this.ini();
		
		Dimension d = new Dimension();
		d.setSize(700, 500);		
		
		if(this.inicioProfesor == null){
			this.inicioProfesor = new InicioProfesor(anterior, this);
			this.inicioProfesor.addListener(new InicioProfesorListener(this.inicioProfesor, this));
		}
		else{
			this.inicioProfesor.setAnterior(anterior);
		}
		
		this.getContentPane().add(this.inicioProfesor);
		
		this.fin(d);
	}
	
	/**
	 * Muestra el Panel Lista de Asignaturas
	 */
	public void showListaAsignaturas(){
		
		NuestroPanel anterior = this.ini();
		
		Dimension d = new Dimension();
		d.setSize(700, 500);		
		
		if(this.listaAsignaturas == null){
			this.listaAsignaturas = new ListaAsignaturas(anterior, this);
			if(Plataforma.loggedAs() instanceof Alumno){
				this.listaAsignaturas.addListener(new ListaAsignaturasAlumnoListener(this.listaAsignaturas, this));
			}
			else{
				this.listaAsignaturas.addListener(new ListaAsignaturasProfesorListener(this.listaAsignaturas, this));
			}
		}
		else{
			this.listaAsignaturas.setAnterior(anterior);
		}
		
		this.getContentPane().add(this.listaAsignaturas);
		
		this.fin(d);
	}
	
	/**
	 * Muestra el Panel Asignatura Alumno
	 */
	public void showAsignaturaAlumno(){
		
		NuestroPanel anterior = this.ini();
		
		Dimension d = new Dimension();
		d.setSize(700, 500);		
		
		if(this.asignaturaAlumno == null){
			this.asignaturaAlumno = new AsignaturaAlumno(anterior, this);
			this.asignaturaAlumno.addListener(new AsignaturaAlumnoListener(this.listaAsignaturas, this));
			
		}
		else{
			this.asignaturaAlumno.setAnterior(anterior);
		}
		
		this.getContentPane().add(this.asignaturaAlumno);
		
		this.fin(d);
	}
	
	/**
	 * Método a llamar antes de cualquier show
	 * @return
	 */
	private NuestroPanel ini(){
		
		return null;
		
		
		
		
//		NuestroPanel anterior = (NuestroPanel) this.getContentPane().getComponent(0);
//		this.getContentPane().removeAll();
//		this.getContentPane().add(this.menu);ç
		
//		return anterior;
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
