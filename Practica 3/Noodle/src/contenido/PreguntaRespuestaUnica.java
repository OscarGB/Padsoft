package contenido;
import java.io.Serializable;

/**
 * Clase PreguntaRespuestaUnica
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public class PreguntaRespuestaUnica extends Pregunta implements Serializable{
	
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;

	//Constructores
	/**
	 * Constructor de PreguntaRespuestaUnica con penalizaci�n
	 * @param enunciado
	 * @param aleatorio
	 * @param penalizacion
	 * @param valorPregunta
	 */
	public PreguntaRespuestaUnica(String enunciado, boolean aleatorio, float penalizacion, float valorPregunta){
		super(enunciado, aleatorio, penalizacion, valorPregunta);
	}
	
	/**
	 * Constructor de PreguntaRespuestaSimple sin penalizaci�n
	 * @param enunciado
	 * @param aleatorio
	 * @param valorPregunta
	 */
	public PreguntaRespuestaUnica(String enunciado, boolean aleatorio, float valorPregunta){
		super(enunciado, aleatorio, valorPregunta);
	}
	
	//Metodos
	
	/**
	 * M�todo privado para saber el n�mero de respuestas correctas que hay
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
	 * M�todo que a�ade opciones al array de opciones
	 * Si ya hay una correcta, no permite meter otra
	 */
	public boolean addOpcion(Opciones op){
		if((op.esCorrecta() == true) && (this.numCorrectas() >=1)){
			return false;
		}
		
		return this.opciones.add(op);
	}
	
	/**
	 * AddOpcion(string) devuelve false en unica
	 */
	public boolean addOpcion(String str){
		return false;
	}
	
	/**
	 * M�todo para borrar una opci�n
	 */
	public void removeOpcion(Opciones opcion){
		if(opcion == null) return;
		this.opciones.remove(opcion);
		return;
	}
	
	/**
	 * M�todo para comprobar que una pregunta est�
	 * bien formada
	 */
	public boolean bienFormada(){
		int numTrue = 0;
		for(Opciones op: this.opciones){
			if(op.esCorrecta() == true){
				numTrue ++;
			}
		}
		if(numTrue == 1){
			return true;
		}
		else {
			return false;
		}
	}
}
