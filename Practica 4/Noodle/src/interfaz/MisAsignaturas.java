package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;

import asignatura.Asignatura;
import plataforma.Plataforma;

/**
 * Clase para implementar el panel de menu generico
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 */
public class MisAsignaturas extends JPanel{

	/**
	 * ID del panel de menu
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Frame
	 */
	private NoodleFrame frame;

	/**
	 * Constructor de MisAsignaturas (subpanel)
	 * @param frame
	 */
	public MisAsignaturas(NoodleFrame frame) {
		this.frame = frame;
		this.setBackground(Color.WHITE);
		DefaultListModel<String> asignaturas = new DefaultListModel<String>();
		ArrayList<Asignatura> cursos = this.getAsignaturas();
		
		SpringLayout spr = new SpringLayout();
		setLayout(spr);
		
		for(Asignatura asig:cursos){
			asignaturas.addElement(asig.getNombre());
		}
			
		
		JList listaAsignaturas = new JList(asignaturas);
		
		listaAsignaturas.setFont(new Font("Arial", Font.BOLD, 20));
		//TODO probar si funcionan los listeners, si no, usar labels
		//TODO centrar letras, dar formato al list
		
		listaAsignaturas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		JScrollPane scroll = new JScrollPane(listaAsignaturas);
		scroll.setPreferredSize(new Dimension(300, 300));
		scroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, scroll, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.VERTICAL_CENTER, scroll, 0, SpringLayout.VERTICAL_CENTER, this);
//		spr.putConstraint(SpringLayout.WEST, listaAsignaturas, 0, SpringLayout.WEST, this);
//		spr.putConstraint(SpringLayout.EAST, listaAsignaturas, 0, SpringLayout.EAST, this);


		
		this.add(scroll);
		
	}
	
	/**
	 * Metodo para obtener las asignaturas del alumno
	 * @return ArrayList
	 */
	private ArrayList<Asignatura> getAsignaturas(){
		//ArrayList<Asignatura> array = Plataforma.loggedAs().getAsignaturas();
		ArrayList<Asignatura> array = new ArrayList<Asignatura>();
		array.add(new Asignatura("Mates"));
		array.add(new Asignatura("Lengua"));
		array.add(new Asignatura("Cono"));
		
		return array;
	}
	
}

