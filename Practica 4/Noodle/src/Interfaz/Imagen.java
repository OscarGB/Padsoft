package Interfaz;

import java.awt.*;

import javax.swing.*;

public class Imagen extends JPanel{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	public Imagen() {
		this.setMinimumSize(new Dimension(150, 150));
		this.setPreferredSize(new Dimension(150, 150));
	}
	
	public void paint(Graphics grafico) {
		Dimension height = getSize();
		
		ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/icon.jpg"));
		
		grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
		
		setOpaque(false);
		super.paintComponent(grafico);
		
	}
	
}
