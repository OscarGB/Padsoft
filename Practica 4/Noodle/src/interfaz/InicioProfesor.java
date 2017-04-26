package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import listeners.InicioProfesorListener;

/**
 * Clase InicioProfesor
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 20/04/2017
 */
public class InicioProfesor extends NuestroPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Menu generico que se muestra en la parte superior
	 */
	private Menu menu;
	
	/**
	 * Texto de bienvenida
	 */
	private JLabel texto;
	
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
		this.texto = new JLabel("Bienvenido a Noodle");
		this.texto.setFont(new Font("Arial", Font.BOLD, 20));
		this.texto.setHorizontalAlignment(JLabel.CENTER);
		this.texto.setVerticalAlignment(JLabel.CENTER);
		
		menu.setPreferredSize(new Dimension(10,10));
		
		this.add(this.menu, BorderLayout.NORTH);
		this.add(this.texto, BorderLayout.CENTER);
		
		int h = this.getHeight();
		int w = this.getWidth();
		
		this.menu.setPreferredSize(new Dimension(w, 40));
		//TODO cambiar
		this.texto.setPreferredSize(new Dimension(w, h));

	}
	
	/**
	 * Hace que el frame muestre este panel
	 */
	public void muestraPanel(){
		this.frame.showInicioProfesor(false);
	}

}
