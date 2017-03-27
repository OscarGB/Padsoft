package persona;

import java.io.Serializable;
import java.util.ArrayList;

import asignatura.Asignatura;
import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
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
	 * Estadï¿½sticas del Alumno
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
	private Alumno(String nia, String nombre, String password, String email){
		super(nia, nombre, password);
		this.asignaturas = new ArrayList<Asignatura>();
		this.estadisticas = new ArrayList<EstadisticasAlumno>();
		this.email = email;
	}
	
	public static Alumno CreaAlumno(String nia, String nombre, String password, String email){
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
		if(EmailSystem.isValidEmailAddr(email) == false){
			System.out.println("El email introducido no es válido");
			return;
		}
		
		this.email = email;
	}
	
	/**
	 * Devuelve las asignaturas en las que estï¿½ matriculado el Alumno
	 * @return ArrayList<Asignatura>
	 */
	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	
	/**
	 * Devuelve las estadï¿½sitcas de un Alumno
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
	 * Mï¿½todo para solicitar acceso a una asignatura
	 * que crearï¿½ una solicitud y la aï¿½adirï¿½ a las
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
				"Estadï¿½sticas.";
	}

	
	
	
	
}
