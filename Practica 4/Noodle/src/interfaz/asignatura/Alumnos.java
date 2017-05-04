package interfaz.asignatura;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import asignatura.Asignatura;
import interfaz.genericos.NoodleFrame;
import persona.Alumno;
import plataforma.Plataforma;

/**
 * Clase RatonList
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
class AlumnoList extends MouseAdapter{
	
	// Variables
	
	/**
	 * Panel al que pertenece
	 */
	Alumnos panel;
	
	/**
	 * Alumno al que hace referencia
	 */
	Alumno alumno;
	
	// Creador
	
	/**
	 * Constructor de RatonList
	 * @param a
	 * @param panel
	 * @param asig
	 */
	AlumnoList(Alumnos panel, Alumno alumno){
		this.panel = panel;
		this.alumno = alumno;
	}
	
	// Métodos
	
	 /**
	  * Método por si se pulsa
	  * @param e
	  */
	public void mouseClicked(MouseEvent e) {
		 this.panel.listenerListaAlumnos(this.alumno);
	 } 
}

public class Alumnos extends JPanel{
	/**
	 * ID del panel del panel
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Frame
	 */
	private NoodleFrame frame;
	
	/**
	 * Array de alumnos
	 */
	private ArrayList<Alumno> alumnos;
	
	/**
	 * Asignatura
	 */
	private Asignatura asignatura;
	
	/**
	 * Array de labels
	 */
	private ArrayList<JLabel> labels;

	/**
	 * Constructor de Alumnos (subpanel)
	 * @param frame
	 */
	
	public Alumnos(NoodleFrame frame, Asignatura asignatura){
		this.frame = frame;
		this.setBackground(Color.WHITE);
		this.asignatura = asignatura;
		this.alumnos = asignatura.getAlumnos();
		this.labels = new ArrayList<JLabel>();
		
		Collections.sort(this.alumnos, new Comparator<Alumno>(){
			
			@Override
			public int compare(Alumno a1, Alumno a2){
				return a1.getNombre().compareTo(a2.getNombre());
			}
			
		});
		
		SpringLayout spr = new SpringLayout();
		setLayout(spr);
		
		int size = this.alumnos.size();
		if(size == 0){
			JLabel label = new JLabel("No hay alumnos en la asignatura");
			this.labels.add(label);
			spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
			spr.putConstraint(SpringLayout.VERTICAL_CENTER, label, 0, SpringLayout.VERTICAL_CENTER, this);
		}
		if(size > 0){
			JLabel label = new JLabel("Selecciona un alumno para acceder a estadísticas y gestión.");
			labels.add(label);
			label.setFont(new Font("Arial", Font.ITALIC, 15));
			spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
			spr.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);

			//Añadimos un MouseListener para poder clicar en los labels de las
			//asignaturas
			labels.get(0).addMouseListener(new AlumnoList(this, alumnos.get(0)));
			for(int i = 1, j = 0; j < size; i++, j++){
				float aux = alumnos.get(j).getMediaAsignatura(this.asignatura);
				label = new JLabel(alumnos.get(j).getNombre() + "      Media: " + ((aux >= 0)?aux:"No evaluado"));
				JLabel previous = labels.get(i-1);
				labels.add(label);
				spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
				spr.putConstraint(SpringLayout.NORTH, label, 50, SpringLayout.NORTH, previous);
				//Añadimos un MouseListener para poder clicar en los labels de las
				//asignaturas
				labels.get(i).addMouseListener(new AlumnoList(this, alumnos.get(j)));
				label.setFont(new Font("Arial", Font.BOLD, 20));
			}
		}
		
		for(JLabel lab:labels){
			this.add(lab);
		}
		
		this.setPreferredSize(new Dimension(300, (labels.get(0).getHeight() + 50)*(size + 1)));
		
		
	}
	
	/**
	 * Listener para cuando se clique en un alumno
	 * @param asig
	 */
	public void listenerListaAlumnos(Alumno alumno){
		this.frame.showEstadisticas(true, alumno, this.asignatura);
	}
	
}
