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
	
	//Variables
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Respuesta a la pregunta
	 */
	private boolean respondido;
	
	//Constructor
	
	/**
	 * Constructor de respuesta Unica.
	 * @param p
	 * @param respondido
	 */
	public RespuestaSimple(Pregunta p, boolean respondido){
		super(p);
		this.respondido = respondido;
	}
	
	//Métodos
	
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
	
	//Override
	
	/**
	 * toString, Override
	 * @return String
	 */
	@Override
	public String toString(){
		return "Pregunta Simple: '" + this.preguntaRespondida.getEnunciado() + "' Respondido: " + this.respondido;
	}
}
