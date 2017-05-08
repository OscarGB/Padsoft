package interfaz.asignatura.contenido.ejercicio.creacionEjercicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import asignatura.Asignatura;
import contenido.Ejercicio;
import contenido.EstadoEjercicio;
import contenido.Tema;
import interfaz.genericos.NoodleFrame;
import plataforma.Plataforma;

/**
 * Clase EjercicioMenuDerListener
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class EjercicioMenuDerListener implements ActionListener {

	//Variables
	
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
	
	//Constructor
	
	/**
	 * Constructor del listener del menu derecho de ejercicio
	 * @param frame
	 * @param ejercicio
	 * @param ejercicioMenuDer
	 * @param tema
	 */
	public EjercicioMenuDerListener(NoodleFrame frame, Ejercicio ejercicio, EjercicioMenuDer ejercicioMenuDer, Tema tema){
		this.frame = frame;
		this.ejercicio = ejercicio;
		this.panel = ejercicioMenuDer;
		this.tema = tema;
		this.asignatura = tema.getAsignatura();
	}
	
	//Métodos
	
	/**
	 * Método en caso de que se pulse algún botón
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("borrar")){
			if(this.ejercicio == null){
				JOptionPane.showMessageDialog(null, "El ejercicio aun no ha sido guardado", "Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			int result = JOptionPane.showConfirmDialog(null, "¿Realmente desea borrar este ejercicio?", "Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.OK_OPTION){
				this.ejercicio.eraseContenido();
				this.frame.showAsignatura(false, this.ejercicio.getAsignatura());
			}
		}
		else if(arg0.getActionCommand().equals("guardar")){
			
			LocalDate ini = this.panel.getFechaIni();
			LocalDate fin = this.panel.getFechaFin();
			boolean aleatorio = this.panel.getAleatorio();
			int peso = this.panel.getPeso();
			String nombre = this.panel.getNombre();
			boolean visibilidad = this.panel.getVisible();
			
			if(this.ejercicio == null){
				
				if(nombre.length() <= 0){
					JOptionPane.showMessageDialog(null, "Introduzca un nombre", "Nombre",JOptionPane.ERROR_MESSAGE);
				}
				else if(ini.isAfter(fin) || ini.isBefore(LocalDate.now())){
					String nl = System.getProperty("line.separator");
					JOptionPane.showMessageDialog(null, "Fechas inválidas"+nl+"Se emplearán fechas por defecto", "Error de fechas",JOptionPane.ERROR_MESSAGE);
					this.ejercicio = new Ejercicio(peso, aleatorio, null, null, tema, nombre, visibilidad, this.asignatura);
					ini = ejercicio.getFechaIniDefecto();
					fin = ejercicio.getFechaFinDefecto();
					this.ejercicio.setFechaFin(fin);
					this.ejercicio.setFechaIni(ini);
					this.frame.showAsignatura(false, this.ejercicio.getAsignatura());
				} else{
					this.ejercicio = new Ejercicio(peso, aleatorio, ini, fin, tema, nombre, visibilidad, this.asignatura);
				}
			}
			else if (ejercicio.getEstado() == EstadoEjercicio.RESPONDIDO || ejercicio.getEstado() == EstadoEjercicio.TERMINADO){
				JOptionPane.showMessageDialog(null, "El ejercicio no puede ser modificado", "Ejercicio no modificable",JOptionPane.ERROR_MESSAGE);
			}
			else{
				
				if(ini.isAfter(fin) || ini.isBefore(LocalDate.now()) || ini.isBefore(this.ejercicio.getFechaIni())){
					String nl = System.getProperty("line.separator");
					JOptionPane.showMessageDialog(null, "Fechas inválidas"+nl+"Se emplearán fechas por defecto", "Error de fechas",JOptionPane.ERROR_MESSAGE);
					ini = ejercicio.getFechaIniDefecto();
					fin = ejercicio.getFechaFinDefecto();
				}
				
				this.ejercicio.setAleatorio(aleatorio);
				this.ejercicio.setPeso(peso);
				this.ejercicio.setFechaFin(fin);
				this.ejercicio.setFechaIni(ini);
				this.ejercicio.setVisibilidad(visibilidad);
				
				this.frame.showAsignatura(false, this.ejercicio.getAsignatura());
				
			}
			Plataforma.plat().saveData();
		}
		else if(arg0.getActionCommand().equals("pregunta")){
			if(this.ejercicio == null){
				JOptionPane.showMessageDialog(null, "Guarde el ejercicio antes de continuar", "Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			this.frame.showElegirTipoPregunta(true, this.ejercicio);
		}
		else if(arg0.getActionCommand().equals("cancelar")){
			int result = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir sin confirmar los cambios?", "Confirmar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.OK_OPTION){
				this.frame.atras();
			}
		}
		
	}

}
