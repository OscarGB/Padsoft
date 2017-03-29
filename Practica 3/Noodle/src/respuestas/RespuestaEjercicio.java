package respuestas;

import java.io.Serializable;
import java.util.ArrayList;

import contenido.Ejercicio;

/**
 * Clase RespuestaEjercicio
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public class RespuestaEjercicio implements Serializable {
	
	//Variables
	
	/**
	 * Para Serializar
	 */
	private static final long serialVersionUID = 1L;

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
	 * nota máxima de un ejercicio
	 */
	public static final float NOTAMAX = 10;
	
	//Constructor
	
	/**
	 * Constructor de respuesta ejercicio
	 */
	public RespuestaEjercicio(Ejercicio ej){
		respuestas = new ArrayList<RespuestaPregunta>();
		nota = 0;
		this.ej = ej;
	}
	
	/**
	 * Get Ejercicio
	 * @return Ejercicio
	 */
	public Ejercicio getEjercicio(){
		return this.ej;
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
		this.nota = (nota/this.ej.getPesoPreguntas())*NOTAMAX;
		if(this.nota < 0){
			this.nota = 0;
		}
		return this.nota;
	}	
	
	/**
	 * toString, Override
	 * @return String
	 */
	@Override
	public String toString(){
		return "Respuestas al ejercicio " + this.ej.getTitulo() + "\n\tRespuestas: " + this.respuestas;
	}
}
