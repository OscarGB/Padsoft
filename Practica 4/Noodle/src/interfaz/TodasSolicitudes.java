package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import listeners.SolicitudesProfesorListener;
import plataforma.Plataforma;
import solicitud.Solicitud;

/**
 * TodasSolicitudes
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class TodasSolicitudes extends JPanel {
	
	/**
	 * ID del panel de Panel
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Panel en el que se encuentra
	 */
	NoodleFrame frame;
	
	/**
	 * Constructor de MisAsignaturas (subpanel)
	 * @param soli
	 */
	public TodasSolicitudes(NoodleFrame frame) {
		this.frame = frame;
		this.setBackground(Color.WHITE);
		ArrayList<Solicitud> solis = this.getSolicitudes();
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		
		SpringLayout spr = new SpringLayout();
		setLayout(spr);
		
		int size = solis.size();
		
		if(size == 0){
			JLabel label = new JLabel("No solicitudes pendientes");
			labels.add(label);
			label.setFont(new Font("Arial", Font.BOLD, 20));
			this.add(label);
			spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
			spr.putConstraint(SpringLayout.VERTICAL_CENTER, label, 0, SpringLayout.VERTICAL_CENTER, this);
		}
		if(size > 0){
			JLabel label = new JLabel("Solicitud de acceso a la asignatura " + solis.get(0).getAsignatura().getNombre() + " por parte de " + solis.get(0).getAlumno().getNombre());
			labels.add(label);
			this.add(label);
			JButton aceptar = new JButton ("Aceptar");
			JButton cancelar = new JButton ("Cancelar");
			cancelar.setActionCommand("cancelar");
			aceptar.setActionCommand("aceptar");
			SolicitudesProfesorListener list = new SolicitudesProfesorListener(this.frame, solis.get(0));
			aceptar.addActionListener(list);
			cancelar.addActionListener(list);
			this.add(aceptar);
			this.add(cancelar);
			spr.putConstraint(SpringLayout.WEST,  label, 10, SpringLayout.WEST, this);
			spr.putConstraint(SpringLayout.EAST,  aceptar, -10, SpringLayout.WEST, cancelar);
			spr.putConstraint(SpringLayout.EAST,  cancelar, -10, SpringLayout.EAST, this);
			spr.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);
			spr.putConstraint(SpringLayout.NORTH, aceptar, 0, SpringLayout.NORTH, this);
			spr.putConstraint(SpringLayout.NORTH, cancelar, 0, SpringLayout.NORTH, this);

			for(int i = 1; i < size; i++){
				label = new JLabel("Solicitud de acceso a la asignatura " + solis.get(i).getAsignatura().getNombre());
				JLabel previous = labels.get(i-1);
				labels.add(label);
				this.add(label);
				aceptar = new JButton ("Aceptar");
				cancelar = new JButton ("Cancelar");
				cancelar.setActionCommand("cancelar");
				aceptar.setActionCommand("aceptar");
				list = new SolicitudesProfesorListener(this.frame, solis.get(i));
				aceptar.addActionListener(list);
				cancelar.addActionListener(list);
				this.add(aceptar);
				this.add(cancelar);
				spr.putConstraint(SpringLayout.WEST,  label, 10, SpringLayout.WEST, this);
				spr.putConstraint(SpringLayout.EAST,  aceptar, -10, SpringLayout.WEST, cancelar);
				spr.putConstraint(SpringLayout.EAST,  cancelar, -10, SpringLayout.EAST, this);
				spr.putConstraint(SpringLayout.NORTH, label, 50, SpringLayout.NORTH, previous);
				spr.putConstraint(SpringLayout.NORTH, aceptar, 50, SpringLayout.NORTH, previous);
				spr.putConstraint(SpringLayout.NORTH, cancelar, 50, SpringLayout.NORTH, previous);
			}
		}
		
		this.setPreferredSize(new Dimension(this.getWidth(), (labels.get(0).getHeight() + 50)*size));
		
	}
	
	/**
	 * Metodo para obtener las asignaturas de la plataforma
	 * @return ArrayList
	 */
	private ArrayList<Solicitud> getSolicitudes(){
		return Plataforma.plat().getSolicitudes();
	}
}
