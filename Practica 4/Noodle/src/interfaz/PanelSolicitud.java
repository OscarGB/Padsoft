package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import asignatura.Asignatura;
import plataforma.*;

/**
 * Clase ActionListener
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
class SolicitudListener implements ActionListener{

	/**
	 * Asignatura al que hace referencia
	 */
	Asignatura asig;
	
	/**
	 * Panel que escucha
	 */
	PanelSolicitud panel;
	
	/**
	 * Constructor de SolicitudListener
	 * @param asig
	 */
	public SolicitudListener(Asignatura asig, PanelSolicitud panel){
		this.asig = asig;
		this.panel = panel;
	}
	
	/**
	 * Método para cuando se pulse sobre el botón
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("boton")){
			Plataforma.loggedAs().solicitarAcceso(this.asig);
			panel.setVisibilidad(true);
			Plataforma.plat().saveData();
		}
	}
	
}

/**
 * Clase PanelSolicitud
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class PanelSolicitud extends JPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Asignatura a la que hace referencia
	 */
	Asignatura asig;
	
	/**
	 * Label con el texto
	 */
	JLabel label;
	
	/**
	 * Botón de confirmar
	 */
	JButton boton;
	
	/**
	 * Label con el texto DE éxito
	 */
	JLabel exito;
	
	/**
	 * Constructor de PanelSolicitud
	 * @param frame
	 * @param asig
	 */
	public PanelSolicitud(Asignatura asig){
		this.asig = asig;
		
		this.setBackground(Color.WHITE);
		
		this.label = new JLabel("No estás matriculado en la asignatura " + asig.getNombre());
		this.boton = new JButton("Solicitar acceso");
		this.exito = new JLabel("Solicitud tramitada con éxito");
		
		SpringLayout spr = new SpringLayout();
		this.setLayout(spr);
		
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, boton, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, exito, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		spr.putConstraint(SpringLayout.VERTICAL_CENTER, boton, 0, SpringLayout.VERTICAL_CENTER, this);
		spr.putConstraint(SpringLayout.SOUTH, label, -5, SpringLayout.NORTH, boton);
		spr.putConstraint(SpringLayout.NORTH, exito, 5, SpringLayout.SOUTH, boton);
		
		this.label.setFont(new Font("Arial", Font.BOLD, 20));
		this.exito.setFont(new Font("Arial", Font.BOLD, 20));
		
		this.setVisibilidad(false);
				
		boton.setActionCommand("boton");
		
		boton.addActionListener(new SolicitudListener(this.asig, this));
		
		this.add(label);
		this.add(boton);
		this.add(exito);
	}	
	

	/**
	 * Cambia la visibilidad de la etiqueta exito
	 * @param flag
	 */
	public void  setVisibilidad(boolean flag){
		this.exito.setVisible(flag);
	}
}
