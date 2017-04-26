package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import asignatura.Asignatura;
import plataforma.Plataforma;

/**
 * Clase RatonList
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
class RatonList extends MouseAdapter{
	
	// Variables
	
	/**
	 * Panel al que pertenece
	 */
	TodasAsignaturas panel;
	
	/**
	 * Asignatura a la que hace referencia
	 */
	Asignatura asig;
	
	// Creador
	
	/**
	 * Constructor de RatonList
	 * @param a
	 * @param panel
	 * @param asig
	 */
	RatonList(TodasAsignaturas panel, Asignatura asig){
		this.panel = panel;
		this.asig = asig;
	}
	
	// M�todos
	
	 /**
	  * M�todo por si se pulsa
	  * @param e
	  */
	public void mouseClicked(MouseEvent e) {
		 panel.listenerListaAsignaturas(asig);
	 } 
}

/**
 * Clase TodasAsignaturas
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class TodasAsignaturas extends JPanel {
	/**
	 * ID del panel del panel
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
	public TodasAsignaturas(NoodleFrame frame) {
		this.frame = frame;
		this.setBackground(Color.WHITE);
		ArrayList<Asignatura> cursos = this.getAsignaturas();
		ArrayList<JLabel> asignaturas = new ArrayList<JLabel>();
		
		SpringLayout spr = new SpringLayout();
		setLayout(spr);
		
		int size = cursos.size();
		
		if(size == 0){
			JLabel label = new JLabel("No hay asignaturas en la plataforma");
			asignaturas.add(label);
			spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
			spr.putConstraint(SpringLayout.VERTICAL_CENTER, label, 0, SpringLayout.VERTICAL_CENTER, this);
		}
		if(size > 0){
			JLabel label = new JLabel(cursos.get(0).getNombre());
			asignaturas.add(label);
			spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
			spr.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);

			//A�adimos un MouseListener para poder clicar en los labels de las
			//asignaturas
			asignaturas.get(0).addMouseListener(new RatonList(this, cursos.get(0)));
			for(int i = 1; i < size; i++){
				label = new JLabel(cursos.get(i).getNombre());
				JLabel previous = asignaturas.get(i-1);
				asignaturas.add(label);
				spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
				spr.putConstraint(SpringLayout.NORTH, label, 50, SpringLayout.NORTH, previous);
				//A�adimos un MouseListener para poder clicar en los labels de las
				//asignaturas
				asignaturas.get(i).addMouseListener(new RatonList(this, cursos.get(i))); 
			}
		}
			
		for(JLabel asig:asignaturas){
			asig.setFont(new Font("Arial", Font.BOLD, 20));
			this.add(asig);
		}
		
		this.setPreferredSize(new Dimension(this.getWidth(), (asignaturas.get(0).getHeight() + 50)*size));
		
	}
	
	/**
	 * Metodo para obtener las asignaturas de la plataforma
	 * @return ArrayList
	 */
	private ArrayList<Asignatura> getAsignaturas(){
		return Plataforma.getAsignaturas();
	}
	
	/**
	 * Listener para cuando se clique en una asignatura
	 * @param asig
	 */
	public void listenerListaAsignaturas(Asignatura asig){
		System.out.println("Has pulsado en " + asig.getNombre());
	}

}
