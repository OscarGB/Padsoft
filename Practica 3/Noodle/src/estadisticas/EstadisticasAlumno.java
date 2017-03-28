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
	
	/**
	 * Constructor de estadisticas alumno
	 */
	public EstadisticasAlumno(Asignatura asig, Alumno al){
		this.notaMedia = 0;
		this.respuestas = new ArrayList<RespuestaEjercicio>();
		this.asig = asig;
		asig.addEstadistica(this);
		this.alumno = al;
		al.addEstadistica(this);
	}
	
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
	/**
	 * Añade una nueva respuesta a ejercicio y calcula la nota media.
	 * @param r
	 */
	public void addRespuestaEjercicio(RespuestaEjercicio r){
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
