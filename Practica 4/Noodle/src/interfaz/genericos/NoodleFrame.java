package interfaz.genericos;

import java.awt.Component;
import java.awt.Dimension;
import java.util.Iterator;

import javax.swing.*;

import asignatura.Asignatura;
import contenido.*;
import interfaz.asignatura.*;
import interfaz.asignatura.asignaturaGUI.AsignaturaGUI;
import interfaz.asignatura.asignaturaGUI.AsignaturaNoMatriculada;
import interfaz.asignatura.asignaturaGUI.estadisticas.Estadisticas;
import interfaz.asignatura.contenido.apuntes.ApuntesGUI;
import interfaz.asignatura.contenido.apuntes.ApuntesListener;
import interfaz.asignatura.contenido.apuntes.SubirApuntes;
import interfaz.asignatura.contenido.ejercicio.EjercicioGUI;
import interfaz.asignatura.contenido.ejercicio.ElegirTipoPregunta;
import interfaz.asignatura.contenido.ejercicio.PreguntaMultiple;
import interfaz.asignatura.contenido.ejercicio.PreguntaUnica;
import interfaz.inicios.*;
import interfaz.login.*;
import interfaz.solicitudes.*;
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
	private SolicitudesAlumno solicitudesAlumno = null;
	private NuestroPanel actual = null;
	private SolicitudesProfesor solicitudesProfesor = null;
	private AsignaturaGUI asignaturaGUI = null;
	private AsignaturaNoMatriculada asignaturaNoMatriculada = null;
	private ApuntesGUI apuntesGUI = null;
	private SubirApuntes subirApuntes = null;
	private AlumnosAsignatura alumnosAsignatura = null;
	private EjercicioGUI ejercicioGUI = null;
	private ElegirTipoPregunta elegirTipoPregunta;
	private Estadisticas estadisticas;
	private SolicitudesExpulsados solicitudesExpulsados;
	private PreguntaUnica preguntaUnica;
	private PreguntaMultiple preguntaMultiple;
//	private PreguntaSimpleGUI preguntaSimpleGUI;

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
//		
//		//--------------------
//		Plataforma.login("1", "contraseniaprofe");
//		Asignatura nacho = new Asignatura("Nacho");
//		Plataforma.addAsignatura(nacho);
//		Tema tema1 = new Tema("Tema 1", true, nacho);
//		Ejercicio ej = new Ejercicio(1, true, Plataforma.getFechaActual().plusDays(0), Plataforma.getFechaActual().plusDays(1), tema1,"Ejercicio1", true, nacho);
//		ej.addPregunta(new PreguntaRespuestaSimple("2 y 2 son 10", true, 1, true));
//		ej.addPregunta(new PreguntaRespuestaSimple("2 y 2 son 5", true, 1, true));
//		ej.addPregunta(new PreguntaRespuestaSimple("2 y 2 son 6", true, 1, true));
//		ej.addPregunta(new PreguntaRespuestaSimple("2 y 2 son 7", true, 1, true));
//		ej.addPregunta(new PreguntaRespuestaSimple("2 y 2 son 4", true, 1, true));
//		ej.addPregunta(new PreguntaRespuestaSimple("2 y 2 son 4", true, 1, true));
//		ej.addPregunta(new PreguntaRespuestaSimple("2 y 2 son 4", true, 1, true));
//		ej.addPregunta(new PreguntaRespuestaSimple("2 y 2 son 4", true, 1, true));
//		ej.addPregunta(new PreguntaRespuestaSimple("2 y 2 son 1", true, 1, true));
//		
//		Plataforma.logout();
//		
////		this.showPanelLogin();
//		this.showEjercicioGUI(false, ej, tema1);
//		//--------------------
	
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
	 * Método para mostrar una asignatura
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
		
