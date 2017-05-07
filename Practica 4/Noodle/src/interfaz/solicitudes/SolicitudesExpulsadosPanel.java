package interfaz.solicitudes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import asignatura.Asignatura;
import solicitud.Solicitud;

/**
 * Clase SolicitudesExpulsadosPanel
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class SolicitudesExpulsadosPanel extends JPanel {
	
	//Variables
	
	/**
	 * ID del panel de Panel
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Asignatura
	 */
	Asignatura asig;
	
	//Constructor
	
	/**
	 * Constructor de SolicitudesExpulsadosPanel
	 * @param asig
	 * @param panel
	 */
	public SolicitudesExpulsadosPanel(Asignatura asig, SolicitudesExpulsados panel) {
		
		this.asig = asig;
		
		this.setBackground(Color.WHITE);
		ArrayList<Solicitud> solis = this.getSolicitudes();
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		
		SpringLayout spr = new SpringLayout();
		setLayout(spr);
		
		int size = 0;
		
		if(solis != null){
			size = solis.size();
		}
		
		if(size == 0){
			JLabel label = new JLabel("No solicitudes pendientes");
			labels.add(label);
			label.setFont(new Font("Arial", Font.BOLD, 20));
			this.add(label);
			spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
			spr.putConstraint(SpringLayout.VERTICAL_CENTER, label, 0, SpringLayout.VERTICAL_CENTER, this);
		}
		else{
			JLabel label = new JLabel("Se ha expulsado a " + solis.get(0).getAlumno().getNombre() + " de " + solis.get(0).getAsignatura().getNombre());
			labels.add(label);
			this.add(label);
			JButton aceptar = new JButton ("Aceptar");
			aceptar.setActionCommand("aceptar");
			SolicitudesExpulsadosListener list = new SolicitudesExpulsadosListener(solis.get(0), panel);
			aceptar.addActionListener(list);
			this.add(aceptar);
			spr.putConstraint(SpringLayout.WEST,  label, 10, SpringLayout.WEST, this);
			spr.putConstraint(SpringLayout.EAST,  aceptar, -10, SpringLayout.EAST, this);
			spr.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);
			spr.putConstraint(SpringLayout.NORTH, aceptar, 0, SpringLayout.NORTH, this);

			for(int i = 1; i < size; i++){
				label = new JLabel("Se ha expulsado a " + solis.get(i).getAlumno().getNombre() + " de " + solis.get(i).getAsignatura().getNombre());
				JLabel previous = labels.get(i-1);
				labels.add(label);
				this.add(label);
				aceptar = new JButton ("Readmitir");
				aceptar.setActionCommand("readmitir");
				list = new SolicitudesExpulsadosListener(solis.get(i), panel);
				aceptar.addActionListener(list);
				this.add(aceptar);
				spr.putConstraint(SpringLayout.WEST,  label, 10, SpringLayout.WEST, this);
				spr.putConstraint(SpringLayout.EAST,  aceptar, -10, SpringLayout.EAST, this);
				spr.putConstraint(SpringLayout.NORTH, label, 50, SpringLayout.NORTH, previous);
				spr.putConstraint(SpringLayout.NORTH, aceptar, 50, SpringLayout.NORTH, previous);
			}
		}
		
		this.setPreferredSize(new Dimension(this.getWidth(), (labels.get(0).getHeight() + 50)*size));
		
	}
	
	//Métodos
		
	/**
	 * Metodo para obtener las asignaturas de la plataforma
	 * @return
	 */
	private ArrayList<Solicitud> getSolicitudes(){
		return this.asig.getSolicitudesExpulsados();
	}
}
