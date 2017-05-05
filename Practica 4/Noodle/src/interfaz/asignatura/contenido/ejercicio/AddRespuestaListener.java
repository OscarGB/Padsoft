package interfaz.asignatura.contenido.ejercicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.EventListenerList;

import contenido.Pregunta;

public class AddRespuestaListener implements ActionListener {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Panel
	 */
	AddRespuesta panel;
	
	/**
	 * Pregunta
	 */
	Pregunta pregunta;
	
	/**
	 * Constructor de AddRespuestaListener
	 * @param pregunta
	 */
	public AddRespuestaListener(Pregunta pregunta){
		this.pregunta = pregunta;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("guardar")){
			System.out.println(this.panel.getRespuesta());
		}
	}

}
