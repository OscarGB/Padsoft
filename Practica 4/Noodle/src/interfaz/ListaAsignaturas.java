package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

import listeners.ListaAsignaturasAlumnoListener;
import listeners.ListaAsignaturasProfesorListener;

/**
 * Clase ListaAsignaturas
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 20/04/2017
 */
public class ListaAsignaturas extends NuestroPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Menu generico que se muestra en la parte superior
	 */
	private Menu menu;

	//TODO esto es temporal
	private JLabel texto;
	
	/**
	 * Constructor de la lista de asignaturas
	 * @param panel anterior
	 * @param frame
	 */
	public ListaAsignaturas(NuestroPanel anterior, NoodleFrame frame){
		super(anterior, frame);
		this.setSize(700,500);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());

		this.menu = new Menu(frame);
		//TODO cambiar
		this.texto = new JLabel("Aquí va una lista de todas las asignaturas");
		this.texto.setFont(new Font("Arial", Font.BOLD, 20));
		this.texto.setHorizontalAlignment(JLabel.CENTER);
		this.texto.setVerticalAlignment(JLabel.CENTER);
		
		menu.setPreferredSize(new Dimension(10,10));
		
		this.add(this.menu, BorderLayout.NORTH);
		//TODO cambiar
		this.add(this.texto, BorderLayout.CENTER);
		
		int h = this.getHeight();
		int w = this.getWidth();
		
		this.menu.setPreferredSize(new Dimension(w, 80));
		//TODO cambiar
		this.texto.setPreferredSize(new Dimension(w, h));

	}
	
	
	/**
	 * Hace que el frame muestre este panel
	 */
	public void muestraPanel(){
		this.frame.showListaAsignaturas(false);
	}

	/**
	 * Añade el listener del alumno
	 * @param listaAsignaturasAlumnoListener
	 */
	public void addListener(ListaAsignaturasAlumnoListener listaAsignaturasAlumnoListener) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Añade el listener del profesor
	 * @param listaAsignaturasProfesorListener
	 */
	public void addListener(ListaAsignaturasProfesorListener listaAsignaturasProfesorListener) {
		// TODO Auto-generated method stub
		
	}

}
