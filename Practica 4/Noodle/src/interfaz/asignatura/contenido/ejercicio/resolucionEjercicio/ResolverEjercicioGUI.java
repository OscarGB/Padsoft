package interfaz.asignatura.contenido.ejercicio.resolucionEjercicio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JScrollPane;

import asignatura.Asignatura;
import contenido.Ejercicio;
import contenido.Tema;
import interfaz.asignatura.contenido.ejercicio.genericosPreguntas.PreguntasPanel;
import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;
import respuestas.RespuestaPregunta;

/**
 * Clase EjercicioGUI
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class ResolverEjercicioGUI extends NuestroPanel{
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Menu generico
	 */
	private Menu menu;
	
	/**
	 * Ejercicio
	 */
	private Ejercicio ejercicio;
	
	/**
	 * Subpanel con las preguntas
	 */
	private PreguntasPanel panel;
	
	/**
	 * Panel de scrolling
	 */
	private JScrollPane scroll;
	
	
	/**
	 * Asignatura
	 */
	private Asignatura asignatura;
	
	/**
	 * Menu derecho
	 */
	private ResolverEjercicioMenuDer der;
	
	/**
	 * Tema
	 */
	private Tema tema;
	
	/**
	 * Respuestas acumuladas
	 */
	private ArrayList<RespuestaPregunta> respuestas;
	
	/**
	 * Para poder acceder a el
	 */
	private static ResolverEjercicioGUI instance;

	/**
	 * Constructor del GUI del ejercicio
	 * @param anterior
	 * @param frame
	 * @param ejercicio
	 * @param tema
	 */
	public ResolverEjercicioGUI(NuestroPanel anterior, NoodleFrame frame, Ejercicio ejercicio, Tema tema) {
		super(anterior, frame);
		this.setSize(700,500);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());
		
		this.tema = tema;
		
		this.respuestas = new ArrayList<RespuestaPregunta>();
		
		this.asignatura = tema.getAsignatura();
	
		this.der = new ResolverEjercicioMenuDer(frame, ejercicio, tema);
		
		this.menu = new Menu(frame);
		this.ejercicio = ejercicio;
		this.panel = new PreguntasPanel(this.frame, this.ejercicio);
		this.scroll = new JScrollPane(this.panel);
		
		this.add(this.menu, BorderLayout.NORTH);
		this.add(this.scroll, BorderLayout.CENTER);
		this.add(this.der, BorderLayout.EAST);
		
		int w = this.getWidth();
		
		this.instance = this;
		
		this.menu.setPreferredSize(new Dimension(w, 80));
		
	}
	
	/**
	 * Hace que el frame muestre este panel
	 */
	public void muestraPanel(){
		this.frame.showResolverEjercicioGUI(false, this.ejercicio, this.tema);
	}
	
	/**
	 * Setter de ejercicio
	 * @param ej
	 */
	public void setEjercicio(Ejercicio ej){
		this.ejercicio = ej;
	}
	
	/**
	 * Setter de tema
	 * @param tema
	 */
	public void setTema(Tema tema){
		this.tema = tema;
		this.asignatura = tema.getAsignatura();
	}
	
	/**
	 * Método que actualiza el panel
	 * @param ejercicio
	 * @param tema
	 */
	public void refreshPanel(Ejercicio ejercicio, Tema tema){
		this.ejercicio = ejercicio;
		this.tema = tema;
		this.remove(this.panel);
		this.panel = new PreguntasPanel(this.frame, this.ejercicio);
		
		this.remove(this.scroll);
		this.scroll = new JScrollPane(this.panel);
		this.add(this.scroll, BorderLayout.CENTER);
		
		this.remove(this.der);
		this.der = new ResolverEjercicioMenuDer(frame, ejercicio, tema);
		this.add(this.der, BorderLayout.EAST);
	}
	
	/**
	 * Añade una pregunta al array
	 * @param res
	 */
	public void addRespuesta(RespuestaPregunta res){
		if(res == null){
			return;
		}
		for (RespuestaPregunta respuesta : this.respuestas){
			if(respuesta.getPregunta() == res.getPregunta()){
				this.respuestas.remove(respuesta);
			}
		}
		this.respuestas.add(res);
	}
	
	/**
	 * Devuelve las respuestas acumuladas
	 * @return
	 */
	public ArrayList<RespuestaPregunta> getRespuestas(){
		return this.respuestas;
	}
	
	/**
	 * Devuelve la instancia
	 * @return
	 */
	public static ResolverEjercicioGUI getInstance(){
		return ResolverEjercicioGUI.instance;
	}

}
