package interfaz.inicios;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

/**
 * Clase CreaAsignatura
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class CreaAsignatura extends JPanel {

	// Variables
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Label de bienvenida
	 */
	private JLabel bienvenida = new JLabel("Bienvenido a Noodle");
	
	/**
	 * Botón para crear una asignatura
	 */
	private JButton crear = new JButton("Crear Asignatura");
	
	/**
	 * Lugar para introducir el nombre de la asignatura
	 */
	private JTextField nombre = new JTextField(20);
	
	/**
	 * Botón para confirmar la creación de la asignatura
	 */
	private JButton confirmar = new JButton("Confirmar");
	
	//Constructor
	
	/**
	 * Constructor de CreaAsignatura
	 */
	public CreaAsignatura(){
		this.setBackground(Color.WHITE);
		
		SpringLayout spr = new SpringLayout();
		this.setLayout(spr);
		
		this.cambiarVisibilidad(false);
		
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, crear, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, bienvenida, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, nombre, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, confirmar, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		spr.putConstraint(SpringLayout.VERTICAL_CENTER, crear, 0, SpringLayout.VERTICAL_CENTER, this);
		spr.putConstraint(SpringLayout.SOUTH, bienvenida, -5, SpringLayout.NORTH, crear);
		spr.putConstraint(SpringLayout.NORTH, nombre, 5, SpringLayout.SOUTH, crear);
		spr.putConstraint(SpringLayout.NORTH, confirmar, 5, SpringLayout.SOUTH, nombre);
		
		this.crear.setActionCommand("Crear");
		this.confirmar.setActionCommand("Confirmar");
		
		this.bienvenida.setFont(new Font("Arial", Font.BOLD, 20));
		
		this.add(confirmar);
		this.add(bienvenida);
		this.add(crear);
		this.add(nombre);
		
		this.addListener(new CreaAsignaturaListener(this));
	}
	
	//Métodos
	
	/**
	 * Cambia la visibilidad de los campos de crear asignatura
	 * @param flag
	 */
	public void cambiarVisibilidad(boolean flag){
		this.nombre.setVisible(flag);
		this.confirmar.setVisible(flag);
	}
	
	/**
	 * Añade un listener al panel
	 * @param list
	 */
	public void addListener(CreaAsignaturaListener list){
		this.crear.addActionListener(list);
		this.confirmar.addActionListener(list);
	}
	
	/**
	 * Devuelve el nombre introducido
	 * @return
	 */
	public String getNombre() {
		return new String(this.nombre.getText().trim());
	}
	

}
