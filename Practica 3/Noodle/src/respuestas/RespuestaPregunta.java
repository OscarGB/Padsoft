package respuestas;

import contenido.Pregunta;

/**
 * Clase RespuestaPregunta
 * @author Óscar Gómez Borzdynski
 * @author Jose Ignacio Gómez García
 * @date 07/03/2017
 */

public abstract class RespuestaPregunta {
	/**
	 * Almacena la nota obtenida en la pregunta
	 */
	protected float nota;
	
	/**
	 * Pregunta que ha sido respondida en esta pregunta
	 */
	protected Pregunta preguntaRespondida;
	
	/**
	 * Constructor de RespuestaPregunta
	 * @param p
	 */
	public RespuestaPregunta(Pregunta p){
		this.nota = 0;
		this.preguntaRespondida = p;
	}
	
	/** Método que calcula la nota obtenida en la pregunta
	 * @return float
	 */
	public float CalcularNota(){
		if(this.nota != 0){
			return this.nota;
		}
		if(this.esCorrecta() == true){
			nota = this.preguntaRespondida.getValorPregunta();
		}
		else{
			nota = this.preguntaRespondida.getPenalizacion();
		}
		return nota;
	}
	
	/**
	 * Método que comprueba si la respuesta es correcta
	 * @return boolean
	 */
	public boolean esCorrecta(){
		return false;
	}
}
