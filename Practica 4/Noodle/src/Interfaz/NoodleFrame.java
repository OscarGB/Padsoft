package Interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NoodleFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoodleFrame(){
		super("Noodle");
		
		JPanel panel = new PanelLogin();
		
		this.getContentPane().add(panel);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
