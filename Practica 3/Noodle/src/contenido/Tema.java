package contenido;

import java.util.ArrayList;

/**
 * Clase Tema
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */
public class Tema extends Contenido {
	/**
	 * Array de subtemas
	 */
	private ArrayList<Contenido> subtemas;
	
	/**
	 * Constructor de la clase Tema
	 * @param titulo
	 * @param visibilidad
	 * @param subtemas
	 */
	public Tema(String titulo, boolean visibilidad, ArrayList<Contenido> subtemas) {
		super(titulo, visibilidad);
		this.subtemas = subtemas;
	}

	/**
	 * Getter de subtemas
	 * @return ArrayList<Contenido>
	 */
	public ArrayList<Contenido> getSubtemas() {
		return subtemas;
	}

	/**
	 * Setter de subtemas
	 * @param ArrayList<Contenido> subtemas
	 */
	public void setSubtemas(ArrayList<Contenido> subtemas) {
		this.subtemas = subtemas;
	}
	
	/**
	 * (Override) toString()
	 * Esribe en un string los datos de Tema
	 * @return String
	 */
	@Override
	public String toString() {
		String aux;
		aux = "";
		
		for(Contenido i: subtemas){
			aux += i.titulo;
			aux += " ";
		}
		return "Titulo del tema: " + this.titulo + "\nTitulos de subtemas: " + aux + "\n";
	}
	

}
