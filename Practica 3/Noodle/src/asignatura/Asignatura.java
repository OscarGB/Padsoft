package asignatura;

import java.io.Serializable;
import java.util.ArrayList;

import contenido.Contenido;
import contenido.Tema;
import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import estadisticas.EstadisticasAlumno;
import persona.Alumno;
import solicitud.Solicitud;

/**
 * Clase Asignatura
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */
public class Asignatura implements Serializable {
	
	//Variables
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;

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
	 * Array con las estadisticas de todos los alumnos
	 */
	private ArrayList<EstadisticasAlumno> estadisticas;
	
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
		this.estadisticas = new ArrayList<EstadisticasAlumno>();
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
	
	/**
	 * Getter de Raiz
	 * @return raiz (array)
	 */
	public ArrayList<Contenido> getRaiz(){
		return this.raiz;
	}
	
	
	//M�todos
	
	/**
	 * M�todo para a�adir alumno a la asignatura
	 * @param alumno
	 */
	public boolean addAlumno(Alumno alumno){
		if(this.isAlumnoIn(alumno) == true){
			return false;
		}
		this.alumnos.add(alumno);
		alumno.addAsignatura(this);
		try {
			EmailSystem.send(alumno.getEmail(), "Admisi�n", "Has sido admitido a la asignatura " + this.getNombre());
		} catch (InvalidEmailAddressException e) {
			e.printStackTrace();
		} catch (FailedInternetConnectionException e) {
			e.printStackTrace();
		}
		
		return true;
		
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
			try {
				EmailSystem.send(alumno.getEmail(), "Expulsi�n", "Has sido expulsado de la asignatura " + this.getNombre());
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
				try {
					EmailSystem.send(alumno.getEmail(), "Readmisi�n", "Has sido readmitido a la asignatura " + this.getNombre());
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
	 * M�todo para denegar (y borrar) una solicitud de acceso
	 * @param solicitud
	 */
	public void denegarSolicitud(Solicitud solicitud) {
		this.solicitudes.remove(solicitud);	
		try {
			EmailSystem.send(solicitud.getAlumno().getEmail(), "Denegaci�n", "Tu solicitud a la asignatura " + this.getNombre() + " ha sido denegada");
		} catch (InvalidEmailAddressException e) {
			e.printStackTrace();
		} catch (FailedInternetConnectionException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * A�ade una solicitud al array de pendientes
	 * @param sol
	 */
	public boolean addSolicitudPendiente(Solicitud sol){
		if(this.solicitudes.contains(sol) == false && this.isAlumnoIn(sol.getAlumno()) == false){
			if(this.solicitudes.add(sol) == true){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * A�ade una solicitud al array de pendientes
	 * @param sol
	 */
	public boolean addSolicitudExpulsado(Solicitud sol){
		if(this.expulsados.contains(sol) == false){
			if(this.expulsados.add(sol) == true){
				return true;
			}
		}
		
		return false;

	}
	
	
	/**
	 * M�todo para saber si un alumno est� inscrito en la asignatura
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
	 * M�todo para aceptar una solicitud que comprueba si
	 * la solicitud est� en el array de pendientes y, si 
	 * lo est�, a�ade al alumno y la saca de pendientes
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
	 * M�todo para a�adir un tema a la raiz
	 * @param tema
	 * @return boolean
	 */
	public boolean addContenidoRaiz(Contenido con){
		return this.raiz.add(con);
	}
	
	/**
	 * M�todo para eliminar un tema de la ra�z
	 * Tambi�n oculta todos los subcontenidos, si se trata 
	 * de un tema
	 * @param tema
	 */
	public void eraseContenidoRaiz(Contenido con){
		this.raiz.remove(con);
		con.ocultarContenido();
		con.setVisibilidad(false);
		return;
	}
	
	/**
	 * M�todo para eliminar un contenido
	 * Si est� en la ra�z (padre == null) llama a eraseContenidoRaiz
	 * Si es un subcontenido, llama a contenido.eraseContenido
	 * @param con
	 */
	public void eraseContenido(Contenido con){
		if(con.getPadre() == null){
			this.eraseContenidoRaiz(con);
		}
		else {
			con.eraseContenido();
		}
	}
	
	/**
	 * Metodo para a�adir subcontenido
	 * Si padre es null, lo a�ade a la raiz 
	 * @param subcontenido
	 * @param padre
	 * @return boolean
	 */
	public boolean addSubcontenido(Contenido sub, Tema padre){
		if(padre == null){
			return this.addContenidoRaiz(sub);
		}
		else {
			return padre.addSubcontenido(sub);
		}
	}
	
	//Overrides
	
	/**
	 * (Override) toString
	 * Devolver� un string con los alumnos de la asignatura
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


	public void addEstadistica(EstadisticasAlumno estadisticasAlumno) {
		this.estadisticas.add(estadisticasAlumno);
		
	}
	
}
