package interfaz.asignatura;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import asignatura.Asignatura;
import contenido.Tema;
import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;
import persona.Profesor;
import plataforma.Plataforma;

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
	
	/**
	 * Menu lateral
	 */
	private AsignaturaMenuDer list;
	
	/**
	 * Menu lateral
	 */
	private AsignaturaMenuIzq izq;
	
	//Constructor

	public AsignaturaGUI(NuestroPanel anterior, NoodleFrame frame, Asignatura asignatura) {
		super(anterior, frame);
		this.setSize(400,350);
		this.setBackground(Color.WHITE);
		
		this.asignatura = asignatura;
		
		this.setLayout(new BorderLayout());
		
		this.menu = new Menu(frame);
		this.arbol = new TreeContent(frame, asignatura);
		
		
		if(Plataforma.loggedAs() instanceof Profesor){
			this.list = new AsignaturaMenuDer(frame, asignatura, null);
			this.izq = new AsignaturaMenuIzq(frame, asignatura);
			this.list.setVisible(false);
			this.add(this.list, BorderLayout.EAST);
			this.add(this.izq, BorderLayout.WEST);
		}
		
		
		
		this.add(this.menu, BorderLayout.NORTH);
		this.add(this.arbol, BorderLayout.CENTER);
		
		
		int w = this.getWidth();
		this.menu.setPreferredSize(new Dimension(w, 80));		
		
	}
	

	// Métodos
	
	/**
	 * Hace que el frame muestre este panel
	 */
	public void muestraPanel(){
		this.frame.showAsignatura(false, this.asignatura);
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
	
	/**
	 * Metodo para mostrar el menu lateral
	 * @param tema
	 */
	public void showLateral(Tema tema){
		this.list.setTema(tema);
		this.list.setVisible(true);
	}

}
