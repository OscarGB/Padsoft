package contenido;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * Clase PreguntaRespuestaAbierta
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public class PreguntaRespuestaAbierta extends Pregunta implements Serializable {
	
	//Variables
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Respuesta
	 */
	private ArrayList<String> respuestas;
	
	
	//Constructores
	
	/**
	 * Constructor de PreguntaRespuestaUnica
	 * Siempre se le pasa la respuesta (boolean)
	 * @param enunciado
	 * @param aleatorio
	 * @param penalizacion
	 * @param valorPregunta
	 * @param respuesta
	 */
	public PreguntaRespuestaAbierta(String enunciado, boolean aleatorio, float penalizacion, float valorPregunta){
		super(enunciado, aleatorio, penalizacion, valorPregunta);
		this.respuestas = new ArrayList<String>();
	}
	
	/**
	 * Constructor de PreguntaRespuestaUnica sin penalizaci�n
	 * Siempre se le pasa la respuesta (boolean)
	 * @param enunciado
	 * @param aleatorio
	 * @param valorPregunta
	 * @param respuesta
	 */
	public PreguntaRespuestaAbierta(String enunciado, boolean aleatorio, float valorPregunta){
		super(enunciado, aleatorio, valorPregunta);
		this.respuestas = new ArrayList<String>();
	}

		
	//Getters and setters
	
	/**
	 * Get respuesta abierta
	 * @return respuesta
	 */
	public ArrayList<String> getRespuestas() {
		return respuestas;
	}
	
	
	//Metodos
	
	/**
	 * M�todo para a�adir una posible respuesta abierta
	 * @param respuesta
	 * @return boolean
	 */
	public boolean addOpcion(String respuesta){
		return this.respuestas.add(respuesta);
	}
	
	/**
	 * M�todo para eliminar una posible respuesta abierta
	 * @param respuesta
	 */
	public void removeOpcion(String respuesta){
		this.respuestas.remove(respuesta);
		return;
	}
	
	//Override
	
	/**
	 * (Override) toString para respuesta abierta
	 */
	@Override
	public String toString(){
		String aux = "";
		for(String r: respuestas){
			aux += r + ". ";
		}
		return "Pregunta: " + this.enunciado + "\n" + "Respuestas aceptadas: " + aux + "\nValor: " + this.valorPregunta
				+ "\nPenalizaci�n: " + this.penalizacion;
	}
	
	
}
