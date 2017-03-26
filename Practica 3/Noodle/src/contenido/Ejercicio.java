package contenido;

import java.time.LocalDate;
import java.util.ArrayList;

import asignatura.Asignatura;

public class Ejercicio extends Contenido {
	//Variables
	
	/**
	 * Número de alumnos que han terminado el ejercicio
	 */
	private int numTerminados;
	
	/**
	 * Peso del ejercicio en la asignatura
	 */
	private int peso;
	
	/**
	 * Flag de aleatoriedad para las preguntas
	 */
	private boolean aleatorio;
	
	/**
	 * Fecha de apertura del ejercicio
	 */
	private LocalDate fechaIni;
	
	/**
	 * Fecha de cierre del ejercicio
	 */
	private LocalDate fechaFin;
	
	/**
	 * Array de preguntas del ejercicio
	 */
	private ArrayList<Pregunta> preguntas;
	
	//Estadisticas
	/**
	 * Nota media de todos los alumnos que han respondido
	 */
	private float notaMedia;
	
	//Constructores

	/**
	 * Constructor de Ejercicio en un directorio padre
	 * @param peso
	 * @param aleatorio
	 * @param fechaIni
	 * @param fechaFin
	 * @param padre
	 * @param titulo
	 * @param visibilidad
	 * @param asignatura
	 */
	public Ejercicio(int peso, boolean aleatorio, LocalDate fechaIni, LocalDate fechaFin, Tema padre,
			String titulo, boolean visibilidad, Asignatura asignatura) {
		super(titulo, visibilidad, asignatura, padre);
		this.peso = peso;
		this.aleatorio = aleatorio;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.preguntas = new ArrayList<Pregunta>();
		this.notaMedia = 0;
	}
	
	/**
	 * Constructor de Ejercicio en la raiz
	 * @param peso
	 * @param aleatorio
	 * @param fechaIni
	 * @param fechaFin
	 * @param titulo
	 * @param visibilidad
	 * @param asignatura
	 */
	public Ejercicio(int peso, boolean aleatorio, LocalDate fechaIni, LocalDate fechaFin,
			String titulo, boolean visibilidad, Asignatura asignatura) {
		super(titulo, visibilidad, asignatura);
		this.peso = peso;
		this.aleatorio = aleatorio;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.preguntas = new ArrayList<Pregunta>();
		this.notaMedia = 0;
	}

	
	//Getters y setters
	
	/**
	 * Get peso
	 * @return  peso
	 */
	public int getPeso() {
		return peso;
	}

	/**
	 * Set peso
	 * @param peso
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}

	/**
	 * esAleatorio
	 * @return boolean
	 */
	public boolean esAleatorio() {
		return aleatorio;
	}

	/**
	 * Set aleatorio
	 * @param aleatorio
	 */
	public void setAleatorio(boolean aleatorio) {
		this.aleatorio = aleatorio;
	}

	/**
	 * Get fecha inicio ejercicio
	 * @return fechaIni
	 */
	public LocalDate getFechaIni() {
		return fechaIni;
	}

	/**
	 * Set fecha inicio
	 * @param fechaIni
	 */
	public void setFechaIni(LocalDate fechaIni) {
		this.fechaIni = fechaIni;
	}

	/**
	 * Get fecha fin ejercicio
	 * @return fechaFin
	 */
	public LocalDate getFechaFin() {
		return fechaFin;
	}

	/**
	 * Set fecha fin ejercicio
	 * @param fechaFin
	 */
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Get preguntas
	 * @return preguntas
	 */
	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}

	/**
	 * Get nota media
	 * @return notaMedia
	 */
	public float getNotaMedia() {
		return notaMedia;
	}
	
	/**
	 * Get del número de alumnos que han terminado
	 * el ejercicio
	 * @return numterminados
	 */
	public int getNumTerminados(){
		return this.numTerminados;
	}

	
	//Metodos
	
	/**
	 * Método para añadir una pregunta al ejercicio
	 * @param pregunta
	 * @return boolean
	 */
	public boolean addPregunta(Pregunta preg){
		return this.preguntas.add(preg);		
	}
	
	/**
	 * Método para eliminar una pregunta
	 * @param pregunta
	 */
	public void removePregunta(Pregunta preg){
		this.preguntas.remove(preg);
	}
	
	
	/**
	 * Método que recibe una nueva nota y recalcula la media, 
	 * incrementando el número de terminados
	 * @param nota
	 */
	public void addNota(float nota){
		this.notaMedia = (this.notaMedia * this.numTerminados + nota) / (this.numTerminados + 1);
		this.numTerminados ++;
	}
	
	
	//Override
	
	@Override
	public String toString(){
		String aux = "";
		
		for(Pregunta p: this.preguntas){
			aux += "- " + p.enunciado + " [Peso: " + p.valorPregunta + "]\n";
		}
		
		return "Título del ejercicio: " + this.titulo + "\n Preguntas: \n" + aux + "Peso ejercicio: " + this.peso + "\n Nota Media: " + this.notaMedia;
	}
	

}
