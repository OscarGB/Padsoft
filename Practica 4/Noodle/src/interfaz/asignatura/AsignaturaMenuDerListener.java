package interfaz.asignatura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import asignatura.Asignatura;
import contenido.Apuntes;
import contenido.Contenido;
import contenido.Tema;
import interfaz.genericos.NoodleFrame;

/**
 * Clase ContenidoMenuDerListener
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class AsignaturaMenuDerListener implements ActionListener {

	/**
	 * Frame en el que se encuentra
	 */
	NoodleFrame frame;
	
	/**
	 * tema al que refiere
	 */
	Tema tema;
	
	/**
	 * Constructor de ContenidoMenuDerListener
	 * @param frame
	 * @param con
	 */
	public AsignaturaMenuDerListener(NoodleFrame frame, Tema tema) {
		this.frame = frame;
		this.tema = tema;
	}
	
	/**
	 * Setter de tema
	 * @param tema
	 */
	public void listenerSetTema(Tema tema){
		this.tema = tema;
	}

	/**
	 * Método que se llama en caso de que se pulse alguno de los botones del menu
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("borrar")){
			this.tema.eraseContenido();
			this.frame.showAsignatura(true, this.tema.getAsignatura());
		}
		else if(arg0.getActionCommand().equals("apuntes")){
			frame.showSubirApuntes(true, tema.getAsignatura(), this.tema, null);
		}
		else if(arg0.getActionCommand().equals("ejercicio")){
			System.out.println("Crear ejercicio en el tema "+this.tema);
		}
	}
}

