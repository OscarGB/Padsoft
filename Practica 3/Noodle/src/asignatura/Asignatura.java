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
	 * Método para añadir alumno a la asignatura
	 * @param alumno
	 */
	public void addAlumno(Alumno alumno){
		this.alumnos.add(alumno);
		alumno.addAsignatura(this);
	}
	
	/**
	 * Método para expulsar alumno de la asignatura
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
	 * Método para readmitir Alumno
	 * Saca el alumno de la lista de expulsados y lo añade a alumnos
	 * @param alumno
	 * @return
	 */
	public boolean readmitirAlumno(Alumno alumno){
		Solicitud readmision = new Solicitud(alumno, this);
		
		for(Solicitud s : this.expulsados){
			if(s.equals(readmision) == true){
				this.expulsados.remove(s);
				this.alumnos.add(alumno);
				alumno.addAsignatura(this);
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Método para denegar (y borrar) una solicitud de acceso
	 * @param solicitud
	 */
	public void denegarSolicitud(Solicitud solicitud) {
		this.solicitudes.remove(solicitud);		
	}
	
	/**
	 * Método para saber si un alumno está inscrito en la asignatura
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
	
}
