package asignatura;

import java.util.ArrayList;

import contenido.Contenido;
import persona.Alumno;
import solicitud.Solicitud;

public class Asignatura {
	/**
	 * ArrayList de alumnos inscritos en la asignatura 
	 */
	private ArrayList<Alumno> alumnos;
	
	/**
	 * ArrayList de solicitudes pendientes
	 */
	private ArrayList<Solicitud> solicitudes;
	
	/**
	 * ArrayList de solicitudes de alumnos expulsados
	 */
	private ArrayList<Solicitud> expulsados;
	
	/**
	 * Nombre de la asignatura
	 */
	private String nombre;
	
	/**
	 * Contenido de la asignatura
	 */
	private ArrayList<Contenido> contenido;
	
	/**
	 * Constructor de Asignatura
	 * @param nombre
	 */
	public Asignatura (String nombre){
		this.alumnos = new ArrayList<Alumno>();
		this.solicitudes = new ArrayList<Solicitud>();
		this.expulsados = new ArrayList<Solicitud>();
		this.contenido = new ArrayList<Contenido>();
		this.nombre = nombre;
	}
	
	/**
	 * M�todo para a�adir alumno a la asignatura
	 * @param alumno
	 */
	public void addAlumno(Alumno alumno){
		this.alumnos.add(alumno);
		alumno.addAsignatura(this);
		//TODO email al alumno
	}
	
	/**
	 * M�todo para expulsar alumno de la asignatura
	 * Introduce el alumno en la lista de expulsados
	 * @param alumno
	 */
	public boolean expulsarAlumno(Alumno alumno){
		if(isAlumnoIn(alumno) == true){
			this.alumnos.remove(alumno);
			this.expulsados.add(new Solicitud(alumno, this));
			alumno.eraseAsignatura(this);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * M�todo para readmitir Alumno
	 * Saca el alumno de la lista de expulsados y lo a�ade a alumnos
	 * @param alumno
	 * @return
	 */
	public boolean readmitirAlumno(Alumno alumno){
		Solicitud readmision = new Solicitud(alumno, this);
		
		for(Solicitud s : this.expulsados){
			if(s.equals(readmision) == true){
				this.expulsados.remove(s);
				this.addAlumno(alumno);
				return true;
			}
		}
		
		return false;
	}

	/**
	 * M�todo para denegar (y borrar) una solicitud de acceso
	 * @param solicitud
	 */
	public void denegarSolicitud(Solicitud solicitud) {
		this.solicitudes.remove(solicitud);	
		//TODO email al alumo
	}
	
	/**
	 * A�ade una solicitud al array de pendientes
	 * @param sol
	 */
	public boolean addSolicitudPendiente(Solicitud sol){
		if(this.solicitudes.add(sol) == true){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Getter de Solicitudes
	 * @return ArrayList solicitudes
	 */
	public ArrayList<Solicitud> getSolicitudes(){
		return this.solicitudes;
	}
	
	/**
	 * M�todo para saber si un alumno est� inscrito en la asignatura
	 * @param a
	 * @return
	 */
	public boolean isAlumnoIn(Alumno a){
		if(alumnos.contains(a) == true){
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * M�todo para aceptar una solicitud que comprueba si
	 * la solicitud est� en el array de pendientes y, si 
	 * lo est�, a�ade al alumno y la saca de pendientes
	 * @param sol
	 * @return
	 */
	public boolean aceptarSolicitud(Solicitud sol) {
		if(this.solicitudes.contains(sol) == true){
			Alumno alumno = sol.getAlumno();
			this.addAlumno(alumno);
			this.solicitudes.remove(sol);
		}
		return false;
	}
	
	/**
	 * Getter del nombre de la Asignatura
	 * @return
	 */
	public String getNombre(){
		return this.nombre;
	}
	
	@Override
	public String toString(){
		return "Alumnos en la asignatura: " + this.alumnos;
	}
	
}
