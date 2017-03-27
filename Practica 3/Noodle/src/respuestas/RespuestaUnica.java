package respuestas;

import contenido.Pregunta;
import contenido.PreguntaRespuestaUnica;

/**
 * Clase RespuestaUnica
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */
public class RespuestaUnica extends RespuestaPregunta{
	/**
	 * Respuesta a la pregunta
	 */
	private boolean respondido;
	
	/**
	 * Constructor de respuesta única.
	 * @param p
	 * @param respondido
	 */
	public RespuestaUnica(Pregunta p, boolean respondido){
		super(p);
		this.respondido = respondido;
	}
	
	/**
	 * Método para comprobar si la respuesta única es correcta
	 * @return boolean
	 */
	@Override
	public boolean esCorrecta(){
		if(((PreguntaRespuestaUnica)this.preguntaRespondida).getRespuesta() == this.respondido){
			return true;
		}
		return false;
	}
}
