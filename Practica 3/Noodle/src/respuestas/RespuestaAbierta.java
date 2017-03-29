package respuestas;

import contenido.Pregunta;
import contenido.PreguntaRespuestaAbierta;

/**
 * Clase RespuestaAbierta
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public class RespuestaAbierta extends RespuestaPregunta {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Strign respondido
	 */
	private String respondido;
	
	/**
	 * Constructor de respuesta abierta
	 * @param p
	 * @param respondido
	 */
	public RespuestaAbierta(Pregunta p, String respondido){
		super(p);
		this.respondido = respondido;
	}
	
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
	
	/**
	 * toString, Override
	 * @return String
	 */
	@Override
	public String toString(){
		return "Pregunta Abierta: '" + this.preguntaRespondida.getEnunciado() + "' Respondido: " + this.respondido;
	}
}
