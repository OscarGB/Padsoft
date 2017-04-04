package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PanelLogin extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelLogin() {
		JLabel etiqueta_user = new JLabel("Usuario");
		JLabel etiqueta_pwd = new JLabel("Password");
		JTextField campo_user = new JTextField(10);
		JPasswordField campo_pwd = new JPasswordField(10);
		JButton boton = new JButton("login");
		
		GridLayout layout = new GridLayout(3,2);
		setLayout(layout);
		
		this.add(etiqueta_user);
		this.add(campo_user);
		this.add(etiqueta_pwd);
		this.add(campo_pwd);
		this.add(boton);
	}
		
}
