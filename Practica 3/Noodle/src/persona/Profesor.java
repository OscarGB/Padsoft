package persona;

import java.time.LocalDate;
import java.util.ArrayList;

import asignatura.Asignatura;
import plataforma.Plataforma;
import solicitud.Solicitud;

public class Profesor extends Persona {
	
	
	/**
	 * Constructor de Profesor
	 * @param nia
	 * @param password
	 */
	public Profesor(String nia, String password){
		super(nia, "Profesor", password, LocalDate.now().toString());
	}
	
	/**
	 * Método que acepta solicitud
	 * @param sol
	 * @return
	 */
	public int aceptarSolicitud(Solicitud sol){
		/*TODO llamará a aceptar solicitud de Solicitud*/
		return 0;
	}
	
	/**
	 * Método que rechaza solicitud
	 * @param sol
	 */
	public void denegarSolicitud(Solicitud sol) {
		/*TODO llamará a denegar solicitud de Solicitud*/
	}

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

	/**
	 * Método para expulsar alumno de una asignatura
	 * @param asig1
	 * @param a1
	 */
	public void expulsarAlumno(Asignatura asig1, Alumno a1) {
		asig1.expulsarAlumno(a1);
	}

	public boolean readmitirAlumno(Asignatura asig1, Alumno a1) {
		if(asig1.readmitirAlumno(a1) == true){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	
	
}
