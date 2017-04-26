package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

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
	
	//private TreeContent arbol;
	
	//private MenuAsignatura menuAsig;
	
	//Constructor

	public AsignaturaGUI(NuestroPanel anterior, NoodleFrame frame) {
		super(anterior, frame);
		this.setSize(400,350);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());
		
		this.menu = new Menu(frame);
//		this.menuAsig = new MenuAsig(frame);
//		this.arbol = new TreeContent(frame);
		
		this.add(this.menu, BorderLayout.NORTH);
		
		int w = this.getWidth();
		this.menu.setPreferredSize(new Dimension(w, 80));
		
		
	}
	

	// Métodos
	
	/**
	 * Hace que el frame muestre este panel
	 */
	public void muestraPanel(){
		this.frame.showAsignatura(true);
	}

}
