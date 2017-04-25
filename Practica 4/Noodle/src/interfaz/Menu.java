package interfaz;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import listeners.MenuListener;

/**
 * Clase para implementar el panel de menu generico
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 */
public class Menu extends JPanel {

	/**
	 * ID del panel de menu
	 */
	private static final long serialVersionUID = 1L;
	
	private NoodleFrame frame;
	
	JMenuBar menubar = new JMenuBar();
	JMenu inicio = new JMenu("Inicio");
	JMenu cursos = new JMenu("Asignaturas");
	JMenu solicitudes = new JMenu("Solicitudes");
	JButton logo = new JButton();
	JButton exit = new JButton();
	
	public Menu(NoodleFrame frame){
		this.frame = frame;
		this.setBackground(Color.WHITE);
		
		SpringLayout spr = new SpringLayout();
		setLayout(spr);
		
		inicio.setFont(new Font("Arial", Font.BOLD, 20));
		inicio.setMargin(new Insets(20, 20, 3, 3));
		cursos.setFont(new Font("Arial", Font.BOLD, 20));
		solicitudes.setFont(new Font("Arial", Font.BOLD, 20));
		try {
			Image img = ImageIO.read(getClass().getResource("/imagenes/atras.png"));
			
			logo.setIcon(new ImageIcon(img.getScaledInstance(25, 25, 20)));
		} catch (Exception ex) {
			System.out.println(ex);
		}
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
		
		MenuListener list = new MenuListener(this, this.frame);
		
		this.inicio.addActionListener(list);
		this.cursos.addActionListener(list);
		this.solicitudes.addActionListener(list);
		this.logo.addActionListener(list);
		this.exit.addActionListener(list);
		
		this.inicio.setActionCommand("Inicio");
		this.cursos.setActionCommand("Asignaturas");
		this.solicitudes.setActionCommand("Solicitudes");
		this.logo.setActionCommand("Atras");
		this.exit.setActionCommand("Logout");
		
		this.menubar.add(Box.createGlue());
		
		this.add(menubar);
		
	}
	
}
