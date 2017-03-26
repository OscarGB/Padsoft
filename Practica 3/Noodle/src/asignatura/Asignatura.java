package asignatura;

import java.util.ArrayList;

import contenido.Contenido;
import contenido.Tema;
import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import persona.Alumno;
import solicitud.Solicitud;

public class Asignatura {
	
	//Variables
	
	/**
	 * Directorio raiz donde almacenar contenidos (raiz)
	 */
	private ArrayList<Contenido> raiz;
	
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
	
	
	
	//Constructores
	
	/**
	 * Constructor de Asignatura
	 * @param nombre
	 */
	public Asignatura (String nombre){
		this.alumnos = new ArrayList<Alumno>();
		this.solicitudes = new ArrayList<Solicitud>();
		this.expulsados = new ArrayList<Solicitud>();
		this.nombre = nombre;
		this.raiz = new ArrayList<Contenido>();
	}
	
	
	//Setters y getters
	
	/**
	 * Getter de Solicitudes
	 * @return ArrayList solicitudes
	 */
	public ArrayList<Solicitud> getSolicitudes(){
		return this.solicitudes;
	}
	
	/**
	 * Getter de Solicitudes de Alumnos expulsados
	 * @return ArrayList solicitudes
	 */
	public ArrayList<Solicitud> getSolicitudesExpulsados(){
		return this.expulsados;
	}
	
	/**
	 * Getter de Alumnos matriculados
	 * @return ArrayList alumnos
	 */
	public ArrayList<Alumno> getAlumnos(){
		return this.alumnos;
	}
	
	/**
	 * Getter del nombre de la Asignatura
	 * @return nombre
	 */
	public String getNombre(){
		return this.nombre;
	}
	
	
	//Métodos
	
	/**
	 * Método para añadir alumno a la asignatura
	 * @param alumno
	 */
	public void addAlumno(Alumno alumno){
		this.alumnos.add(alumno);
		alumno.addAsignatura(this);
		try {
			EmailSystem.send(alumno.getEmail(), "Admisión", "Has sido admitido a la asignatura " + this.getNombre());
		} catch (InvalidEmailAddressException e) {
			e.printStackTrace();
		} catch (FailedInternetConnectionException e) {
			e.printStackTrace();
		}
		
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
			try {
				EmailSystem.send(alumno.getEmail(), "Expulsión", "Has sido expulsado de la asignatura " + this.getNombre());
			} catch (InvalidEmailAddressException e) {
				e.printStackTrace();
			} catch (FailedInternetConnectionException e) {
				e.printStackTrace();
			}
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
				this.addAlumno(alumno);
				try {
					EmailSystem.send(alumno.getEmail(), "Readmisión", "Has sido readmitido a la asignatura " + this.getNombre());
				} catch (InvalidEmailAddressException e) {
					e.printStackTrace();
				} catch (FailedInternetConnectionException e) {
					e.printStackTrace();
				}
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
		try {
			EmailSystem.send(solicitud.getAlumno().getEmail(), "Denegación", "Tu solicitud a la asignatura " + this.getNombre() + " ha sido denegada");
		} catch (InvalidEmailAddressException e) {
			e.printStackTrace();
		} catch (FailedInternetConnectionException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Añade una solicitud al array de pendientes
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
	 * Añade una solicitud al array de pendientes
	 * @param sol
	 */
	public boolean addSolicitudExpulsado(Solicitud sol){
		if(this.expulsados.add(sol) == true){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	/**
	 * Método para saber si un alumno está inscrito en la asignatura
	 * @param a
	 * @return boolean
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
	 * Método para aceptar una solicitud que comprueba si
	 * la solicitud está en el array de pendientes y, si 
	 * lo está, añade al alumno y la saca de pendientes
	 * @param sol
	 * @return boolean
	 */
	public boolean aceptarSolicitud(Solicitud sol) {
		if(this.solicitudes.contains(sol) == true){
			Alumno alumno = sol.getAlumno();
			this.addAlumno(alumno);
			this.solicitudes.remove(sol);
			return true;
		}
		return false;
	}
	
	
	/**
	 * Método para añadir un tema a la raiz
	 * @param tema
	 * @return boolean
	 */
	public boolean addContenidoRaiz(Contenido con){
		return this.raiz.add(con);
	}
	
	/**
	 * Método para eliminar un tema de la raíz
	 * @param tema
	 */
	public void eraseContenidoRaiz(Contenido con){
		this.raiz.remove(con);
			return;
	}
	
	//Overrides
	
	/**
	 * (Override) toString
	 * Devolverá un string con los alumnos de la asignatura
	 * @return String
	 */
	@Override
	public String toString(){
		String aux = "";
		for(Contenido c: this.raiz){
			if(c.getVisibilidad() == true){
				aux += c.toString();
			}
		}
		return "Alumnos en la asignatura: " + this.alumnos + "\n" + aux;
	}
	
}
