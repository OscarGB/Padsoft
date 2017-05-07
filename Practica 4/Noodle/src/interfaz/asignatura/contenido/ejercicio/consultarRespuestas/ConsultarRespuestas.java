package interfaz.asignatura.contenido.ejercicio.consultarRespuestas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import contenido.Ejercicio;
import contenido.Tema;
import interfaz.asignatura.contenido.ejercicio.genericosPreguntas.PreguntasPanel;
import interfaz.asignatura.contenido.ejercicio.resolucionEjercicio.ResolverEjercicioMenuDer;
import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;
import persona.Alumno;
import respuestas.RespuestaEjercicio;

public class ConsultarRespuestas extends NuestroPanel{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Menu generico
	 */
	private Menu menu;
	
	/**
	 * Subpanel con las respuestas
	 */
	private RespuestasPanel respuestas;
	
	/**
	 * Panel de scrolling
	 */
	private JScrollPane scroll;
	
	/**
	 * Ejercicio
	 */
	private Ejercicio ejercicio;
	
	/**
	 * Respuesta al ejercicio
	 */
	private RespuestaEjercicio respuesta;
	
	/**
	 * Alumno
	 */
	private Alumno alumno;
	
	private JLabel nota = new JLabel();
	
	public ConsultarRespuestas(NuestroPanel anterior, NoodleFrame frame, RespuestaEjercicio respuesta, Alumno alumno) {
		super(anterior, frame);
		this.setSize(700,500);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());
		
		this.respuesta = respuesta;
		this.ejercicio = this.respuesta.getEjercicio();
		this.alumno = alumno;
		this.nota.setText("Nota del ejercicio: " + this.ejercicio.getNotaMedia());
		this.nota.setPreferredSize(new Dimension(200, 30));
		
		this.menu = new Menu(frame);
		this.respuestas = new RespuestasPanel(this.frame, this.respuesta, this.ejercicio, this.alumno);
		this.scroll = new JScrollPane(this.respuestas);
		
		this.add(this.menu, BorderLayout.NORTH);
		this.add(this.scroll, BorderLayout.CENTER);
		this.add(this.nota, BorderLayout.EAST);
		
		int w = this.getWidth();
		
		this.menu.setPreferredSize(new Dimension(w, 80));
		
	}
	
	/**
	 * Hace que el frame muestre este panel
	 */
	public void muestraPanel(){
		this.frame.showConsultarRespuestas(true, this.respuesta, this.alumno);
	}
	
	/**
	 * Método que actualiza el panel
	 * @param ejercicio
	 */
	public void refreshPanel(Ejercicio ejercicio){
		this.ejercicio = ejercicio;
		this.remove(this.respuestas);
		this.respuestas = new RespuestasPanel(this.frame, this.respuesta, this.ejercicio, this.alumno);
		
		this.remove(this.scroll);
		this.scroll = new JScrollPane(this.respuestas);
		this.add(this.scroll, BorderLayout.CENTER);
	}

}
