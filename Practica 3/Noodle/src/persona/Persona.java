package persona;

import java.io.Serializable;


/**
 * Clase Persona
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */
public abstract class Persona implements Serializable{
	
	//Variables
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;

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
	
	//Constructor
	
	/**
	 * Constructor de la clase Persona
	 * @param nia
	 * @param nombre
	 * @param password
	 */
	public Persona(String nia, String nombre, String password) {
		this.nia = nia;
		this.nombre = nombre;
		this.password = password;
	}
	
	//Setters y getters
	
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
	
	//Override

	/**
	 * (Override) toString()
	 * Escribe en un String los datos de Persona
	 * @return String 
	 */
	@Override
	public String toString() {
		return "NIA: " + this.nia + ". Nombre: "+ this.nombre + ". Password" + this.password;
	}
	
	
}
