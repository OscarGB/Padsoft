package contenido;
import java.io.Serializable;

import java.util.ArrayList;

import asignatura.Asignatura;

/**
 * Clase Tema
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */
public class Tema extends Contenido  implements Serializable{
	
	//Variables
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ArrayList de contenidos
	 */
	protected ArrayList<Contenido> subcontenido;
	
	//Constructores
	
	/**
	 * Constructor de Tema en el directorio raiz
	 * @param titulo
	 * @param visibilidad
	 * @param asignatura
	 */
	public Tema(String titulo, boolean visibilidad, Asignatura asig){
		super(titulo, visibilidad, asig);
		this.subcontenido = new ArrayList<Contenido>();
	}
	
	/**
	 * Constructor de Tema con un padre
	 * @param titulo
	 * @param visibilidad
	 * @param asignatura
	 * @param padre
	 */
	public Tema(String titulo, boolean visibilidad, Asignatura asig, Tema padre){
		super(titulo, visibilidad, asig, padre);
		this.subcontenido = new ArrayList<Contenido>();
	}
	
	//Getters y setters
	
	/**
	 * Getter de subcontenido
	 * @return ArrayList subcontenido
	 */
	public ArrayList<Contenido> getSubcontenido(){
		return this.subcontenido;
	}
	
	
	//Métodos
	
	/**
	 * Método para añadir contenido al tema actual
	 * También setea el padre del contenido a añadir
	 * @param contenido
	 * @return boolean
	 */
	public boolean addSubcontenido(Contenido con){
		con.setPadre(this);
		return this.subcontenido.add(con);
	}
	
	/**
	 * Método para eliminar un contenido del array de subcontenidos
	 * @param contenido
	 */
	public void eraseSubcontenido(Contenido con){
		con.setVisibilidad(false);
		this.subcontenido.remove(con);
		return;
	}
	
	/**
	 * Método que oculta todo el contenido recursivamente para cuando se borra
	 * un tema
	 */
	public void ocultarContenido(){
		for(Contenido c: this.subcontenido){
			c.ocultarContenido();
			c.setVisibilidad(false);
		}
		return;
	}
	
	
	//Override
	
	/**
	 * (Override) toString()
	 * Esribe en un string los datos de Tema
	 * @return String
	 */
	@Override
	public String toString() {
		String aux;
		aux = "";
		
		for(Contenido s: subcontenido){
			if(s.getVisibilidad() == true){
				aux += s.titulo;
				aux += " ";
			}
		}
		return "Titulo del tema: " + this.titulo + "\nTitulos de subcontenidos: " + aux + "\n";
	}
	

}
