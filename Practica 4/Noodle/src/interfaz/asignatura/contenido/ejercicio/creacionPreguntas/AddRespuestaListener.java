package interfaz.asignatura.contenido.ejercicio.creacionPreguntas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
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
	 * Panel generico
	 */
	PreguntaGenerico gen;
	
	/**
	 * Pregunta
	 */
	Pregunta pregunta;
	
	/**
	 * Constructor de AddRespuestaListener
	 * @param pregunta
	 */
	public AddRespuestaListener(Pregunta pregunta, PreguntaGenerico gen,AddRespuesta panel){
		this.pregunta = pregunta;
		this.panel = panel;
		this.gen = gen;
	}
	
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
