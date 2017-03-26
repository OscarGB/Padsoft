package solicitud;

import asignatura.Asignatura;
import es.uam.eps.padsof.emailconnection.EmailSystem;
import persona.Alumno;

public class Solicitud {
	
	//Variables
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
	
	// Métodos
	
	/**
	 * Método para aceptar solicitud que llamará 
	 * a asignatura.addAlumno
	 */
	public void aceptarSolicitud(){
		this.asignatura.addAlumno(this.alumno);
	}
	
	/**
	 * Método para denegar solicitud
	 */
	public void denegarSolicitud(){
		this.asignatura.denegarSolicitud(this);
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
