package respuestas;

import contenido.Pregunta;
import contenido.PreguntaRespuestaAbierta;
import contenido.PreguntaRespuestaUnica;

/**
 * Clase RespuestaAbierta
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public class RespuestaAbierta extends RespuestaPregunta {
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
}
