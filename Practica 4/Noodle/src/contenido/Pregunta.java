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
	 * Flag que indica si las respuestas se mostrarán en orden aleatorio
	 * o en orden de creación
	 */
	protected boolean aleatorio;
	
	/**
	 * Valor de penalización de un fallo
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
	
	//Variables para las estadísticas	
	/**
	 * Número de alumnos que ha contestado a la pregunta
	 */
	protected int numRespuestas;
	
	/**
	 * Número de alumnos que han respondido correctamente
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
	 * Constructor de Pregunta con penalización por defecto (0)
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
	 * Getter de la penalización por defecto
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
	 * Getter penalización
	 * @return penalización
	 */
	public float getPenalizacion() {
		return penalizacion;
	}

	/**
	 * Set penalización
	 * @param penalización
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
	
	
	
	//Métodos
	
	/**
	 * Método para añadir una opción a la pregunta
	 * Se va a sobreescribir
	 * @param opcion
	 * @return boolean
	 */
	public boolean addOpcion(Opciones opcion){
		return false;
	}
	
	/**
	 * Método para añadir una posible respuesta abierta
	 * Se va a sobreescribir
	 * @param respuesta
	 * @return boolean
	 */
	public boolean addOpcion(String respuesta){
		return false;
	}
	
	/**
	 * Método para eliminar una posible respuesta abierta
	 * Se va a sobreescribir
	 * @param respuesta
	 */
	public void removeOpcion(String respuesta){
		return;
	}
	
	/**
	 * Método para eliminar una opción de la pregunta
	 * @param opcion
	 */
	public void removeOpcion(Opciones opcion){
		return;
	}
	
	/**
	 * Método para incrementar el número de preguntas respondidas erroneamente
	 */
	public void addRespondida(){
		this.numRespuestas ++;
	}
	
	/**
	 * Método para incrementar el número de preguntas respondidas correctamente
	 */
	public void addCorrecta(){
		this.numRespuestas ++;
		this.numCorrectas ++;
	}
	
	/**
	 * Método para comprobar que una pregunta está bien formada
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
				+ "\nPenalización: " + this.penalizacion;
	}
	
}
