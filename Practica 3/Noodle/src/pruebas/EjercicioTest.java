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
import contenido.EstadoEjercicio;
import contenido.Pregunta;
import contenido.PreguntaRespuestaSimple;
import contenido.Tema;
import estadisticas.EstadisticasAlumno;
import persona.Alumno;
import plataforma.Plataforma;
import respuestas.RespuestaEjercicio;
import respuestas.RespuestaPregunta;
import respuestas.RespuestaSimple;

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
	private RespuestaPregunta falsa;
	private ArrayList<RespuestaPregunta> array;
	private ArrayList<RespuestaPregunta> arrayfalso;
	private Tema tema1;
	private Ejercicio ej1;
	private Ejercicio ej2;
	private Plataforma plataforma;
	private File file;
	
	@Before
	public void setUp(){
		
		file = new File("./data/plataforma");
		file.delete();
		Plataforma.openPlataforma();
		Plataforma.login(Plataforma.alumnos.get(0).getNia(), Plataforma.alumnos.get(0).getPassword());
		mates = new Asignatura("Mates");
		tema1 = new Tema("Tema1", true, mates);
		nacho = Alumno.CreaAlumno("2", "nacho", "Password", "nacho@gmail.com");
		mates.addAlumno(nacho);
		pre = new PreguntaRespuestaSimple("Prueba", true, 0, true);
		res = new RespuestaSimple(pre, true);
		falsa = new RespuestaSimple(pre, false);
		array = new ArrayList<RespuestaPregunta>();
		array.add(res);
		arrayfalso = new ArrayList<RespuestaPregunta>();
		array.add(falsa);
		ej1 = new Ejercicio(1, true, Plataforma.getFechaActual().minusDays(1), Plataforma.getFechaActual().plusDays(4),
				tema1, "Ejercicio1", true, mates);
		ej2 = new Ejercicio(1, true, Plataforma.getFechaActual().minusDays(1), Plataforma.getFechaActual().plusDays(4),
				tema1, "Ejercicio2", true, mates);
	}
	
	/**
	 * Test para crear un ejercicio
	 */
	@Test
	public void testCrearEjercicio1(){
		Ejercicio ej = new Ejercicio(1, true, Plataforma.getFechaActual().plusDays(1), Plataforma.getFechaActual().plusDays(4),
				tema1, "Ejercicio1", true, mates);
		
		assertTrue(tema1.getSubcontenido().contains(ej));
		assertEquals(ej.getAsignatura(), mates);
		assertEquals(ej.getEstado(), EstadoEjercicio.ESPERA);
		assertEquals(ej.getFechaFin(), Plataforma.getFechaActual().plusDays(4));
		assertEquals(ej.getFechaIni(), Plataforma.getFechaActual().plusDays(1));
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
		Ejercicio ej = new Ejercicio(1, true, Plataforma.getFechaActual().plusDays(3), Plataforma.getFechaActual().plusDays(2),
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
		Ejercicio ej = new Ejercicio(1, true, Plataforma.getFechaActual().minusDays(3), Plataforma.getFechaActual().plusDays(2),
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
		Ejercicio ej = new Ejercicio(-1, true, Plataforma.getFechaActual().plusDays(1), Plataforma.getFechaActual().plusDays(4),
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
	
	/**
	 * Test para eliminar pregunta
	 */
	@Test
	public void testRemovePregunta(){
		ej1.addPregunta(pre);
		ej1.removePregunta(pre);
		assertFalse(ej1.getPreguntas().contains(pre));
	}
	
	/**
	 * Test para comprobar que se puede responder a un ejercicio estando
	 * en plazo
	 */
	@Test
	public void testResponderEjercicio1(){
		Plataforma.setFechaActual(Plataforma.getFechaActual().plusDays(1));
		assertTrue(ej1.responderEjercicio(nacho, array));
		assertFalse(nacho.getEstadisticas().isEmpty());
	}
	
	/**
	 * Test para comprobar que no se puede responder a un ejercicio estando
	 * fuera de plazo
	 */
	@Test
	public void testResponderEjercicio2(){
		Plataforma.setFechaActual(Plataforma.getFechaActual().plusDays(0));
		assertFalse(ej1.responderEjercicio(nacho, array));
		assertTrue(nacho.getEstadisticas().isEmpty());
	}
	
	/**
	 * Test para comprobar que no se puede responder a un ejercicio estando
	 * fuera de plazo
	 */
	@Test
	public void testResponderEjercicio3(){
		Plataforma.setFechaActual(Plataforma.getFechaActual().plusDays(20));
		assertFalse(ej1.responderEjercicio(nacho, array));
		assertTrue(nacho.getEstadisticas().isEmpty());
	}
	
	/**
	 * Test para comprobar que un alumno no matriculado no puede
	 * responder a un ejercicio
	 */
	@Test
	public void testResponderEjercicio4(){
		Alumno oscar = Alumno.CreaAlumno("2", "Oscar", "Password", "nacho@email.com");
		Plataforma.setFechaActual(Plataforma.getFechaActual().plusDays(1));
		assertFalse(ej1.responderEjercicio(oscar, array));
		assertTrue(oscar.getEstadisticas().isEmpty());
	}
	
	/**
	 * Test para comprobar que se añaden respuestas a las
	 * estadísticas del alumno si estas ya existían
	 */
	@Test
	public void testResponderEjercicio5(){
		EstadisticasAlumno nuevo = new EstadisticasAlumno(ej2.getAsignatura(), nacho);
		RespuestaEjercicio respuestas = new RespuestaEjercicio(ej2);
		nuevo.addRespuestaEjercicio(respuestas);
		Plataforma.setFechaActual(Plataforma.getFechaActual().plusDays(1));
		assertTrue(ej1.responderEjercicio(nacho, array));
		assertTrue(nuevo.getRespuestas().contains(respuestas));
	}
	
	/**
	 * Test para comprobar que un alumno no puede responder dos veces
	 * el mismo ejercicio
	 */
	@Test
	public void testResponderEjercicio6(){
		Plataforma.setFechaActual(Plataforma.getFechaActual().plusDays(1));
		assertTrue(ej1.responderEjercicio(nacho, array));
		assertFalse(ej1.responderEjercicio(nacho, array));
	}
	
	/**
	 * Test para comprobar que se añade correctamente la nota
	 */
	@Test
	public void testAddNota(){
		ej1.addNota(6);
		ej1.addNota(8);
		assertTrue(ej1.getNotaMedia() == 7);
		assertTrue(ej1.getNumTerminados() == 2);
		assertTrue(ej1.getEstado() == EstadoEjercicio.RESPONDIDO);
	}
	
	/**
	 * Test para comprobar que las notas negativas no ponderan
	 */
	@Test
	public void testAddNota2(){
		ej1.addNota(-2);
		assertTrue(ej1.getNotaMedia() == 0);
	}
	
	/**
	 * Test para comprobar la función enPlazo
	 */
	@Test
	public void testEnPlazo1(){
		Plataforma.setFechaActual(Plataforma.fechaActual.plusDays(2));
		assertTrue(ej1.enPlazo());
	}
	
	/**
	 * Test para comprobar la función enPlazo
	 */
	@Test
	public void testEnPlazo2(){
		Plataforma.setFechaActual(Plataforma.fechaActual.minusDays(2));
		assertFalse(ej1.enPlazo());
	}
	
	/**
	 * Test para comprobar la función enPlazo
	 */
	@Test
	public void testEnPlazo3(){
		Plataforma.setFechaActual(Plataforma.fechaActual.plusDays(20));
		assertFalse(ej1.enPlazo());
	}
	
	/**
	 * Test para comprobar si se puede responder un ejercicio
	 */
	@Test
	public void testRespondible1(){
		Plataforma.setFechaActual(Plataforma.fechaActual.plusDays(2));
		assertTrue(ej1.sePuedeResponder());
	}
	
	/**
	 * Test para comprobar si se puede responder un ejercicio
	 */
	@Test
	public void testRespondible2(){
		Plataforma.setFechaActual(Plataforma.fechaActual.minusDays(2));
		assertFalse(ej1.sePuedeResponder());
	}
	
	/**
	 * Test para comprobar si se puede responder un ejercicio
	 */
	@Test
	public void testRespondible3(){
		Plataforma.setFechaActual(Plataforma.fechaActual.plusDays(20));
		assertFalse(ej1.sePuedeResponder());
	}
	
	/**
	 * Test para comprobar si se puede responder un ejercicio
	 */
	@Test
	public void testRespondible4(){
		Plataforma.setFechaActual(Plataforma.fechaActual.plusDays(20));
		assertFalse(ej1.sePuedeResponder());
	}
	
	
	@After
	public void afterTest(){
		Plataforma.closePlataforma();
	}
	

}
