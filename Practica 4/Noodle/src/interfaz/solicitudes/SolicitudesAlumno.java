package interfaz.solicitudes;

import java.awt.*;

import javax.swing.JScrollPane;

import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;

/**
 * Clase SolicitudesAlumno
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class SolicitudesAlumno extends NuestroPanel {
	
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
	private MisSolicitudes solis;
	
	/**
	 * Panel de scrolling
	 */
	private JScrollPane scroll;
	
	//Constructor
	
	/**
	 * Constructor del inicio del alumno
	 * @param panel anterior
	 * @param frame
	 */
	public SolicitudesAlumno(NuestroPanel anterior, NoodleFrame frame){
		super(anterior, frame);
		this.setSize(700,500);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());

		this.menu = new Menu(frame);
		this.solis = new MisSolicitudes();
		this.scroll = new JScrollPane(this.solis);
		
		menu.setPreferredSize(new Dimension(10,10));
		
		this.add(this.menu, BorderLayout.NORTH);
		this.add(this.scroll, BorderLayout.CENTER);
		
		int w = this.getWidth();
		
		this.menu.setPreferredSize(new Dimension(w, 80));

	}
	
	//Métodos
	
	/**
	 * Hace que el frame muestre este panel
	 */
	@Override
	public void muestraPanel(){
		this.frame.showSolicitudesAlumno(false);
	}
	
	/**
	 * Método que actualiza el panel
	 */
	public void refreshPanel(){
		this.remove(this.scroll);
		this.solis = new MisSolicitudes();
		this.scroll = new JScrollPane(this.solis);
		this.add(this.scroll, BorderLayout.CENTER);
	}
}
