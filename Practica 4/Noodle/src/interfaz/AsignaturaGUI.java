package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import asignatura.Asignatura;
import contenido.Contenido;
import contenido.Ejercicio;
import contenido.Tema;
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
	
	//private MenuAsignatura menuAsig;
	
	//Constructor

	public AsignaturaGUI(NuestroPanel anterior, NoodleFrame frame, Asignatura asignatura) {
		super(anterior, frame);
		this.setSize(400,350);
		this.setBackground(Color.WHITE);
		
		this.asignatura = asignatura;
		
		this.setLayout(new BorderLayout());
		
		//Contenidos para probar el treecontent
		
		Tema tema1 = new Tema("Tema 1", true, asignatura);
		Tema tema11 = new Tema("Tema 11", true, asignatura, tema1);
		Tema tema111 = new Tema("Tema 111", false, asignatura, tema11);
		Tema tema2 = new Tema("Tema 2", true, asignatura);
		Tema tema3 = new Tema("Tema 3", true, asignatura);
		Ejercicio ej1 = new Ejercicio(1, false, Plataforma.getFechaActual().minusDays(0), Plataforma.getFechaActual().plusDays(4), tema2,"ej1", true, asignatura);
		
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

}
