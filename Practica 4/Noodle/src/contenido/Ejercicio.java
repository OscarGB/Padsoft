package contenido;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import asignatura.Asignatura;
import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import estadisticas.EstadisticasAlumno;
import persona.Alumno;
import persona.Profesor;
import plataforma.Plataforma;
import respuestas.RespuestaEjercicio;
import respuestas.RespuestaPregunta;

/**
 * Clase Ejercicio
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 08/03/2017
 */
public class Ejercicio extends Contenido implements Serializable{
	//Variables
	
	/**
	 * Estado del ejercicio (enum)
	 */
	private EstadoEjercicio estado;
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Peso por defecto de un ejercicio
	 */
	private static final int PESO_DEFECTO = 1;
	
	/**
	 * N�mero de alumnos que han terminado el ejercicio
	 */
	private int numTerminados;
	
	/**
	 * Peso del ejercicio en la asignatura
	 */
	private int peso;
	
	/**
	 * Peso total de las preguntas
	 */
	private int pesoPreguntas;
	
	/**
	 * Flag de aleatoriedad para las preguntas
	 */
	private boolean aleatorio;
	
	/**
	 * Fecha de apertura del ejercicio
	 */
	private LocalDate fechaIni;
	
	/**
	 * Fecha de cierre del ejercicio
	 */
	private LocalDate fechaFin;
	
	/**
	 * Array de preguntas del ejercicio
	 */
	private ArrayList<Pregunta> preguntas;
	
	//Estadisticas
	/**
	 * Nota media de todos los alumnos que han respondido
	 */
	private float notaMedia;
	
	//Constructores

	/**
	 * Constructor de Ejercicio en un directorio padre
	 * @param peso
	 * @param aleatorio
	 * @param fechaIni
	 * @param fechaFin
	 * @param padre
	 * @param titulo
	 * @param visibilidad
	 * @param asignatura
	 */
	public Ejercicio(int peso, boolean aleatorio, LocalDate fechaIni, LocalDate fechaFin, Tema padre,
			String titulo, boolean visibilidad, Asignatura asignatura) {
		
		super(titulo, visibilidad, asignatura, padre);
		
		if(peso >= 0){
			this.peso = peso;
		}
		else{
			this.peso = Ejercicio.PESO_DEFECTO;
		}
		
		this.aleatorio = aleatorio;
		
		if(fechaIni == null || fechaFin == null || fechaIni.isAfter(fechaFin) || fechaIni.isBefore(LocalDate.now())){
			this.fechaIni = Plataforma.getFechaActual().plusDays(0);
			this.fechaFin = Plataforma.getFechaActual().plusDays(10);
		}
		else {
			this.fechaIni = fechaIni;
			this.fechaFin = fechaFin;
		}
		
		this.preguntas = new ArrayList<Pregunta>();
		this.notaMedia = 0;
		this.pesoPreguntas = 0;
		this.estado = EstadoEjercicio.ESPERA;
	}
	
	/**
	 * Constructor de Ejercicio en la raiz
	 * @param peso
	 * @param aleatorio
	 * @param fechaIni
	 * @param fechaFin
	 * @param titulo
	 * @param visibilidad
	 * @param asignatura
	 */
	public Ejercicio(int peso, boolean aleatorio, LocalDate fechaIni, LocalDate fechaFin,
			String titulo, boolean visibilidad, Asignatura asignatura) {
		
		super(titulo, visibilidad, asignatura);
		
		if(peso >= 0){
			this.peso = peso;
		}
		else{
			this.peso = Ejercicio.PESO_DEFECTO;
		}
		
		this.aleatorio = aleatorio;
		
		if(fechaIni.isAfter(fechaFin) || fechaIni.isBefore(LocalDate.now())){
			this.fechaIni = Plataforma.getFechaActual().plusDays(0);
			this.fechaFin = Plataforma.getFechaActual().plusDays(10);
		}
		else {
			this.fechaIni = fechaIni;
			this.fechaFin = fechaFin;
		}
		
		this.preguntas = new ArrayList<Pregunta>();
		this.notaMedia = 0;
		this.pesoPreguntas = 0;
		this.estado = EstadoEjercicio.ESPERA;
	}

	
	//Getters y setters
	
	/**
	 * Get peso
	 * @return  peso
	 */
	public int getPeso() {
		return peso;
	}
	
	/**
	 * M�todo para obtener el peso por defecto de un ejercicio
	 * @return int
	 */
	public int getPesoDefecto(){
		return Ejercicio.PESO_DEFECTO;
	}
	
	/**
	 * Get pesoPreguntas
	 * @return pesoPreguntas
	 */
	public int getPesoPreguntas(){
		return this.pesoPreguntas;
	}