//		this.asignaturaGUI = new AsignaturaGUI(anterior, this, asignatura);
		
		this.getContentPane().add(this.asignaturaGUI);
		
		this.fin(700,500, this.asignaturaGUI);
		
	}

	/**
	 * Método para mostrar las solicitudes de un profesor
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
	 * Método a llamar antes de cualquier show
	 * @return
	 */
	private NuestroPanel ini(){
		
		NuestroPanel anterior = null;
		if(this.getContentPane().getComponentCount() != 0){
			anterior = (NuestroPanel) this.getContentPane().getComponent(0);
			this.getContentPane().removeAll();
		}
		return anterior;
	}
	
	/**
	 * Método a llamar después de cualquier show
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
	
	/**
	 * Método para mostrar el panel de Apuntes
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
	 * Método para mostrar el panel de subir apuntes
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
			this.subirApuntes.refreshPanel(asignatura, tema, apuntes);
			this.subirApuntes.addListener(new ApuntesListener(this.subirApuntes.getForm(), this));
		}
		
		this.getContentPane().add(this.subirApuntes);
		
		this.fin(700,500, this.subirApuntes);
	}
	
	/**
	 * Metodo para obtener la instancia del frame estatico
	 * @return
	 */
	public static NoodleFrame getInstance(){
		return NoodleFrame.frame;
	}
	
	/**
	 * Muestra el Panel Lista de Asignaturas
	 * @param back, true si se quiere guardar el panel anterior
	 */
	public void showAlumnosAsignatura(boolean back, Asignatura asignatura){
		
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		if(this.alumnosAsignatura == null){
			this.alumnosAsignatura = new AlumnosAsignatura(anterior, this, asignatura);
		}
		else{
			this.alumnosAsignatura.setAnterior(anterior);
		}
		this.alumnosAsignatura.refreshPanel();
		
		this.getContentPane().add(this.alumnosAsignatura);
		
		this.fin(700,500, this.alumnosAsignatura);
	}
	
	/**
	 * Muestra el Panel de ejercicio
	 * @param back, true si se quiere guardar el panel anterior
	 * @param ejercicio
	 */
	public void showEjercicioGUI(boolean back, Ejercicio ejercicio, Tema tema){
		
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		
		if(this.ejercicioGUI == null){
			this.ejercicioGUI = new EjercicioGUI(anterior, this, ejercicio, tema);
		}
		else{
			this.ejercicioGUI.setTema(tema);
			this.ejercicioGUI.setEjercicio(ejercicio);
			this.ejercicioGUI.refreshPanel();
			this.ejercicioGUI.setAnterior(anterior);
		}
		//this.ejercicioGUI.refreshPanel();
		
		this.getContentPane().add(this.ejercicioGUI);
		
		this.fin(700,500, this.ejercicioGUI);
	}
	
	/**
	 * Muestra el Panel para elegir el tipo de preguntas
	 * @param back
	 * @param ejercicio
	 */
	public void showElegirTipoPregunta(boolean back, Ejercicio ejercicio){
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		if(this.elegirTipoPregunta == null){
			this.elegirTipoPregunta = new ElegirTipoPregunta(anterior, this, ejercicio);
		}
		else{
			this.elegirTipoPregunta.setAnterior(anterior);
		}
		//this.ejercicioGUI.refreshPanel();
		
		this.getContentPane().add(this.elegirTipoPregunta);
		
		this.fin(700,500, this.elegirTipoPregunta);
	}
	
	/**
	 * Muestra el panel de las estadisticas de un alumno
	 * @param back
	 * @param al
	 * @param asig
	 */
	public void showEstadisticas(boolean back, Alumno al, Asignatura asig){
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		if(this.estadisticas == null){
			this.estadisticas = new Estadisticas(anterior, this, al, asig);
		}
		else{
			this.estadisticas.setAnterior(anterior);
		}
		//this.ejercicioGUI.refreshPanel();
		
		this.getContentPane().add(this.estadisticas);
		
		this.fin(700,500, this.estadisticas);
	}

	/**Muestra el panel con todos los alumnos expulsados
	 * @param asig
	 */
	public void showExpulsados(boolean back, Asignatura asig) {

		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		if(this.solicitudesExpulsados == null){
			this.solicitudesExpulsados = new SolicitudesExpulsados(anterior, this, asig);			
		}
		else{
			this.solicitudesExpulsados.setAnterior(anterior);
		}
		
		this.solicitudesExpulsados.refreshPanel(asig);
		
		this.getContentPane().add(this.solicitudesExpulsados);
		
		this.fin(700,500, this.solicitudesExpulsados);
		
	}
	
	/**
	 * Método que muestra PreguntaUnica
	 * @param back
	 * @param ejercicio
	 * @param pregunta
	 */
	public void showPreguntaUnica(boolean back, Ejercicio ejercicio, Pregunta pregunta){
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		if(this.preguntaUnica == null){
			this.preguntaUnica = new PreguntaUnica(anterior, this, ejercicio, pregunta);			
		}
		else{
			this.preguntaUnica.setAnterior(anterior);
			this.preguntaUnica.refreshPanel(pregunta, ejercicio);
		}
		
		
		this.getContentPane().add(this.preguntaUnica);
		
		this.fin(700,500, this.preguntaUnica);
	}
	
	/**
	 * Método que muestra PreguntaUnica
	 * @param back
	 * @param ejercicio
	 * @param pregunta
	 */
	public void showPreguntaMultiple(boolean back, Ejercicio ejercicio, Pregunta pregunta){
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		if(this.preguntaMultiple == null){
			this.preguntaMultiple = new PreguntaMultiple(anterior, this, ejercicio, pregunta);			
		}
		else{
			this.preguntaMultiple.setAnterior(anterior);
			this.preguntaMultiple.refreshPanel(pregunta, ejercicio);
		}
		
		
		this.getContentPane().add(this.preguntaMultiple);
		
		this.fin(700,500, this.preguntaMultiple);
	}
	
}
