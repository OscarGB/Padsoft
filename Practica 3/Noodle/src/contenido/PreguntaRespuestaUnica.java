package contenido;
import java.io.Serializable;

/**
 * Clase PreguntaRespuestaUnica
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public class PreguntaRespuestaUnica extends Pregunta implements Serializable{
	//Variables
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Respuesta única
	 */
	private boolean respuesta;
	
	
	//Constructores
	
	/**
	 * Constructor de PreguntaRespuestaUnica
	 * Siempre se le pasa la respuesta (boolean)
	 * @param enunciado
	 * @param aleatorio
	 * @param penalizacion
	 * @param valorPregunta
	 * @param respuesta
	 */
	public PreguntaRespuestaUnica(String enunciado, boolean aleatorio, float penalizacion, float valorPregunta, boolean respuesta){
		super(enunciado, aleatorio, penalizacion, valorPregunta);
		this.respuesta = respuesta;
	}
	
	/**
	 * Constructor de PreguntaRespuestaUnica sin penalización
	 * Siempre se le pasa la respuesta (boolean)
	 * @param enunciado
	 * @param aleatorio
	 * @param valorPregunta
	 * @param respuesta
	 */
	public PreguntaRespuestaUnica(String enunciado, boolean aleatorio, float valorPregunta, boolean respuesta){
		super(enunciado, aleatorio, valorPregunta);
		this.respuesta = respuesta;
	}

	
	//Getters y setters
	
	/**
	 * Get de respuesta unica
	 * @return respuesta
	 */
	public boolean getRespuesta() {
		return respuesta;
	}

	/**
	 * Set respuesta unica
	 * @param respuesta
	 */
	public void setRespuesta(boolean respuesta) {
		this.respuesta = respuesta;
	}
	
	//Override
	
		/**
		 * (Override) toString para respuesta unica
		 */
		@Override
		public String toString(){
			return "Pregunta: " + this.enunciado + "\n" + "Respuesta correcta: " + this.respuesta + "\nValor: " + this.valorPregunta
					+ "\nPenalización: " + this.penalizacion;
		}
	
	
}
