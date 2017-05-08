package interfaz.asignatura.contenido.ejercicio.resolucionPreguntas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import asignatura.Asignatura;
import contenido.Ejercicio;
import contenido.Pregunta;
import interfaz.asignatura.contenido.ejercicio.resolucionEjercicio.ResolverEjercicioGUI;
import interfaz.genericos.NoodleFrame;

/**
 * Clase ResponderPreguntaMenuDer
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class ResponderPreguntaMenuDerListener implements ActionListener{

	//Variables
	
	/**
	 * Frame en el que se encuentra
	 */
	NoodleFrame frame;
	
	/**
	 * Panel al que escucha
	 */
	ResponderPreguntaMenuDer panel;
	
	/**
	 * Ejercicio al que hace referencia
	 */
	Ejercicio ejercicio;
	
	/**
	 * Tema del ejercicio
	 */
	Pregunta preg;
	
	/**
	 * Asignatura
	 */
	Asignatura asignatura;
	
	/**
	 * Panel gnérico
	 */
	ResponderPregunta gen;
	
	//Constructor
	
	/**
	 * Constructor del listener del menu derecho de ejercicio
	 * @param frame
	 * @param ejercicio
	 * @param panel
	 * @param preg
	 * @param gen
	 */
	public ResponderPreguntaMenuDerListener(NoodleFrame frame, Ejercicio ejercicio, ResponderPreguntaMenuDer panel, Pregunta preg, ResponderPregunta gen){
		this.frame = frame;
		this.ejercicio = ejercicio;
		this.panel = panel;
		this.preg = preg;
		this.gen = gen;
		this.asignatura = ejercicio.getAsignatura();
	}
	
	//Métodos
	
	/**
	 * Método por si se pulsa algún botón
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("cancelar")){
			this.frame.atras();
		}
		else if(arg0.getActionCommand().equals("guardar")){
			ResolverEjercicioGUI.getInstance().addRespuesta(gen.getRespuesta());
			this.frame.atras();
		}
	}
}
