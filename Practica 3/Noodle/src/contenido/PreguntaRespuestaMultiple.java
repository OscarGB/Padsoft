package contenido;

import java.io.Serializable;

/**
 * Clase RespuestaMultiple
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 10/03/2017
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
		 * Constructor de PreguntaRespuestaSimple con penalizaci�n
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
		 * Constructor de PreguntaRespuestaSimple sin penalizaci�n
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
		 * Get del n�mero de respuestas correctas
		 * @return numCorrectas
		 */
		public int getNum(){
			return this.numCorrectas;
		}
		
		//M�todos
		
		/** 
		 * M�todo que a�ade una opci�n e incrementa el n�mero de respuestas
		 * correctas
		 */
		@Override
		public boolean addOpcion(Opciones opcion){
			if(opcion == null) return false;
			this.numCorrectas ++;
			return this.opciones.add(opcion);
		}
		
		/**
		 * M�todo para borrar una opci�n
		 */
		@Override
		public void removeOpcion(Opciones opcion){
			if(opcion == null) return;
			this.opciones.remove(opcion);
			return;
		}
		
		/**
		 * M�todo para comprobar si una pregunta est� bien formada
		 */
		@Override
		public boolean bienFormada(){
			if(this.getOpciones().isEmpty()){
				return false;
			}
			for(Opciones op: this.opciones){
				if(op.esCorrecta() == true){
					return true;
				}
			}
			return false;
		}
}
