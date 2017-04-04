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
	 * Constructor de PreguntaRespuestaSimple
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
	 * Constructor de PreguntaRespuestaSimple sin penalizaci�n
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
	 * Get respuestas correctas
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
	@Override
	public boolean addOpcion(String respuesta){
		if(respuesta == null) return false;
		return this.respuestas.add(respuesta);
	}
	
	
	/**
	 * M�todo para eliminar una posible respuesta abierta
	 * @param respuesta
	 */
	@Override
	public void removeOpcion(String respuesta){
		if(respuesta == null) return;
		this.respuestas.remove(respuesta);
		return;
	}
	
	/**
	 * M�todo para comprobar que una pregunta est�
	 * bien formada
	 */
	@Override
	public boolean bienFormada(){
		if(this.respuestas.isEmpty()){
			return false;
		}
		else {
			return true;
		}
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
