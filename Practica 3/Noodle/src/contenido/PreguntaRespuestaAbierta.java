package contenido;

import java.util.ArrayList;

public class PreguntaRespuestaAbierta extends Pregunta {
	
	//Variables
	
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
	 * Constructor de PreguntaRespuestaUnica sin penalización
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
	 * Método para añadir una posible respuesta abierta
	 * @param respuesta
	 * @return boolean
	 */
	public boolean addRespuestaAbierta(String respuesta){
		return this.respuestas.add(respuesta);
	}
	
	/**
	 * Método para eliminar una posible respuesta abierta
	 * @param respuesta
	 */
	public void removeRespuestaAbierta(String respuesta){
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
				+ "\nPenalización: " + this.penalizacion;
	}
	
	
}
