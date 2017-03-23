package main;

import asignatura.Asignatura;
import persona.Alumno;
import persona.Profesor;
import solicitud.Solicitud;

public class testersolicitud {

	public static void main(String[] args) {
		
		Alumno alumno = new Alumno("1", "nacho", "abcd", "15-03-1997", "nagomez97@gmail.com");
		Asignatura asig = new Asignatura("Mates");
		Profesor prof = new Profesor("1234", "profe");
		
		Solicitud sol = alumno.solicitarAcceso(asig);
		if(prof.aceptarSolicitud(sol) == true){
			System.out.println("Solicitud aceptada");
		}
		
		System.out.println(asig);
		
	}

}
