package interfaz.asignatura;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

import asignatura.Asignatura;
import contenido.Apuntes;
import contenido.Tema;
import interfaz.genericos.NoodleFrame;

/**
 * Clase ApuntesForm
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class ApuntesForm extends JPanel{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Asignatura a la que hace referencia
	 */
	private Asignatura asignatura;
	
	/**
	 * Frame
	 */
	private NoodleFrame frame;
	
	/**
	 * Tema a introducir
	 */
	private Tema tema;
	
	/**
	 * Apuntes
	 */
	private Apuntes apuntes;
	
	private JButton guardar;
	private JButton cancelar;
	private JTextArea titulo;
	private JTextArea texto;
	
	public ApuntesForm(NoodleFrame frame, Asignatura asignatura, Tema tema, Apuntes apuntes){
		SpringLayout spr = new SpringLayout();
		this.setLayout(spr);
		this.setBackground(Color.WHITE);
		this.asignatura = asignatura;
		this.tema = tema;
		this.frame = frame;
		this.apuntes = null;
		
		guardar = new JButton("Guardar");
		cancelar = new JButton("Cancelar");
		JLabel labeltitulo = new JLabel("Titulo: ");
		JLabel labeltexto = new JLabel("Introduzca el texto: ");
		titulo = new JTextArea();
		texto = new JTextArea();
		JScrollPane scrolltext;
		JScrollPane scrolltitle;
		
		labeltitulo.setFont(new Font("Arial", Font.BOLD, 20));
		labeltitulo.setPreferredSize(new Dimension(100, 20));
		labeltexto.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setPreferredSize(new Dimension(200, 25));
		
		texto.setLineWrap(true);
		texto.setWrapStyleWord(true);
		
		if(apuntes != null && apuntes instanceof Apuntes){
			this.apuntes = apuntes;
			titulo.setText(apuntes.getTitulo());
			texto.setText(apuntes.getTexto());
		}

		scrolltext = new JScrollPane(texto);
		scrolltitle = new JScrollPane(titulo);
		scrolltext.setPreferredSize(new Dimension(400, 200));
		
		//labeltitulo
		spr.putConstraint(SpringLayout.WEST, labeltitulo, -200, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.NORTH, labeltitulo, 10, SpringLayout.NORTH, this);
		
		//titulo
		spr.putConstraint(SpringLayout.VERTICAL_CENTER, scrolltitle, 0, SpringLayout.VERTICAL_CENTER, labeltitulo);
		spr.putConstraint(SpringLayout.WEST, scrolltitle, 10, SpringLayout.EAST, labeltitulo);
		
		//labeltexto
		spr.putConstraint(SpringLayout.NORTH, labeltexto, 20, SpringLayout.SOUTH, labeltitulo);	
		spr.putConstraint(SpringLayout.WEST, labeltexto, -200, SpringLayout.HORIZONTAL_CENTER, this);	

		//texto
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, scrolltext, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.NORTH, scrolltext, 20, SpringLayout.SOUTH, labeltexto);
		
		//guardar y cancelar
		spr.putConstraint(SpringLayout.WEST, guardar, 50, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.NORTH, guardar, 20, SpringLayout.SOUTH, scrolltext);
		spr.putConstraint(SpringLayout.EAST, cancelar, -50, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.NORTH, cancelar, 20, SpringLayout.SOUTH, scrolltext);

		this.guardar.setActionCommand("guardar");
		this.cancelar.setActionCommand("cancelar");
		
		this.add(labeltitulo);
		this.add(labeltexto);
		this.add(scrolltitle);
		this.add(scrolltext);
		this.add(guardar);
		this.add(cancelar);
		
		this.setPreferredSize(new Dimension(400, 250));
		
		
	}
	
	//Métodos
	
	/**
	 * Añade un ActionListener al ApuntesForm
	 * @param listener
	 */
	public void addListener(ActionListener listener){
		this.guardar.addActionListener(listener);
		this.cancelar.addActionListener(listener);
	}
	
	/**
	 * Devuelve el título de los apuntes
	 * @return
	 */
	public String getTitulo(){
		return new String(this.titulo.getText());
	}
	
	/**
	 * Devuelve el texto de los apuntes
	 * @return
	 */
	public String getTexto(){
		return new String(this.texto.getText());
	}
	
	/**
	 * Getter de asignatura
	 * @return
	 */
	public Asignatura getAsignatura(){
		return this.asignatura;
	}
	
	/**
	 * Getter de tema
	 * @return
	 */
	public Tema getTema(){
		return this.tema;
	}
	
	/**
	 * Getter de apuntes
	 * @return
	 */
	public Apuntes getApuntes(){
		return this.apuntes;
	}
		
	

}
