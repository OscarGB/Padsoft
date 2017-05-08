package interfaz.asignatura.asignaturaGUI.estadisticas;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import asignatura.Asignatura;
import interfaz.genericos.NoodleFrame;
import persona.Alumno;

/**
 * Clase EstadisticasPanelDer
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */
public class EstadisticasPanelDer extends JPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Frame global
	 */
	NoodleFrame frame;
	
	/**
	 * Alumno
	 */
	Alumno al;
	
	/**
	 * Asignatura
	 */
	Asignatura asig;
	
	/**
	 * Botón de expulsar
	 */
	private JButton expulsar = new JButton("Expulsar");
	
	/**
	 * Constructor
	 * @param frame
	 * @param al
	 * @param asig
	 */
	public EstadisticasPanelDer(NoodleFrame frame, Alumno al, Asignatura asig) {
		this.frame = frame;
		this.al = al;
		this.asig = asig;
		
		this.setBackground(Color.WHITE);
		
		SpringLayout spr = new SpringLayout();
		setLayout(spr);
		
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.expulsar, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.VERTICAL_CENTER, this.expulsar, 0, SpringLayout.VERTICAL_CENTER, this);
		
		expulsar.addActionListener(new EstadisticasPanelDerListener(this.frame, this.al, this.asig));
		
		this.add(expulsar);		
		
		this.setPreferredSize(new Dimension(100, 400));
		
	}


}
