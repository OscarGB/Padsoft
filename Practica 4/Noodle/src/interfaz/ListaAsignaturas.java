package interfaz;

import java.awt.*;

import javax.swing.*;

/**
 * Clase ListaAsignaturas
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 20/04/2017
 */
public class ListaAsignaturas extends NuestroPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Menu generico que se muestra en la parte superior
	 */
	private Menu menu;

	/**
	 * Panel con todas las asignaturas
	 */
	private TodasAsignaturas cursos;
	
	/**
	 * Panel de scrolling
	 */
	private JScrollPane scroll;
	
	/**
	 * Constructor de la lista de asignaturas
	 * @param panel anterior
	 * @param frame
	 */
	public ListaAsignaturas(NuestroPanel anterior, NoodleFrame frame){
		super(anterior, frame);
		this.setSize(700,500);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());

		this.menu = new Menu(frame);
		this.cursos = new TodasAsignaturas(frame);
		this.scroll = new JScrollPane(cursos);
		
		menu.setPreferredSize(new Dimension(10,10));
		
		this.add(this.menu, BorderLayout.NORTH);
		this.add(this.scroll, BorderLayout.CENTER);
		
		int w = this.getWidth();
		
		this.menu.setPreferredSize(new Dimension(w, 80));

	}
	
	
	/**
	 * Hace que el frame muestre este panel
	 */
	public void muestraPanel(){
		this.frame.showListaAsignaturas(false);
	}
	
	/**
	 * Método que actualiza el panel
	 */
	public void refreshPanel(){
		this.remove(this.scroll);
		this.cursos = new TodasAsignaturas(frame);
		this.scroll = new JScrollPane(cursos);
		this.add(this.scroll, BorderLayout.CENTER);
	}
}
