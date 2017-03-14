package contenido;

import java.util.ArrayList;

public class Pregunta {
	/**
	 * Enunciado de la pregunta
	 */
	private String enunciado;
	
	/**
	 * Array de respuestas posbiles
	 */
	private ArrayList<Opciones> respuestas;
	
	/**
	 * Array de respuestas correctas (varias si es de respuesta múltiple)
	 */
	private ArrayList<Opciones> respuestaCorrecta;
	
	
	/**
	 * Puntos que resta un fallo en esta pregunta
	 */
	private int restaFallo;
	
	/**
	 * Variable para la aleatoriedad del orden de las respuestas
	 */
	private boolean aleatorio;
	
	/**
	 * Nota media entre las respuestas de esta pregunta
	 */
	private int notaMedia;
	
	/**
	 * Valor de la pregunta dentro del ejercicio
	 */
	private float pesoPregunta;
	
	/**
	 * Valor constante del peso por defecto
	 */
	public static final float PESO_POR_DEFECTO = 1;
	
	/**
	 * Número de veces que la pregunta ha sido respondida
	 */
	private int nRespuestasPregunta;
	
	/**
	 * Número de veces que se ha contestado correctamente esta pregunta
	 */
	private int nRespuestasCorrectas;
	
	/**
	 * Constructor de Pregunta
	 * @param enunciado
	 * @param respuestas
	 * @param respuestaCorrecta
	 * @param restaFallo
	 * @param aleatorio
	 * @param notaMedia
	 */
	public Pregunta(String enunciado, ArrayList<Opciones> respuestas, ArrayList<Opciones> respuestaCorrecta,
			int restaFallo, boolean aleatorio, int notaMedia) {
		
		this.enunciado = enunciado;
		this.respuestas = respuestas;
		this.respuestaCorrecta = respuestaCorrecta;
		this.respuestaEscogida = new ArrayList<String>();
		this.restaFallo = restaFallo;
		this.aleatorio = aleatorio;
		this.notaMedia = notaMedia;
		this.pesoPregunta = Pregunta.PESO_POR_DEFECTO;
		this.nRespuestasPregunta = 0;
		this.nRespuestasCorrectas = 0;
	}
	
	/**
	 * Constructor de Pregunta con peso definido
	 * @param enunciado
	 * @param respuestas
	 * @param respuestaCorrecta
	 * @param restaFallo
	 * @param aleatorio
	 * @param notaMedia
	 * @param peso
	 */
	public Pregunta(String enunciado, ArrayList<Opciones> respuestas, ArrayList<Opciones> respuestaCorrecta,
			int restaFallo, boolean aleatorio, int notaMedia, float peso) {
		
		this.enunciado = enunciado;
		this.respuestas = respuestas;
		this.respuestaCorrecta = respuestaCorrecta;
		this.respuestaEscogida = new ArrayList<String>();
		this.restaFallo = restaFallo;
		this.aleatorio = aleatorio;
		this.notaMedia = notaMedia;
		this.pesoPregunta = peso;
		this.nRespuestasPregunta = 0;
		this.nRespuestasCorrectas = 0;
	}

	/**
	 * Getter de enunciado
	 * @return enunciado
	 */
	public String getEnunciado() {
		return enunciado;
	}

	/**
	 * Setter de enunciado
	 * @param enunciado
	 */
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	/**
	 * Getter de respuestas
	 * @return respuestas
	 */
	public ArrayList<String> getRespuestas() {
		return respuestas;
	}

	/**
	 * Setter de respuestas
	 * @param respuestas
	 */
	public void setRespuestas(ArrayList<String> respuestas) {
		this.respuestas = respuestas;
	}

	/**
	 * Getter de respuestaCorrecta
	 * @return respuestaCorrecta
	 */
	public ArrayList<String> getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	/**
	 * Setter de respuestaCorrecta
	 * @param respuestaCorrecta
	 */
	public void setRespuestaCorrecta(ArrayList<String> respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}

	/**
	 * Getter de respuestaEscogida
	 * @return respuestaEscogida
	 */
	public ArrayList<String> getRespuestaEscogida() {
		return respuestaEscogida;
	}

	/**
	 * Setter de respuestaEscogida
	 * @param respuestaEscogida
	 */
	public void setRespuestaEscogida(ArrayList<String> respuestaEscogida) {
		this.respuestaEscogida = respuestaEscogida;
	}

	/**
	 * Getter de nota
	 * @return nota
	 */
	public int getNota() {
		return nota;
	}

	/**
	 * Setter de nota
	 * @param nota
	 */
	public void setNota(int nota) {
		this.nota = nota;
	}

	/**
	 * Getter de restaFallo
	 * @return restaFallo
	 */
	public int getRestaFallo() {
		return restaFallo;
	}

	/**
	 * Setter de restaFallo
	 * @param restaFallo
	 */
	public void setRestaFallo(int restaFallo) {
		this.restaFallo = restaFallo;
	}

	/**
	 * Getter de aleatorio
	 * @return boolean aleatorio
	 */
	public boolean isAleatorio() {
		return aleatorio;
	}

	/**
	 * Setter de aleatorio
	 * @param aleatorio
	 */
	public void setAleatorio(boolean aleatorio) {
		this.aleatorio = aleatorio;
	}

	/**
	 * Getter de notaMedia
	 * @return notaMedia
	 */
	public int getnotaMedia() {
		return notaMedia;
	}

	/**
	 * Setter de notaMedia
	 * @param notaMedia
	 */
	public void setnotaMedia(int notaMedia) {
		this.notaMedia = notaMedia;
	}

	/**
	 * Getter de nRespuestasPregunta
	 * @return nRespuestasPregunta
	 */
	public int getnRespuestasPregunta() {
		return nRespuestasPregunta;
	}

	/**
	 * Setter de nRespuestasPregunta
	 * @param nRespuestasPregunta
	 */
	public void setnRespuestasPregunta(int nRespuestasPregunta) {
		this.nRespuestasPregunta = nRespuestasPregunta;
	}

	/**
	 * Getter de nRespuestasCorrectas
	 * @return nRespuestasCorrectas
	 */
	public int getnRespuestasCorrectas() {
		return nRespuestasCorrectas;
	}

	/**
	 * Setter de nRespuestasCorrectas
	 * @param nRespuestasCorrectas
	 */
	public void setnRespuestasCorrectas(int nRespuestasCorrectas) {
		this.nRespuestasCorrectas = nRespuestasCorrectas;
	}
	
	/**
	 * Comprueba si la respuesta escogida es la correcta
	 * @return boolean
	 */
	public boolean checkRespuesta() {
		if (this.respuestaEscogida.equals(this.respuestaCorrecta)){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Añade una respuesta al array de respuestas
	 * @param respuesta
	 * @return boolean
	 */
	public boolean addRespuesta(String respuesta) {
		if(this.respuestas.add(respuesta)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Borrará una respuesta del array de respuestas
	 * @param respuesta
	 * @return
	 */
	public boolean eraseRespuesta(String respuesta) {
		if(this.respuestas.remove(respuesta)){
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
