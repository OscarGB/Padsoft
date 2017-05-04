package interfaz.asignatura;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import asignatura.Asignatura;
import interfaz.genericos.NoodleFrame;
import plataforma.Plataforma;
/**
 * Clase AsigAlumnoMenuIzq
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */
public class AsigAlumnoMenuIzq extends JPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Frame en el que se encuentra
	 */
	private NoodleFrame frame;
	
	/**
	 * Asignatura en la que se encuentra
	 */
	private Asignatura asignatura;
	
	/**
	 * Botón para acceder a las notas
	 */
	private JButton notas = new JButton("Notas");

	/**
	 * Creador
	 * @param frame
	 * @param asignatura
	 */
	public AsigAlumnoMenuIzq(NoodleFrame frame, Asignatura asignatura){
		this.frame = frame;
		this.asignatura = asignatura;
		
		this.setBackground(Color.WHITE);

		SpringLayout spr = new SpringLayout();
		this.setLayout(spr);
		
		spr.putConstraint(SpringLayout.WEST, this.notas, 10, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.VERTICAL_CENTER, this.notas, 0, SpringLayout.VERTICAL_CENTER, this);
		
		this.add(this.notas);
		this.notas.setPreferredSize(new Dimension(150, 30));
		
		this.notas.setActionCommand("notas");
		
		this.notas.addActionListener(new AsigAlumnoMenuIzqListener(this.frame, Plataforma.loggedAs(), asignatura));
		this.setPreferredSize(new Dimension(200, 250));
	}
}
