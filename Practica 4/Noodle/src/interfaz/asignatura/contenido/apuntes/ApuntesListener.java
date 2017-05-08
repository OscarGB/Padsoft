package interfaz.asignatura.contenido.apuntes;

import java.awt.event.*;

import contenido.Apuntes;
import interfaz.genericos.NoodleFrame;
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
	 * @param frame
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
			boolean visible = panel.getVisible();
			
			if(this.panel.getApuntes() == null){
				new Apuntes(texto, titulo, visible, this.panel.getAsignatura(), this.panel.getTema());
			} else{
				this.panel.getApuntes().setTexto(texto);
				this.panel.getApuntes().setTitulo(titulo);
				this.panel.getApuntes().setVisibilidad(visible);
			}
			
			this.frame.showAsignatura(true, this.panel.getAsignatura());
			Plataforma.plat().saveData();
		}
		if(arg0.getActionCommand().equals("cancelar") == true){
			this.frame.showAsignatura(true, this.panel.getAsignatura());
		}
		
		return;
		
	}
	
}
