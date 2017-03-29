package main;

import java.time.LocalDate;

import asignatura.Asignatura;
import contenido.Ejercicio;
import contenido.Opciones;
import contenido.PreguntaRespuestaAbierta;
import contenido.PreguntaRespuestaMultiple;
import contenido.PreguntaRespuestaUnica;
import contenido.PreguntaRespuestaSimple;

public class test_pregunta {
	public static void main(String[] args) {
		Asignatura mates = new Asignatura("Mates");
		LocalDate fini = LocalDate.of(1997, 03, 15); 
		LocalDate ffin = LocalDate.of(1998, 03, 15);
		
		Ejercicio e1 = new Ejercicio(10, true, fini, ffin, "Ejercicio 1", true, mates);
		
		System.out.println(e1 + "\n");		
		
		PreguntaRespuestaMultiple p1 = new PreguntaRespuestaMultiple("2 + 2", true, 1f, 1);
		PreguntaRespuestaUnica p2 = new PreguntaRespuestaUnica("2 + 2", true, 0.5f, 1);
		PreguntaRespuestaSimple p3 = new PreguntaRespuestaSimple("Hola?", true, 1, true);
		PreguntaRespuestaAbierta p4 = new PreguntaRespuestaAbierta("Di hola", true, 1);
		Opciones o1 = new Opciones("5", false);
		Opciones o2 = new Opciones("6", false);
		Opciones o3 = new Opciones("4", true);
		Opciones o4 = new Opciones("4", true);
		
		p1.addOpcion(o1);
		p1.addOpcion(o2);
		p1.addOpcion(o3);
		p1.addOpcion(o4);
		
		p2.addOpcion(o1);
		p2.addOpcion(o2);
		p2.addOpcion(o3);
		p2.addOpcion(o4);
		
		p4.addOpcion("HOLA");
		p4.addOpcion("Hola");
		
		e1.addPregunta(p1);
		e1.addPregunta(p2);
		e1.addPregunta(p3);
		e1.addPregunta(p4);
		
		System.out.println(e1 + "\n");
		
		e1.addNota(6f);
		e1.addNota(7f);
		e1.addNota(5f);
		e1.addNota(8f);
		e1.addNota(3f);
		
		System.out.println(e1 + "\n");


	}
}
