package interfaz.asignatura.contenido.apuntes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import asignatura.Asignatura;
import contenido.Apuntes;
import interfaz.asignatura.contenido.ContenidoMenuDer;
import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;
import persona.Profesor;
import plataforma.Plataforma;

/**
 * Clase ApuntesGUI
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class ApuntesGUI extends NuestroPanel{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Apuntes a mostrar
	 */
	private Apuntes apuntes;
	
	/**
	 * Menu generico que se muestra en la parte superior
	 */
	private Menu menu;
	
	/**
	 * Menu lateral
	 */
	private ContenidoMenuDer list;
	
	/**
	 * Panel con los apuntes
	 */
	private ApuntesPanel contenido;

	public ApuntesGUI(NuestroPanel anterior, NoodleFrame frame, Apuntes apuntes) {
		super(anterior, frame);
		this.setSize(700,500);
		this.setBackground(Color.WHITE);
		
		this.apuntes = apuntes;
		
		this.setLayout(new BorderLayout());
		
		this.menu = new Menu(frame);
		this.contenido = new ApuntesPanel(this.apuntes);
		if(Plataforma.loggedAs() instanceof Profesor){
			this.list = new ContenidoMenuDer(frame, apuntes);
			this.add(this.list, BorderLayout.EAST);
		}
		
		
		this.add(this.menu, BorderLayout.NORTH);
		this.add(this.contenido, BorderLayout.CENTER);
		

		int w = this.getWidth();
		this.menu.setPreferredSize(new Dimension(w, 80));
	}
	
	/**
	 * Hace que el frame muestre este panel
	 */
	public void muestraPanel(){
		this.frame.showApuntes(true, this.apuntes);
	}
	
	/**
	 * Método para refrescar el panel
	 */
	public void refreshPanel(Apuntes apuntes){
		this.apuntes = apuntes;
		this.remove(this.contenido);
		this.contenido = new ApuntesPanel(this.apuntes);
		this.add(this.contenido, BorderLayout.CENTER);
		if(Plataforma.loggedAs() instanceof Profesor){
			this.remove(this.list);
			this.list = new ContenidoMenuDer(frame, apuntes);
			this.add(this.list, BorderLayout.EAST);
		}
	}

}
