package pruebas;

import respuestas.*;
import contenido.*;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import asignatura.Asignatura;

public class RespuestaEjercicioTest {
	RespuestaEjercicio res;
	RespuestaPregunta pre;
	RespuestaPregunta pre2;
	Pregunta pregunta2;
	Pregunta pregunta;
	Ejercicio ej;
	Asignatura asig;
	@Before
	public void setUp() throws Exception {
		pregunta = new PreguntaRespuestaUnica("Prueba", false, -4, 4, true);
		pregunta2 = new PreguntaRespuestaUnica("Prueba2", false, -8, 6, false);
		asig = new Asignatura("Lengua");
		ej = new Ejercicio(8, false, LocalDate.now(), LocalDate.now(), "titulo", true, asig);
		ej.addPregunta(pregunta);
		ej.addPregunta(pregunta2);
		res = new RespuestaEjercicio(ej);
		
	}

	@Test
	public void testNotaVerdad() {
		pre = new RespuestaUnica(pregunta, true);
		res.addRespuesta(pre);
		assertTrue(res.calcularNota() == 4);		
	}
	
	@Test
	public void testNotaVerdad2() {
		pre = new RespuestaUnica(pregunta, false);
		res.addRespuesta(pre);
		pre2 = new RespuestaUnica(pregunta2, false);
		res.addRespuesta(pre2);
		assertTrue(res.calcularNota() == 2);		
	}

}
