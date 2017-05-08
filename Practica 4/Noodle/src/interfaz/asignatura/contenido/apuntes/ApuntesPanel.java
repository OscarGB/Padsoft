package interfaz.asignatura.contenido.apuntes;

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

/**
 * Clase ApuntesPanel
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class ApuntesPanel extends JPanel{
	
	//Variables

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Etiqueta con el titulo
	 */
	private JLabel titulo;
	
	/**
	 * Área para el texto
	 */
	private JTextArea texto;
	
	/**
	 * Scroll
	 */
	private JScrollPane scrolltext;
	
	//Constructor
	
	/**
	 * Constructor de ApuntesPanel
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
