package main;

/**
 * Tester
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 28/03/2017
 */

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import asignatura.Asignatura;
import contenido.*;
import persona.*;
import plataforma.Plataforma;
import respuestas.*;
import solicitud.Solicitud;

/**
 * Tester de la aplicación completa
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 28/03/2017
 */
public class Tester {

	public static void main(String[] args) {
		Asignatura asig1;
		Asignatura asig2;
		File file = new File("./data/plataforma");
		file.delete();
		Plataforma.openPlataforma();
		
		Profesor p1 = Plataforma.profesor();
			
		Alumno a1 = Plataforma.alumnos().get(0);
		
		//Login como profesor
		Plataforma.login(Plataforma.profesor().getNia(), Plataforma.profesor().getPassword());
		
		//Creación de Asignaturas
		asig1 = new Asignatura("matematicas");
		asig2 = new Asignatura("lengua");
		
		//Añadir las asignaturas
		Plataforma.addAsignatura(asig1);
		Plataforma.addAsignatura(asig2);
		
		//Borrar un asignatura
		Plataforma.eraseAsignatura(asig2);
		
		System.out.println(a1);
		System.out.println(asig1);
		System.out.println(p1);
		
		//Solicitudes de acceso
		Solicitud s1 = a1.solicitarAcceso(asig1);
		// Solicita acceso de nuevo, pero no se le deja (imprime null)
		Solicitud s2 = a1.solicitarAcceso(asig1);
		
		System.out.println(s1);
		System.out.println(s2);	
		System.out.println(asig1);
		
		ArrayList<Solicitud> solis = p1.getSolicitudes();
		
		System.out.println("Solicitudes: " + solis + "\n");	
		
		//Denegar las solicitudes
		p1.denegarSolicitud(s1);
		//Comprobar que existe
		p1.denegarSolicitud(s2);
		
		s1 = a1.solicitarAcceso(asig1);
		// Solicita acceso de nuevo, pero no se le deja (imprime null)
		s2 = a1.solicitarAcceso(asig1);
		
		System.out.println("Asignaturas existentes" + Plataforma.getAsignaturas());
		System.out.println(s1);
		System.out.println(s2);	
		
		p1.aceptarSolicitud(s1);
		//Comprobar que existe
		p1.aceptarSolicitud(s2);
		
		System.out.println(asig1);
		
		//Expulsar a un alumno
		p1.expulsarAlumno(asig1, a1);
		
		System.out.println(asig1);
		
		//Los expulsados se guardan en un array aparte y se comprueba al crear una nueva solicitud
		p1.readmitirAlumno(asig1, a1);
		
		System.out.println(asig1);
		System.out.println(asig1.getAlumnos());
		
		//Añadir un tema, null es la raiz
		Tema t1 = new Tema("Tema 1", true, asig1);
		
		//Añadir un subtema, t1 es el tema donde se añade
		Tema t11 = new Tema("Tema 1.1", true, asig1, t1);
		
		System.out.println("\n" + asig1);
		
		//Borrar un tema
		asig1.eraseContenido(t11);
		
		System.out.println("\n" + asig1);
		
		//Crear unos apuntes
		Apuntes apun = new Apuntes("Esto son unos apuntes muy bonitos", "Apunte1", true, asig1, t1);

		System.out.println("\n" + asig1);
		
		//Crear un ejercicio
		Ejercicio aborrar = new Ejercicio(2, false, LocalDate.now().minusDays(3), LocalDate.now().plusDays(4), t1, "Ejercicio a borrar", true, asig1);
		
		//Borrar un ejercicio
		asig1.eraseContenido(aborrar);		
		
		//Crear un ejercicio
		Ejercicio ej = new Ejercicio(2, false, Plataforma.getFechaActual().minusDays(0), Plataforma.getFechaActual().plusDays(4), t1, "Ejercicio", true, asig1);
		
		Plataforma.setFechaActual(Plataforma.getFechaActual().plusDays(1));
		
		System.out.println("\n" + asig1);

		//Modifica visibilidad
		ej.setVisibilidad(false);

		//Como es profesor podemos ver los elementos invisibles
		System.out.println("\n" + asig1);
		
		//Login como alumno
		Plataforma.logout();
		Plataforma.login(a1.getNia(), a1.getPassword());

		//Como somos alumno no vemos los elementos invisibles
		System.out.println("\n Asignaturas del alumno: \n" + Plataforma.loggedAs.getAsignaturas());
		
		Plataforma.logout();
		Plataforma.login(Plataforma.profesor().getNia(), Plataforma.profesor().getPassword());
		
		ej.setVisibilidad(true);
		
		ej.setPeso(8);
		ej.setAleatorio(true);
		
		//Crear preguntas varias para el ejercicio
		ArrayList<Opciones> opc = new ArrayList<Opciones>();
		opc.add(new Opciones("4", true));
		opc.add(new Opciones("3", false));
		
		Pregunta preg1 = new PreguntaRespuestaUnica("Cuánto es 2 + 2", false, 6);
		for(Opciones op : opc){
			preg1.addOpcion(op);
		}
		
		ej.addPregunta(preg1);
		
		System.out.println("\n" + asig1);
		
		opc = new ArrayList<Opciones>();
		opc.add(new Opciones("Colón descubrió América", true));
		opc.add(new Opciones("El cielo es rosa", false));
		opc.add(new Opciones("El cielo es azul", true));
		
		Pregunta preg2 = new PreguntaRespuestaMultiple("Selecciona las verdaderas", false, 3);
		for(Opciones op : opc){
			preg2.addOpcion(op);
		}
		
		ej.addPregunta(preg2);
		
		Pregunta preg3 = new PreguntaRespuestaSimple("¿Java es un lenguaje de programación orientado a objetos?", false, -4, 8, true);
		
		ej.addPregunta(preg3);
		
		Pregunta preg4 = new PreguntaRespuestaAbierta("¿Quíen escribió 'Los Hijos del Capitán Grant'?", false, -1, 3);
		preg4.addOpcion("Verne");
		preg4.addOpcion("Julio");
		preg4.addOpcion("Julio Verne");
		
		ej.addPregunta(preg4);
		
		System.out.println("\n" + asig1);
		
		//Login como alumno
		Plataforma.logout();
		Plataforma.login(a1.getNia(), a1.getPassword());
		
		//Comienzo de Responder al ejercicio
		ArrayList<RespuestaPregunta> res = new ArrayList<RespuestaPregunta>();
		
		//Correcta
		res.add(new RespuestaUnica(preg1, new Opciones("4", true)));
		//Incorrecta
		res.add(new RespuestaMultiple(preg2, opc));
		//Correcta
		res.add(new RespuestaSimple(preg3, true));
		//Incorrecta
		res.add(new RespuestaAbierta(preg4, "Lorca"));
		
		ej.responderEjercicio(a1, res);
	
		//Ver una corrección a la pregunta1:
		System.out.println(preg1.getEnunciado());
		for(Opciones op : preg1.getOpciones()){
			System.out.println("\t" + op.getRespuesta() + " ¿Correcta? " + op.esCorrecta());
		}
		
		Plataforma.logout();
		Plataforma.login(Plataforma.profesor().getNia(), Plataforma.profesor().getPassword());
				
		System.out.println("\n" + asig1);
		
		//Imprimir las Estadisticas de la asignatura
		System.out.println(asig1.getEstadisticas());
		
		System.out.println("\n" + a1.getEstadisticas());
		
		//Comprobar que se guarda todo correctamente
		Plataforma.closePlataforma();
		
		Plataforma.openPlataforma();
		
		Plataforma.login(Plataforma.profesor().getNia(), Plataforma.profesor().getPassword());
		
		System.out.println("\n" + Plataforma.plat);
		
		Plataforma.closePlataforma();
		
	}

}
