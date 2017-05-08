package interfaz.asignatura.contenido.ejercicio.creacionPreguntas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import contenido.Ejercicio;
import contenido.Pregunta;
import interfaz.genericos.NoodleFrame;

/**
 * Clase PreguntaMenuDerListener
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class PreguntaMenuDerListener implements ActionListener {

	//Variable
	
	/**
	 * Ejercicio
	 */
	private Ejercicio ej;
	
	/**
	 * Pregunta 
	 */
	private Pregunta p;
	
	/**
	 * Panel
	 */
	private PreguntaGenerico panel;
	
	/**
	 * Frame
	 */
	private NoodleFrame frame;
	
	/**
	 * Menu de las preguntas
	 */
	private PreguntaMenuDer menu;
	
	//Constructor
	
	/**
	 * Constructor
	 * @param panel
	 * @param frame
	 * @param ej
	 * @param p, null si se quiere crear una nueva
	 */
	public PreguntaMenuDerListener(PreguntaGenerico panel, NoodleFrame frame, Ejercicio ej, Pregunta p, PreguntaMenuDer menu) {
		this.ej = ej;
		this.p = p;
		this.panel = panel;
		this.frame = frame;
		this.menu = menu;
	}
	
	//Métodos
	
	/**
	 * Método por si se pulsa algún botón
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("guardar")){
			if((this.p = this.panel.getPregunta()) == null){
				JOptionPane.showMessageDialog(null, "Seleccione la opción correcta", "Opcion",JOptionPane.ERROR_MESSAGE);
			}
			else {
				this.p.setValorPregunta(menu.getValuePesoSpinner());
				this.p.setPenalizacion(menu.getValuePesoFalloSpinner());
				this.ej.addPregunta(this.p);
				this.frame.showEjercicioGUI(false, this.ej, this.ej.getPadre());
			}			
		}
		else if(arg0.getActionCommand().equals("borrar")){
			int result = JOptionPane.showConfirmDialog(null, "¿Realmente desea borrar esta pregunta?", "Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.OK_OPTION){
				this.ej.removePregunta(this.p);
				this.frame.showEjercicioGUI(false, this.ej, this.ej.getPadre());
			}
		}
		else if(arg0.getActionCommand().equals("cancelar")){
			frame.atras();
		}
	}

}
