package estadisticas;

import java.io.Serializable;

import java.util.ArrayList;

/**
 * Clase EstadisticasAlumno
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

import respuestas.RespuestaEjercicio;

public class EstadisticasAlumno implements Serializable{
	
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Respuestas de los ejercicios
	 */
	private ArrayList<RespuestaEjercicio> respuestas;
	
	/**
	 * Nota media de todos los ejercicios 
	 */
	private float notaMedia;
	
	/**
	 * Constructor de wstadisticas alumno
	 */
	public EstadisticasAlumno(){
		this.notaMedia = 0;
		this.respuestas = new ArrayList<RespuestaEjercicio>();
	}
	
	/**
	 * Get nota media
	 * @return float
	 */
	public float getNotaMedia() {
		return notaMedia;
	}
	
	/**
	 * Añade una nueva respuesta a ejercicio y calcula la nota media.
	 * @param r
	 */
	public void addRespuestaEjercicio(RespuestaEjercicio r){
		float nota = 0;
		float pesototal = 0;
		this.respuestas.add(r);
		for(RespuestaEjercicio re : this.respuestas){
			nota += re.calcularNota()*re.getEjercicio().getPeso();
			pesototal += re.getEjercicio().getPeso();
		}
		this.notaMedia = (nota/pesototal)*RespuestaEjercicio.NOTAMAX;
	}
	
	
}
