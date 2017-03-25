package plataforma;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

public class Plataforma {
	
	public static final String NAME = "NOODLE";
	
	public static ArrayList<Asignatura> asignaturas;
	
	public static ArrayList<Alumno> alumnos;
	
	public static Profesor profesor;
	
	public static LocalDate fechaActual;
	
	public static Persona loggedAs;
	
	public static EmailSystem emailSystem;

	public Plataforma(){
		this.asignaturas = new ArrayList<Asignatura>();
		this.alumnos = new ArrayList<Alumno>();
		this.profesor = new Profesor("1", "Profesor");
		this.fechaActual = LocalDate.now();
		this.loggedAs = null;
		this.emailSystem = new EmailSystem();
		this.readFile();
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
	
	public static String getName() {
		return NAME;
	}

	public static ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public static void addAsignatura(Asignatura asignatura) {
		Plataforma.asignaturas.add(asignatura);
	}
	
	public static void eraseAsignatura(Asignatura asignatura) {
		Plataforma.asignaturas.remove(asignatura);
	}

	public static LocalDate getFechaActual() {
		return fechaActual;
	}

	public static void setFechaActual(LocalDate fechaActual) {
		Plataforma.fechaActual = fechaActual;
	}
	
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
