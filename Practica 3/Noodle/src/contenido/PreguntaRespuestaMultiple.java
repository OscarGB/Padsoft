package contenido;

public class PreguntaRespuestaMultiple extends Pregunta{
	
	//Variables
	
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
		public boolean addOpcion(Opciones opcion){
			this.numCorrectas ++;
			return this.opciones.add(opcion);
		}
}
