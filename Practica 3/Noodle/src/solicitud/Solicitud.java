package solicitud;

import asignatura.Asignatura;
import persona.Alumno;

public class Solicitud {
	/**
	 * Alumno que solicita acceso
	 */
	Alumno alumno;
	
	/**
	 * Asignatura a la que se solicita acceso
	 */
	Asignatura asignatura;
	
	/**
	 * Constructor de Solicitud
	 * @param alumno
	 * @param asig
	 */
	public Solicitud (Alumno alumno, Asignatura asig){
		this.alumno = alumno;
		this.asignatura = asignatura;
	}
	
	/**
	 * Método para aceptar solicitud
	 */
	public void aceptarSolicitud(){
		/*TODO Tramitará la inserción del alumno*/
		this.asignatura.addAlumno(this.alumno);
	}
	
	/**
	 * Método para denegar solicitud
	 */
	public void denegarSolicitud(){
		/*TODO Tramitará la denegación de la solicitud*/
		this.asignatura.denegarSolicitud(this);
	}
	
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
}
