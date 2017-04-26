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
	private NuestroPanel actual = null;
	
	/**
	 * Constructor de NoodleFrame
	 */
	public NoodleFrame(){
		super("Noodle");
		Plataforma.openPlataforma();

		this.showPanelLogin();
		//this.showInicioAlumno();
		//this.showListaAsignaturas();
	}
	
	/**
	 * Muestra el Panel de login
	 */
	public void showPanelLogin(){
		NuestroPanel anterior = ini();
		
		if(this.login == null){
			this.login = new PanelLogin(anterior, this);
			this.login.addListener(new LoginListener(this.login, this));
		}
		else{
			this.login.setAnterior(anterior);
		}
		
		this.getContentPane().add(this.login);

		this.fin(700,500, this.login);
		
	}
	
	/**
	 * Muestra el Panel de Inicio del Alumno
	 * @param back, false si se quiere guardar el panel anterior
	 */
	public void showInicioAlumno(boolean back){
		
		NuestroPanel anterior = this.ini();
		System.out.println(anterior +"" + back);
		if(back == false){
			anterior = null;
		}
		
		if(this.inicioAlumno == null){
			this.inicioAlumno = new InicioAlumno(anterior, this);
			this.inicioAlumno.addListener(new InicioAlumnoListener(this.inicioAlumno, this));
		}
		else{
			this.inicioAlumno.setAnterior(anterior);
		}
		
		this.getContentPane().add(this.inicioAlumno);
		
		this.fin(700,500, this.inicioAlumno);
	}
	
	/**
	 * Muestra el Panel de Inicio del Profesor
	 * @param back, false si se quiere guardar el panel anterior
	 */
	public void showInicioProfesor(boolean back){
		
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		
		if(this.inicioProfesor == null){
			this.inicioProfesor = new InicioProfesor(anterior, this);
			this.inicioProfesor.addListener(new InicioProfesorListener(this.inicioProfesor, this));
		}
		else{
			this.inicioProfesor.setAnterior(anterior);
		}
		
		this.getContentPane().add(this.inicioProfesor);
		
		this.fin(700,500, this.inicioProfesor);
	}
	
	/**
	 * Muestra el Panel Lista de Asignaturas
	 * @param back, false si se quiere guardar el panel anterior
	 */
	public void showListaAsignaturas(boolean back){
		
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
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
		
		this.fin(700,500, this.listaAsignaturas);
	}
	
	/**
	 * Muestra el Panel Asignatura Alumno
	 * @param back, false si se quiere guardar el panel anterior
	 */
	public void showAsignaturaAlumno(boolean back){
		
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		if(this.asignaturaAlumno == null){
			this.asignaturaAlumno = new AsignaturaAlumno(anterior, this);
			this.asignaturaAlumno.addListener(new AsignaturaAlumnoListener(this.listaAsignaturas, this));
			
		}
		else{
			this.asignaturaAlumno.setAnterior(anterior);
		}
		
		this.getContentPane().add(this.asignaturaAlumno);
		
		this.fin(700,500, this.asignaturaAlumno);
	}

	/**
	 * Método para realizar el logout
	 */
	public void logout() {
		
		ini();
		Plataforma.logout();
		
		this.showPanelLogin();
		
		
	}

	/**
	 * Método para mostrar las solicitudes de un alumno
	 * @param back, false si se quiere guardar el panel anterior
	 */
	public void showSolicitudesAlumno(boolean back) {
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		// TODO Auto-generated method stub
		
	}

	/**
	 * Método para mostrar las solicitudes de un profesor
	 * @param back, false si se quiere guardar el panel anterior
	 */
	public void showSolicitudesProfesor(boolean back) {
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		// TODO Auto-generated method stub
		
	}

	/**
	 * Método para mostrar las asignaturas
	 * @param back, false si se quiere guardar el panel anterior
	 */
	public void showAsignaturas(boolean back) {
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Método a llamar antes de cualquier show
	 * @return
	 */
	private NuestroPanel ini(){
		
		//return null;
		NuestroPanel anterior = null;
		if(this.getContentPane().getComponentCount() != 0){
			anterior = (NuestroPanel) this.getContentPane().getComponent(0);
			this.getContentPane().removeAll();
		}
//		return null;
		return anterior;
	}
	
	/**
	 * Método a llamar después de cualquier show
	 * @param a
	 * @param b
	 */
	private void fin(int a, int b, NuestroPanel actual){
		Dimension d = new Dimension();
		d.setSize(a,b);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(d);
		this.repaint();
		this.actual = actual;
	}

	/**
	 * Función para volver atrás en la aplicación
	 */
	public void atras(){
		if(this.actual == null){
			return;
		}
		if(this.actual.getAnterior() == null){
			return;
		}
		this.actual.getAnterior().muestraPanel();
	}
	
}
