package respuestas;

import contenido.Pregunta;
import contenido.PreguntaRespuestaSimple;

/**
 * Clase RespuestaSimple
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */
public class RespuestaSimple extends RespuestaPregunta{
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Respuesta a la pregunta
	 */
	private boolean respondido;
	
	/**
	 * Constructor de respuesta Unica.
	 * @param p
	 * @param respondido
	 */
	public RespuestaSimple(Pregunta p, boolean respondido){
		super(p);
		this.respondido = respondido;
	}
	
	/**
	 * Método para comprobar si la respuesta Ãºnica es correcta
	 * @return boolean
	 */
	@Override
	public boolean esCorrecta(){
		if(((PreguntaRespuestaSimple)this.preguntaRespondida).getRespuesta() == this.respondido){
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
		return "Pregunta Única: '" + this.preguntaRespondida.getEnunciado() + "' Respondido: " + this.respondido;
	}
}
