package pruebas;

import static org.junit.Assert.*;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import asignatura.Asignatura;
import contenido.Ejercicio;
import contenido.Pregunta;
import contenido.PreguntaRespuestaSimple;
import contenido.Tema;
import persona.Alumno;
import plataforma.Plataforma;
import respuestas.RespuestaPregunta;
import respuestas.RespuestaSimple;

/**
 * Test de Tema
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 28/03/2017
 */
public class TemaTest {

	private Asignatura mates = new Asignatura("Mates");
	private String titulo = "Tema 1";
	private Tema tema1 = new Tema(titulo, true, mates);
	private File file;
	private Plataforma plataforma;
	
	
	@Before
	public void setUp(){
		
		file = new File("./data/plataforma");
		file.delete();
		Plataforma.openPlataforma();
	}
	
	/**
	 * Test para crear un tema en la raiz
	 */
	@Test
	public void testCrearTemaRaiz(){
		Tema tema = new Tema(titulo, true, mates);
		
		assertTrue(mates.getRaiz().contains(tema));
	}
	
	/**
	 * Test para crear un subtema
	 */
	@Test
	public void testCrearSubtema(){
		Tema subtema = new Tema(titulo, true, mates, tema1);
		
		assertTrue(tema1.getSubcontenido().contains(subtema));
	}
	
	/**
	 * Test para probar que no se puede añadir subcontenido null
	 */
	@Test
	public void testAddSubcontenidoNull(){
		assertFalse(tema1.addSubcontenido(null));
	}
	
	/**
	 * Test para comprobar que se borran subtemas correctamente
	 */
	@Test
	public void testEraseSubcontenido(){
		Tema subtema = new Tema(titulo, true, mates, tema1);
		
		tema1.eraseSubcontenido(subtema);
		
		assertFalse(tema1.getSubcontenido().contains(subtema));
	}
	
	/**
	 * Método para probar que se oculta el contenido
	 */
	@Test
	public void testOcultarContenido(){
		tema1.ocultarContenido();
		assertFalse(tema1.getVisibilidad());
	}
	
	/**
	 * Método para comprobar que se oculta el contenido
	 * de los hijos
	 */
	@Test
	public void testOcultarContenidoHijos(){
		Tema subtema = new Tema(titulo, true, mates, tema1);
		
		tema1.ocultarContenido();
		assertFalse(tema1.getVisibilidad());
		assertFalse(subtema.getVisibilidad());
	}
	
	/**
	 * Test para el método esBorrable
	 */
	@Test
	public void testEsBorrable1(){
		assertTrue(tema1.esBorrable());
	}
	
	/**
	 * Test para el método es borrable con un ejercicio ya empezado
	 */
	@Test
	public void testEsBorrable2(){
		Ejercicio ej1 = new Ejercicio(1, true, Plataforma.fechaActual.plusDays(0), Plataforma.fechaActual.plusDays(4), tema1, "Ejercicio 1", true, mates);
		Plataforma.setFechaActual(Plataforma.getFechaActual().plusDays(2));
		Alumno nacho = Alumno.CreaAlumno("2", "Nacho", "Password", "nacho@gmail.com");
		
		mates.addAlumno(nacho);
		
		//Creamos las preguntas y las respuestas
		Pregunta pre = new PreguntaRespuestaSimple("Prueba", true, -1, true);
		
		ej1.addPregunta(pre);
		
		RespuestaPregunta res = new RespuestaSimple(pre, true);

		ArrayList<RespuestaPregunta> array = new ArrayList<RespuestaPregunta>();
		array.add(res);
		ej1.responderEjercicio(nacho, array);
		
		assertFalse(tema1.esBorrable());
	}
	
	/**
	 * Test para el método es borrable con un ejercicio ya terminado
	 */
	@Test
	public void testEsBorrable3(){
		Ejercicio ej1 = new Ejercicio(1, true, Plataforma.fechaActual.plusDays(0), Plataforma.fechaActual.plusDays(2), tema1, "Ejercicio 1", true, mates);
		Plataforma.setFechaActual(Plataforma.getFechaActual().plusDays(20));

		
		assertFalse(tema1.esBorrable());
	}
	
	@After
	public void afterTest(){
		Plataforma.closePlataforma();
	}
	

	
}
