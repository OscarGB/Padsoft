package persona;
import java.io.Serializable;
import java.util.ArrayList;

import asignatura.Asignatura;
import plataforma.Plataforma;
import solicitud.Solicitud;

/**
 * Clase Profesor
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public class Profesor extends Persona implements Serializable{
	
	//Variables
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Profesor de la plataforma (singleton)
	 */
	public static Profesor profesor;
	
	//Constructor
	
	/**
	 * Constructor de Profesor
	 */
	private Profesor(){
		super("1", "Profesor", "contraseniaprofe");
	}
	
	/**
	 * M�todo para crear un nuevo profesor (singleton)
	 * @return profesor
	 */
	public static Profesor newProfesor(){
		if(Profesor.profesor == null){
			Profesor.profesor = new Profesor();
		}
		
		return Profesor.profesor;
	}
		
	//M�todos
	
	/**
	 * M�todo para obtener un ArrayList con todas las solicitudes pendientes
	 * @return ArrayList solicitudes
	 */
	public ArrayList<Solicitud> getSolicitudes() {
		ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();
		
		for(Asignatura asig : Plataforma.getAsignaturas()){
			solicitudes.addAll(asig.getSolicitudes());
		}
		
		return solicitudes;
	}
		
	/**
	 * M�todo que acepta solicitud
	 * @param sol
	 * @return true si ha sido aceptada
	 */
	public boolean aceptarSolicitud(Solicitud sol){
		if(sol == null){
			return false;
		}
		return sol.getAsignatura().aceptarSolicitud(sol);
	}
	
	/**
	 * M�todo que rechaza solicitud
	 * @param sol
	 */
	public void denegarSolicitud(Solicitud sol) {
		if(sol == null){
			return;
		}
		sol.getAsignatura().denegarSolicitud(sol);
	}

	/**
	 * M�todo para expulsar alumno de una asignatura
	 * @param asig1
	 * @param a1
	 */
	public void expulsarAlumno(Asignatura asig1, Alumno a1) {
		if(asig1 == null || a1 == null) return;
		asig1.expulsarAlumno(a1);
	}

	
	/**
	 * M�todo para readmitir a un alumno expulsado
	 * @param asig1
	 * @param a1
	 * @return boolean
	 */
	public boolean readmitirAlumno(Asignatura asig1, Alumno a1) {
		if(asig1 == null || a1 == null){
			return false;
		}
		if(asig1.readmitirAlumno(a1) == true){
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
