package interfaz.solicitudes;

import java.awt.*;

import javax.swing.JScrollPane;

import asignatura.Asignatura;
import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;

/**
 * Clase SolicitudesExpulsados
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class SolicitudesExpulsados extends NuestroPanel {
	
	//Variables
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Menu genérico que se muestra en la parte superior
	 */
	private Menu menu;
	
	/**
	 * Panel con las solicitudes
	 */
	private SolicitudesExpulsadosPanel solis;
	
	/**
	 * Panel de scrolling
	 */
	private JScrollPane scroll;
	
	/**
	 * Asignatura
	 */
	private Asignatura asig;
	
	//Constructor
	
	/**
	 * Constructor del inicio del alumno
	 * @param panel anterior
	 * @param frame
	 * @param asig
	 */
	public SolicitudesExpulsados(NuestroPanel anterior, NoodleFrame frame, Asignatura asig){
		super(anterior, frame);
		
		this.asig = asig;
		
		this.setSize(700,500);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());

		this.menu = new Menu(frame);
		this.solis = new SolicitudesExpulsadosPanel(this.asig, this);
		this.scroll = new JScrollPane(this.solis);
		
		menu.setPreferredSize(new Dimension(10,10));
		
		this.add(this.menu, BorderLayout.NORTH);
		this.add(this.scroll, BorderLayout.CENTER);
		
		int w = this.getWidth();
		
		this.menu.setPreferredSize(new Dimension(w, 80));

	}
	
	//Métodos
	
	/**
	 * Devuelve la asignatura
	 * @return
	 */
	public Asignatura getAsignatura(){
		return this.asig;
	}
	
	/**
	 * Hace que el frame muestre este panel
	 */
	@Override
	public void muestraPanel(){
		this.frame.showSolicitudesAlumno(false);
	}
	
	/**
	 * Método que actualiza el panel
	 * @param asig
	 */
	public void refreshPanel(Asignatura asig){
		this.asig = asig;
		this.remove(this.scroll);
		this.solis = new SolicitudesExpulsadosPanel(this.asig, this);
		this.scroll = new JScrollPane(this.solis);
		this.add(this.scroll, BorderLayout.CENTER);
	}
}
