package interfaz.asignatura.contenido.ejercicio;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import contenido.Ejercicio;
import contenido.Pregunta;

public class AddRespuesta extends JPanel{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Boton para añadir respuesta
	 */
	private JButton guardar = new JButton("Añadir respuesta");
	
	/**
	 * Texto de la respuesta
	 */
	private JTextField respuesta = new JTextField();
	
	/**
	 * Ejercicio
	 */
	private Pregunta pregunta;
	
	/**
	 * Listener
	 */
	private AddRespuestaListener list;
	
	/**
	 * Constructor de AddRespuesta
	 * @param ejercicio
	 */
	public AddRespuesta(Pregunta pregunta){
		this.pregunta = pregunta;
		
		this.setBackground(Color.WHITE);
		
		SpringLayout spr = new SpringLayout();
		this.setLayout(spr);
		
		this.guardar.setPreferredSize(new Dimension(100, 30));
		this.respuesta.setPreferredSize(new Dimension(200, 50));
		
		spr.putConstraint(SpringLayout.VERTICAL_CENTER, guardar, 0, SpringLayout.VERTICAL_CENTER, this);
		spr.putConstraint(SpringLayout.VERTICAL_CENTER, respuesta, 0, SpringLayout.VERTICAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, respuesta, -50, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.WEST, guardar, 10, SpringLayout.EAST, this.respuesta);
		
		this.add(this.respuesta);
		this.add(this.guardar);
		
		this.guardar.setActionCommand("guardar");

		this.list= new AddRespuestaListener(this.pregunta);
		
		this.guardar.addActionListener(list);
		
		this.setPreferredSize(new Dimension(this.getWidth(), 100));
		this.repaint();
	}
	
	/**
	 * Devuelve la respuesta escrita
	 * @return
	 */
	public String getRespuesta(){
		return this.respuesta.getText();
	}
	
}