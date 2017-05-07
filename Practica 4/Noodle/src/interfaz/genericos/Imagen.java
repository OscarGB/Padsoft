package interfaz.genericos;

import java.awt.*;

import javax.swing.*;

/**
 * Clase Imagen, es el logo de nuestra aplicación
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 06/04/2017
 */

public class Imagen extends JPanel{

	//Variables
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	//Constructor
	
	/**
	 * Constructor de Imagen
	 * @param int height
	 * @param int width
	 */
	public Imagen(int width, int height) {
		this.setPreferredSize(new Dimension(width, height));
	}
	
	//Métodos
	
	/**
	 * (Override) Método para pintar la imagen
	 * @param Graphics
	 */
	@Override
	public void paint(Graphics grafico) {
		Dimension height = getSize();
		
		ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/icon.jpg"));
		
		grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
		
		setOpaque(false);
		super.paintComponent(grafico);
		
	}
	
}
