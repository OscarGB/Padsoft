package interfaz.asignatura.contenido.ejercicio;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.SpringLayout;

import contenido.Ejercicio;
import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;

/**
 * Clase ElegirTipoPregunta
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class ElegirTipoPregunta extends NuestroPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Menú genérico
	 */
	private Menu menu;
	
	/**
	 * Ejercicio al que se va a añadir
	 */
	Ejercicio ej;
	
	/**
	 * Botones
	 */
	JButton botones[] = {new JButton("Pregunta Simple"), new JButton("Pregunta Unica"), new JButton("Pregunta Multiple"), new JButton("Pregunta Abierta"), new JButton("Cancelar")};
	
	/**
	 * Creador
	 * @param anterior
	 * @param frame
	 * @param ej
	 */
	public ElegirTipoPregunta(NuestroPanel anterior, NoodleFrame frame, Ejercicio ej) {
		super(anterior, frame);
		this.ej = ej;
		
		this.setBackground(Color.WHITE);
		
		SpringLayout spr = new SpringLayout();
		this.setLayout(spr);
		
		Dimension d = new Dimension(150, 30);
		
		ElegirTipoPreguntaListener list = new ElegirTipoPreguntaListener(frame, ej);
		
		for(JButton boton : botones){
			boton.setPreferredSize(d);
			spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, boton, 0, SpringLayout.HORIZONTAL_CENTER, this);
			this.add(boton);
			boton.addActionListener(list);
			boton.setActionCommand(boton.getText());
		}
		
		spr.putConstraint(SpringLayout.VERTICAL_CENTER, this.botones[2], 0, SpringLayout.VERTICAL_CENTER, this);
		spr.putConstraint(SpringLayout.SOUTH, this.botones[1], -20, SpringLayout.NORTH, this.botones[2]);
		spr.putConstraint(SpringLayout.SOUTH, this.botones[0], -20, SpringLayout.NORTH, this.botones[1]);
		spr.putConstraint(SpringLayout.NORTH, this.botones[3], 20, SpringLayout.SOUTH, this.botones[2]);
		spr.putConstraint(SpringLayout.NORTH, this.botones[4], 20, SpringLayout.SOUTH, this.botones[3]);
	}
	
	/**
	 * Método para mostrar el panel
	 */
	public void muestraPanel(){
		this.frame.showElegirTipoPregunta(false, this.ej);
	}

}
