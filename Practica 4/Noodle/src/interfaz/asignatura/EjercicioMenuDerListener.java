package interfaz.asignatura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import contenido.Ejercicio;
import interfaz.genericos.NoodleFrame;

public class EjercicioMenuDerListener implements ActionListener {

	/**
	 * Frame en el que se encuentra
	 */
	NoodleFrame frame;
	
	/**
	 * Panel al que escucha
	 */
	EjercicioMenuDer panel;
	
	/**
	 * Ejercicio al que hace referencia
	 */
	Ejercicio ejercicio;
	
	/**
	 * Constructor del listener del menu derecho de ejercicio
	 * @param frame
	 * @param ejercicio
	 * @param ejercicioMenuDer
	 */
	public EjercicioMenuDerListener(NoodleFrame frame, Ejercicio ejercicio, EjercicioMenuDer ejercicioMenuDer){
		this.frame = frame;
		this.ejercicio = ejercicio;
		this.panel = ejercicioMenuDer;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("borrar")){
			this.ejercicio.eraseContenido();
			this.frame.showAsignatura(true, this.ejercicio.getAsignatura());
		}
		else if(arg0.getActionCommand().equals("guardar")){
			
			if(this.ejercicio == null){
//				System.out.println(panel.getFechaIni());
//				System.out.println(panel.getFechaFin());
				System.out.println(panel.getAleatorio());
				System.out.println(panel.getPeso());
			} 
			else{
				System.out.println(panel.getFechaIni());
				System.out.println(panel.getFechaFin());
				System.out.println(panel.getAleatorio());
				System.out.println(panel.getPeso());
			}
		}
		
	}

}
