package interfaz.asignatura;

import java.awt.event.*;

import contenido.Apuntes;
import interfaz.*;
import interfaz.genericos.NoodleFrame;
import persona.Profesor;
import plataforma.Plataforma;

/**
 * Clase ApuntesListener
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
	 * Constructor de ApuntesListener
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
			String titulo = this.panel.getTitulo();
			String texto = this.panel.getTexto();
			System.out.println("Has pulsado guardar");
			System.out.println(this.panel.getTexto());
			System.out.println(this.panel.getTitulo());
			System.out.println(this.panel.getAsignatura());
			
			if(this.panel.getApuntes() == null){
				new Apuntes(texto, titulo, true, this.panel.getAsignatura(), this.panel.getTema());
			} else{
				this.panel.getApuntes().setTexto(texto);
				this.panel.getApuntes().setTitulo(titulo);
			}
			
			this.frame.showAsignatura(true, this.panel.getAsignatura());
		}
		if(arg0.getActionCommand().equals("cancelar") == true){
			System.out.println("Has pulsado cancelar");
			this.frame.showAsignatura(true, this.panel.getAsignatura());
		}
		
		return;
		
	}
	
}
