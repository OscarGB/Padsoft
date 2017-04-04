package respuestas;

import contenido.Pregunta;
import contenido.PreguntaRespuestaAbierta;

/**
 * Clase RespuestaAbierta
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 21/03/2017
 */

public class RespuestaAbierta extends RespuestaPregunta {
	
	//Variables
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * String respondido
	 */
	private String respondido;
	
	//Constructor
	
	/**
	 * Constructor de respuesta abierta
	 * @param p
	 * @param respondido
	 */
	public RespuestaAbierta(Pregunta p, String respondido){
		super(p);
		this.respondido = respondido;
	}
	
	//Métodos
	
	/**
	 * Método para comprobar si la respuesta abierta es correcta
	 * @return boolean
	 */
	@Override
	public boolean esCorrecta(){
		if(((PreguntaRespuestaAbierta)this.preguntaRespondida).getRespuestas().contains(respondido)){
			return true;
		}
		return false;
	}
	
	//Override
	
	/**
	 * toString, Override
	 * @return String
	 */
	@Override
	public String toString(){
		return "Pregunta Abierta: '" + this.preguntaRespondida.getEnunciado() + "' Respondido: " + this.respondido;
	}
}
