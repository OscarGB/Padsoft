package interfaz.asignatura;

import java.awt.event.*;

import interfaz.*;
import interfaz.genericos.NoodleFrame;
import persona.Profesor;
import plataforma.Plataforma;

/**
 * Clase LoginListener
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class ApuntesListener implements ActionListener{
	
	//Variables
	
	/**
	 * Panel sobre el que actua
	 */
	private ApuntesForm panel;
	
	/**
	 * Cuerpo del programa
	 */
	private NoodleFrame frame;
	
	//Constructor
	
	/**
	 * Constructor de LoginListener
	 * @param panel
	 */
	public ApuntesListener(ApuntesForm panel, NoodleFrame frame){
		this.panel = panel;
		this.frame = frame;
	}
	
	//Métodos
	
	/** 
	 * Método para realizar la acción al pulsar el botón
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("guardar") == true){
			System.out.println("Has pulsado guardar");
			System.out.println(this.panel.getTexto());
			System.out.println(this.panel.getTitulo());
			//TODO llamar a crear apunte del noodle
		}
		if(arg0.getActionCommand().equals("cancelar") == true){
			System.out.println("Has pulsado cancelar");
			//volver atras sin guardar
		}
		
		return;
		
	}
	
}
