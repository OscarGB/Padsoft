package pruebas;

import respuestas.*;
import contenido.*;
import plataforma.Plataforma;

import static org.junit.Assert.*;

import java.io.File;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import asignatura.Asignatura;

/**
 * Test Respuesta a ejercicio
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 28/03/2017
 */

public class RespuestaEjercicioTest {
	private RespuestaEjercicio res;
	private RespuestaPregunta pre;
	private RespuestaPregunta pre2;
	private Pregunta pregunta2;
	private Pregunta pregunta;
	private Ejercicio ej;
	private Asignatura asig;
	private Plataforma plataforma;
	private File file;
	
	@Before
	public void setUp() throws Exception {
		File file = new File("./data/plataforma");
		file.delete();
		Plataforma.openPlataforma();
		Plataforma.login(Plataforma.profesor.getNia(), Plataforma.profesor.getPassword());
		pregunta = new PreguntaRespuestaSimple("Prueba", false, -4, 4, true);
		pregunta2 = new PreguntaRespuestaSimple("Prueba2", false, -8, 6, false);
		asig = new Asignatura("Lengua");
		ej = new Ejercicio(8, false, LocalDate.now(), LocalDate.now(), "titulo", true, asig);
		ej.addPregunta(pregunta);
		ej.addPregunta(pregunta2);
		res = new RespuestaEjercicio(ej);
		
	}

	/**
	 * Test que comprueba el calculo de la nota
	 */
	@Test
	public void testNotaVerdad() {
		pre = new RespuestaSimple(pregunta, true);
		res.addRespuesta(pre);
		assertTrue(res.calcularNota() == 4);		
	}
	
	/**
	 * Test que comprueba el calculo de la nota con preguntas incorrectas
	 */
	@Test
	public void testNotaVerdad2() {
		pre = new RespuestaSimple(pregunta, false);
		res.addRespuesta(pre);
		pre2 = new RespuestaSimple(pregunta2, false);
		res.addRespuesta(pre2);
		assertTrue(res.calcularNota() == 2);		
	}
	
	/**
	 * Test que comprueba el calculo de la nota con preguntas correctas
	 */
	@Test
	public void testNotaVerdad3() {
		pre = new RespuestaSimple(pregunta, true);
		res.addRespuesta(pre);
		pre2 = new RespuestaSimple(pregunta2, false);
		res.addRespuesta(pre2);
		assertTrue(res.calcularNota() == 10);		
	}
	
	/**
	 * Test que comprueba el calculo de la nota con todas las preguntas erroneas
	 */
	@Test
	public void testNotaVerdad4() {
		pre = new RespuestaSimple(pregunta, false);
		res.addRespuesta(pre);
		pre2 = new RespuestaSimple(pregunta2, true);
		res.addRespuesta(pre2);
		assertTrue(res.calcularNota() == 0);		
	}
	
	@After
	public void afterTest(){
		Plataforma.closePlataforma();
	}
	


}
