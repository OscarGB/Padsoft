package pruebas;

import static org.junit.Assert.*;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import asignatura.Asignatura;
import contenido.Apuntes;
import contenido.Ejercicio;
import contenido.Opciones;
import contenido.Pregunta;
import contenido.PreguntaRespuestaSimple;
import contenido.PreguntaRespuestaUnica;
import contenido.Tema;
import persona.Alumno;
import plataforma.Plataforma;
import respuestas.RespuestaEjercicio;
import respuestas.RespuestaPregunta;
import respuestas.RespuestaUnica;
import solicitud.Solicitud;

/**
 * Test de Asignatura
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */
public class AsignaturaTest {
	private Asignatura mates;
	private Alumno nacho;
	private Solicitud sol1;
	private Tema tema1;
	private Plataforma plataforma;
	private File file;
	
	@Before
	public void setUp() throws Exception {
		file = new File("./data/plataforma");
		file.delete();
		Plataforma.openPlataforma();
		Plataforma.login(Plataforma.alumnos.get(0).getNia(), Plataforma.alumnos.get(0).getPassword());
		mates = new Asignatura("Mates");
		nacho = Alumno.CreaAlumno("2", "Nacho", "Password", "nacho@gmail.com");
		sol1 = new Solicitud(nacho, mates);
		tema1 = new Tema("Tema 1", true, mates);
	}
	
	/**
	 * Test para comprobar que se crea correctamente la asignatura
	 */
	@Test
	public void testNuevaAsignatura(){
		Asignatura asig = new Asignatura("Lengua");
		assertNotEquals(null, asig);
		assertEquals("Lengua", asig.getNombre());
	}
	
	/**
	 * Test para comprobar que se añaden las solicitudes al array de pendientes
	 */
	@Test
	public void testAddSolicitudPendiente1(){
		assertTrue(mates.getSolicitudes().contains(sol1));
	}
	
	/**
	 * Test para comprobar que no se duplican las solicitudes
	 */
	@Test
	public void testAddSolicitudPendiente2(){
		Solicitud sol2 = new Solicitud(nacho, mates);
		assertFalse(mates.addSolicitudPendiente(sol2));
		assertEquals(mates.getSolicitudes().size(), 1);
	}
	
	/**
	 * Test para añadir una solicitud a expulsados
	 */
	@Test
	public void testAddSolicitudExpulsado(){
		assertTrue(mates.addSolicitudExpulsado(sol1));
		assertTrue(mates.getSolicitudesExpulsados().contains(sol1));
	}
	
	/**
	 * Test para comprobar que no se duplican las solicitudes
	 */
	@Test
	public void testAddSolicitudExpulsado2(){
		Solicitud sol2 = new Solicitud(nacho, mates);
		mates.addSolicitudExpulsado(sol1);
		assertFalse(mates.addSolicitudExpulsado(sol2));
		assertEquals(mates.getSolicitudesExpulsados().size(), 1);
	}
	
	/**
	 * Test para comprobar que el alumno se añade a la asignatura
	 */
	@Test
	public void testAddAlumno1(){
		assertTrue(mates.addAlumno(nacho));
		assertTrue(mates.isAlumnoIn(nacho));
	}
	
	/**
	 * Test para comprobar que el alumno no se añade
	 * dos veces
	 */
	@Test
	public void testAddAlumno2(){
		assertTrue(mates.addAlumno(nacho));
		assertFalse(mates.addAlumno(nacho));
	}
	
	/**
	 * Test isAlumnoIn
	 */
	@Test
	public void testIsAlumnoIn1(){
		mates.addAlumno(nacho);
		assertTrue(mates.isAlumnoIn(nacho));		
	}
	
	/**
	 * Test isAlumnoIn con alumno fuera de la asignatura
	 */
	@Test
	public void testIsAlumnoIn2(){
		assertFalse(mates.isAlumnoIn(nacho));		
	}
	
	/**
	 * Test para aceptar una solicitud
	 */
	@Test
	public void testAceptarSolicitud1(){
		mates.aceptarSolicitud(sol1);
		
		assertTrue(mates.isAlumnoIn(sol1.getAlumno()));
		assertFalse(mates.getSolicitudes().contains(sol1));
	}
	
	/**
	 * Test para denegar una solicitud
	 */
	@Test
	public void testDenegarSolicitud1(){
		mates.denegarSolicitud(sol1);
		
		assertFalse(mates.isAlumnoIn(sol1.getAlumno()));
		assertFalse(mates.getSolicitudes().contains(sol1));
	}
	
	/**
	 * Test para intentar denegar una solicitud que no está
	 * en el array de pendientes
	 */
	@Test
	public void testDenegarSolicitud2(){
		mates.denegarSolicitud(sol1);
		
		assertFalse(mates.isAlumnoIn(sol1.getAlumno()));
		assertFalse(mates.getSolicitudes().contains(sol1));
	}
	
	/**
	 * Test para expulsar alumno
	 */
	@Test
	public void testExpulsarAlumno1(){
		mates.addAlumno(nacho);
		assertTrue(mates.expulsarAlumno(nacho));
		
		assertFalse(mates.isAlumnoIn(nacho));
		
		Solicitud solExp = new Solicitud(nacho, mates);
		
		assertTrue(mates.getSolicitudesExpulsados().contains(solExp));
	}
	
	/**
	 * Test para expulsar alumno que no está en la asignatura
	 */
	@Test
	public void testExpulsarAlumno2(){
		assertFalse(mates.expulsarAlumno(nacho));
		
		assertFalse(mates.isAlumnoIn(nacho));
	}
	
