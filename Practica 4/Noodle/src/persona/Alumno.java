package persona;

import java.io.Serializable;
import java.util.ArrayList;

import asignatura.Asignatura;
import es.uam.eps.padsof.emailconnection.EmailSystem;
import estadisticas.EstadisticasAlumno;
import solicitud.Solicitud;

/**
 * Clase Alumno
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public class Alumno extends Persona implements Serializable{
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;

	//Variables
	/**
	 * Email del Alumno
	 */
	private String email;
	
	/**
	 * Asignaturas en las que esta matriculado el Alumno
	 */
	private ArrayList<Asignatura> asignaturas;
	
	/**
	 * Estadísticas del Alumno
	 */
	private ArrayList<EstadisticasAlumno> estadisticas;

	//Constructor
	
	/**
	 * Constructor de la clase Alumno
	 * @param nia
	 * @param nombre
	 * @param password
	 * @param email
	 */
	public Alumno(String nia, String nombre, String password, String email){
		super(nia, nombre, password);
		this.asignaturas = new ArrayList<Asignatura>();
		this.estadisticas = new ArrayList<EstadisticasAlumno>();
		this.email = email;
	}
	
	/**
	 * Cosntructor con comprobaciones
	 * @param nia
	 * @param nombre
	 * @param password
	 * @param email
	 * @return Alumno
	 */
	public static Alumno creaAlumno(String nia, String nombre, String password, String email){
		if(EmailSystem.isValidEmailAddr(email) == false){
			return null;
		}
		return new Alumno(nia, nombre, password, email);
	}
	
	//Getters y Setters
	
	/**
	 * Da valor al email de Alumno
	 * @param email
	 */
	public void setEmail(String email) {
		if(email == null) return;
		if(EmailSystem.isValidEmailAddr(email) == false){
			System.out.println("El email introducido no es válido");
			return;
		}
		
		this.email = email;
	}
	
	/**
	 * Getter de media de la asignatura
	 * @param asignatura
	 * @return
	 */
	public float getMediaAsignatura(Asignatura asignatura){
		float media = 0f;
		for(EstadisticasAlumno est: this.getEstadisticas()){
			if(est.getAsignatura().equals(asignatura)){
				media += est.getNotaMedia();
			}
		}
		return media;
	}
	
	/**
	 * Devuelve las asignaturas en las que está matriculado el Alumno
	 * @return ArrayList<Asignatura>
	 */
	@Override
	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	
	/**
	 * Devuelve las estadísitcas de un Alumno
	 * @return ArrayList<EstadisticasIndividuales>
	 */
	@Override
	public ArrayList<EstadisticasAlumno> getEstadisticas() {
		return estadisticas;
	}
	
	/**
	 * devuelve el email de un alumno
	 * @return String
	 */
	@Override
	public String getEmail() {
		return email;
	}
	
	//Métodos

	/**
	 * Añade una asigatura al alumno
	 * @param asignatura
	 */
	public void addAsignatura(Asignatura asignatura) {
		if(asignatura == null){
			return;
		}
		if(this.asignaturas.contains(asignatura) == true){
			return;
		}
		this.asignaturas.add(asignatura);
	}
	
	/**
	 * Elimina una asigatura del alumno
	 * @param asignatura
	 */
	public void eraseAsignatura(Asignatura asignatura) {
		if(asignatura == null){
			return;
		}
		if(this.asignaturas.contains(asignatura) == false){
			return;
		}
		this.asignaturas.remove(asignatura);
	}

	

	/**
	 * Añade una estadistica al alumno
	 * @param estadistica
	 */
	public void addEstadistica(EstadisticasAlumno estadistica) {
		if(estadistica == null){
			return;
		}
		if(this.estadisticas.contains(estadistica) == true){
			return;
		}
		this.estadisticas.add(estadistica);
	}
	
	/**
	 * Elimina una asigatura del alumno
	 * @param asignaturas
	 */
	public void eraseEstadistica(EstadisticasAlumno estadistica) {
		if(estadistica == null){
			return;
		}
		if(this.estadisticas.contains(estadistica) == false){
			return;
		}
		this.estadisticas.remove(estadistica);
	}
	
	/**
	 * Método para solicitar acceso a una asignatura
	 * que creará una solicitud y la añadirá a las
	 * solicitudes pendientes de la asignatura
	 * @param asig
	 * @return solicitud
	 */
	public Solicitud solicitarAcceso(Asignatura asig) {
		if(asig == null){
			return null;
		}
		if(asig.isAlumnoIn(this) == true) {
			System.out.println("Alumno in");
			return null;
		}
		else {
			Solicitud sol = new Solicitud(this, asig);
			if(asig.addSolicitudPendiente(sol) == true){
				return sol;
			}
		}
		return null;
	}
	
	
	//Overrides

	/**
	 * (Override) toString()
	 * Escribe en un String los datos de un Alumno
	 * @return String 
	 */
	@Override
	public String toString() {
		return "NIA: " + this.nia + ". Nombre: "+ this.nombre + ". Password: " + this.password  +  ". Email: " + this.email +
				". Matriculado en " + this.asignaturas.size() + " Asignaturas. Almacena " + this.estadisticas.size() +
				" Estadísticas.";
	}

	
	
	
	
}
