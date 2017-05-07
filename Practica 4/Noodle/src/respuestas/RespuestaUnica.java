package respuestas;

import contenido.Opciones;
import contenido.Pregunta;

/**
 * Clase RespuestaUnica
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public class RespuestaUnica extends RespuestaPregunta{
	
	//Variables
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Respuesta escogida
	 */
	private Opciones respuesta;
	
	//Cosntructor

	/**
	 * constructor de respuesta simple
	 * @param p
	 * @param respuesta
	 */
	public RespuestaUnica(Pregunta p, Opciones respuesta) {
		super(p);
		this.respuesta = respuesta;
	}
	
	//Método
	
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
	
	//Override
	
	/**
	 * toString, Override
	 * @return String
	 */
	@Override
	public String toString(){
		return "Pregunta Unica: '" + this.preguntaRespondida.getEnunciado() + "' Respondido: " + this.respuesta;
	}
}
