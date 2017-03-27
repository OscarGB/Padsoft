package respuestas;

import java.util.ArrayList;

import contenido.Opciones;
import contenido.Pregunta;
import contenido.PreguntaRespuestaAbierta;

/**
 * Clase RespuestaMultiple
 * @author Óscar Gómez Borzdynski
 * @author Jose Ignacio Gómez García
 * @date 07/03/2017
 */

public class RespuestaMultiple extends RespuestaPregunta{

	/**
	 * Respuestas escogidas
	 */
	private ArrayList<Opciones> respuestas;
		
	/**
	 * Constructor de respuesta multiple
	 * @param p
	 * @param respuestas
	 */
	public RespuestaMultiple(Pregunta p, ArrayList<Opciones> respuestas) {
		super(p);
		this.respuestas = respuestas;
	}
	
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

}
