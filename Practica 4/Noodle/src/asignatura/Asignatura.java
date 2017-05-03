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
import plataforma.Plataforma;
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
	
	/**
	 * Getter de Estadisticas
	 * @return estadisticas (ArrayList)
	 */
	public ArrayList<EstadisticasAlumno> getEstadisticas(){
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return null;
		}
		return this.estadisticas;
	}
	
	
	//Métodos
	
	/**
	 * Método para añadir alumno a la asignatura
	 * @param alumno
	 */
	public boolean addAlumno(Alumno alumno){
		if(alumno == null){
			return false;
		}
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return false;
		}
		if(this.isAlumnoIn(alumno) == true){
			return false;
		}
		this.alumnos.add(alumno);
		alumno.addAsignatura(this);
		try {
			EmailSystem.send(alumno.getEmail(), "Admisión", "Has sido admitido a la asignatura " + this.getNombre());
		} catch (InvalidEmailAddressException e) {
			e.printStackTrace();
		} catch (FailedInternetConnectionException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	/**
	 * Método para expulsar alumno de la asignatura
	 * Introduce el alumno en la lista de expulsados
	 * @param alumno
	 */
	public boolean expulsarAlumno(Alumno alumno){
		if(alumno == null){
			return false;
		}
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return false;
		}
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
		if(alumno == null){
			return false;
		}
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return false;
		}
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
		if(solicitud == null){
			return;
		}
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return;
		}
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
		if(sol == null){
			return false;
		}
		if(Plataforma.loggedAs() == null){
			return false;
		}
		if(this.solicitudes.contains(sol) == false && this.isAlumnoIn(sol.getAlumno()) == false && this.getSolicitudesExpulsados().contains(sol) == false){
			if(this.solicitudes.add(sol) == true){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Añade una solicitud al array de pendientes
	 * @param sol
	 */
	public boolean addSolicitudExpulsado(Solicitud sol){
		if(sol == null){
			return false;
		}
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return false;
		}
		if(this.expulsados.contains(sol) == false){
			if(this.expulsados.add(sol) == true){
				return true;
			}
		}
		
		return false;

	}
	
	
	/**
	 * Método para saber si un alumno está inscrito en la asignatura
	 * @param a
	 * @return boolean
	 */
	public boolean isAlumnoIn(Alumno a){
		if(a == null){
			return false;
		}
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
		if(sol == null){
			return false;
		}
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return false;
		}
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
		if(con == null){
			return false;
		}
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return false;
		}
		return this.raiz.add(con);
	}
	
	/**
	 * Método para eliminar un tema de la raiz
	 * También oculta todos los subcontenidos, si se trata 
	 * de un tema
	 * @param tema
	 */
	public void eraseContenidoRaiz(Contenido con){
		if(con == null){
			return;
		}
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return;
		}
		this.raiz.remove(con);
		con.ocultarContenido();
		return;
	}
	
	/**
	 * Método para eliminar un contenido
	 * Si está en la raíz (padre == null) llama a eraseContenidoRaiz
	 * Si es un subcontenido, llama a contenido.eraseContenido
	 * @param con
	 */
	public boolean eraseContenido(Contenido con){
		if(con == null){
			return false;
		}
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return false;
		}
		if(con.esBorrable() == false){
			return false;
		}
		else if(con.getPadre() == null){
			this.eraseContenidoRaiz(con);
		}
		else {
			con.eraseContenido();
		}
		
		return true;
	}
	
	/**
	 * Metodo para añadir subcontenido
	 * Si padre es null, lo añade a la raiz 
	 * @param subcontenido
	 * @param padre
	 * @return boolean
	 */
	public boolean addSubcontenido(Contenido sub, Tema padre){
		if(sub == null){
			return false;
		}
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return false;
		}
		if(padre == null){
			return this.addContenidoRaiz(sub);
		}
		else {
			return padre.addSubcontenido(sub);
		}
	}
	
	/**
	 * Añade una estadisitica de un alumno a la asignatura
	 * @param estadisticasAlumno
	 */
	public boolean addEstadistica(EstadisticasAlumno estadisticasAlumno) {
		if(estadisticasAlumno == null){
			return false;
		}
		if(Plataforma.loggedAs() == null){
			return false;
		}
		return this.estadisticas.add(estadisticasAlumno);
	}
	
	//Overrides
	
	/**
	 * (Override) toString
	 * Devolvería un string con los alumnos de la asignatura
	 * @return String
	 */
	@Override
	public String toString(){
		String aux = "";
		if(Plataforma.loggedAs().getClass() == Alumno.class){
			for(Contenido c: this.raiz){
				if(c.getVisibilidad() == true){
					aux += c.toString();
				}
			}
			return "Asignatura: "+ this.nombre + " Alumnos en la asignatura: " + this.alumnos + "\n" + aux;
		}
		else{
			for(Contenido c: this.raiz){
				aux += c.toString();
			}
			return "Asignatura: "+ this.nombre + " Alumnos en la asignatura: " + this.alumnos + "\n" + aux;
		}
	}
	
	/**
	 * Método a llamar al borrar una asignatura
	 */
	public void eraseAsignatura(){
		for(Alumno al : this.alumnos){
			al.eraseAsignatura(this);
		}
	}
	
	/**
	 * (Override) equals de Asignatura
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj){
		if(obj == null) return false;
		else if(!(obj instanceof Asignatura)) return false;
		
		Asignatura asig = (Asignatura) obj;
		
		return this.getNombre().equals(asig.getNombre());
	}

	
}
