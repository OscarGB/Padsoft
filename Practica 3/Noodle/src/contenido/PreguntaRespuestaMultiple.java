package contenido;

import java.io.Serializable;

/**
 * Clase RespuestaMultiple
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public class PreguntaRespuestaMultiple extends Pregunta implements Serializable{
	
	//Variables
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Numero de respuestas correctas que hay
	 */
	private int numCorrectas;
	
	//Constructores
		/**
		 * Constructor de PreguntaRespuestaSimple con penalización
		 * @param enunciado
		 * @param aleatorio
		 * @param penalizacion
		 * @param valorPregunta
		 */
		public PreguntaRespuestaMultiple(String enunciado, boolean aleatorio, float penalizacion, float valorPregunta){
			super(enunciado, aleatorio, penalizacion, valorPregunta);
			this.numCorrectas = 0;
		}
		
		/**
		 * Constructor de PreguntaRespuestaSimple sin penalización
		 * @param enunciado
		 * @param aleatorio
		 * @param penalizacion
		 * @param valorPregunta
		 */
		public PreguntaRespuestaMultiple(String enunciado, boolean aleatorio, float valorPregunta){
			super(enunciado, aleatorio, valorPregunta);
			this.numCorrectas = 0;
		}
		
		//Getters y setters
		
		
		/**
		 * Get del número de respuestas correctas
		 * @return numCorrectas
		 */
		public int getNum(){
			return this.numCorrectas;
		}
		
		//Métodos
		
		/** 
		 * Método que añade una opción e incrementa el número de respuestas
		 * correctas
		 */
		public boolean addOpcion(Opciones opcion){
			this.numCorrectas ++;
			return this.opciones.add(opcion);
		}
		
		/**
		 * Método para borrar una opción
		 */
		public void removeOpcion(Opciones opcion){
			if(opcion == null) return;
			this.opciones.remove(opcion);
			return;
		}
}
