package interfaz.genericos;

import java.awt.Dimension;

import javax.swing.*;

import asignatura.Asignatura;
import contenido.Apuntes;
import contenido.Ejercicio;
import contenido.Tema;
import interfaz.asignatura.ApuntesGUI;
import interfaz.asignatura.ApuntesListener;
import interfaz.asignatura.AsignaturaGUI;
import interfaz.asignatura.AsignaturaNoMatriculada;
import interfaz.asignatura.ListaAsignaturas;
import interfaz.asignatura.SubirApuntes;
import interfaz.inicios.InicioAlumno;
import interfaz.inicios.InicioProfesor;
import interfaz.login.LoginListener;
import interfaz.login.PanelLogin;
import interfaz.solicitudes.SolicitudesAlumno;
import interfaz.solicitudes.SolicitudesProfesor;
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
	private ApuntesGUI apuntesGUI = null;
	private SubirApuntes subirApuntes = null;
	
	private static NoodleFrame frame;
	
	/**
	 * Constructor de NoodleFrame
	 */
	public NoodleFrame(){
		super("Noodle");
		NoodleFrame.frame = this;
		Plataforma.openPlataforma();
		Plataforma.logout();
		this.showPanelLogin();
//		Asignatura asignatura = new Asignatura("Mates");
//		this.showSubirApuntes(true, asignatura, null);
		
//		//-----------------
// 		Plataforma.login("1", "contraseniaprofe");
// 		
// 		//Contenidos para probar el treecontent
// 		
// 		Asignatura asignatura = new Asignatura("Mates");
// 	
// 		Tema tema1 = new Tema("Tema 1", true, asignatura);
// 		Tema tema11 = new Tema("Tema 11", true, asignatura, tema1);
// 		Tema tema111 = new Tema("Tema 111", true, asignatura, tema11);
// 		System.out.println(tema1.getSubcontenido());
// 		Tema tema2 = new Tema("Tema 2", true, asignatura);
// 		Tema tema3 = new Tema("Tema 3", true, asignatura);
// 		Ejercicio ej1 = new Ejercicio(1, true, Plataforma.getFechaActual().minusDays(0), Plataforma.getFechaActual().plusDays(4), tema2,"ej1", true, asignatura);
// 		Apuntes ap1 = new Apuntes("Apuntes muy bonitos de prueba", "Apuntes 1", true, asignatura, tema3);
// 		new Apuntes("Prueba", "Auntes 2", true, asignatura, tema2);
//// 		Plataforma.logout();
//// 		Plataforma.login("9113", "idPrieto");
// 		//------------------
// 		this.showAsignatura(true, asignatura);
	}
	
	public AsignaturaGUI getAsignaturaGUI(){
		return this.asignaturaGUI;
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
	 * @param back, true si se quiere guardar el panel anterior
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
	 * @param back, true si se quiere guardar el panel anterior
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
	 * @param back, true si se quiere guardar el panel anterior
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
	 * M�todo para realizar el logout
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
	 * M�todo para mostrar las solicitudes de un alumno
	 * @param back, true si se quiere guardar el panel anterior
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
	 * M�todo para mostrar una asignatura
	 * @param back, true si se quiere guardar el panel anterior
	 * @param asignatura a mostrar
	 */
	public void showAsignatura(boolean back, Asignatura asignatura) {
		
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		if(this.asignaturaGUI == null){
			this.asignaturaGUI = new AsignaturaGUI(anterior, this, asignatura);
		}
		else{
			this.asignaturaGUI.refreshPanel(asignatura);
			this.asignaturaGUI.setAnterior(anterior);
		}
		
		this.getContentPane().add(this.asignaturaGUI);
		
		this.fin(700,500, this.asignaturaGUI);
		
	}

	/**
	 * M�todo para mostrar las solicitudes de un profesor
	 * @param back, true si se quiere guardar el panel anterior
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
	 * M�todo a llamar antes de cualquier show
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
	 * M�todo a llamar despu�s de cualquier show
	 * @param a
	 * @param b
	 * @param actual
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
	 * Funci�n para volver atr�s en la aplicaci�n
	 */
	public void atras(){
		System.out.println(this.actual.getAnterior());
		if(this.actual == null){
			return;
		}
		if(this.actual.getAnterior() == null){
			return;
		}
		this.actual.getAnterior().muestraPanel();
	}

	/**
	 * M�todo para mostrar el panel si no est� matriculado en esa asignatura
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
	
	/**
	 * M�todo para mostrar el panel de Apuntes
	 * @param back
	 * @param apuntes
	 */
	public void showApuntes(boolean back, Apuntes apuntes) {
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		if(this.apuntesGUI == null){
			this.apuntesGUI = new ApuntesGUI(anterior, this, apuntes);
		}
		else{
			this.apuntesGUI.setAnterior(anterior);
			this.apuntesGUI.refreshPanel(apuntes);
		}
		
		this.getContentPane().add(this.apuntesGUI);
		
		this.fin(700,500, this.apuntesGUI);
	}
	
	/**
	 * M�todo para mostrar el panel de subir apuntes
	 * @param back
	 * @param asignatura
	 * @param tema
	 */
	public void showSubirApuntes(boolean back, Asignatura asignatura, Tema tema, Apuntes apuntes) {
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		if(this.subirApuntes == null){
			this.subirApuntes = new SubirApuntes(anterior, this, asignatura, tema, apuntes);
			this.subirApuntes.addListener(new ApuntesListener(this.subirApuntes.getForm(), this));
		}
		else{
			this.subirApuntes.setAnterior(anterior);
		}
		
		this.getContentPane().add(this.subirApuntes);
		
		this.fin(700,500, this.subirApuntes);
	}
	
	public static NoodleFrame getInstance(){
		return NoodleFrame.frame;
	}
	
}
