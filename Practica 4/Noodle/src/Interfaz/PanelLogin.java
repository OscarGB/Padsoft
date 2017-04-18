package Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import plataforma.Plataforma;

class BotonListener implements ActionListener{

	public BotonListener(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(Plataforma.login(PanelLogin.usrField.getSelectedText(), PanelLogin.pwdField.getSelectedText()) == false){
			PanelLogin.failPasswordLabel.setVisible(true);
		}
	}
}

public class PanelLogin extends JPanel {
	
	JLabel usrLabel = new JLabel("Usuario");
	public static JTextField usrField = new JTextField(20);
	JLabel pwdLabel = new JLabel("Password");
	public static JPasswordField pwdField = new JPasswordField(20);
	JButton boton = new JButton("Login");
	Imagen img = new Imagen(150,150);
	public static JLabel failPasswordLabel = new JLabel("Usuario o contraseña incorrectos");
	
	
	public PanelLogin() {
		
//		this.setPreferredSize(new Dimension(500, 300));
//		this.setMinimumSize(new Dimension(500, 300));
		this.setBackground(Color.WHITE);
		
		SpringLayout spr = new SpringLayout();
		setLayout(spr);
		
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, img, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, usrLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, pwdLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, usrField, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, pwdField, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, boton, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, failPasswordLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		spr.putConstraint(SpringLayout.VERTICAL_CENTER, usrLabel, 0, SpringLayout.VERTICAL_CENTER, this);
		spr.putConstraint(SpringLayout.SOUTH, img, -5, SpringLayout.NORTH, usrLabel);
		spr.putConstraint(SpringLayout.NORTH, usrField, 5, SpringLayout.SOUTH, usrLabel);
		spr.putConstraint(SpringLayout.NORTH, pwdLabel, 5, SpringLayout.SOUTH, usrField);
		spr.putConstraint(SpringLayout.NORTH, pwdField, 5, SpringLayout.SOUTH, pwdLabel);
		spr.putConstraint(SpringLayout.NORTH, boton, 10, SpringLayout.SOUTH, pwdField);
		spr.putConstraint(SpringLayout.NORTH, failPasswordLabel, 10, SpringLayout.SOUTH, boton);
		
		boton.addActionListener(new BotonListener());
		
		failPasswordLabel.setForeground(Color.RED);
		failPasswordLabel.setVisible(false);
		
		this.add(img);
		this.add(usrLabel);
		this.add(usrField);
		this.add(pwdLabel);
		this.add(pwdField);
		this.add(boton);
		this.add(failPasswordLabel);
		
	}
	
}
