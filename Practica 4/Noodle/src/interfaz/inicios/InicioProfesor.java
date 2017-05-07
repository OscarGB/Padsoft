package interfaz.inicios;

import java.awt.*;

import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;

/**
 * Clase InicioProfesor
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 20/04/2017
 */
public class InicioProfesor extends NuestroPanel {

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
	 * Panel de inicio
	 */
	private CreaAsignatura centro = new CreaAsignatura();
	
	//constructor
	
	/**
	 * Constructor del inicio del profesor
	 * @param panel anterior
	 * @param frame
	 */
	public InicioProfesor(NuestroPanel anterior, NoodleFrame frame){
		super(anterior, frame);
		this.setSize(700,500);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());

		this.menu = new Menu(frame);
		
		menu.setPreferredSize(new Dimension(10,10));
		
		this.add(this.menu, BorderLayout.NORTH);
		this.add(this.centro, BorderLayout.CENTER);
		
		int h = this.getHeight();
		int w = this.getWidth();
		
		this.menu.setPreferredSize(new Dimension(w, 40));
		//TODO cambiar
		this.centro.setPreferredSize(new Dimension(w, h));

	}
	
	//Métodos
	
	/**
	 * Hace que el frame muestre este panel
	 */
	@Override
	public void muestraPanel(){
		this.frame.showInicioProfesor(false);
	}

}
