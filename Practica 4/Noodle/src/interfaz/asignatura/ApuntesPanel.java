package interfaz.asignatura;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import contenido.Apuntes;
import interfaz.genericos.NoodleFrame;

public class ApuntesPanel extends JPanel{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Frame
	 */
	private NoodleFrame frame;
	
	public ApuntesPanel(NoodleFrame frame, Apuntes apuntes){
		this.frame = frame;
		this.setBackground(Color.WHITE);
		
		SpringLayout spr = new SpringLayout();
		setLayout(spr);
		
		JLabel titulo = new JLabel(apuntes.getTitulo());
		JLabel texto = new JLabel(apuntes.getTexto());
		JScrollPane scrolltext = new JScrollPane(texto);
		
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, titulo, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, scrolltext, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.NORTH, titulo, 0, SpringLayout.NORTH, this);
		spr.putConstraint(SpringLayout.NORTH, scrolltext, 10, SpringLayout.SOUTH, titulo);

		this.add(titulo);
		this.add(scrolltext);
		
		titulo.setPreferredSize(new Dimension(this.getWidth(), 40));
		scrolltext.setPreferredSize(new Dimension(this.getWidth(), texto.getHeight()));


	}

}
