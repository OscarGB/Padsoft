package interfaz.asignatura.contenido.ejercicio.consultarRespuestas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import contenido.Opciones;
import contenido.PreguntaRespuestaUnica;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;
import persona.Alumno;
import respuestas.RespuestaEjercicio;
import respuestas.RespuestaUnica;

/**
 * Clase ConsultaPreguntaUnicaPanel
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class ConsultaPreguntaUnicaPanel extends ConsultaPregunta {
	
	//Variables
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Array de opciones
	 */
	private ArrayList<Opciones> opciones;
	
	/**
	 * Array de radiobuttons
	 */
	private ArrayList<JRadioButton> radios;
	
	/**
	 * Grupo de Radiobuttons
	 */
	private ButtonGroup grupo;
	
	/**
	 * Area para el enunciado
	 */
	private JTextArea area;
	
	/**
	 * Layout
	 */
	private SpringLayout spr;
	
	/**
	 * Respuesta
	 */
	private RespuestaUnica respuesta;
	
	/**
	 * Pregunta
	 */
	private PreguntaRespuestaUnica pregunta;
	
	/**
	 * Alumno
	 */
	private Alumno al;
	
	/**
	 * Respuesta al ejericico
	 */
	private RespuestaEjercicio resEjer;
	
	//Constructor
	
	/**
	 * Constructor
	 * @param respuesta
	 * @param anterior
	 * @param al
	 * @param resEjer
	 */
	public ConsultaPreguntaUnicaPanel(RespuestaUnica respuesta, NuestroPanel anterior, Alumno al, RespuestaEjercicio resEjer){
		super(anterior, NoodleFrame.getInstance());
		this.respuesta = respuesta;
		this.al = al;
		this.resEjer = resEjer;
		this.pregunta = (PreguntaRespuestaUnica) this.respuesta.getPregunta();
		
		this.setBackground(Color.WHITE);
		
		this.area = new JTextArea(5,20);
		this.area.setSize(300, 50);
		
		grupo = new ButtonGroup();
		spr = new SpringLayout();
		setLayout(spr);
	
		this.area.setText(pregunta.getEnunciado());
		this.radios = new ArrayList<JRadioButton>();
		this.opciones = (ArrayList<Opciones>) this.pregunta.getOpciones().clone();
		
		for(Opciones op : this.opciones){
			JRadioButton aux = new JRadioButton(op.getRespuesta());
			if(op.esCorrecta() == true){
				aux.setBackground(Color.GREEN);
			}
			if(op.equals(this.respuesta.getEscogida()) == true){
				aux.setSelected(true);
				if(op.esCorrecta() == false){
					aux.setBackground(Color.RED);
				}
			}
			aux.setEnabled(false);
			radios.add(aux);
			grupo.add(aux);
			this.add(aux);
			
			spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, aux, 0, SpringLayout.HORIZONTAL_CENTER, this);
			
			if(radios.size() == 1){
				spr.putConstraint(SpringLayout.NORTH, aux, 60, SpringLayout.NORTH, this);
			}else{
				spr.putConstraint(SpringLayout.NORTH, aux, 20, SpringLayout.SOUTH, radios.get(radios.indexOf(aux) - 1));
			}
		}
		
		this.area.setEditable(false);
		
		this.add(this.area);
		
		this.area.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		
		spr.putConstraint(SpringLayout.NORTH, area, 5, SpringLayout.NORTH, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, area, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		this.setPreferredSize(new Dimension(this.getWidth(), (this.radios.get(0).getHeight() + 50) * (radios.size() + 1)));
		
	}

	//Métodos
	
	/**
	 * Método para mostrar el panel
	 */
	@Override
	public void muestraPanel(){
		this.frame.showConsultarRespuestas(false, resEjer,  al);
	}
}
