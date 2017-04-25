package interfaz;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import listeners.ListaAsignaturasAlumnoListener;
import listeners.ListaAsignaturasProfesorListener;

public class ListaAsignaturas extends NuestroPanel {

	private JPanel menu;
	
	public ListaAsignaturas(NuestroPanel anterior, NoodleFrame frame) {
		super(anterior, frame);
		this.setMinimumSize(new Dimension(500,700));
		this.setBackground(Color.WHITE);
		
		this.menu = new Menu();
		
		SpringLayout spr = new SpringLayout();
		this.setLayout(spr);
		
		spr.putConstraint(SpringLayout.NORTH, this.menu, 5, SpringLayout.NORTH, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.menu, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		this.add(this.menu);
	}

	public void addListener(ListaAsignaturasAlumnoListener listaAsignaturasAlumnoListener) {
		// TODO Auto-generated method stub
		
	}

	public void addListener(ListaAsignaturasProfesorListener listaAsignaturasProfesorListener) {
		// TODO Auto-generated method stub
		
	}

}
