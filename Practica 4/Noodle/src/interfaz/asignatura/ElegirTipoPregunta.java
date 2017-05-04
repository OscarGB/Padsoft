package interfaz.asignatura;

import javax.swing.JButton;

import contenido.Ejercicio;
import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;

public class ElegirTipoPregunta extends NuestroPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Menú genérico
	 */
	private Menu menu;
	
	/**
	 * Ejercicio al que se va a añadir
	 */
	Ejercicio ej;
	
	/**
	 * Botones
	 */
	JButton botones[] = {new JButton("Simple"), new JButton("Unica"), new JButton("Multiple"), new JButton("Abierta")};
	
	/**
	 * Creador
	 * @param anterior
	 * @param frame
	 * @param ej
	 */
	protected ElegirTipoPregunta(NuestroPanel anterior, NoodleFrame frame, Ejercicio ej) {
		super(anterior, frame);
		this.ej = ej;
		
		
		
	}

}
