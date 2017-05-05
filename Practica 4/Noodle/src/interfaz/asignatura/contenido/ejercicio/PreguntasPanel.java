package interfaz.asignatura.contenido.ejercicio;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import contenido.Ejercicio;
import contenido.Pregunta;
import interfaz.genericos.NoodleFrame;
import persona.Alumno;

/**
 * Clase PreguntaList
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
class PreguntaList extends MouseAdapter{
	
	// Variables
	
	/**
	 * Panel al que pertenece
	 */
	PreguntasPanel panel;
	
	/**
	 * Pregunta a la que hace referencia
	 */
	Pregunta pregunta;
	
	// Creador
	
	/**
	 * Constructor de RatonList
	 * @param panel
	 * @param pregunta
	 */
	PreguntaList(PreguntasPanel panel, Pregunta pregunta){
		this.panel = panel;
		this.pregunta = pregunta;
	}
	
	// Métodos
	
	 /**
	  * Método por si se pulsa
	  * @param e
	  */
	public void mouseClicked(MouseEvent e) {
		 this.panel.listenerPreguntas(this.pregunta);
	 } 
}

public class PreguntasPanel extends JPanel{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Frame
	 */
	private NoodleFrame frame;
	
	/**
	 * Array de preguntas
	 */
	private ArrayList<Pregunta> preguntas;
	
	/**
	 * Array de labels
	 */
	private ArrayList<JLabel> labels;
	
	/**
	 * Ejercicio
	 */
	private Ejercicio ejercicio;
	
	/**
	 * Constructor de preugntas panel
	 * @param frame
	 * @param ejercicio
	 */
	public PreguntasPanel(NoodleFrame frame, Ejercicio ejercicio){
		this.frame = frame;
		this.setBackground(Color.WHITE);
		this.ejercicio = ejercicio;
		this.labels = new ArrayList<JLabel>();
		
		if(ejercicio != null){
			this.preguntas = ejercicio.getPreguntas();
		}
		else{
			this.preguntas = new ArrayList<Pregunta>();
		}
		
		SpringLayout spr = new SpringLayout();
		setLayout(spr);
		
		int size = this.preguntas.size();
				
		if(size == 0){
			JLabel label = new JLabel("No hay preguntas en el ejercicio");
			this.labels.add(label);
			spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
			spr.putConstraint(SpringLayout.VERTICAL_CENTER, label, 0, SpringLayout.VERTICAL_CENTER, this);
		}
		else if(size > 0){
			JLabel label = new JLabel("Selecciona una pregunta.");
			labels.add(label);
			label.setFont(new Font("Arial", Font.ITALIC, 15));
			spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
			spr.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);
		
			for(int i = 1, j = 0; j < size; i++, j++){
				label = new JLabel(preguntas.get(j).getEnunciado());
				JLabel previous = labels.get(i-1);
				labels.add(label);
				spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
				spr.putConstraint(SpringLayout.NORTH, label, 50, SpringLayout.NORTH, previous);
				//Añadimos un MouseListener para poder clicar en los labels de las
				//asignaturas
				labels.get(i).addMouseListener(new PreguntaList(this, preguntas.get(j)));
				label.setFont(new Font("Arial", Font.BOLD, 20));
			}
		}
		
		for(JLabel lab:labels){
			this.add(lab);
		}
		
		this.setPreferredSize(new Dimension(300, (labels.get(0).getHeight() + 50)*(size + 1)));
		
	}
	
	/**
	 * Listener para cuando se clique en una pregunta
	 * @param pregunta
	 */
	public void listenerPreguntas(Pregunta pregunta){
		System.out.println("Se ha seleccionado la pregunta: "+pregunta);
	}

}
