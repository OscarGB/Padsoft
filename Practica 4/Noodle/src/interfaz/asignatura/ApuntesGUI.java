package interfaz.asignatura;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import contenido.Apuntes;
import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;
import persona.Profesor;
import plataforma.Plataforma;

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
		this.list = new ContenidoMenuDer(frame, apuntes);
		
		this.setLayout(new BorderLayout());
		
		this.menu = new Menu(frame);
		this.contenido = new ApuntesPanel(this.apuntes);
		if(Plataforma.loggedAs() instanceof Profesor){
			this.list = new ContenidoMenuDer(frame, apuntes);
			this.add(this.list, BorderLayout.EAST);
		}
		
		
		this.add(this.menu, BorderLayout.NORTH);
		this.add(this.contenido, BorderLayout.CENTER);
		this.add(this.list, BorderLayout.EAST);
		

		int w = this.getWidth();
		this.menu.setPreferredSize(new Dimension(w, 80));
//		this.list.setPreferredSize(new Dimension(50, this.getHeight()));;
	}

}
