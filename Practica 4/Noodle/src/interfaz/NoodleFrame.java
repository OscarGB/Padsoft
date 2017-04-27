package interfaz;

import java.awt.Dimension;

import javax.swing.*;

import asignatura.Asignatura;
import contenido.Ejercicio;
import contenido.Tema;
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
	private InicioProfesor inicioProfesor = null;
	private ListaAsignaturas listaAsignaturas = null;
	private SolicitudesAlumno solicitudesAlumno = null;
	private NuestroPanel actual = null;
	private SolicitudesProfesor solicitudesProfesor = null;
	private AsignaturaGUI asignaturaGUI = null;
	private AsignaturaNoMatriculada asignaturaNoMatriculada = null;
	
	/**
	 * Constructor de NoodleFrame
	 */
	public NoodleFrame(){
		super("Noodle");
		Plataforma.openPlataforma();
		Plataforma.logout();
		this.showPanelLogin();
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
		if(back == false){
			anterior = null;
		}
		
		if(this.inicioAlumno == null){
			this.inicioAlumno = new InicioAlumno(anterior, this);
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
		}
		else{
			this.listaAsignaturas.setAnterior(anterior);
		}
		this.listaAsignaturas.refreshPanel();
		
		this.getContentPane().add(this.listaAsignaturas);
		
		this.fin(700,500, this.listaAsignaturas);
	}

	/**
	 * Método para realizar el logout
	 */
	public void logout() {
		
		login = null;
		inicioAlumno = null;
		inicioProfesor = null;
		listaAsignaturas = null;
		solicitudesAlumno = null;
		actual = null;
		solicitudesProfesor = null;
		asignaturaGUI = null;
		asignaturaNoMatriculada = null;
		
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
		if(this.solicitudesAlumno == null){
			this.solicitudesAlumno = new SolicitudesAlumno(anterior, this);			
		}
		else{
			this.solicitudesAlumno.setAnterior(anterior);
		}
		this.solicitudesAlumno.refreshPanel();
		
		this.getContentPane().add(this.solicitudesAlumno);
		
		this.fin(700,500, this.solicitudesAlumno);
		
	}
	
	/**
	 * Método para mostrar una asignatura
	 * @param back, false si se quiere guardar el panel anterior
	 * @param asignatura a mostrar
	 */
	public void showAsignatura(boolean back, Asignatura asignatura) {
		
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		if(this.asignaturaGUI == null){
			this.asignaturaGUI = new AsignaturaGUI(anterior, this, asignatura);
			//Añadir Listener??
			
		}
		else{
			this.asignaturaGUI.setAnterior(anterior);
			this.asignaturaGUI.refreshPanel(asignatura);
		}
		
		this.getContentPane().add(this.asignaturaGUI);
		
		this.fin(700,500, this.asignaturaGUI);
		
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
		if(this.solicitudesProfesor == null){
			this.solicitudesProfesor = new SolicitudesProfesor(anterior, this);			
		}
		else{
			this.solicitudesProfesor.setAnterior(anterior);
		}
		
		this.solicitudesProfesor.refreshPanel();
		
		this.getContentPane().add(this.solicitudesProfesor);
		
		this.fin(700,500, this.solicitudesProfesor);
		
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

	/**
	 * Método para mostrar el panel si no está matriculado en esa asignatura
	 * @param back
	 * @param asig
	 */
	public void showAsignaturaNoMatriculada(boolean back, Asignatura asig) {
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		if(this.asignaturaNoMatriculada == null){
			this.asignaturaNoMatriculada = new AsignaturaNoMatriculada(anterior, this, asig);
		}
		else{
			this.asignaturaNoMatriculada.setAnterior(anterior);
			this.asignaturaNoMatriculada.refreshPanel(asig);
		}
		
		this.getContentPane().add(this.asignaturaNoMatriculada);
		
		this.fin(700,500, this.asignaturaNoMatriculada);
	}
	
}
