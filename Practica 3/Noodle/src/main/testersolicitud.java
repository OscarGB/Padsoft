package main;

import asignatura.Asignatura;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import persona.Alumno;
import persona.Profesor;
import solicitud.Solicitud;

public class testersolicitud {

	public static void main(String[] args) throws InvalidEmailAddressException {
		
		Alumno alumno = new Alumno("1", "nacho", "abcd", "nagomez97@gmail.com");
		Asignatura mates = new Asignatura("Mates");
		Asignatura lengua = new Asignatura("Lengua");
		Asignatura cono = new Asignatura("Cono");
		Profesor prof = new Profesor("1234", "profe");
		
		//Nacho solicita acceso a Mates y se acepta su solicitud		
		Solicitud sol = alumno.solicitarAcceso(mates);
		System.out.println(sol);
		if(sol == null){
			//ERROOOOOOOOOR
			System.out.println("ERROR");
			return;
		}
		if(prof.aceptarSolicitud(sol) == true){
			System.out.println("Solicitud aceptada");
		}
		
		System.out.println(mates);
		
		//Se expulsa al alumno nacho
		prof.expulsarAlumno(mates, alumno);
		
		System.out.println(mates);
		
		//Se readmite a nacho
		if(prof.readmitirAlumno(mates, alumno) == true){
			System.out.println("Alumno " + alumno.getNombre() + " readmitido.");
			System.out.println(mates);
		}
		
		//Solicita acceso a Lengua y se le acepta (matriculado en 2)
		Solicitud sol2 = alumno.solicitarAcceso(lengua);
		System.out.println(sol2);
		
		if(prof.aceptarSolicitud(sol2) == true){
			System.out.println("Solicitud aceptada");
		}
		
		System.out.println(lengua);
		
		//Solicita acceso a cono y se le rechaza
		Solicitud sol3 = alumno.solicitarAcceso(cono);
		System.out.println(sol3);
		
		prof.denegarSolicitud(sol3);
		System.out.println("Solicitud rechazada");
		
		System.out.println(cono);
		
	}

}
