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
	 * M�todo que acepta solicitud
	 * @param sol
	 * @return
	 */
	public int aceptarSolicitud(Solicitud sol){
		/*TODO llamar� a aceptar solicitud de Solicitud*/
		return 0;
	}
	
	/**
	 * M�todo que rechaza solicitud
	 * @param sol
	 */
	public void denegarSolicitud(Solicitud sol) {
		/*TODO llamar� a denegar solicitud de Solicitud*/
	}
	
	
	
}
