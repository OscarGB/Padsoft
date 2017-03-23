package plataforma;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import asignatura.Asignatura;
import es.uam.eps.padsof.emailconnection.EmailSystem;
import persona.*;

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
		File archivo = new File ("./data/datosalumnos.txt");
	    FileReader f = null;
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
					Alumno a = new Alumno(toks[3], (toks[0] + " " + toks[1]), toks[4], toks[2]);
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
