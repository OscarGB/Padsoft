package interfaz.asignatura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import asignatura.Asignatura;
import contenido.Ejercicio;
import contenido.EstadoEjercicio;
import contenido.Tema;
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
	 * Tema del ejercicio
	 */
	Tema tema;
	
	/**
	 * Asignatura
	 */
	Asignatura asignatura;
	
	/**
	 * Constructor del listener del menu derecho de ejercicio
	 * @param frame
	 * @param ejercicio
	 * @param ejercicioMenuDer
	 */
	public EjercicioMenuDerListener(NoodleFrame frame, Ejercicio ejercicio, EjercicioMenuDer ejercicioMenuDer, Tema tema){
		this.frame = frame;
		this.ejercicio = ejercicio;
		this.panel = ejercicioMenuDer;
		this.tema = tema;
		this.asignatura = tema.getAsignatura();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("borrar")){
			this.ejercicio.eraseContenido();
			this.frame.showAsignatura(false, this.ejercicio.getAsignatura());
		}
		else if(arg0.getActionCommand().equals("guardar")){
			
			if(this.ejercicio == null){
				LocalDate ini = this.panel.getFechaIni();
				LocalDate fin = this.panel.getFechaFin();
				boolean aleatorio = this.panel.getAleatorio();
				int peso = this.panel.getPeso();
				String nombre = this.panel.getNombre();
				
				if(nombre.length() <= 0){
					JOptionPane.showMessageDialog(null, "Introduzca un nombre", "Nombre",JOptionPane.ERROR_MESSAGE);
				}
				else if(ini.isAfter(fin) || ini.isBefore(LocalDate.now())){
					String nl = System.getProperty("line.separator");
					JOptionPane.showMessageDialog(null, "Fechas inválidas"+nl+"Se emplearán fechas por defecto", "Error de fechas",JOptionPane.ERROR_MESSAGE);
					ini = ejercicio.getFechaIniDefecto();
					fin = ejercicio.getFechaFinDefecto();
				}
				else {
					this.ejercicio = new Ejercicio(peso, aleatorio, ini, fin, tema, nombre, aleatorio, this.asignatura);
					this.frame.showAsignatura(false, this.ejercicio.getAsignatura());
				}
			}
			else if (ejercicio.getEstado() == EstadoEjercicio.RESPONDIDO || ejercicio.getEstado() == EstadoEjercicio.TERMINADO){
				JOptionPane.showMessageDialog(null, "El ejercicio no puede ser modificado", "Ejercicio no modificable",JOptionPane.ERROR_MESSAGE);
			}
			else{
				LocalDate ini = this.panel.getFechaIni();
				LocalDate fin = this.panel.getFechaFin();
				boolean aleatorio = this.panel.getAleatorio();
				int peso = this.panel.getPeso();
				
				if(ini.isAfter(fin) || ini.isBefore(LocalDate.now()) || ini.isAfter(this.ejercicio.getFechaIni())){
					String nl = System.getProperty("line.separator");
					JOptionPane.showMessageDialog(null, "Fechas inválidas"+nl+"Se emplearán fechas por defecto", "Error de fechas",JOptionPane.ERROR_MESSAGE);
					ini = ejercicio.getFechaIniDefecto();
					fin = ejercicio.getFechaFinDefecto();
				}
				
				this.ejercicio.setAleatorio(aleatorio);
				this.ejercicio.setPeso(peso);
				this.ejercicio.setFechaIni(ini);
				this.ejercicio.setFechaFin(fin);
				
				
				this.frame.showAsignatura(false, this.ejercicio.getAsignatura());
				
			}
		}
		
	}

}
