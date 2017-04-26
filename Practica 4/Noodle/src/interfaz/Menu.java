package interfaz;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.*;

import listeners.MenuListener;
import persona.Alumno;
import persona.Profesor;
import plataforma.Plataforma;

/**
 * Clase para implementar el panel de menu generico
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 18/04/2017
 */
public class Menu extends JPanel {

	/**
	 * ID del panel de menu
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Frame en el que se va a encontrar
	 */
	private NoodleFrame frame;
	
	/**
	 * Elementos del panel
	 */
	JMenuBar menubar = new JMenuBar();
	JMenu inicio = new JMenu("Inicio");
	JMenu cursos = new JMenu("Asignaturas");
	JMenu solicitudes = new JMenu("Solicitudes");
	JButton logo = new JButton();
	JButton exit = new JButton();
	
	/**
	 * Constructor del menu
	 * @param frame
	 */
	public Menu(NoodleFrame frame){
		this.frame = frame;
		this.setBackground(Color.WHITE);
		
		SpringLayout spr = new SpringLayout();
		setLayout(spr);
		
		inicio.setFont(new Font("Arial", Font.BOLD, 20));
		inicio.setMargin(new Insets(20, 20, 3, 3));
		cursos.setFont(new Font("Arial", Font.BOLD, 20));
		solicitudes.setFont(new Font("Arial", Font.BOLD, 20));
		//Botón de atrás
		try {
			Image img = ImageIO.read(getClass().getResource("/imagenes/atras.png"));
			
			logo.setIcon(new ImageIcon(img.getScaledInstance(25, 25, 20)));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		//Botón de Logout
		try {
			Image img2 = ImageIO.read(getClass().getResource("/imagenes/logout.png"));
			exit.setIcon(new ImageIcon(img2.getScaledInstance(25, 25, 20)));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		exit.setBackground(Color.RED);
		
		spr.putConstraint(SpringLayout.NORTH, logo, 5, SpringLayout.NORTH, this);
		spr.putConstraint(SpringLayout.WEST, logo, 5, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.NORTH, menubar, 5, SpringLayout.NORTH, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, menubar, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.EAST, menubar, -5, SpringLayout.WEST, exit);
		spr.putConstraint(SpringLayout.WEST, menubar, 5, SpringLayout.EAST, logo);
		spr.putConstraint(SpringLayout.NORTH, exit, 5, SpringLayout.NORTH, this);
		spr.putConstraint(SpringLayout.EAST, exit, -5, SpringLayout.EAST, this);
		
		this.menubar.add(Box.createGlue());
		//Los createGlue rellenan el espacio para poder centrar contenidos
		this.add(logo);
		this.add(exit);
		this.menubar.add(inicio);
		this.menubar.add(Box.createGlue());
		this.menubar.add(cursos);
		this.menubar.add(Box.createGlue());
		this.menubar.add(solicitudes);
		
		//Añade el listener
		this.addListener(new MenuListener(this, this.frame));
		
		this.inicio.setActionCommand("Inicio");
		this.cursos.setActionCommand("Asignaturas");
		this.solicitudes.setActionCommand("Solicitudes");
		this.logo.setActionCommand("Atras");
		this.exit.setActionCommand("Logout");
		
		this.menubar.add(Box.createGlue());
		
		this.add(menubar);
		
	}
	
	/**
	 * Método que añade el listener al menú
	 * Ademas crea los listeners propios a cada botón del menubar
	 * @param list
	 */
	private void addListener(MenuListener list){
		
		this.inicio.addMouseListener(
			new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					System.out.println("Ha pulsado inicio");
					if(Plataforma.loggedAs() instanceof Alumno){
						frame.showInicioAlumno(true);
					}
					else if(Plataforma.loggedAs() instanceof Profesor){
						frame.showInicioProfesor(true);
					}
					return;
				}
			}
		);
		this.cursos.addMouseListener(
			new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					System.out.println("Ha pulsado asignaturas");
					if(Plataforma.loggedAs() instanceof Alumno){
						frame.showListaAsignaturas(true);
					}
					else if(Plataforma.loggedAs() instanceof Profesor){
						frame.showListaAsignaturas(true);
					}
					return;
				}
			}
		);
		this.solicitudes.addMouseListener(
			new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					System.out.println("Ha pulsado solicitudes");
					if(Plataforma.loggedAs() instanceof Alumno){
						frame.showSolicitudesAlumno(true);
					}
					else if(Plataforma.loggedAs() instanceof Profesor){
						frame.showSolicitudesProfesor(true);
					}
					return;
				}
			}
		);
		this.logo.addActionListener(list);
		this.exit.addActionListener(list);
	}
	
}
