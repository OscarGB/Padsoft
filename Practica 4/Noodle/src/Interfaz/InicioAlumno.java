package Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.*;

public class InicioAlumno extends JPanel {
	
	JMenuBar menubar = new JMenuBar();
	JMenu inicio = new JMenu("Inicio");
	JMenu cursos = new JMenu("Mis cursos");
	JMenu solicitudes = new JMenu("Solicitudes");
	Imagen logo = new Imagen(50, 50);
	JButton exit = new JButton("LOG OUT");
	
	public InicioAlumno(){
		
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
	
}
