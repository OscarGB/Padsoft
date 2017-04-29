package interfaz.asignatura;

import java.awt.*;
import java.awt.event.ActionListener;

import asignatura.Asignatura;
import contenido.Tema;
import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;

public class SubirApuntes extends NuestroPanel {
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Asignatura a la que subir los apuntes
	 */
	private Asignatura asignatura;
	
	/**
	 * Tema al que subir los apuntes
	 */
	private Tema tema;
	
	/**
	 * Menu generico
	 */
	private Menu menu;
	
	/**
	 * Formulario para subir los apuntes
	 */
	private ApuntesForm formulario;

	/**
	 * Constructor de SubirApuntes. Si tema es null, lo sube a la raiz
	 * @param anterior
	 * @param frame
	 * @param asignatura
	 * @param tema
	 */
	public SubirApuntes(NuestroPanel anterior, NoodleFrame frame, Asignatura asignatura, Tema tema) {
		super(anterior, frame);
		this.setSize(400,350);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());
		
		this.menu = new Menu(frame);
		this.asignatura = asignatura;
		this.tema = tema;
		
		this.formulario = new ApuntesForm(this.frame, this.asignatura, this.tema);

		this.add(this.menu, BorderLayout.NORTH);
		this.add(formulario, BorderLayout.CENTER);
		
		int w = this.getWidth();
		this.menu.setPreferredSize(new Dimension(w, 80));
		
	}
	
	/**
	 * Metodo para añadir listener al formulario
	 * @param listener
	 */
	public void addListener(ActionListener listener){
		this.formulario.addListener(listener);
	}
	
	public ApuntesForm getForm(){
		return this.formulario;
	}

}
