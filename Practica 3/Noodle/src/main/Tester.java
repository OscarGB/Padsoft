package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import asignatura.Asignatura;
import persona.Alumno;
import persona.Profesor;

public class Tester {

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Alumno a1 = new Alumno("352689", "Pepe", "1234", LocalDate.now().toString(), "pepe@noodle.es");
		Asignatura asig1 = new Asignatura("Matemáticas");
		Profesor p1 = new Profesor("1", "Profe");
		
		a1.solicitarAcceso(asig1);
		
		p1.getSolicitudesPendientes();
		
		
		

	}

}
