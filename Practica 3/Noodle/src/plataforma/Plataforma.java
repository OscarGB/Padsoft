package plataforma;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import asignatura.Asignatura;
import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import persona.*;
import solicitud.Solicitud;

/**
 * Clase Plataforma
 * @author Óscar Gómez Borzdynski
 * @author Jose Ignacio Gómez García
 * @date 07/03/2017
 */

public class Plataforma implements Serializable {
	
	/**
	 * Para serializar
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Nombre de la plataforma
	 */
	public static final String NAME = "NOODLE";
	
	/**
	 * Asignaturas de la plataforma
	 */
	public static ArrayList<Asignatura> asignaturas;
	
	/**
	 * Alumnos de la plataforma
	 */
	public static ArrayList<Alumno> alumnos;
	
	/**
	 * Profesor de la plataforma
	 */
	public static Profesor profesor;
	
	/**
	 * Fecha de la paltaforma
	 */
	public static LocalDate fechaActual;
	
	/**
	 * Persona que se ha logueado a la plataforma
	 */
	public static Persona loggedAs;
	
	/**
	 * Sistema de emails
	 */
	public static EmailSystem emailSystem;
	
	/**
	 * Singleton plataforma
	 */
	public static Plataforma plat;

	/**
	 * Constructor de Plataforma
	 */
	private Plataforma(){
		Plataforma.asignaturas = new ArrayList<Asignatura>();
		Plataforma.alumnos = new ArrayList<Alumno>();
		Plataforma.profesor = Profesor.newProfesor();
		Plataforma.fechaActual = LocalDate.now();
		Plataforma.loggedAs = null;
		Plataforma.emailSystem = new EmailSystem();
		if( this.loadData() == false){
			this.readFile();
		}
		Plataforma.plat = this;
	}
	
	/**
	 * Método para abrir la plataforma, crea la plataforma en si.
	 * @return Plataforma
	 */
	public static Plataforma openPlataforma(){
		if(Plataforma.plat == null){
			Plataforma.plat = new Plataforma();
		}
		return Plataforma.plat;
	}
	
	/**
	 * Método para cerrar la plataforma.
	 */
	public void closePlataforma(){
		this.saveData();
	}
	
	/**
	 * Guarda los datos de la plataforma completa.
	 */
	private void saveData(){
		 try {

	         FileOutputStream out = new FileOutputStream("plataforma");
	         ObjectOutputStream oout = new ObjectOutputStream(out);

	         oout.writeObject(Plataforma.plat);

	         oout.close();
		 } catch (Exception ex) {
	         ex.printStackTrace();
	     }

	}
	
	/**
	 * Carga los datos de la plataforma completa.
	 * @return boolean
	 */
	private boolean loadData(){
		FileInputStream out = null;
		 try {

	         // create a new file with an ObjectOutputStream
	          out = new FileInputStream("plataforma");
		 } catch (Exception FileNotFoundException){
			 return false;
		 }
		 try{
			ObjectInputStream oout = new ObjectInputStream(out);

	         // write something in the file
	         Plataforma.plat = (Plataforma) oout.readObject();

	         // close the stream
	         oout.close();
		 } catch (Exception ex) {
	         ex.printStackTrace();
	     }
		 return true;

	}
	
