package solicitud;

import java.io.Serializable;

import asignatura.Asignatura;
import persona.Alumno;

/**
 * Clase Solicitud
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public class Solicitud implements Serializable{
	
	//Variables
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Alumno que solicita acceso
	 */
	private Alumno alumno;
	
	/**
	 * Asignatura a la que se solicita acceso
	 */
	private Asignatura asignatura;
	
	//Constructor
	
	/**
	 * Constructor de Solicitud
	 * @param alumno
	 * @param asig
	 */
	public Solicitud (Alumno alumno, Asignatura asig){
		this.alumno = alumno;
		this.asignatura = asig;
		
	}
	
	//Getters y Setters
	
	/**
	 * Getter de Asignatura
	 * @return
	 */
	public Asignatura getAsignatura(){
		return this.asignatura;
	}
	
	/**
	 * Getter de Alumno de la Solicitud
	 * @return Alumno
	 */
	public Alumno getAlumno() {
		return this.alumno;
	}
	
	
	//Overrides
	
	/**
	 * Override de equals() para Solicitud
	 * @param other
	 */
	@Override
	public boolean equals(Object other){
		Solicitud s2 = (Solicitud) other;
		if(this.alumno == s2.alumno && this.asignatura == s2.asignatura){
			return true;
		}
		else {
			return false;
		}
	}


	/** 
	 * (Override) toString de la solicitud
	 * @return String
	 */
	@Override
	public String toString(){
		return "El alumno: " + this.alumno.getNombre() + " solicita acceso a la asignatura: " + this.asignatura.getNombre();
	}
}
