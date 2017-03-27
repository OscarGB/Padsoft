package contenido;

import asignatura.Asignatura;

/**
 * Clase Contenido
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */
/**
 * @author Nacho
 *
 */
public abstract class Contenido {
	//Variables
	
	/**
	 * Contenido padre
	 * Si es null, se encuentra en el directorio raiz
	 */
	protected Tema padre;
	
	/**
	 * Titulo del contenido
	 */
	protected String titulo;
	
	/**
	 * Visibilidad del contenido
	 */
	protected boolean visibilidad;	
	
	/**
	 * Asignatura a la que pertenece el contenido
	 */
	protected Asignatura asignatura;
	
	
	//Constructor
	
	/**
	 * Constructor de Contenido en el directorio raiz
	 * Va a inicializar los campos del contenido (padre = null)
	 * Introduce el contenido en el array raiz de la Asignatura
	 * @param titulo
	 * @param visibilidad
	 */
	public Contenido(String titulo, boolean visibilidad, Asignatura asig){
		this.asignatura = asig;
		this.titulo = titulo;
		this.visibilidad = visibilidad;
		this.padre = null;
		this.asignatura.addSubcontenido(this, null);
	}
	
	/**
	 * Constructor de Contenido con un padre definido, que ya inserta el
	 * contenido en el padre
	 * @param titulo
	 * @param visibilidad
	 */
	public Contenido(String titulo, boolean visibilidad, Asignatura asig, Tema padre){
		this.asignatura = asig;
		this.titulo = titulo;
		this.visibilidad = visibilidad;
		this.padre = padre;
		this.asignatura.addSubcontenido(this, padre);
	}
	

	
	//Getters y setters
	
	/**
	 * Setter de Padre
	 * @param tema
	 */
	public void setPadre(Tema tema){
		this.padre = tema;
		return; 
	}
	
	/**
	 * Getter de Padre
	 * @return Tema padre
	 */
	public Tema getPadre(){
		return this.padre;
	}
	
	/**
	 * Getter de titulo
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Setter de titulo
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Getter de visibilidad
	 * @return
	 */
	public boolean getVisibilidad() {
		return visibilidad;
	}

	/**
	 * Setter de visibilidad
	 * @param visibilidad
	 */
	public void setVisibilidad(boolean visibilidad) {
		this.visibilidad = visibilidad;
	}
	
	/**
	 * Get asignatura
	 * @return Asignatura
	 */
	public Asignatura getAsignatura(){
		return this.asignatura;
	}
	
	//Métodos
	
	
	/**
	 * Método para borrar un contenido.En Asignatura se comprueba que el padre
	 * no sea null
	 * Primero lo saca del array de subcontenidos del tema padre
	 * Luego le quita la visibilidad
	 * Si el tema está en la raíz, lo borra de Asignatura.raiz
	 * @param contenido
	 */
	public void eraseContenido(){
		
		this.padre.eraseSubcontenido(this);
		this.setVisibilidad(false);
		
		return;
	}
	
	/**
	 * Método que oculta todo el contenido para cuando se borra
	 * un tema
	 */
	public void ocultarContenido(){
		return;
	}
	
	
	
}
