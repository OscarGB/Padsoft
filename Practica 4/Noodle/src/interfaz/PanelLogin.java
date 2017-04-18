package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;



/**
 * Clase PanelLogin
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public final class PanelLogin extends JPanel {
	
	//Variables
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Etiqueta con "Usuario"
	 */
	JLabel usrLabel = new JLabel("Usuario");
	
	/**
	 * Campo para introducir el usr
	 */
	private JTextField usrField = new JTextField(20);
	
	/**
	 * Etiqueta con "Password"
	 */
	JLabel pwdLabel = new JLabel("Password");
	
	/**
	 * Campo para introducir la pwd
	 */
	private JPasswordField pwdField = new JPasswordField(20);
	
	/**
	 * Botón para realizar el Login
	 */
	JButton boton = new JButton("Login");
	
	/**
	 * Logo
	 */
	Imagen img = new Imagen();
	
	/**
	 * Etiqueta con "Usuario o contraseña incorrectos" para avisar que los datos son erróneos
	 */
	private JLabel failPasswordLabel = new JLabel("Usuario o contraseña incorrectos");
	
	//Constructor
	
	/**
	 * Constructor de PanelLogin
	 */
	public PanelLogin() {
		
		this.setPreferredSize(new Dimension(500, 300));
		this.setMinimumSize(new Dimension(500, 300));
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
	
		failPasswordLabel.setForeground(Color.RED);
		failPasswordLabel.setVisible(false);
		
		boton.setActionCommand("Login");
		
		this.add(img);
		this.add(usrLabel);
		this.add(usrField);
		this.add(pwdLabel);
		this.add(pwdField);
		this.add(boton);
		this.add(failPasswordLabel);
		
	}
	
	//Métodos
	
	/**
	 * Añade un ActionListener al PanelLogin
	 * @param listener
	 */
	public void addListener(ActionListener listener){
		boton.addActionListener(listener);
	}
	
	/**
	 * Devuelve la pwd introducida
	 * @return
	 */
	public String getPassword(){
		return new String(this.pwdField.getPassword());
	}

	/**
	 * Devuelve el uss introducido
	 * @return
	 */
	public String getUser() {
		return this.usrField.getText().trim();
	}
	
	/**
	 * Cambia la visibilidad de la FailPassword (para avisar al usuario)
	 * @param b
	 */
	public void setFailPasswordVisibility(boolean b){
		this.failPasswordLabel.setVisible(b);
	}
	
}
