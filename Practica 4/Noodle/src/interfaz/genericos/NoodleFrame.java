package interfaz.genericos;

import java.awt.Dimension;

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
import interfaz.asignatura.contenido.ejercicio.consultarRespuestas.ConsultarRespuestas;
import interfaz.asignatura.contenido.ejercicio.consultarRespuestas.EstPregunta;
import interfaz.asignatura.contenido.ejercicio.creacionEjercicio.EjercicioGUI;
import interfaz.asignatura.contenido.ejercicio.creacionEjercicio.ElegirTipoPregunta;
import interfaz.asignatura.contenido.ejercicio.creacionPreguntas.PreguntaAbierta;
import interfaz.asignatura.contenido.ejercicio.creacionPreguntas.PreguntaMultiple;
import interfaz.asignatura.contenido.ejercicio.creacionPreguntas.PreguntaSimple;
import interfaz.asignatura.contenido.ejercicio.creacionPreguntas.PreguntaUnica;
import interfaz.asignatura.contenido.ejercicio.resolucionEjercicio.ResolverEjercicioGUI;
import interfaz.asignatura.contenido.ejercicio.resolucionPreguntas.ResponderPreguntaAbierta;
import interfaz.asignatura.contenido.ejercicio.resolucionPreguntas.ResponderPreguntaMultiple;
import interfaz.asignatura.contenido.ejercicio.resolucionPreguntas.ResponderPreguntaSimple;
import interfaz.asignatura.contenido.ejercicio.resolucionPreguntas.ResponderPreguntaUnica;
import interfaz.inicios.*;
import interfaz.login.*;
import interfaz.solicitudes.*;
import persona.Alumno;
import plataforma.Plataforma;
import respuestas.RespuestaEjercicio;
import respuestas.RespuestaPregunta;

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
	private ElegirTipoPregunta elegirTipoPregunta = null;
	private Estadisticas estadisticas = null;
	private SolicitudesExpulsados solicitudesExpulsados = null;
	private PreguntaUnica preguntaUnica = null;
	private PreguntaMultiple preguntaMultiple = null;
	private PreguntaAbierta preguntaAbierta = null;
	private PreguntaSimple preguntaSimple = null;
	private ResolverEjercicioGUI resolverEjercicioGUI = null;
	private ResponderPreguntaSimple responderPreguntaSimple = null;
	private ResponderPreguntaAbierta responderPreguntaAbierta = null;
	private ResponderPreguntaUnica responderPreguntaUnica = null;
	private ResponderPreguntaMultiple responderPreguntaMultiple = null;
	private ConsultarRespuestas consultarRespuestas = null;
	private EstPregunta estPreguntaUnica = null;

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
	}
	
	/**
	 * Getter de asignaturaGUI
	 * @return
	 */
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
	 * @param apuntes
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
	 * @param asignatura
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
	 * @param tema
	 */
	public void showEjercicioGUI(boolean back, Ejercicio ejercicio, Tema tema){
		
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = this.ejercicioGUI.getAnterior();
		}
		this.ejercicioGUI = new EjercicioGUI(anterior, this, ejercicio, tema);
		
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
			this.elegirTipoPregunta.refreshPanel(ejercicio);
		}
		
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
		
		this.getContentPane().add(this.estadisticas);
		
		this.fin(700,500, this.estadisticas);
	}

	/**Muestra el panel con todos los alumnos expulsados
	 * @param back
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
	 * Método que muestra PreguntaMultiple
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
	
	/**
	 * Método que muestra PreguntaAbierta
	 * @param back
	 * @param ejercicio
	 * @param pregunta
	 */
	public void showPreguntaAbierta(boolean back, Ejercicio ejercicio, Pregunta pregunta){
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		if(this.preguntaAbierta == null){
			this.preguntaAbierta = new PreguntaAbierta(anterior, this, ejercicio, pregunta);			
		}
		else{
			this.preguntaAbierta.setAnterior(anterior);
			this.preguntaAbierta.refreshPanel(pregunta, ejercicio);
		}
		
		
		this.getContentPane().add(this.preguntaAbierta);
		
		this.fin(700,500, this.preguntaAbierta);
	}
	
	/**
	 * Método que muestra PreguntaSimple
	 * @param back
	 * @param ejercicio
	 * @param pregunta
	 */
	public void showPreguntaSimple(boolean back, Ejercicio ejercicio, Pregunta pregunta){
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		if(this.preguntaSimple == null){
			this.preguntaSimple = new PreguntaSimple(anterior, this, ejercicio, pregunta);			
		}
		else{
			this.preguntaSimple.setAnterior(anterior);
			this.preguntaSimple.refreshPanel(pregunta, ejercicio);
		}
		
		
		this.getContentPane().add(this.preguntaSimple);
		
		this.fin(700,500, this.preguntaSimple);
	}

	/**
	 * Enseña el panel para resolver el ejercicio
	 * @param back
	 * @param ejercicio
	 * @param tema
	 */
	public void showResolverEjercicioGUI(boolean back, Ejercicio ejercicio, Tema tema) {
		
		if(ejercicio.getEstado().equals(EstadoEjercicio.ESPERA)){
			JOptionPane.showMessageDialog(null, "El ejercicio aun no ha sido abierto", "Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if(ejercicio.getEstado().equals(EstadoEjercicio.TERMINADO)){
			//TODO ir a las respuestas
			System.out.println("Respuestas");
			return;
		}else if(((Alumno)Plataforma.loggedAs()).haRespondidoA(ejercicio)){
			JOptionPane.showMessageDialog(null, "Ya has respondido a este ejercicio", "Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = this.resolverEjercicioGUI.getAnterior();
		}
		if(this.resolverEjercicioGUI == null){
			this.resolverEjercicioGUI = new ResolverEjercicioGUI(anterior, this, ejercicio, tema);
		}
		
		this.getContentPane().add(this.resolverEjercicioGUI);
		
		this.fin(700,500, this.resolverEjercicioGUI);
		
	}
	
	/**
	 * Método que se llamará al responder un ejercicio, forzará la creación de un nuevo panel
	 */
	public void responderOCancelarEjercicio(){
		this.resolverEjercicioGUI = null;
	}
	
	/**
	 * Método que muestra ResponderPreguntaSimple
	 * @param back
	 * @param ejercicio
	 * @param pregunta
	 */
	public void showResponderPreguntaSimple(boolean back, Ejercicio ejercicio, Pregunta pregunta){
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		
		this.responderPreguntaSimple = new ResponderPreguntaSimple(anterior, this, (PreguntaRespuestaSimple)pregunta, ejercicio);
		
		this.getContentPane().add(this.responderPreguntaSimple);
		
		this.fin(700,500, this.responderPreguntaSimple);
	}
	
	/**
	 * Método que muestra ResponderPreguntaMultiple
	 * @param back
	 * @param ejercicio
	 * @param pregunta
	 */
	public void showResponderPreguntaMultiple(boolean back, Ejercicio ejercicio, Pregunta pregunta){
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		
		this.responderPreguntaMultiple = new ResponderPreguntaMultiple(anterior, this, (PreguntaRespuestaMultiple)pregunta, ejercicio);		
		
		this.getContentPane().add(this.responderPreguntaMultiple);
		
		this.fin(700,500, this.responderPreguntaMultiple);
	}
	
	/**
	 * Método que muestra ResponderPreguntaUnica
	 * @param back
	 * @param ejercicio
	 * @param pregunta
	 */
	public void showResponderPreguntaUnica(boolean back, Ejercicio ejercicio, Pregunta pregunta){
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		
		this.responderPreguntaUnica = new ResponderPreguntaUnica(anterior, this, (PreguntaRespuestaUnica)pregunta, ejercicio);	
		
		this.getContentPane().add(this.responderPreguntaUnica);
		
		this.fin(700,500, this.responderPreguntaUnica);
	}
	
	/**
	 * Método que muestra ResponderPreguntaAbierta
	 * @param back
	 * @param ejercicio
	 * @param pregunta
	 */
	public void showResponderPreguntaAbierta(boolean back, Ejercicio ejercicio, Pregunta pregunta){
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = null;
		}
		
		this.responderPreguntaAbierta = new ResponderPreguntaAbierta(anterior, this, (PreguntaRespuestaAbierta)pregunta, ejercicio);
		
		this.getContentPane().add(this.responderPreguntaAbierta);
		
		this.fin(700,500, this.responderPreguntaAbierta);
	}
	
	/**
	 * Muestra el Panel del ejercicio con las respuestas
	 * @param back, true si se quiere guardar el panel anterior
	 * @param respuesta
	 * @param alumno
	 */
	public void showConsultarRespuestas(boolean back, RespuestaEjercicio respuesta, Alumno alumno){
		
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = this.consultarRespuestas.getAnterior();
		}
		this.consultarRespuestas = new ConsultarRespuestas(anterior, this, respuesta, alumno);
		
		this.getContentPane().add(this.consultarRespuestas);
		
		this.fin(700,500, this.consultarRespuestas);
	}

	public void showEstPreguntaUnica(boolean back, RespuestaPregunta respuesta, Ejercicio ejercicio) {
		
		NuestroPanel anterior = this.ini();
		if(back == false){
			anterior = this.estPreguntaUnica.getAnterior();
		}
		this.estPreguntaUnica = new EstPregunta(anterior, this, respuesta, ejercicio);
		
		this.getContentPane().add(this.estPreguntaUnica);
		
		this.fin(700,500, this.estPreguntaUnica);
		
	}
	
}
