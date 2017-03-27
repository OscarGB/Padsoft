package pruebas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asignatura.Asignatura;
import contenido.Apuntes;
import contenido.Tema;
import persona.Alumno;
import solicitud.Solicitud;

public class AsignaturaTest {
	private Asignatura mates;
	private Alumno nacho;
	private Solicitud sol1;
	private Tema tema1;
	
	@Before
	public void setUp() throws Exception {
		mates = new Asignatura("Mates");
		nacho = new Alumno("2", "Nacho", "Password", "nacho@gmail.com");
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
		assertTrue(mates.addSolicitudPendiente(sol1));
		assertTrue(mates.getSolicitudes().contains(sol1));
	}
	
	/**
	 * Test para comprobar que no se duplican las solicitudes
	 */
	@Test
	public void testAddSolicitudPendiente2(){
		Solicitud sol2 = new Solicitud(nacho, mates);
		mates.addSolicitudPendiente(sol1);
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
		mates.addSolicitudPendiente(sol1);
		mates.aceptarSolicitud(sol1);
		
		assertTrue(mates.isAlumnoIn(sol1.getAlumno()));
		assertFalse(mates.getSolicitudes().contains(sol1));
	}
	
	/**
	 * Test para aceptar una solicitud que no está en pendientes
	 */
	@Test
	public void testAceptarSolicitud2(){
		assertFalse(mates.aceptarSolicitud(sol1));
		assertFalse(mates.isAlumnoIn(nacho));
	}
	
	/**
	 * Test para denegar una solicitud
	 */
	@Test
	public void testDenegarSolicitud1(){
		mates.addSolicitudPendiente(sol1);
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
	 * Debe borrar los tres
	 */
	@Test
	public void eraseContenidoRaiz3(){
		Tema subtema1 = new Tema("Tema 1.1", true, mates, tema1);
		Tema subtema2 = new Tema("Tema 1.1.1", true, mates, subtema1);
		
		mates.eraseContenido(tema1);
		
		assertFalse(mates.getRaiz().contains(tema1));
		assertFalse(tema1.getVisibilidad());
		assertFalse(subtema1.getVisibilidad());
		assertFalse(subtema2.getVisibilidad());
	}
	
	
	
}