	/**
	 * Set peso
	 * @param peso
	 */
	public void setPeso(int peso) {
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return;
		}
		if(peso < 0){
			this.peso = -peso;
			return;
		}
		this.peso = peso;
	}

	/**
	 * Get aleatorio
	 * @return boolean
	 */
	public boolean esAleatorio() {
		return aleatorio;
	}

	/**
	 * Set aleatorio
	 * @param aleatorio
	 */
	public void setAleatorio(boolean aleatorio) {
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return;
		}
		this.aleatorio = aleatorio;
	}

	/**
	 * Get fecha inicio ejercicio
	 * @return fechaIni
	 */
	public LocalDate getFechaIni() {
		return fechaIni;
	}
	
	/**
	 * M�todo para obtener la fecha de inicio por defecto
	 * @return localdate
	 */
	public LocalDate getFechaIniDefecto(){
		return Plataforma.getFechaActual().plusDays(0);
	}

	/**
	 * Set fecha inicio
	 * @param fechaIni
	 * @return boolean
	 */
	public boolean setFechaIni(LocalDate fechaIni) {
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return false;
		}
		if(fechaIni == null){
			return false;
		}
		this.enPlazo();
		if(this.fechaIni.isBefore(fechaIni)){
			if(this.estado == EstadoEjercicio.RESPONDIDO || this.estado == EstadoEjercicio.TERMINADO){
				return false;
			}
		}
		if(this.fechaIni.isBefore(Plataforma.getFechaActual())){
			return false;
		}
		if(Plataforma.loggedAs().getClass() == Profesor.class){
			if(fechaIni.isAfter(Plataforma.getFechaActual()) && fechaIni.isBefore(this.fechaFin)){
				this.fechaIni = fechaIni;
				ArrayList<Alumno> alumnos = this.getAsignatura().getAlumnos();
				for(Alumno al: alumnos){
					try {
						EmailSystem.send(al.getEmail(), "Modificacion en ejercicio", "La fecha de inicio del ejercicio "+this.getTitulo()+" ha sido modificada");
					} catch (InvalidEmailAddressException e) {
						e.printStackTrace();
					} catch (FailedInternetConnectionException e) {
						e.printStackTrace();
					}
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Get fecha fin ejercicio
	 * @return fechaFin
	 */
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	
	
	/**
	 * M�todo para obtener la fecha de cierre por defecto
	 * @return localdate
	 */
	public LocalDate getFechaFinDefecto(){
		return Plataforma.getFechaActual().plusDays(10);
	}

	/**
	 * Set fecha fin ejercicio
	 * @param fechaFin
	 * @return boolean
	 */
	public boolean setFechaFin(LocalDate fechaFin) {
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return false;
		}
		if(fechaFin == null){
			return false;
		}
		this.enPlazo();
		if(this.estado == EstadoEjercicio.TERMINADO){
			return false;
		}
		if(this.fechaFin.isAfter(fechaFin)){
			if(this.estado == EstadoEjercicio.RESPONDIDO){
				return false;
			}
		}
		if(this.fechaIni.isAfter(fechaFin)){
			return false;
		}
		if(Plataforma.loggedAs().getClass() == Profesor.class){
			this.fechaFin = fechaFin;
			ArrayList<Alumno> alumnos = this.getAsignatura().getAlumnos();
			for(Alumno al: alumnos){
				try {
					EmailSystem.send(al.getEmail(), "Modificacion en ejercicio", "La fecha de fin del ejercicio "+this.getTitulo()+" ha sido modificada");
				} catch (InvalidEmailAddressException e) {
					e.printStackTrace();
				} catch (FailedInternetConnectionException e) {
					e.printStackTrace();
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Get preguntas que te las desordena en caso de ser alumno y estar activada a aleatoriedad
	 * @return preguntas
	 */
	public ArrayList<Pregunta> getPreguntas() {
		if(Plataforma.loggedAs() instanceof Alumno){
			if(this.aleatorio == true){
				long seed = System.nanoTime();
				ArrayList<Pregunta> aux = (ArrayList<Pregunta>) this.preguntas.clone();
				Collections.shuffle(aux, new Random(seed));
				return (ArrayList<Pregunta>) aux;
			}
		}
		return this.preguntas;
	}
	
	/**
	 * Get nota media
	 * @return notaMedia
	 */
	public float getNotaMedia() {
		return notaMedia;
	}
	
	/**
	 * Get del n�mero de alumnos que han terminado
	 * el ejercicio
	 * @return numterminados
	 */
	public int getNumTerminados(){
		return this.numTerminados;
	}

	/**
	 * Getter de EstadoEjercicio
	 * @return estado
	 */
	public EstadoEjercicio getEstado(){
		this.enPlazo();
		return this.estado;
	}
	
	
	//M�todos
	
	/**
	 * M�todo para a�adir una pregunta al ejercicio
	 * @param pregunta
	 * @return boolean
	 */
	public boolean addPregunta(Pregunta preg){
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return false;
		}
		if(preg == null) return false;
		if(preg.bienFormada() == false) return false;
		if(this.preguntas.contains(preg)){
			this.removePregunta(preg);
		}
		this.pesoPreguntas += preg.getValorPregunta();
		return this.preguntas.add(preg);	
	}
	
	/**
	 * M�todo para eliminar una pregunta
	 * @param pregunta
	 */
	public void removePregunta(Pregunta preg){
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return;
		}
		if(preg == null) return;
		this.preguntas.remove(preg);
	}
	
	/**
	 * M�todo para responder a un ejercicio
	 * @param al
	 * @param res
	 * @return boolean
	 */
	public boolean responderEjercicio(Alumno al, ArrayList<RespuestaPregunta> res){
		if(res == null || al == null){
			return false;
		}
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Profesor.class){
			return false;
		}
		if(this.asignatura.getAlumnos().contains(al) == false){
			return false;
		}
		else if(this.sePuedeResponder() == false){
			return false;
		}
		//Crea la respuesta
		RespuestaEjercicio respuestas = new RespuestaEjercicio(this);
		for(RespuestaPregunta resi : res){
			if(this.getPreguntas().contains(resi.getPregunta())){
				respuestas.addRespuesta(resi);
			}
		}
		//Busca las estad�sticas del alumno en esta asignatura 
		//y les a�ade la respuesta y la nota de este ejercicio
		ArrayList<EstadisticasAlumno> ests = al.getEstadisticas();
		for(EstadisticasAlumno estadisticas : ests){
			if(estadisticas.getAsignatura() == this.asignatura){
				for(RespuestaEjercicio estas: estadisticas.getRespuestas()){
					if(estas.getEjercicio() == this){
						return false;
					}
				}
				estadisticas.addRespuestaEjercicio(respuestas);
				this.addNota(respuestas.calcularNota());
				return true;
			}
		}
		//Si el alumno no tiene estad�sticas en esta asignatura, las crea
		EstadisticasAlumno nuevo = EstadisticasAlumno.newEstadisticasAlumno(this.asignatura, al);
		nuevo.addRespuestaEjercicio(respuestas);
		this.addNota(respuestas.calcularNota());
		return true;		
	}
	
	/**
	 * M�todo que recibe una nueva nota y recalcula la media, 
	 * incrementando el n�mero de terminados
	 * @param nota
	 */
	public void addNota(float nota){
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Profesor.class){
			return;
		}
		if(nota < 0) return;
		this.notaMedia = (this.notaMedia * this.numTerminados + nota) / (this.numTerminados + 1);
		this.numTerminados ++;
		this.estado = EstadoEjercicio.RESPONDIDO;
	}
	
	/**
	 * M�todo que comprueba si un ejercicio est� en plazo
	 * @return boolean
	 */
	public boolean enPlazo(){
		if(this.estado == EstadoEjercicio.TERMINADO){
			return false;
		}
		else if(Plataforma.getFechaActual().isAfter(this.fechaFin)){
			this.estado = EstadoEjercicio.TERMINADO;
			return false;
		}
		else if(this.estado == EstadoEjercicio.ABIERTO){
			return true;
		}
		else if(Plataforma.getFechaActual().isBefore(this.fechaFin) && (Plataforma.getFechaActual().isAfter(this.fechaIni) || Plataforma.getFechaActual().equals(this.fechaIni))){
			if(this.estado != EstadoEjercicio.RESPONDIDO){
				this.estado = EstadoEjercicio.ABIERTO;
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * M�todo para comprobar si se puede responder un ejercicio
	 * @return boolean
	 */
	public boolean sePuedeResponder(){
		
		if(enPlazo() == true && this.getVisibilidad() == true){
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * M�todo para comprobar si un ejercicio es borrable, es decir,
	 * si est� en espera (la fecha de inicio no ha llegado) o
	 * si a�n no ha sido respondido
	 * @return boolean
	 */
	public boolean esBorrable(){
		if(this.enPlazo() && this.estado == EstadoEjercicio.RESPONDIDO){
			return false;
		}
		else if(this.estado == EstadoEjercicio.ESPERA || this.estado == EstadoEjercicio.ABIERTO){
			return true;
		}
		else {
			return false;
		}
	}
	
	
	//Override
	
	/**
	 * toString, Override
	 * @return String
	 */
	@Override
	public String toString(){
		return this.getTitulo();
	}
	

}
