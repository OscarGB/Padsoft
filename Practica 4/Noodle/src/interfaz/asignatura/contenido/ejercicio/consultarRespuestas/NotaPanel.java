package interfaz.asignatura.contenido.ejercicio.consultarRespuestas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import contenido.Ejercicio;

public class NotaPanel extends JPanel{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	public NotaPanel(Ejercicio ejercicio){
		SpringLayout spr = new SpringLayout();
		this.setLayout(spr);
		
		this.setBackground(Color.WHITE);
		
		JLabel nota = new JLabel("Nota: " + ejercicio.getNotaMedia());
		
		nota.setFont(new Font("Arial", Font.BOLD, 30));
		
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, nota, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.VERTICAL_CENTER, nota, 0, SpringLayout.VERTICAL_CENTER, this);

		this.add(nota);
		
		this.setPreferredSize(new Dimension(150, 400));
		
	}

}
