package interfaz.solicitudes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;

import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;

/**
 * Clase SolicitudesProfesor
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class SolicitudesProfesor extends NuestroPanel {
	
	//Variables
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Menu generico que se muestra en la parte superior
	 */
	private Menu menu;
	
	/**
	 * Panel con las solicitudes
	 */
	private TodasSolicitudes solis;
	
	/**
	 * Panel de scrolling
	 */
	private JScrollPane scroll;
	
	//Constructor
	
	/**
	 * Constructor
	 * @param anterior
	 * @param frame
	 */
	public SolicitudesProfesor(NuestroPanel anterior, NoodleFrame frame){
		super(anterior, frame);
		this.setSize(700,500);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());

		this.menu = new Menu(frame);
		this.solis = new TodasSolicitudes(frame);
		this.scroll = new JScrollPane(this.solis);
		
		menu.setPreferredSize(new Dimension(10,10));
		
		this.add(this.menu, BorderLayout.NORTH);
		this.add(this.scroll, BorderLayout.CENTER);
		
		int w = this.getWidth();
		
		this.menu.setPreferredSize(new Dimension(w, 80));

	}
	
	//M�todos
	
	/**
	 * Hace que el frame muestre este panel
	 */
	@Override
	public void muestraPanel(){
		this.frame.showSolicitudesAlumno(false);
	}
	
	/**
	 * M�todo que actualiza el panel
	 */
	public void refreshPanel(){
		this.remove(this.scroll);
		this.solis = new TodasSolicitudes(this.frame);
		this.scroll = new JScrollPane(solis);
		this.add(this.scroll, BorderLayout.CENTER);
	}
}
