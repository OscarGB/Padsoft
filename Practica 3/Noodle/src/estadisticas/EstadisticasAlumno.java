package estadisticas;

import java.io.Serializable;

import java.util.ArrayList;

import asignatura.Asignatura;
import persona.Alumno;

/**
 * Clase EstadisticasAlumno
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

import respuestas.RespuestaEjercicio;

/**
 * Clase EstadisitcasAlumno
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public class EstadisticasAlumno implements Serializable{
	
	//Variables
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Respuestas de los ejercicios
	 */
	private ArrayList<RespuestaEjercicio> respuestas;
	
	/**
	 * Nota media de todos los ejercicios 
	 */
	private float notaMedia;
	
	/**
	 * Asignatura a la que pertenece la estadistica
	 */
	private Asignatura asig;
	
	/**
	 * Alumno al que pertenece esta estadística
	 */
	private Alumno alumno;
	
	//Constructores
	
	/**
	 * Constructor privado de estadisticas alumno
	 */
	private EstadisticasAlumno(Asignatura asig, Alumno al){
		this.notaMedia = 0;
		this.respuestas = new ArrayList<RespuestaEjercicio>();
		this.asig = asig;
		asig.addEstadistica(this);
		this.alumno = al;
		al.addEstadistica(this);
	}
	
	/**
	 * Constructor con comprobacioness
	 * @param asig
	 * @param al
	 * @return EstadisticasAlumno
	 */
	public static EstadisticasAlumno newEstadisticasAlumno(Asignatura asig, Alumno al){
		if(asig == null || al == null){
			return null;
		}
		if(al.getAsignaturas().contains(asig) == false){
			return null;
		}
		return new EstadisticasAlumno(asig, al);
	}
	
	//Getters y Setters
	
	/**
	 * Get nota media
	 * @return float
	 */
	public float getNotaMedia() {
		return notaMedia;
	}
	
	/**
	 * Get alumno
	 * @return
	 */
	public Alumno getAlumno(){
		return alumno;
	}
	
	/**
	 * Getter de respuestas
	 * @return respuestas
	 */
	public ArrayList<RespuestaEjercicio> getRespuestas(){
		return this.respuestas;
	}
	
	/**
	 * Get asignatura
	 * @return
	 */
	public Asignatura getAsignatura(){
		return asig;
	}
	
	//Métodos
	
	/**
	 * Añade una nueva respuesta a ejercicio y calcula la nota media.
	 * @param r
	 */
	public void addRespuestaEjercicio(RespuestaEjercicio r){
		if(r == null){
			return;
		}
		float nota = 0;
		float pesototal = 0;
		this.respuestas.add(r);
		for(RespuestaEjercicio re : this.respuestas){
			nota += re.calcularNota()*re.getEjercicio().getPeso();
			pesototal += re.getEjercicio().getPeso();
		}
		this.notaMedia = (nota/pesototal);
	}
	
	/**
	 * toString, Override
	 * @return String
	 */
	@Override
	public String toString(){
		return "Estadisticas del Alumno " + this.alumno + " Nota media = " + this.notaMedia + "\nEjercicios: " + this.respuestas;
	}
	
	
}
