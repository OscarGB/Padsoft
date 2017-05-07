package interfaz.asignatura.contenido.ejercicio.creacionPreguntas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import contenido.Pregunta;

/**
 * Clase AddRespuestaListener
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class AddRespuestaListener implements ActionListener {

	//Variables
	
	/**
	 * Panel
	 */
	AddRespuesta panel;
	
	/**
	 * Panel generico
	 */
	PreguntaGenerico gen;
	
	/**
	 * Pregunta
	 */
	Pregunta pregunta;
	
	//Constructor
	
	/**
	 * Constructor de AddRespuestaListener
	 * @param pregunta
	 */
	public AddRespuestaListener(Pregunta pregunta, PreguntaGenerico gen,AddRespuesta panel){
		this.pregunta = pregunta;
		this.panel = panel;
		this.gen = gen;
	}
	
	//Métodos
	
	/**
	 * Método por si se pulsa
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("guardar")){
			String respuesta = this.panel.getRespuesta();
			if(respuesta.length() <= 0){
				JOptionPane.showMessageDialog(null, "Introduzca una respuesta", "Respuesta",JOptionPane.ERROR_MESSAGE);
			}
			else {
				gen.addOpcion(this.panel.getRespuesta());
			}
			this.panel.cleanRespuesta();
		}
	}

}
