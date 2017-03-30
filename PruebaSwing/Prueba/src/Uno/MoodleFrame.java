package Uno;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoodleFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MoodleFrame(){
		super("Moodle");
		JPanel panel = new PanelLogin();
		this.getContentPane().add(panel);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
