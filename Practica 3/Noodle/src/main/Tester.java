package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import asignatura.Asignatura;
import contenido.*;
import persona.*;
import plataforma.Plataforma;
import solicitud.Solicitud;

/**
 * Tester de toda la aplicación
 * @author Óscar Gómez Borzdynski
 * @author Jose Ignacio Gómez García
 * @date 21/03/2017
 */
public class Tester {

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Asignatura asig1;
		Asignatura asig2;
		Plataforma Noodle = new Plataforma();
		
		Profesor p1 = Plataforma.profesor;
		
		Plataforma.addAlumno("352689", "Pepe", "1234", LocalDate.now().toString(), "pepe@noodle.es");
		Alumno a1 = Plataforma.alumnos.get(0);
		
		Plataforma.createAsignatura("Matemáticas");
		Plataforma.createAsignatura("Lengua");
		
		asig1 = Plataforma.asignaturas.get(0);
		asig2 = Plataforma.asignaturas.get(1);
		
		p1.eraseAsignatura(asig2);
		
		System.out.println(a1);
		System.out.println(asig1);
		System.out.println(p1);
		
		Solicitud s1 = a1.solicitarAcceso(asig1);
		// TODO Comprobar equals
		Solicitud s2 = a1.solicitarAcceso(asig1);
		
		System.out.println(s1);
		System.out.println(s2);	
		System.out.println(asig1);
		
		ArrayList<Solicitud> solis = p1.getSolicitudes();
		
		System.out.println(solis);	
		
		p1.denegarSolicitud(s1);
		//TODO Comprobar que existe
		p1.denegarSolicitud(s2);
		
		s1 = a1.solicitarAcceso(asig1);
		// TODO Comprobar equals
		s2 = a1.solicitarAcceso(asig1);
		
		System.out.println(s1);
		System.out.println(s2);	
		
		p1.aceptarSolicitud(s1);
		//TODO Comprobar que existe
		p1.aceptarSolicitud(s2);
		
		System.out.println(asig1);
		
		p1.expulsarAlumno(asig1, a1);
		
		System.out.println(asig1);
		
		// TODO los expulsados se guardan en un array aparte y se comprueba al crear una nueva solicitud
		p1.readmitirAlumno(asig1, a1);
		
		System.out.println(asig1.getAlumnos());
		
		// Añadir un tema, null es la raiz
		asig1.addContenido(new Tema("Tema 1", true), null);
		
		//Obtener el tema para añadir contenido
		Tema t1 = (Tema)asig1.getContenido().get(0);
		
		//Añadir un subtema, t1 es el tema donde se añade
		asig1.addContenido(new Tema("Tema 1.1", true), t1);
		
		Tema t11 = (Tema)t1.getContenido().get(0);
		
		asig1.eraseContenido(t11);
		
		asig1.addContenido(new Apuntes("Esto son unos apuntes muy bonitos", "Apunte1", true), t1);
		
		// TODO Crear un ejercicio
		Ejercicio ej = new Ejercicio();
		
		asig1.addContenido(ej, t1);
		
		//Cambia a oculto el ejercicio
		asig1.setVisibilidad(ej, false);

		System.out.println(asig1.getContenidoVisible());
		
		System.out.println(asig1.getContenido());
		
		asig1.setVisibilidad(ej, true);
		
		System.out.println(Plataforma.asignaturas);
		
		System.out.println(a1.getAsignaturas());
		
		ej.setPeso(8);
		ej.setAleatoriedad(true);
		ej.setAleatoriedad(false);
		ej.setFechaFin(LocalDate.now().toString());
		ej.setFechaIni(LocalDate.now().toString());
		
		ArrayList<Opciones> opc = new ArrayList<Opciones>();
		opc.add(new Opciones("4", true));
		opc.add(new Opciones("3", false));
		
		
		
		Pregunta p1 = new Pregunta("Cuánto es 2 + 2", opc, 0, false, 0);
		
		
	}

}
