package interfaz.asignatura.contenido.ejercicio.resolucionEjercicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import asignatura.Asignatura;
import contenido.Ejercicio;
import contenido.Tema;
import interfaz.genericos.NoodleFrame;
import persona.Alumno;
import plataforma.Plataforma;

/**
 * Clase ResolverEjercicioMenuDerListener
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class ResolverEjercicioMenuDerListener implements ActionListener {

	//Variables
	
	/**
	 * Frame en el que se encuentra
	 */
	NoodleFrame frame;
	
	/**
	 * Panel al que escucha
	 */
	ResolverEjercicioMenuDer panel;
	
	/**
	 * Ejercicio al que hace referencia
	 */
	Ejercicio ejercicio;
	
	/**
	 * Tema del ejercicio
	 */
	Tema tema;
	
	/**
	 * Asignatura
	 */
	Asignatura asignatura;
	
	//Constructor
	
	/**
	 * Constructor del listener del menu derecho de ejercicio
	 * @param frame
	 * @param ejercicio
	 * @param ejercicioMenuDer
	 * @param tema
	 */
	public ResolverEjercicioMenuDerListener(NoodleFrame frame, Ejercicio ejercicio, ResolverEjercicioMenuDer ejercicioMenuDer, Tema tema){
		this.frame = frame;
		this.ejercicio = ejercicio;
		this.panel = ejercicioMenuDer;
		this.tema = tema;
		this.asignatura = tema.getAsignatura();
	}
	
	//Métodos
	
	/**
	 * Método por si se pulsa algún botón
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("cancelar")){
			this.frame.responderOCancelarEjercicio();
			this.frame.atras();
		}
		else if(arg0.getActionCommand().equals("guardar")){
			int result = JOptionPane.showConfirmDialog(null, "¿Realmente desea entregar este ejercicio?", "Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.OK_OPTION){
				this.ejercicio.responderEjercicio((Alumno)Plataforma.loggedAs(), ResolverEjercicioGUI.getInstance().getRespuestas());
				this.frame.responderOCancelarEjercicio();
				Plataforma.plat().saveData();
				this.frame.atras();
			}
		}
	}
}