	/**
	 * Función que lee el fichero y guarda todos los datos necesarios
	 */
	private void readFile(){
		String cadena;
		
		/*Alumnos*/
		File archivo = new File ("./data/datosalumnos.txt");
	    FileReader f = null;
	    Alumno a = null;
		try {
			f = new FileReader(archivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    BufferedReader b = new BufferedReader(f);
	    try {
	    	
			while((cadena = b.readLine())!=null) {
				LocalDate.now();
				String[] toks = cadena.split(";");
				if(EmailSystem.isValidEmailAddr(toks[2]) == true){
					try {
						a = new Alumno(toks[3], (toks[0] + " " + toks[1]), toks[4], toks[2]);
					} catch (InvalidEmailAddressException e) {
						System.out.println("Correo inválido");
						e.printStackTrace();
					}
					Plataforma.alumnos.add(a);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	    try {
			b.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    /*Asignaturas*/
	    archivo = new File("./data/datosasignaturas.txt");
	    try {
			f = new FileReader(archivo);
		
		    b = new BufferedReader(f);
		    try {
		    	while((cadena = b.readLine())!=null) {
		    		
		    		//Titulo
		    		String titulo = cadena;
		    		
		    		// Alumnos matriculados
		    		Asignatura asig = new Asignatura(titulo);
		    		cadena = b.readLine();
		    		int n = Integer.parseInt(cadena);
		    		for( int i = 0; i < n; i++){
		    			cadena = b.readLine();
		    			for(Alumno alum : Plataforma.alumnos){
		    				if(alum.getNia() == cadena){
		    					asig.addAlumno(alum);
		    					break;
		    				}
		    			}
		    		}
		    		
		    		// Solicitudes pendientes
		    		cadena = b.readLine();
		    		n = Integer.parseInt(cadena);
		    		for( int i = 0; i < n; i++){
		    			cadena = b.readLine();
		    			for(Alumno alum : Plataforma.alumnos){
		    				if(alum.getNia() == cadena){
		    					Solicitud s = new Solicitud(alum, asig);
		    					asig.addSolicitudPendiente(s);
		    					break;
		    				}
		    			}
		    		}
		    		
		    		// Solicitudes de los expulsados
		    		cadena = b.readLine();
		    		n = Integer.parseInt(cadena);
		    		for( int i = 0; i < n; i++){
		    			cadena = b.readLine();
		    			for(Alumno alumn : Plataforma.alumnos){
		    				if(alumn.getNia() == cadena){
		    					Solicitud sol = new Solicitud(alumn, asig);
		    					asig.addSolicitudExpulsado(sol);
		    					break;
		    				}
		    			}
		    		}
		    		
		    		// TODO falta el contenido
		    		
		    		Plataforma.addAsignatura(asig);
				}	    	
		    } catch (IOException e) {
				e.printStackTrace();
			}
		    try {
				b.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    } catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Archivo que guarda el estado de la plataforma
	 */
	public void writeFile(){
		PrintWriter f = null;
		
		// Alumnos
	    try {
			f = new PrintWriter("./data/datosalumnos.txt", "UTF-8");
			for(Alumno a : Plataforma.alumnos){
		    	String aux = a.getNombre();
		    	String[] n = aux.split(" ");
		    	f.println(n[0] + ";" + n[1] + ";" + a.getEmail() + ";" + a.getNia() + ";" + a.getPassword());
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    // Asignaturas
	    try {
			f = new PrintWriter("./data/datosasignaturas.txt", "UTF-8");
			for(Asignatura asig : Plataforma.asignaturas){
				f.println(asig.getNombre());
				ArrayList<Alumno> alumnos = asig.getAlumnos();
				f.println(alumnos.size());
				for(Alumno a : alumnos){
					f.println(a.getNia());
				}
				ArrayList<Solicitud> solicitudes = asig.getSolicitudes();
				f.println(solicitudes.size());
				for(Solicitud s : solicitudes){
					f.println(s.getAlumno().getNia());
				}
				solicitudes = asig.getSolicitudesExpulsados();
				f.println(solicitudes.size());
				for(Solicitud s : solicitudes){
					f.println(s.getAlumno().getNia());
				}
				
				// TODO contenido
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    	    
	}
	
	/**
	 * Devuelve el nombre de la plataforma
	 * @return
	 */
	public static String getName() {
		return NAME;
	}

	/**
	 * Devuelve las asignaturas de la plataforma
	 * @return
	 */
	public static ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	/**
	 * Añade una asignatura
	 * @param asignatura
	 */
	public static void addAsignatura(Asignatura asignatura) {
		Plataforma.asignaturas.add(asignatura);
	}
	
	/**
	 * Borra una asignatura
	 * @param asignatura
	 */
	public static void eraseAsignatura(Asignatura asignatura) {
		Plataforma.asignaturas.remove(asignatura);
	}

	/**
	 * Devuelve la fecha actual
	 * @return
	 */
	public static LocalDate getFechaActual() {
		return fechaActual;
	}

	/**
	 * Modifica la fecha de la plataforma
	 * @param fechaActual
	 */
	public static void setFechaActual(LocalDate fechaActual) {
		Plataforma.fechaActual = fechaActual;
	}
	
	/**
	 * Método para hacer el login en la plataforma
	 * @param Nia
	 * @param password
	 * @return boolean
	 */
	public static boolean login(String Nia, String password){
		if(Plataforma.profesor.getNia() == Nia){
			if(Plataforma.profesor.getPassword() == password){
				Plataforma.loggedAs = Plataforma.profesor;
				return true;
			}
		}
		for(Alumno al : Plataforma.alumnos){
			if(al.getNia() == Nia){
				if(al.getPassword() == password){
					Plataforma.loggedAs = al;
					return true;
				}
			}
		}
		return false;
	}
	
}
