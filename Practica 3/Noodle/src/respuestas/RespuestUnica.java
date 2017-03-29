package respuestas;

import contenido.Opciones;
import contenido.Pregunta;
import contenido.PreguntaRespuestaAbierta;

/**
 * Clase RespuestUnica
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public class RespuestUnica extends RespuestaPregunta{
	/**
	 * Respuesta escogida
	 */
	private Opciones respuesta;

	/**
	 * constructor de respuesta simple
	 * @param p
	 * @param respuesta
	 */
	public RespuestUnica(Pregunta p, Opciones respuesta) {
		super(p);
		this.respuesta=respuesta;
	}
	
	/**
	 * Método para comprobar si la respuesta simple es correcta
	 * @return boolean
	 */
	@Override
	public boolean esCorrecta(){
		for( Opciones o : this.preguntaRespondida.getOpciones()){
			if(o.getRespuesta() == this.respuesta.getRespuesta()){
				return o.esCorrecta();
			}
		}
		return false;
	}
	
	/**
	 * toString, Override
	 * @return String
	 */
	@Override
	public String toString(){
		return "Pregunta Simple: '" + this.preguntaRespondida.getEnunciado() + "' Respondido: " + this.respuesta;
	}
}
