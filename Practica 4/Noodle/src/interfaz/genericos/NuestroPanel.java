package interfaz.genericos;

import javax.swing.JPanel;

public class NuestroPanel extends JPanel{
	
	//Variables
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * N�mero de Paneles actuales
	 */
	private static int nPaneles = 0;
	
	/**
	 * M�ximo n�mero de paneles que se guardar�n en la pila de retrocesos
	 */
	private static final int maxPaneles = 10;
	
	/**
	 * M�nimo n�mero de paneles al borrar la pila de retrocesos, siempre se asegura
	 * que puedas retroceder este numero de veces
	 */
	private static final int minPaneles = 5;
	
	/**
	 * Panel anterior en la cola de retrocesos
	 */
	protected NuestroPanel anterior;
	
	/**
	 * Frame del programa
	 */
	protected NoodleFrame frame;
	
	//Constructor
	
	/**
	 * Constructor de NuestroPanel
	 * @param anterior
	 * @param frame
	 */
	protected NuestroPanel(NuestroPanel anterior, NoodleFrame frame){
		this.anterior = anterior;
		this.frame = frame;
		NuestroPanel.nPaneles++;
		this.limpiaPaneles();
	}
	
	//M�todos
	
	/**
	 * Devuelve el panel anterior de la pila de retrocesos
	 * @return
	 */
	public NuestroPanel getAnterior(){
		return this.anterior;
	}
	
	/**
	 * Modifica el valor del Panel anterior de la pila de retrocesos
	 * @param anterior
	 */
	public void setAnterior(NuestroPanel anterior){
		
		if(anterior == null){
			return;
		}
		this.anterior = anterior;
		NuestroPanel.nPaneles++;
		this.limpiaPaneles();
	}
	
	/**
	 * Limpia los paneles de la pila de retrocesos (hasta un minimo) siempre que haya m�s que el m�ximo
	 */
	private void limpiaPaneles(){
		if(NuestroPanel.nPaneles < NuestroPanel.maxPaneles){
			return;
		}
		NuestroPanel aux = this;
		int pan = 1;
		for(int i = 1; i < minPaneles; i++){
			if(aux.anterior != null){
				pan ++;
				aux = aux.anterior;
			}
		}
		aux.anterior = null;
		
		NuestroPanel.nPaneles = pan;		
	}
	
	/**
	 * Hace que el frame muestre este panel
	 */
	public void muestraPanel(){
		return;
	}
	
}
