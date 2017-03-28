package contenido;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.ArrayList;

import asignatura.Asignatura;
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
 * @date 07/03/2017
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
	 * Número de alumnos que han terminado el ejercicio
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
		this.peso = peso;
		this.aleatorio = aleatorio;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.preguntas = new ArrayList<Pregunta>();
		this.notaMedia = 0;
		this.pesoPreguntas = 0;
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
		this.peso = peso;
		this.aleatorio = aleatorio;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
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
		this.peso = peso;
	}

	/**
	 * esAleatorio
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
	 * Set fecha inicio
	 * @param fechaIni
	 */
	public void setFechaIni(LocalDate fechaIni) {
		if(Plataforma.loggedAs.getClass() == Profesor.class){
			this.fechaIni = fechaIni;
		}
		return;
	}

	/**
	 * Get fecha fin ejercicio
	 * @return fechaFin
	 */
	public LocalDate getFechaFin() {
		return fechaFin;
	}

	/**
	 * Set fecha fin ejercicio
	 * @param fechaFin
	 */
	public void setFechaFin(LocalDate fechaFin) {
		if(Plataforma.loggedAs.getClass() == Profesor.class){
			this.fechaFin = fechaFin;
		}
		return;
	}

	/**
	 * Get preguntas
	 * @return preguntas
	 */
	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}

	/**
	 * Get nota media
	 * @return notaMedia
	 */
	public float getNotaMedia() {
		return notaMedia;
	}
	
	/**
	 * Get del nï¿½mero de alumnos que han terminado
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
		return this.estado;
	}
	
	
	//Metodos
	
	/**
	 * Mï¿½todo para aï¿½adir una pregunta al ejercicio
	 * @param pregunta
	 * @return boolean
	 */
	public boolean addPregunta(Pregunta preg){
		this.pesoPreguntas += preg.getValorPregunta();
		return this.preguntas.add(preg);	
	}
	
	/**
	 * Mï¿½todo para eliminar una pregunta
	 * @param pregunta
	 */
	public void removePregunta(Pregunta preg){
		this.preguntas.remove(preg);
	}
	
	/**
	 * Método para responder a un ejercicio
	 * @param al
	 * @param res
	 * @return
	 */
	public boolean responderEjercicio(Alumno al, ArrayList<RespuestaPregunta> res){
		if(res == null){
			return false;
		}
		if(this.asignatura.getAlumnos().contains(al) == false){
			return false;
		}
		else if(this.sePuedeResponder() == false){
			return false;
		}
		RespuestaEjercicio respuestas = new RespuestaEjercicio(this);
		for(RespuestaPregunta resi : res){
			respuestas.addRespuesta(resi);
		}
		ArrayList<EstadisticasAlumno> ests = al.getEstadisticas();
		for(EstadisticasAlumno estadisticas : ests){
			if(estadisticas.getAsignatura() == this.asignatura){
				estadisticas.addRespuestaEjercicio(respuestas);
				this.addNota(respuestas.calcularNota());
				return true;
			}
		}
		EstadisticasAlumno nuevo = new EstadisticasAlumno(this.asignatura, al);
		nuevo.addRespuestaEjercicio(respuestas);
		this.addNota(respuestas.calcularNota());
		return true;		
	}
	
	/**
	 * Método que recibe una nueva nota y recalcula la media, 
	 * incrementando el número de terminados
	 * @param nota
	 */
	public void addNota(float nota){
		this.notaMedia = (this.notaMedia * this.numTerminados + nota) / (this.numTerminados + 1);
		this.numTerminados ++;
		this.estado = EstadoEjercicio.RESPONDIDO;
	}
	
	/**
	 * Método que comprueba si un ejercicio está en plazo
	 * @return boolean
	 */
	public boolean enPlazo(){
		if(this.estado == EstadoEjercicio.ABIERTO){
			return true;
		}
		else if(this.estado == EstadoEjercicio.TERMINADO){
			return false;
		}
		else if(LocalDate.now().isBefore(this.fechaFin) && LocalDate.now().isAfter(this.fechaIni)){
			if(this.estado != EstadoEjercicio.RESPONDIDO){
				this.estado = EstadoEjercicio.ABIERTO;
			}
			return true;
		}
		else if(this.estado == EstadoEjercicio.ESPERA){
			return false;
		}
		else {
			this.estado = EstadoEjercicio.TERMINADO;
			return false;
		}
	}
	
	/**
	 * Método para comprobar si se puede responder un ejercicio
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
	 * Método para comprobar si un ejercicio es borrable, es decir,
	 * si está en espera (la fecha de inicio no ha llegado) o
	 * si aún no ha sido respondido
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
		String aux = "";
		
		for(Pregunta p: this.preguntas){
			aux += "- " + p.enunciado + " [Peso: " + p.valorPregunta + "]\n";
		}
		
		return "Título del ejercicio: " + this.titulo + "\n Preguntas: \n" + aux + " Peso ejercicio: " + this.peso + "\n Nota Media: " + this.notaMedia + "\n";
	}
	

}
