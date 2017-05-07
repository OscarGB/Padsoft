package interfaz.asignatura.contenido.apuntes;

import java.awt.*;
import java.awt.event.ActionListener;

import asignatura.Asignatura;
import contenido.Apuntes;
import contenido.Tema;
import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;

/**
 * Clase SubirApuntes
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class SubirApuntes extends NuestroPanel {
	
	//Variables
	
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

	//Constructor
	
	/**
	 * Constructor de SubirApuntes. Si tema es null, lo sube a la raiz
	 * @param anterior
	 * @param frame
	 * @param asignatura
	 * @param apuntes
	 */
	public SubirApuntes(NuestroPanel anterior, NoodleFrame frame, Asignatura asignatura, Tema tema, Apuntes apuntes) {
		super(anterior, frame);
		this.setSize(400,350);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());
		
		this.menu = new Menu(frame);
		this.asignatura = asignatura;
		this.tema = tema;
		
		this.formulario = new ApuntesForm(this.frame, this.asignatura, this.tema, apuntes);

		this.add(this.menu, BorderLayout.NORTH);
		this.add(formulario, BorderLayout.CENTER);
		
		int w = this.getWidth();
		this.menu.setPreferredSize(new Dimension(w, 80));
		
	}
	
	//M�todos
	
	/**
	 * Metodo para a�adir listener al formulario
	 * @param listener
	 */
	public void addListener(ActionListener listener){
		this.formulario.addListener(listener);
	}
	
	/**
	 * Getter del formulario
	 * @return
	 */
	public ApuntesForm getForm(){
		return this.formulario;
	}
	
	/**
	 * M�todo que refresca el panel
	 * @param asig
	 * @param tema
	 * @param apuntes
	 */
	public void refreshPanel(Asignatura asig, Tema tema, Apuntes apuntes){
		this.asignatura = asig;
		this.tema = tema;
		
		this.remove(this.formulario);
		this.formulario = new ApuntesForm(this.frame, this.asignatura, this.tema, apuntes);
		this.add(this.formulario, BorderLayout.CENTER);
	}
	
	/**
	 * Hace que el frame muestre este panel
	 * @param apuntes
	 */
	public void muestraPanel(Apuntes apuntes){
		this.frame.showSubirApuntes(false, apuntes.getAsignatura(), apuntes.getPadre(), apuntes);
	}

}
