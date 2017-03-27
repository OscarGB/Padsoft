package contenido;
import java.io.Serializable;

/**
 * Clase PreguntaRespuestaSimple
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public class PreguntaRespuestaSimple extends Pregunta implements Serializable{
	
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;

	//Constructores
	/**
	 * Constructor de PreguntaRespuestaSimple con penalización
	 * @param enunciado
	 * @param aleatorio
	 * @param penalizacion
	 * @param valorPregunta
	 */
	public PreguntaRespuestaSimple(String enunciado, boolean aleatorio, float penalizacion, float valorPregunta){
		super(enunciado, aleatorio, penalizacion, valorPregunta);
	}
	
	/**
	 * Constructor de PreguntaRespuestaSimple sin penalización
	 * @param enunciado
	 * @param aleatorio
	 * @param penalizacion
	 * @param valorPregunta
	 */
	public PreguntaRespuestaSimple(String enunciado, boolean aleatorio, float valorPregunta){
		super(enunciado, aleatorio, valorPregunta);
	}
	
	//Metodos
	
	/**
	 * Método privado para saber el número de respuestas correctas que hay
	 * @return
	 */
	private int numCorrectas(){
		int num = 0;
		for(Opciones op: this.opciones){
			if(op.esCorrecta() == true){
				num ++;
			}
		}
		
		return num;
	}
	
	/**
	 * Método que añade opciones al array de opciones
	 * Si ya hay una correcta, no permite meter otra
	 */
	public boolean addOpcion(Opciones op){
		if((op.esCorrecta() == true) && (this.numCorrectas() >=1)){
			return false;
		}
		
		return this.opciones.add(op);
	}
}
