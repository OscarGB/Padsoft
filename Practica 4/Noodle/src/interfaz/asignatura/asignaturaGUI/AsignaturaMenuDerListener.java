package interfaz.asignatura.asignaturaGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import asignatura.Asignatura;
import contenido.Apuntes;
import contenido.Contenido;
import contenido.Tema;
import interfaz.genericos.NoodleFrame;
import plataforma.Plataforma;

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
	 * Panel al que escucha
	 */
	AsignaturaMenuDer panel;
	
	/**
	 * Asignatura a la que hace referencia
	 */
	Asignatura asig;
	
	/**
	 * Constructor de ContenidoMenuDerListener
	 * @param frame
	 * @param asignaturaMenuDer 
	 * @param asignatura 
	 * @param con
	 */
	public AsignaturaMenuDerListener(NoodleFrame frame, Tema tema, AsignaturaMenuDer asignaturaMenuDer, Asignatura asignatura) {
		this.frame = frame;
		this.tema = tema;
		this.panel = asignaturaMenuDer;
		this.asig = asignatura;
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
			int result = JOptionPane.showConfirmDialog(null, "¿Realmente desea borrar este tema?", "Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.OK_OPTION){
				this.tema.eraseContenido();
				this.frame.showAsignatura(true, this.tema.getAsignatura());
			}
		}
		else if(arg0.getActionCommand().equals("apuntes")){
			//TODO Null pointer exception si el tema es la raiz
			frame.showSubirApuntes(true, this.tema.getAsignatura(), this.tema, null);
		}
		else if(arg0.getActionCommand().equals("ejercicio")){
			frame.showEjercicioGUI(true, null, this.tema);
		}
		else if(arg0.getActionCommand().equals("subtema")){
			String aux = panel.getText();
			if(aux.equals("")){
				return;
			}
			new Tema(aux, true, this.asig, this.tema);
			this.frame.showAsignatura(true, this.asig);
		}
		Plataforma.plat().saveData();
	}
}

