package persona;

import java.time.LocalDate;
import java.util.ArrayList;

import asignatura.Asignatura;
import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import estadisticas.EstadisticasAlumno;
import solicitud.Solicitud;

/**
 * Clase Alumno
 * @author Óscar Gómez Borzdynski
 * @author Jose Ignacio Gómez García
 * @date 07/03/2017
 */

public class Alumno extends Persona {
	
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
	public Alumno(String nia, String nombre, String password, String email) throws InvalidEmailAddressException{
		super(nia, nombre, password);
		this.asignaturas = new ArrayList<Asignatura>();
		this.estadisticas = new ArrayList<EstadisticasAlumno>();
		if(EmailSystem.isValidEmailAddr(email) == false){
			System.out.println("El email introducido no es válido");
		}
		
		this.email = email;
	}
	
	//Getters y Setters
	
	/**
	 * Da valor al email de Alumno
	 * @param email
	 */
	public void setEmail(String email) {
		if(EmailSystem.isValidEmailAddr(email) == false){
			System.out.println("El email introducido no es válido");
			return;
		}
		
		this.email = email;
	}
	
	/**
	 * Devuelve las asignaturas en las que está matriculado el Alumno
	 * @return ArrayList<Asignatura>
	 */
	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	
	/**
	 * Devuelve las estadísitcas de un Alumno
	 * @return ArrayList<EstadisticasIndividuales>
	 */
	public ArrayList<EstadisticasAlumno> getEstadisticas() {
		return estadisticas;
	}
	
	/**
	 * devuelve el email de un alumno
	 * @return String
	 */
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
	 * Añade una estadística al alumno
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
				". Matriculado en " + this.asignaturas.size() + " Asignaturas. Almacena" + this.estadisticas.size() +
				"Estadísticas.";
	}

	
	
	
	
}
