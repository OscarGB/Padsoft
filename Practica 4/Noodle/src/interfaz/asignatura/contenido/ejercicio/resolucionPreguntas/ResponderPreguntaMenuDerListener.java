package interfaz.asignatura.contenido.ejercicio.resolucionPreguntas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import asignatura.Asignatura;
import contenido.Ejercicio;
import contenido.Pregunta;
import interfaz.asignatura.contenido.ejercicio.resolucionEjercicio.ResolverEjercicioGUI;
import interfaz.genericos.NoodleFrame;
import plataforma.Plataforma;

public class ResponderPreguntaMenuDerListener implements ActionListener{

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
	 * Panel gn�rico
	 */
	ResponderPregunta gen;
	
	/**
	 * Constructor del listener del menu derecho de ejercicio
	 * @param frame
	 * @param ejercicio
	 * @param ejercicioMenuDer
	 */
	public ResponderPreguntaMenuDerListener(NoodleFrame frame, Ejercicio ejercicio, ResponderPreguntaMenuDer panel, Pregunta preg, ResponderPregunta gen){
		this.frame = frame;
		this.ejercicio = ejercicio;
		this.panel = panel;
		this.preg = preg;
		this.gen = gen;
		this.asignatura = ejercicio.getAsignatura();
	}
	
	/**
	 * M�todo por si se pulsa alg�n bot�n
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("cancelar")){
			this.frame.atras();
		}
		else if(arg0.getActionCommand().equals("guardar")){
			ResolverEjercicioGUI.getInstance().addRespuesta(gen.getRespuesta());
		}
	}
}
