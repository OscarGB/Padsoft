package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;

import asignatura.Asignatura;

public class AsignaturaNoMatriculada extends NuestroPanel {
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Menú genérico
	 */
	Menu menu;
	
	/**
	 * Asignatura que no está matriculada
	 */
	Asignatura asig;
	
	/**
	 * Panel con la solicitud
	 */
	PanelSolicitud sol;

	/**
	 * Constructor de AsignaturaNoMatriculada
	 * @param anterior
	 * @param frame
	 * @param asig
	 */
	protected AsignaturaNoMatriculada(NuestroPanel anterior, NoodleFrame frame, Asignatura asig) {
		super(anterior, frame);
		this.setSize(700,500);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());

		this.menu = new Menu(frame);
		this.sol = new PanelSolicitud(asig);
		
		menu.setPreferredSize(new Dimension(10,10));
		
		this.add(this.menu, BorderLayout.NORTH);
		this.add(this.sol, BorderLayout.CENTER);
		
		int w = this.getWidth();
		
		this.menu.setPreferredSize(new Dimension(w, 80));

	}
	
	/**
	 * Hace que el frame muestre este panel
	 */
	public void muestraPanel(){
		this.frame.showAsignaturaNoMatriculada(false, this.asig);
	}
	
	/**
	 * Método para refrescar el panel
	 * @param asig
	 */
	public void refreshPanel(Asignatura asig){
		if(asig == this.asig){
			return;
		}
		else{
			this.remove(this.sol);
			this.sol = new PanelSolicitud(asig);
			this.add(this.sol, BorderLayout.CENTER);
		}
	}

}
