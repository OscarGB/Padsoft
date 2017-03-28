package pruebas;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import asignatura.Asignatura;
import contenido.Ejercicio;
import contenido.EstadoEjercicio;
import contenido.Pregunta;
import contenido.PreguntaRespuestaUnica;
import contenido.Tema;
import persona.Alumno;
import respuestas.RespuestaPregunta;
import respuestas.RespuestaUnica;

/**
 * Test Ejercicio
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 28/03/2017
 */
public class EjercicioTest {
	private Asignatura mates;
	private Alumno nacho;
	private Pregunta pre;
	private RespuestaPregunta res;
	private ArrayList<RespuestaPregunta> array;
	private Tema tema1;
	private Ejercicio ej1;
	
	@Before
	public void setUp(){
		mates = new Asignatura("Mates");
		tema1 = new Tema("Tema1", true, mates);
		nacho = Alumno.CreaAlumno("2", "nacho", "Password", "nacho@gmail.com");
		pre = new PreguntaRespuestaUnica("Prueba", true, -1, true);
		res = new RespuestaUnica(pre, true);
		array = new ArrayList<RespuestaPregunta>();
		array.add(res);
		ej1 = new Ejercicio(1, true, LocalDate.now().plusDays(1), LocalDate.now().plusDays(4),
				tema1, "Ejercicio1", true, mates);
	}
	
	/**
	 * Test para crear un ejercicio
	 */
	@Test
	public void testCrearEjercicio1(){
		Ejercicio ej = new Ejercicio(1, true, LocalDate.now().plusDays(1), LocalDate.now().plusDays(4),
				tema1, "Ejercicio1", true, mates);
		
		assertTrue(tema1.getSubcontenido().contains(ej));
		assertEquals(ej.getAsignatura(), mates);
		assertEquals(ej.getEstado(), EstadoEjercicio.ESPERA);
		assertEquals(ej.getFechaFin(), LocalDate.now().plusDays(4));
		assertEquals(ej.getFechaIni(), LocalDate.now().plusDays(1));
		assertTrue(ej.getNotaMedia() == 0);
		assertTrue(ej.getNumTerminados() == 0);
		assertTrue(ej.getPadre() == tema1);
		assertTrue(ej.getPeso() == 1);
		assertEquals(ej.getTitulo(), "Ejercicio1");
	}
	
	/**
	 * Test para comprobar que se usan las fechas por defecto si las introducidas son
	 * incorrectas
	 * La de inicio es posterior a la de fin
	 */
	@Test
	public void testCrearEjercicio2(){
		Ejercicio ej = new Ejercicio(1, true, LocalDate.now().plusDays(3), LocalDate.now().plusDays(2),
				tema1, "Ejercicio1", true, mates);
		
		assertEquals(ej.getFechaIni(), ej.getFechaIniDefecto());
		assertEquals(ej.getFechaFin(), ej.getFechaFinDefecto());
		assertTrue(tema1.getSubcontenido().contains(ej));
	}
	
	/**
	 * Test para comprobar que se usan las fechas por defecto si las introducidas son
	 * incorrectas
	 * La de inicio es anterior al dia actual
	 */
	@Test
	public void testCrearEjercicio3(){
		Ejercicio ej = new Ejercicio(1, true, LocalDate.now().minusDays(3), LocalDate.now().plusDays(2),
				tema1, "Ejercicio1", true, mates);
		
		assertEquals(ej.getFechaIni(), ej.getFechaIniDefecto());
		assertEquals(ej.getFechaFin(), ej.getFechaFinDefecto());
		assertTrue(tema1.getSubcontenido().contains(ej));
	}
	
	/**
	 * Método para comprobar que si se introduce un peso no válido
	 * se usa el peso por defecto
	 */
	@Test
	public void testCrearEjercicio4(){
		Ejercicio ej = new Ejercicio(-1, true, LocalDate.now().plusDays(1), LocalDate.now().plusDays(4),
				tema1, "Ejercicio1", true, mates);
		
		assertEquals(ej.getPeso(), ej.getPesoDefecto());
		assertTrue(tema1.getSubcontenido().contains(ej));
	}
	
	/**
	 * Test para añadir una pregunta
	 */
	@Test
	public void testAddPregunta(){
		assertTrue(ej1.addPregunta(pre));
		assertTrue(ej1.getPreguntas().contains(pre));
	}
	
	/**
	 * Test para añadir una pregunta null
	 */
	@Test
	public void testAddPregunta1(){
		assertFalse(ej1.addPregunta(null));
		assertTrue(ej1.getPreguntas().isEmpty());
	}
	

}
