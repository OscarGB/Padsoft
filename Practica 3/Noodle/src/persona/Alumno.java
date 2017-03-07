package persona;

import java.util.ArrayList;

import asignatura.Asignatura;
import estadisticas.EstadisticasAlumno;

/**
 * Clase Alumno
 * @author �scar G�mez Borzdynski
 * @author Jose Ignacio G�mez Garc�a
 * @date 07/03/2017
 */

public class Alumno extends Persona {
	/**
	 * Email del Alumno
	 */
	private String email;
	
	/**
	 * Asignaturas en las que esta matriculado el Alumno
	 */
	private ArrayList<Asignatura> asignaturas;
	
	/**
	 * Estad�sticas del Alumno
	 */
	private ArrayList<EstadisticasAlumno> estadisticas;
	
	/**
	 * N�mero de asignaturas del Alumno
	 */
	private int numAsignaturas;
	
	/**
	 * N�mero de estad�sticas del Alumno
	 */
	private int numEstadisticas;

	/**
	 * Constructor de la clase Alumno
	 * @param nia
	 * @param nombre
	 * @param password
	 * @param email
	 */
	public Alumno(String nia, String nombre, String password, String fecha, String email) {
		super(nia, nombre, password, fecha);
		this.asignaturas = new ArrayList<Asignatura>();
		this.estadisticas = new ArrayList<EstadisticasAlumno>();
		this.email = email;
		this.numAsignaturas = 0;
		this.numEstadisticas = 0;
	}
	
	/**
	 * devuelve el email de un alumno
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Da valor al email de Alumno
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Devuelve las asignaturas en las que est� matriculado el Alumno
	 * @return ArrayList<Asignatura>
	 */
	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	/**
	 * A�ade una asigatura al alumno
	 * @param asignatura
	 */
	public void addAsignatura(Asignatura asignatura) {
		this.asignaturas.add(asignatura);
		this.numAsignaturas++;
	}
	
	/**
	 * Elimina una asigatura del alumno
	 * @param asignatura
	 */
	public void eraseAsignatura(Asignatura asignatura) {
		this.asignaturas.remove(asignatura);
		this.numAsignaturas--;
	}

	/**
	 * Devuelve las estad�sitcas de un Alumno
	 * @return ArrayList<EstadisticasIndividuales>
	 */
	public ArrayList<EstadisticasAlumno> getEstadisticas() {
		return estadisticas;
	}

	/**
	 * A�ade una estad�stica al alumno
	 * @param estadistica
	 */
	public void addEstadistica(EstadisticasAlumno estadistica) {
		this.estadisticas.add(estadistica);
		this.numEstadisticas++;
	}
	
	/**
	 * Elimina una asigatura del alumno
	 * @param asignaturas
	 */
	public void eraseEstadistica(EstadisticasAlumno estadistica) {
		this.estadisticas.remove(estadistica);
		this.numEstadisticas--;
	}
	
	/**
	 * Solicita el acceso del Alumno a una Asignatura
	 * @param asignatura
	 */
	public void solicitarAcceso(Asignatura asignatura){
		Solicitud a = new Solicitud(asignatura, this);
	}

	/**
	 * (Override) toString()
	 * Escribe en un String los datos de un Alumno
	 * @return String 
	 */
	@Override
	public String toString() {
		return "NIA: " + this.nia + ". Nombre: "+ this.nombre + ". Password: " + this.password +
				". Fecha de inscripci�n: " + this.fechaInscripcion +  ". Email: " + this.email +
				". Matriculado en " + this.numAsignaturas+ " Asignaturas. Almacena" + this.numEstadisticas +
				"Estad�sticas.";
	}
	
	
	
}
