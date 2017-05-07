package interfaz.asignatura.asignaturaGUI.estadisticas;

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
import contenido.Pregunta;
import estadisticas.EstadisticasAlumno;
import interfaz.genericos.NoodleFrame;
import persona.Alumno;
import respuestas.RespuestaEjercicio;
import respuestas.RespuestaPregunta;

/**
 * Clase EstadisticaList
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
class EstadisticaList extends MouseAdapter{
	
	// Variables
	
	/**
	 * Panel al que pertenece
	 */
	private EstadisticasPanel panel;
	
	/**
	 * Pregunta a la que hace referencia
	 */
	private RespuestaEjercicio respuesta;
	
	/**
	 * Alumno
	 */
	private Alumno alumno;
	
	// Creador
	
	/**
	 * Constructor de RatonList
	 * @param panel
	 * @param pregunta
	 */
	EstadisticaList(EstadisticasPanel panel, RespuestaEjercicio respuesta, Alumno alumno){
		this.panel = panel;
		this.respuesta = respuesta;
		this.alumno = alumno;
	}
	
	// Métodos
	
	 /**
	  * Método por si se pulsa
	  * @param e
	  */
	public void mouseClicked(MouseEvent e) {
		 this.panel.listenerEstadisticas(this.respuesta, this.alumno);
	 } 
}

/**
 * Clase EstadisticasPanel
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class EstadisticasPanel extends JPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Frame global
	 */
	NoodleFrame frame;
	
	/**
	 * Array de labels
	 */
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();;
	
	/**
	 * Array con todas las respuestas
	 */
	private ArrayList<RespuestaEjercicio> respuestas;
	
	/**
	 * Label con el resumen
	 */
	private JLabel top;
	
	/**
	 * Alumno
	 */
	private Alumno alumno;
	
	/**
	 * Cosntructor
	 * @param frame
	 * @param al
	 * @param asig
	 */
	public EstadisticasPanel(NoodleFrame frame, Alumno al, Asignatura asig) {
		this.frame = frame;
		this.setBackground(Color.WHITE);
		
		EstadisticasAlumno aux = null;
		
		Font f = new Font("Arial", Font.BOLD, 15);
		
		for(EstadisticasAlumno est : al.getEstadisticas()){
			if(est.getAsignatura().equals(asig)){
				aux = est;
				break;
			}
		}
		
		System.out.println(al.getEstadisticas());
		
		if(aux == null){
			this.top = new JLabel("Estadisticas del alumno: " + al.getNombre() + " en " + asig.getNombre() + ". No evaluado");

		}else{
			this.top = new JLabel("Estadisticas del alumno: " + al.getNombre() + " en " + asig.getNombre() + ". Nota media: " + al.getMediaAsignatura(asig));
		}
				
		this.add(top);
		
		this.top.setFont(f);
		SpringLayout spr = new SpringLayout();
		setLayout(spr);
		
		spr.putConstraint(SpringLayout.NORTH, this.top, 0, SpringLayout.NORTH, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.top, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		
		int size = 0;
		
		if(aux != null){
			this.respuestas = aux.getRespuestas();
			size = this.respuestas.size();
			if(size == 0){
				JLabel label = new JLabel("No hay estadisticas");
				label.setFont(f);
				this.labels.add(label);
				spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
				spr.putConstraint(SpringLayout.NORTH, label, 50, SpringLayout.SOUTH, this.top);
			}
			else{
				JLabel label = new JLabel("Selecciona una estadistica.");
				label.setFont(f);
				labels.add(label);
				spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
				spr.putConstraint(SpringLayout.NORTH, label, 50, SpringLayout.NORTH, this.top);
				
				for(int i = 1, j = 0; j < size; i++, j++){
					label = new JLabel(respuestas.get(j).toString());
					JLabel previous = labels.get(i-1);
					labels.add(label);
					spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
					spr.putConstraint(SpringLayout.NORTH, label, 50, SpringLayout.NORTH, previous);
					//Añadimos un MouseListener para poder clicar en los labels de las
					//estadisticas
					labels.get(i).addMouseListener(new EstadisticaList(this, respuestas.get(j), this.alumno));
					label.setFont(new Font("Arial", Font.BOLD, 20));
				}
			}

		}
		else{
			JLabel label = new JLabel("No hay estadisticas");
			label.setFont(f);
			this.labels.add(label);
			spr.putConstraint(SpringLayout.HORIZONTAL_CENTER,  label, 0, SpringLayout.HORIZONTAL_CENTER, this);
			spr.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.SOUTH, this.top);
		}
		
		for(JLabel lab:labels){
			this.add(lab);
		}
		
		this.setPreferredSize(new Dimension(500, (labels.get(0).getHeight() + 50)*(size + 1)));
		
	}

	/**
	 * Método por si se pulsa en unas estadisticas
	 * @param respuesta
	 */
	public void listenerEstadisticas(RespuestaEjercicio respuesta, Alumno alumno) {
		this.frame.showConsultarRespuestas(true, respuesta, alumno);
		
	}

}
