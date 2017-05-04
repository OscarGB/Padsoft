package interfaz.asignatura;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;

import asignatura.Asignatura;
import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;
import persona.Alumno;
import persona.Profesor;
import plataforma.Plataforma;

/**
 * Clase Estadisticas
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */
public class Estadisticas extends NuestroPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Alumno 
	 */
	private Alumno al;
	
	/**
	 * Asignatura
	 */
	private Asignatura asig;
	
	/**
	 * Menú genérico
	 */
	private Menu menu;
	
	/**
	 * Panel con las estadísitcas
	 */
	private EstadisticasPanel panel;
	
	/**
	 * Panel derecho
	 */
	private EstadisticasPanelDer panelDer;
	
	/**
	 * Panel scrolleable
	 */
	private JScrollPane scroll;
	
	
	/**
	 * Constructor
	 * @param anterior
	 * @param frame
	 * @param al
	 * @param asig
	 */
	public Estadisticas(NuestroPanel anterior, NoodleFrame frame, Alumno al, Asignatura asig) {
		super(anterior, frame);
		
		this.asig = asig;
		this.al = al;
		
		this.menu = new Menu(frame);
		this.panel = new EstadisticasPanel(frame, this.al, this.asig);
		this.panelDer = new EstadisticasPanelDer(frame, this.al, this.asig);
		this.scroll = new JScrollPane(this.panel);
		
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());
		
		this.menu.setPreferredSize(new Dimension(this.getWidth(), 80));
		
		this.add(this.menu, BorderLayout.NORTH);
		this.add(this.scroll, BorderLayout.CENTER);
		if(Plataforma.loggedAs() instanceof Profesor){
			this.add(this.panelDer, BorderLayout.EAST);
		}
	}

}
