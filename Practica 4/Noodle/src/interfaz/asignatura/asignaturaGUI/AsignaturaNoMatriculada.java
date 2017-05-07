package interfaz.asignatura.asignaturaGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import asignatura.Asignatura;
import interfaz.genericos.Menu;
import interfaz.genericos.NoodleFrame;
import interfaz.genericos.NuestroPanel;
import interfaz.solicitudes.PanelSolicitud;

/**
 * Clase AsignaturaNoMatriculada
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */
public class AsignaturaNoMatriculada extends NuestroPanel {
	
	//Variables
	
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

	//Constructor
	
	/**
	 * Constructor de AsignaturaNoMatriculada
	 * @param anterior
	 * @param frame
	 * @param asig
	 */
	public AsignaturaNoMatriculada(NuestroPanel anterior, NoodleFrame frame, Asignatura asig) {
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
		
		this.menu.setPreferredSize(new Dimension(w, 40));

	}
	
	//Métodos
	
	/**
	 * Hace que el frame muestre este panel
	 */
	@Override
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
