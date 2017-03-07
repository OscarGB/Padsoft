package persona;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


/**
 * Clase Persona
 * @author Óscar Gómez Borzdynski
 * @author Jose Ignacio Gómez García
 * @date 07/03/2017
 */
public abstract class Persona {
	
	/**
	 * NIA de la persona
	 */
	protected String nia;
	/**
	 * Nombre de la persona
	 */
	protected String nombre;
	/**
	 * Contraseña de la persona
	 */
	protected String password;
	
	/**
	 * Fecha de Inscripción de una Persona
	 */
	protected LocalDate fechaInscripcion;
	
	/**
	 * Constructor de la clase Persona
	 * @param nia
	 * @param nombre
	 * @param password
	 */
	public Persona(String nia, String nombre, String password, String fecha) {
		this.nia = nia;
		this.nombre = nombre;
		this.password = password;
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		this.fechaInscripcion = LocalDate.parse(fecha, dtf);
	}
	
	/**
	 * Devuelve el NIA de una persona
	 * @return String
	 */
	public String getNia() {
		return nia;
	}
	/**
	 * Da valor al NIA de una persona
	 * @param nia
	 */
	public void setNia(String nia) {
		this.nia = nia;
	}
	/**
	 * Devuelve el nombre de una persona
	 * @return String
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Da valor al nombre de una persona
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Devuelve la contraseña de una persona
	 * @return String
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Da valor a la contraseña de una persona
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * (Override) toString()
	 * Escribe en un String los datos de Persona
	 * @return String 
	 */
	@Override
	public String toString() {
		return "NIA: " + this.nia + ". Nombre: "+ this.nombre + ". Password" + this.password + ". Fecha de inscripción: " + this.fechaInscripcion;
	}
	
	
}
