package interfaz.asignatura;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import contenido.Apuntes;
import interfaz.genericos.NoodleFrame;

public class ApuntesPanel extends JPanel{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel titulo;
	
	private JTextArea texto;
	
	private JScrollPane scrolltext;
	
	/**
	 * Constructor de ApuntesPanel
	 * @param frame
	 * @param apuntes
	 */
	public ApuntesPanel(Apuntes apuntes){
		this.setBackground(Color.WHITE);
		
		SpringLayout spr = new SpringLayout();
		setLayout(spr);
		
		this.titulo = new JLabel(apuntes.getTitulo());
		this.texto = new JTextArea(apuntes.getTexto());
		
		this.scrolltext = new JScrollPane(texto);
		
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.titulo, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.scrolltext, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.NORTH, this.titulo, 5, SpringLayout.NORTH, this);
		spr.putConstraint(SpringLayout.NORTH, this.scrolltext, 30, SpringLayout.SOUTH, this.titulo);

		this.titulo.setFont(new Font("Arial", Font.ITALIC, 40));
		this.texto.setFont(new Font("Arial", Font.BOLD, 15));
		this.texto.setLineWrap(true);
		this.texto.setWrapStyleWord(true);
		this.texto.setEditable(false);
		
		this.add(this.titulo);
		this.add(this.scrolltext);
		
		this.scrolltext.setPreferredSize(new Dimension(400,280));
		
		this.setPreferredSize(new Dimension(200, 150));

	}

}
