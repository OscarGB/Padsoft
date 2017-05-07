package interfaz.asignatura.contenido.ejercicio.creacionEjercicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import contenido.Ejercicio;
import interfaz.genericos.NoodleFrame;

/**
 * Clase ElegirTipoPreguntaListener
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class ElegirTipoPreguntaListener implements ActionListener {

	//Variables
	
	/**
	 * Ejercicio que afecta
	 */
	Ejercicio ej;
	
	/**
	 * Frame global
	 */
	NoodleFrame frame;
	
	//Constructor
	
	/**
	 * Creador
	 * @param frame
	 * @param ej
	 */
	public ElegirTipoPreguntaListener(NoodleFrame frame, Ejercicio ej) {
		this.ej = ej;
		this.frame = frame;
	}

	//Métodos
	
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
			this.frame.showPreguntaSimple(true, ej, null);
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

	/**
	 * Método que refresca el panel
	 * @param ej
	 */
	public void refresh(Ejercicio ej) {
		this.ej = ej;
	}
}
