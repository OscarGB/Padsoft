package interfaz.asignatura;

import java.awt.Color;
import java.awt.Dimension;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;


import contenido.Ejercicio;
import interfaz.genericos.NoodleFrame;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class EjercicioMenuDer extends JPanel {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Botón de borrar
	 */
	private JButton borrar = new JButton("Borrar tema");
	
	/**
	 * Boton para añadir pregunta
	 */
	private JButton pregunta = new JButton("Añadir pregunta");
	
	/**
	 * Label de elegir peso
	 */
	private JLabel peso = new JLabel("Elegir peso: ");
	
	/**
	 * Spinner para el peso
	 */
	private JSpinner pesoSpinner;
	
	/**
	 * Label de aleatorio
	 */
	private JLabel aleatLabel = new JLabel("Orden aleatorio:");
	
	/**
	 * Checkbos para la aleatoriedad
	 */
	private JCheckBox aleatorio = new JCheckBox();
	
	/**
	 * Label fecha inicio
	 */
	private JLabel inicio = new JLabel("Fecha inicio: ");
	
	/**
	 * Fecha inicio
	 */
	private JDatePickerImpl  fechaIni;
	
	/**
	 * Label fecha fin
	 */
	private JLabel fin = new JLabel("Fecha fin: ");

	/**
	 * Fecha fin
	 */
	private JDatePickerImpl  fechaFin;
	
	/**
	 * Boton de guardar
	 */
	private JButton guardar = new JButton("Guardar");
	
	/**
	 * Boton de cancelar
	 */
	private JButton cancelar = new JButton("Cancelar");

	/**
	 * Ejercicio
	 */
	private Ejercicio ejercicio;
	
	/**
	 * Frame
	 */
	private NoodleFrame frame;
	
	private EjercicioMenuDerListener list;
	
	public EjercicioMenuDer(NoodleFrame frame, Ejercicio ejercicio){
		this.ejercicio = ejercicio;
		this.frame = frame;
		
		this.setBackground(Color.WHITE);
		
		SpringLayout spr = new SpringLayout();
		this.setLayout(spr);
		
	    SpinnerNumberModel m_numberSpinnerModel;
	    Double current = new Double(10.00);
	    Double min = new Double(0.00);
	    Double max = new Double(100.00);
	    Double step = new Double(1.00);
	    m_numberSpinnerModel = new SpinnerNumberModel(current, min, max, step);
	    pesoSpinner = new JSpinner(m_numberSpinnerModel);
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		this.fechaIni = new JDatePickerImpl(datePanel, null);
		
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		this.fechaFin = new JDatePickerImpl(datePanel, null);
		
		Dimension d = new Dimension(150, 30);
		
		
		this.borrar.setPreferredSize(d);
		this.pregunta.setPreferredSize(d);
		this.guardar.setPreferredSize(new Dimension(100, 30));
		this.cancelar.setPreferredSize(new Dimension(100, 30));
		this.peso.setPreferredSize(new Dimension(100, 15));
		this.aleatLabel.setPreferredSize(new Dimension(100, 15));
		this.inicio.setPreferredSize(new Dimension(100, 15));
		this.fin.setPreferredSize(new Dimension(100, 15));
		
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.pregunta, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.borrar, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.EAST, this.peso, 0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.EAST, this.aleatLabel,0, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.WEST, this.inicio, 5, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.WEST, this.fin, 5, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.WEST, this.fechaIni, 5, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.WEST, this.fechaFin, 5, SpringLayout.WEST, this);
		spr.putConstraint(SpringLayout.WEST, this.aleatorio, 5, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.WEST, this.pesoSpinner, 5, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.EAST, this.guardar, -10, SpringLayout.HORIZONTAL_CENTER, this);
		spr.putConstraint(SpringLayout.WEST, this.cancelar, 10, SpringLayout.HORIZONTAL_CENTER, this);
		
		spr.putConstraint(SpringLayout.NORTH, this.pregunta, 0, SpringLayout.NORTH, this);
		spr.putConstraint(SpringLayout.NORTH, this.borrar, 20, SpringLayout.SOUTH, this.pregunta);
		spr.putConstraint(SpringLayout.NORTH, this.peso, 20, SpringLayout.SOUTH, this.borrar);
		spr.putConstraint(SpringLayout.NORTH, this.aleatLabel, 20, SpringLayout.SOUTH, this.peso);
		spr.putConstraint(SpringLayout.NORTH, this.inicio, 20, SpringLayout.SOUTH, this.aleatLabel);
		spr.putConstraint(SpringLayout.NORTH, this.fechaIni, 5, SpringLayout.SOUTH, this.inicio);
		spr.putConstraint(SpringLayout.NORTH, this.fin, 20, SpringLayout.SOUTH, this.fechaIni);
		spr.putConstraint(SpringLayout.NORTH, this.fechaFin, 5, SpringLayout.SOUTH, this.fin);
		spr.putConstraint(SpringLayout.NORTH, this.aleatorio, 20, SpringLayout.SOUTH, this.peso);
		spr.putConstraint(SpringLayout.NORTH, this.pesoSpinner, 20, SpringLayout.SOUTH, this.borrar);
		spr.putConstraint(SpringLayout.NORTH, this.guardar, 40, SpringLayout.SOUTH, this.fechaFin);
		spr.putConstraint(SpringLayout.NORTH, this.cancelar, 40, SpringLayout.SOUTH, this.fechaFin);

		this.add(this.pregunta);
		this.add(this.borrar);
		this.add(this.peso);
		this.add(this.aleatLabel);
		this.add(this.fechaFin);
		this.add(this.fechaIni);
		this.add(this.aleatorio);
		this.add(this.pesoSpinner);
		this.add(this.guardar);
		this.add(this.inicio);
		this.add(this.fin);
		this.add(this.cancelar);
		
		this.borrar.setActionCommand("borrar");
		this.pregunta.setActionCommand("pregunta");
		this.guardar.setActionCommand("guardar");
		this.cancelar.setActionCommand("cancelar");
		
		this.list = new EjercicioMenuDerListener(frame, ejercicio, this);
		
		this.borrar.addActionListener(list);
		this.guardar.addActionListener(list);
		
		this.setPreferredSize(new Dimension(250, 400));
	}
	
	/**
	 * Devuelve el peso del spinner
	 * @return
	 */
	public double getPeso(){
		return (double)this.pesoSpinner.getValue();
	}
	
	/**
	 * Devuelve la fecha seleccionada en el calendario
	 * @return
	 */
	public LocalDate getFechaIni(){
		Date date = (Date) this.fechaIni.getModel().getValue();
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	/**
	 * Devuelve la fecha seleccionada en el calendario
	 * @return
	 */
	public LocalDate getFechaFin(){
		Date date = (Date) this.fechaFin.getModel().getValue();
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	/**
	 * Devuelve true si se ha seleccionado el checkbox de aleatorio
	 * @return
	 */
	public boolean getAleatorio(){
		return this.aleatorio.isSelected();
	}
	
	//TODO Set del inicio de las fechas en los calendarios. Que no se superpongan.
	
}
