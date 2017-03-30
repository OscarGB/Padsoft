package Uno;

import java.awt.GridLayout;

import javax.swing.*;

public class PanelLogin extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelLogin (){
		JLabel etiqueta_user = new JLabel("Usuario");
		JLabel etiqueta_pwd = new JLabel("Contraseña");
		JTextField campo_user = new JTextField(10);
		JPasswordField campo_pwd = new JPasswordField(10);
		JButton boton = new JButton("Login");
		
		GridLayout lay = new GridLayout(3,2);
		this.setLayout(lay);
		
		this.add(etiqueta_user);
		this.add(campo_user);
		this.add(etiqueta_pwd);
		this.add(campo_pwd);
		this.add(boton);
	}
	
}
