package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import asignatura.Asignatura;

public class AsignaturaGUI extends NuestroPanel{
	
	// Variables

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Menu generico que se muestra en la parte superior
	 */
	private Menu menu;
	
	/**
	 * Asignatura a mostrar
	 */
	private Asignatura asignatura;
	
	private TreeContent arbol;
	
	//private MenuAsignatura menuAsig;
	
	//Constructor

	public AsignaturaGUI(NuestroPanel anterior, NoodleFrame frame, Asignatura asignatura) {
		super(anterior, frame);
		this.setSize(400,350);
		this.setBackground(Color.WHITE);
		
		this.asignatura = asignatura;
		
		this.setLayout(new BorderLayout());
		
		this.menu = new Menu(frame);
//		this.menuAsig = new MenuAsig(frame);
		this.arbol = new TreeContent(frame, asignatura);
		
		this.add(this.menu, BorderLayout.NORTH);
//		this.add(this.menuAsig, BorderLayout.EAST);
		this.add(this.arbol, BorderLayout.CENTER);
		
		int w = this.getWidth();
		this.menu.setPreferredSize(new Dimension(w, 80));		
		
	}
	

	// Métodos
	
	/**
	 * Hace que el frame muestre este panel
	 */
	public void muestraPanel(Asignatura asignatura){
		this.frame.showAsignatura(true, asignatura);
	}
	
	/**
	 * Método que actualiza el panel
	 */
	public void refreshPanel(Asignatura asignatura){
		this.asignatura = asignatura;
		this.remove(this.arbol);
		this.arbol = new TreeContent(frame, asignatura);
		this.add(this.arbol, BorderLayout.CENTER);
	}

}
