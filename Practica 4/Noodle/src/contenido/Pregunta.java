package contenido;

import java.util.ArrayList;

import persona.Alumno;
import plataforma.Plataforma;

import java.io.Serializable;

/**
 * Clase Pregunta
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public abstract class Pregunta implements Serializable{
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	//Variables
		
	/**
	 * Penalizacion por defecto
	 */
	private static final float PENALIZACION_DEFECTO = 0.f;

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
		this.penalizacion = - Math.abs(penalizacion);
		this.valorPregunta = Math.abs(valorPregunta);
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
		this.penalizacion = Pregunta.PENALIZACION_DEFECTO;
		this.valorPregunta = valorPregunta;
		this.opciones = new ArrayList<Opciones>();
		this.numCorrectas = 0;
		this.numRespuestas = 0;
	}
	
	
	//Getters y setters
	
	/**
	 * Getter de la penalizaci�n por defecto
	 * @return float
	 */
	public float getPenalizacionDefecto(){
		return Pregunta.PENALIZACION_DEFECTO;
	}

	/**
	 * Getter enunciado
	 * @return String
	 */
	public String getEnunciado() {
		return enunciado;
	}

	/**
	 * Setter enunciado
	 * @param enunciado
	 */
	public void setEnunciado(String enunciado) {
		if(enunciado == null || enunciado == "") return;
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return;
		}
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
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return;
		}
		this.aleatorio = aleatorio;
	}

	/**
	 * Getter penalizaci�n
	 * @return penalizaci�n
	 */
	public float getPenalizacion() {
		return penalizacion;
	}

	/**
	 * Set penalizaci�n
	 * @param penalizaci�n
	 */
	public void setPenalizacion(float penalizacion) {
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return;
		}
		this.penalizacion = - Math.abs(penalizacion);
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
		if(Plataforma.loggedAs() == null || Plataforma.loggedAs().getClass() == Alumno.class){
			return;
		}
		this.valorPregunta = Math.abs(valorPregunta);
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
		return false;
	}
	
	/**
	 * M�todo para a�adir una posible respuesta abierta
	 * Se va a sobreescribir
	 * @param respuesta
	 * @return boolean
	 */
	public boolean addOpcion(String respuesta){
		return false;
	}
	
	/**
	 * M�todo para eliminar una posible respuesta abierta
	 * Se va a sobreescribir
	 * @param respuesta
	 */
	public void removeOpcion(String respuesta){
		return;
	}
	
	/**
	 * M�todo para eliminar una opci�n de la pregunta
	 * @param opcion
	 */
	public void removeOpcion(Opciones opcion){
		return;
	}
	
	/**
	 * M�todo para incrementar el n�mero de preguntas respondidas erroneamente
	 */
	public void addRespondida(){
		this.numRespuestas ++;
	}
	
	/**
	 * M�todo para incrementar el n�mero de preguntas respondidas correctamente
	 */
	public void addCorrecta(){
		this.numRespuestas ++;
		this.numCorrectas ++;
	}
	
	/**
	 * M�todo para comprobar que una pregunta est� bien formada
	 * @return boolean
	 */
	public boolean bienFormada(){
		return true;
	}
	
	
	//Override
	
	/**
	 * toString, Override
	 * @return String
	 */
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
