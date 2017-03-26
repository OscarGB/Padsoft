package contenido;

import java.util.ArrayList;

public abstract class Pregunta {
	
	//Variables
	
	/**
	 * Enunciado de la pregunta
	 */
	protected String enunciado;
	
	/**
	 * Flag que indica si las respuestas se mostrar�n en orden aleatorio
	 * o en orden de creaci�n
	 */
	protected boolean aleatorio;
	
	/**
	 * Valor de penalizaci�n de un fallo
	 */
	protected float penalizacion;
	
	/**
	 * Valor de la pregunta dentro del ejercicio
	 */
	protected float valorPregunta;
	
	/**
	 * Array de posibles respuestas
	 */
	protected ArrayList<Opciones> opciones;
	
	//Variables para las estad�sticas	
	/**
	 * N�mero de alumnos que ha contestado a la pregunta
	 */
	protected int numRespuestas;
	
	/**
	 * N�mero de alumnos que han respondido correctamente
	 */
	protected int numCorrectas;
	
	
	//Constructores
	
	/**
	 * Constructor de Pregunta con todos los valores
	 * @param enunciado
	 * @param aleatorio
	 * @param penalizacion
	 * @param valorPregunta
	 */
	public Pregunta(String enunciado, boolean aleatorio, float penalizacion, float valorPregunta){
		this.enunciado = enunciado;
		this.aleatorio = aleatorio;
		this.penalizacion = penalizacion;
		this.valorPregunta = valorPregunta;
		this.numCorrectas = 0;
		this.numRespuestas = 0;
		this.opciones = new ArrayList<Opciones>();
	}
	
	/**
	 * Constructor de Pregunta con penalizaci�n por defecto (0)
	 * @param enunciado
	 * @param aleatorio
	 * @param valorPregunta
	 * @param opciones
	 */
	public Pregunta(String enunciado, boolean aleatorio, float valorPregunta){
		this.enunciado = enunciado;
		this.aleatorio = aleatorio;
		this.penalizacion = 0f;
		this.valorPregunta = valorPregunta;
		this.opciones = new ArrayList<Opciones>();
		this.numCorrectas = 0;
		this.numRespuestas = 0;
	}
	
	
	//Getters y setters

	/**
	 * Getter enunciado
	 * @return enunciado
	 */
	public String getEnunciado() {
		return enunciado;
	}

	/**
	 * Setter enunciado
	 * @param enunciado
	 */
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	/**
	 * Getter aleatorio
	 * @return the aleatorio
	 */
	public boolean getAleatorio() {
		return aleatorio;
	}

	/**
	 * set aleatorio
	 * @param aleatorio 
	 */
	public void setAleatorio(boolean aleatorio) {
		this.aleatorio = aleatorio;
	}

	/**
	 * Getter penalizacion
	 * @return penalizacion
	 */
	public float getPenalizacion() {
		return penalizacion;
	}

	/**
	 * Set penalizacion
	 * @param penalizacion
	 */
	public void setPenalizacion(float penalizacion) {
		this.penalizacion = penalizacion;
	}

	/**
	 * Get valorPregunta
	 * @return valorPregunta
	 */
	public float getValorPregunta() {
		return valorPregunta;
	}

	/**
	 * Set valorPregunta
	 * @param valorPregunta
	 */
	public void setValorPregunta(float valorPregunta) {
		this.valorPregunta = valorPregunta;
	}

	/**
	 * Get opciones
	 * @return opciones
	 */
	public ArrayList<Opciones> getOpciones() {
		return opciones;
	}

	/**
	 * Get numrespuestas
	 * @return numRespuestas
	 */
	public int getNumRespuestas() {
		return numRespuestas;
	}

	/**
	 * Get numCorrectas
	 * @return numCorrectas
	 */
	public int getNumCorrectas() {
		return numCorrectas;
	}
	
	
	
	//M�todos
	
	/**
	 * M�todo para a�adir una opci�n a la pregunta
	 * Se va a sobreescribir
	 * @param opcion
	 * @return boolean
	 */
	public boolean addOpcion(Opciones opcion){
		return this.opciones.add(opcion);
	}
	
	/**
	 * M�todo para eliminar una opci�n de la pregunta
	 * @param opcion
	 */
	public void removeOpcion(Opciones opcion){
		this.opciones.remove(opcion);
		return;
	}
	
	/**
	 * M�todo para incrementar el n�mero de preguntas respondidas
	 */
	public void addRespondida(){
		this.numRespuestas ++;
	}
	
	/**
	 * M�todo para incrementar el n�mero de preguntas respondidas correctamente
	 */
	public void addCorrecta(){
		this.numCorrectas ++;
	}
	
	
	//Override
	
	@Override
	public String toString(){
		String aux = "";
		for(Opciones o: this.opciones){
			aux += "- " + o.getRespuesta() + "\n";
		}
		return "Pregunta: " + this.enunciado + "\n" + aux + "Valor: " + this.valorPregunta
				+ "\nPenalizaci�n: " + this.penalizacion;
	}
	
}
