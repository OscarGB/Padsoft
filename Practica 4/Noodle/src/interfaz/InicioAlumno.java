package interfaz;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InicioAlumno extends NuestroPanel {
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	JMenuBar menubar = new JMenuBar();
	JMenu inicio = new JMenu("Inicio");
	JMenu cursos = new JMenu("Mis cursos");
	JMenu solicitudes = new JMenu("Solicitudes");
	Imagen logo = new Imagen(50, 50);
	JButton exit = new JButton("LOG OUT");
	
	public InicioAlumno(NuestroPanel anterior, NoodleFrame frame){
		super(anterior, frame);
		this.setPreferredSize(new Dimension(50, 50));
		this.setMaximumSize(new Dimension(50, 50));
		this.setBackground(Color.WHITE);
		
		SpringLayout spr = new SpringLayout();
		setLayout(spr);
		
		exit.setBackground(Color.RED);
		exit.setFont(new Font("Arial", Font.BOLD, 20));
		inicio.setFont(new Font("Arial", Font.BOLD, 20));
		inicio.setMargin(new Insets(20, 20, 3, 3));
		cursos.setFont(new Font("Arial", Font.BOLD, 20));
		solicitudes.setFont(new Font("Arial", Font.BOLD, 20));
		
		spr.putConstraint(SpringLayout.NORTH, logo, 5, SpringLayout.NORTH, this);
		spr.putConstraint(SpringLayout.WEST, logo, 5, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.NORTH, menubar, 5, SpringLayout.NORTH, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, menubar, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.EAST, menubar, -5, SpringLayout.WEST, exit);
		spr.putConstraint(SpringLayout.WEST, menubar, 5, SpringLayout.EAST, logo);
		spr.putConstraint(SpringLayout.NORTH, exit, 5, SpringLayout.NORTH, this);
		spr.putConstraint(SpringLayout.EAST, exit, -5, SpringLayout.EAST, this);
		
		this.add(logo);
		this.add(exit);
		this.menubar.add(inicio);
		this.menubar.add(cursos);
		this.menubar.add(solicitudes);
		
		this.add(menubar);
	}
	
	/**
	 * Añade un ActionListener al InicioAlumno
	 * @param listener
	 */
	public void addListener(ActionListener listener){
		//TODO añadir los listeners
		return;
	}
	
	/**
	 * Hace que el frame muestre este panel
	 */
	public void muestraPanel(){
		this.frame.showInicioAlumno();
	}
	
}
