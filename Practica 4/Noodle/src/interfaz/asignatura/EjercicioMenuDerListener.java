package interfaz.asignatura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import contenido.Ejercicio;
import contenido.EstadoEjercicio;
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
			this.frame.showAsignatura(false, this.ejercicio.getAsignatura());
		}
		else if(arg0.getActionCommand().equals("guardar")){
			
			if(this.ejercicio == null){
//				System.out.println(panel.getFechaIni());
//				System.out.println(panel.getFechaFin());
				System.out.println(panel.getAleatorio());
				System.out.println(panel.getPeso());
			}
			else if (ejercicio.getEstado() == EstadoEjercicio.RESPONDIDO || ejercicio.getEstado() == EstadoEjercicio.TERMINADO){
				JOptionPane.showMessageDialog(null, "El ejercicio no puede ser modificado", "Ejercicio no modificable",JOptionPane.ERROR_MESSAGE);
			}
			else{
				LocalDate ini = this.panel.getFechaIni();
				LocalDate fin = this.panel.getFechaFin();
				boolean aleatorio = this.panel.getAleatorio();
				int peso = this.panel.getPeso();
				
				if(ini.isAfter(fin) || ini.isBefore(LocalDate.now())){
					String nl = System.getProperty("line.separator");
					JOptionPane.showMessageDialog(null, "Fechas inválidas"+nl+"Se emplearán fechas por defecto", "Error de fechas",JOptionPane.ERROR_MESSAGE);
					ini = ejercicio.getFechaIniDefecto();
					fin = ejercicio.getFechaFinDefecto();
				}
				
				this.ejercicio.setAleatorio(aleatorio);
				this.ejercicio.setPeso(peso);
				this.ejercicio.setFechaIni(ini);
				this.ejercicio.setFechaFin(fin);
				
				System.out.println(ejercicio.getFechaIni());
				System.out.println(ejercicio.getFechaFin());
				
				this.frame.showAsignatura(false, this.ejercicio.getAsignatura());
				
			}
		}
		
	}

}
