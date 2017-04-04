package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PanelLogin_GridBagLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelLogin_GridBagLayout() {
		JLabel etiqueta_user = new JLabel("Usuario");
		JLabel etiqueta_pwd = new JLabel("Password");
		JTextField campo_user = new JTextField(10);
		JPasswordField campo_pwd = new JPasswordField(10);
		JButton boton = new JButton("login");
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridy = 0;
		c.ipadx = 20;
		c.gridx = 0;
		layout.setConstraints();
		
		this.add(etiqueta_user);
		this.add(campo_user);
		this.add(etiqueta_pwd);
		this.add(campo_pwd);
		this.add(boton);
	}
	
}
