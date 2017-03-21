package persona;

import java.time.LocalDate;

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
	
	
	
}
