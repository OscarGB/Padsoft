package interfaz.asignatura.contenido.ejercicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import contenido.Ejercicio;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;

/**
 * Clase ElegirTipoPreguntaListener
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class ElegirTipoPreguntaListener implements ActionListener {

	/**
	 * Ejercicio que afecta
	 */
	Ejercicio ej;
	
	/**
	 * Frame global
	 */
	NoodleFrame frame;
	
	/**
	 * Creador
	 * @param frame
	 * @param ej
	 */
	public ElegirTipoPreguntaListener(NoodleFrame frame, Ejercicio ej) {
		this.ej = ej;
		this.frame = frame;
	}

	/**
	 * Método si se pincha en algún botón
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Cancelar")){
			frame.atras();
		}
		else if(arg0.getActionCommand().equals("Pregunta Simple")){
			System.out.println("Has pichado en Pregunta Simple");
		}
		else if(arg0.getActionCommand().equals("Pregunta Unica")){
			this.frame.showPreguntaUnica(true, ej, null);
		}
		else if(arg0.getActionCommand().equals("Pregunta Multiple")){
			this.frame.showPreguntaMultiple(true, ej, null);
		}
		else if(arg0.getActionCommand().equals("Pregunta Abierta")){
			this.frame.showPreguntaAbierta(true, ej, null);
		}
	}

}
