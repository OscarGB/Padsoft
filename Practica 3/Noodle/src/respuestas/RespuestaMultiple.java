package respuestas;

import java.util.ArrayList;

import contenido.Opciones;
import contenido.Pregunta;

/**
 * Clase RespuestaMultiple
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public class RespuestaMultiple extends RespuestaPregunta{
	
	//Variables
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Respuestas escogidas
	 */
	private ArrayList<Opciones> respuestas;
		
	//Constructor
	
	/**
	 * Constructor de respuesta multiple
	 * @param p
	 * @param respuestas
	 */
	public RespuestaMultiple(Pregunta p, ArrayList<Opciones> respuestas) {
		super(p);
		this.respuestas = respuestas;
	}
	
	//Métodos
	
	/**
	 * Método para comprobar si la respuesta multiple es correcta
	 * @return boolean
	 */
	@Override
	public boolean esCorrecta(){
		int flag = 0;
		ArrayList<Opciones> opcionesPregunta = this.preguntaRespondida.getOpciones();
		for(Opciones o : opcionesPregunta){
			//Busco para todas las opciones posibles cuales han sido escogidas
			for(Opciones op : this.respuestas){
				flag = 0;
				// Si ha sido escogida
				if(op.getRespuesta() == o.getRespuesta()){
					// Si no es correcta
					if(o.esCorrecta() == false){
						return false;
					}
					// Si lo es
					else{
						flag = 1;
						break;
					}
				}
			}
			// si no ha sido escogida pero es correcta
			if(flag == 0 && o.esCorrecta() == true){
				return false;
			}
		}
		// Si todo es correcto y no hay ninguna correcta sin responder
		return true;
	}
	
	//Override
	
	/**
	 * toString, Override
	 * @return String
	 */
	@Override
	public String toString(){
		return "Pregunta Multiple: '" + this.preguntaRespondida.getEnunciado() + "' Respondido: " + this.respuestas;
	}

}
