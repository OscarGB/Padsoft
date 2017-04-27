package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import plataforma.Plataforma;
import solicitud.Solicitud;

/**
 * MisSolicitudes
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class MisSolicitudes extends JPanel {
	/**
	 * ID del panel de Panel
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de MisAsignaturas (subpanel)
	 * @param frame
	 */
	public MisSolicitudes() {
		this.setBackground(Color.WHITE);
		ArrayList<Solicitud> solis = this.getSolicitudes();
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		
		SpringLayout spr = new SpringLayout();
		setLayout(spr);
		
		int size = solis.size();
		
		if(size == 0){
			JLabel label = new JLabel("No solicitudes pendientes");
			labels.add(label);
			spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
			spr.putConstraint(SpringLayout.VERTICAL_CENTER, label, 0, SpringLayout.VERTICAL_CENTER, this);
		}
		if(size > 0){
			JLabel label = new JLabel("Solicitud de acceso a la asignatura " + solis.get(0).getAsignatura().getNombre());
			labels.add(label);
			spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
			spr.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);

			for(int i = 1; i < size; i++){
				label = new JLabel("Solicitud de acceso a la asignatura " + solis.get(i).getAsignatura().getNombre());
				JLabel previous = labels.get(i-1);
				labels.add(label);
				spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
				spr.putConstraint(SpringLayout.NORTH, label, 50, SpringLayout.NORTH, previous);
			}
		}
			
		for(JLabel lab : labels){
			lab.setFont(new Font("Arial", Font.BOLD, 20));
			this.add(lab);
		}
		
		this.setPreferredSize(new Dimension(this.getWidth(), (labels.get(0).getHeight() + 50)*size));
		
	}
	
	/**
	 * Metodo para obtener las asignaturas de la plataforma
	 * @return ArrayList
	 */
	private ArrayList<Solicitud> getSolicitudes(){
		ArrayList<Solicitud> total = Plataforma.plat().getSolicitudes();
		ArrayList<Solicitud> propias = new ArrayList<Solicitud>();
		for(Solicitud sol : total){
			if(sol.getAlumno().equals(Plataforma.loggedAs())){
				propias.add(sol);
			}
		}
		return propias;		
	}
}
