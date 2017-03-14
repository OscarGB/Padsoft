package plataforma;

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

	public Plataforma(ArrayList<Asignatura> asignaturas, ArrayList<Alumno> alumnos, Profesor profesor){
		this.asignaturas = asignaturas;
		this.alumnos = alumnos;
		this.profesor = profesor;
		this.fechaActual = LocalDate.now();
		this.loggedAs = null;
		this.emailSystem = new EmailSystem();
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
