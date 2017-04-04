package Interfaz;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class PanelLogin extends JPanel {
	
	public PanelLogin() {
		
		this.setPreferredSize(new Dimension(500, 300));
		this.setBackground(Color.WHITE);
		
		JLabel usrLabel = new JLabel("Usuario");
		JTextField usrField = new JTextField(20);
		JLabel pwdLabel = new JLabel("Password");
		JPasswordField pwdField = new JPasswordField(20);
		JButton boton = new JButton("Login");
		Imagen img = new Imagen();
		
		SpringLayout spr = new SpringLayout();
		setLayout(spr);
		
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, img, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, usrLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, pwdLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, usrField, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, pwdField, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, boton, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		spr.putConstraint(SpringLayout.NORTH, img, 10, SpringLayout.NORTH, this);
		spr.putConstraint(SpringLayout.NORTH, usrLabel, 5, SpringLayout.SOUTH, img);
		spr.putConstraint(SpringLayout.NORTH, usrField, 5, SpringLayout.SOUTH, usrLabel);
		spr.putConstraint(SpringLayout.NORTH, pwdLabel, 5, SpringLayout.SOUTH, usrField);
		spr.putConstraint(SpringLayout.NORTH, pwdField, 5, SpringLayout.SOUTH, pwdLabel);
		spr.putConstraint(SpringLayout.NORTH, boton, 10, SpringLayout.SOUTH, pwdField);
		
		this.add(img);
		this.add(usrLabel);
		this.add(usrField);
		this.add(pwdLabel);
		this.add(pwdField);
		this.add(boton);
		
		
		
	}
	
}
