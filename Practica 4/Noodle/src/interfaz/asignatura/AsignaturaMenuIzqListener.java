package interfaz.asignatura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import asignatura.Asignatura;
import contenido.Tema;
import interfaz.genericos.NoodleFrame;
import plataforma.Plataforma;

/**
 * Clase ContenidoMenuDerListener
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class AsignaturaMenuIzqListener implements ActionListener {

	/**
	 * Frame en el que se encuentra
	 */
	NoodleFrame frame;
	
	/**
	 * tema al que refiere
	 */
	Asignatura asignatura;
	
	/**
	 * Panel al que hace referencia
	 */
	AsignaturaMenuIzq panel;
	
	/**
	 * Constructor de ContenidoMenuDerListener
	 * @param frame
	 * @param asignaturaMenuIzq 
	 * @param con
	 */
	public AsignaturaMenuIzqListener(NoodleFrame frame, Asignatura asignatura, AsignaturaMenuIzq asignaturaMenuIzq) {
		this.frame = frame;
		this.asignatura = asignatura;
		this.panel = asignaturaMenuIzq;
	}

	/**
	 * Método que se llama en caso de que se pulse alguno de los botones del menu
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("borrar")){
			Plataforma.eraseAsignatura(this.asignatura);
			this.frame.showListaAsignaturas(false);
		}
		else if(arg0.getActionCommand().equals("tema")){
			String aux = panel.getText();
			if(aux.equals("")){
				return;
			}
			new Tema(aux, true, this.asignatura);
			this.frame.showAsignatura(true, this.asignatura);
		}
	}
}


