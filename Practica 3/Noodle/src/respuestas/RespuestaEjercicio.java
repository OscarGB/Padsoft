package respuestas;

import java.util.ArrayList;

import contenido.Ejercicio;

/**
 * Clase RespuestaEjercicio
 * @author Óscar Gómez Borzdynski
 * @author Jose Ignacio Gómez García
 * @date 07/03/2017
 */

public class RespuestaEjercicio {
	/**
	 * Respuestas de las preguntas
	 */
	private ArrayList<RespuestaPregunta> respuestas;
	
	/**
	 * nota del ejercicio
	 */
	private float nota;
	
	/**
	 * Ejercicio que se responde
	 */
	private Ejercicio ej;
	
	/**
	 * Get Ejercicio
	 * @return Ejercicio
	 */
	public Ejercicio getEjercicio(){
		return this.ej;
	}
	
	/**
	 * Constructor de respuesta ejercicio
	 */
	public RespuestaEjercicio(){
		respuestas = new ArrayList<RespuestaPregunta>();
		nota = 0;
	}
	
	/**
	 * Método para añadir una respuesta
	 * @param r
	 */
	public void addRespuesta(RespuestaPregunta r){
		this.respuestas.add(r);
	}
	
	/**
	 * Calcula la nota obtenida en el ejercicio
	 * @return float
	 */
	public float calcularNota(){
		float nota = 0;
		for(RespuestaPregunta rp : this.respuestas){
			nota += rp.CalcularNota();
		}
		this.nota = nota/this.ej.getPesoPreguntas();
		return this.nota;
	}	
}
