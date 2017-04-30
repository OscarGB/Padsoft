package interfaz.asignatura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import contenido.Contenido;
import interfaz.genericos.NoodleFrame;

/**
 * Clase ContenidoMenuDerListener
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class ContenidoMenuDerListener implements ActionListener {

	/**
	 * Frame en el que se encuentra
	 */
	NoodleFrame frame;
	
	/**
	 * contenido al que refiere
	 */
	Contenido con;
	
	/**
	 * Constructor de ContenidoMenuDerListener
	 * @param frame
	 * @param con
	 */
	public ContenidoMenuDerListener(NoodleFrame frame, Contenido con) {
		this.frame = frame;
		this.con = con;
	}

	/**
	 * M�todo que se llama en caso de que se pulse alguno de los botones del menu
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("borrar")){
			System.out.println("Has pulsado sobre borrar en " + con.getTitulo());
		}
		if(arg0.getActionCommand().equals("editar")){
			System.out.println("Has pulsado sobre editar en " + con.getTitulo());
		}
	}
}