	/**
	 * Test para readmitir alumno
	 */
	@Test
	public void testReadmitirAlumno1(){
		mates.addSolicitudExpulsado(sol1);
		assertTrue(mates.readmitirAlumno(sol1.getAlumno()));
		assertTrue(mates.isAlumnoIn(sol1.getAlumno()));
		assertFalse(mates.getSolicitudesExpulsados().contains(sol1));
	}
	
	/**
	 * Test para readmitir alumno que no está en expulsados
	 */
	@Test
	public void testReadmitirAlumno2(){
		assertFalse(mates.readmitirAlumno(sol1.getAlumno()));
	}
	
	/**
	 * Test para añadir un contenido a la raiz
	 */
	@Test
	public void testAddContenidoRaiz(){
		Tema tema2 = new Tema("Tema 2", true, mates);
		assertTrue(mates.getRaiz().contains(tema2));
	}
	
	/**
	 * Test para añadir subcontenido a un tema
	 */
	@Test
	public void testAddSubcontenido(){
		//El constructor de tema lo añade a un tema padre directamente
		Tema subtema1 = new Tema("Tema 1.1", true, mates, tema1);
		assertEquals(subtema1.getPadre(), tema1);
		assertTrue(tema1.getSubcontenido().contains(subtema1));
	}
	
	/**
	 * Test para borrar contenido de la raiz
	 */
	@Test
	public void eraseContenidoRaiz1(){
		mates.eraseContenido(tema1); //Llama a eraseContenidoRaiz
		assertFalse(mates.getRaiz().contains(tema1));
		assertFalse(tema1.getVisibilidad());
	}
	
	/**
	 * Test para borrar un contenido de la raiz
	 * que a su vez es padre de otro subcontenido
	 * Debe borrar los dos
	 */
	@Test
	public void eraseContenidoRaiz2(){
		Tema subtema1 = new Tema("Tema 1.1", true, mates, tema1);
		
		mates.eraseContenido(tema1);
		
		assertFalse(mates.getRaiz().contains(tema1));
		assertFalse(tema1.getVisibilidad());
		assertFalse(subtema1.getVisibilidad());
	}
	
	/**
	 * Test para borrar una cadena de contenidos
	 * Debe borrar los cuatro
	 */
	@Test
	public void eraseContenidoRaiz3(){
		Tema subtema1 = new Tema("Tema 1.1", true, mates, tema1);
		Tema subtema2 = new Tema("Tema 1.1.1", true, mates, subtema1);
		Tema subtema3 = new Tema("Tema 1.1.1.1", true, mates, subtema2);
		
		assertTrue(mates.eraseContenido(tema1));
		
		assertFalse(mates.getRaiz().contains(tema1));
		assertFalse(tema1.getVisibilidad());
		assertFalse(subtema1.getVisibilidad());
		assertFalse(subtema2.getVisibilidad());
		assertFalse(subtema3.getVisibilidad());
	}
	
	@Test
	public void testEraseContenidoRaiz4(){
		Ejercicio ej1 = new Ejercicio(1, true, Plataforma.fechaActual.plusDays(0), Plataforma.fechaActual.plusDays(4), "Ejercicio 1", true, mates);
		Plataforma.setFechaActual(Plataforma.fechaActual.plusDays(2));		
		assertTrue(mates.eraseContenido(tema1));
	}
	
	@Test
	public void testEraseContenidoRaiz5(){
		Ejercicio ej1 = new Ejercicio(1, true, Plataforma.fechaActual.plusDays(0), Plataforma.fechaActual.plusDays(4), tema1, "Ejercicio 1", true, mates);
		Plataforma.setFechaActual(Plataforma.fechaActual.plusDays(2));
		
		assertTrue(ej1.enPlazo());
		
		mates.addAlumno(nacho);
		
		//Creamos las preguntas y las respuestas
		Pregunta pre = new PreguntaRespuestaUnica("Prueba", true, -1, true);
		
		ej1.addPregunta(pre);
		
		RespuestaPregunta res = new RespuestaUnica(pre, true);

		ArrayList<RespuestaPregunta> array = new ArrayList<RespuestaPregunta>();
		array.add(res);
		ej1.responderEjercicio(nacho, array);
		assertFalse(mates.eraseContenido(tema1));
	}
	
	/**
	 * Test para probar que un ejercicio ya terminado no se puede borrar
	 */
	@Test
	public void testEraseContenidoRaiz6(){
		Ejercicio ej1 = new Ejercicio(1, true, Plataforma.fechaActual.plusDays(0), Plataforma.fechaActual.plusDays(4), tema1, "Ejercicio 1", true, mates);
		Plataforma.setFechaActual(Plataforma.fechaActual.plusDays(2));		
		
		mates.addAlumno(nacho);
		
		//Creamos las preguntas y las respuestas
		Pregunta pre = new PreguntaRespuestaUnica("Prueba", true, -1, true);
		
		ej1.addPregunta(pre);
		
		RespuestaPregunta res = new RespuestaUnica(pre, true);

		ArrayList<RespuestaPregunta> array = new ArrayList<RespuestaPregunta>();
		array.add(res);
		ej1.responderEjercicio(nacho, array);
		
		assertFalse(mates.eraseContenido(tema1));
		
		assertTrue(mates.getRaiz().contains(tema1));
		assertTrue(tema1.getSubcontenido().contains(ej1));
	}
	
	
	
	@After
	public void afterTest(){
		Plataforma.closePlataforma();
	}
	
}
