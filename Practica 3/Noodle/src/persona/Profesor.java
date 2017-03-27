package persona;

import java.util.ArrayList;

import asignatura.Asignatura;
import plataforma.Plataforma;
import solicitud.Solicitud;

public class Profesor extends Persona {
	
	/**
	 * Profesor de la plataforma (singleton)
	 */
	private static Profesor profesor;
	
	//Constructor
	
	/**
	 * Constructor de Profesor
	 */
	private Profesor(){
		super("1", "Profesor", "contraseniaprofe");
	}
	
	//Setters y getters
	
	/**
	 * Método para obtener un ArrayList con todas las solicitudes pendientes
	 * @return ArrayList solicitudes
	 */
	public ArrayList<Solicitud> getSolicitudes() {
		ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();
		
		for(Asignatura asig : Plataforma.asignaturas){
			solicitudes.addAll(asig.getSolicitudes());
		}
		
		return solicitudes;
	}
	
	
	//Métodos
	
	/**
	 * Método para crear un nuevo profesor (singleton)
	 * @return profesor
	 */
	public static Profesor newProfesor(){
		if(Profesor.profesor == null){
			Profesor.profesor = new Profesor();
		}
		
		return Profesor.profesor;
	}
	
	/**
	 * Método que acepta solicitud
	 * @param sol
	 * @return true si ha sido aceptada
	 */
	public boolean aceptarSolicitud(Solicitud sol){
		if(sol.getAsignatura().aceptarSolicitud(sol) == true){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Método que rechaza solicitud
	 * @param sol
	 */
	public void denegarSolicitud(Solicitud sol) {
		sol.getAsignatura().denegarSolicitud(sol);
	}

	/**
	 * Método para expulsar alumno de una asignatura
	 * @param asig1
	 * @param a1
	 */
	public void expulsarAlumno(Asignatura asig1, Alumno a1) {
		asig1.expulsarAlumno(a1);
	}

	
	/**
	 * Método para readmitir a un alumno expulsado
	 * @param asig1
	 * @param a1
	 * @return boolean
	 */
	public boolean readmitirAlumno(Asignatura asig1, Alumno a1) {
		if(asig1.readmitirAlumno(a1) == true){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	
	
}
