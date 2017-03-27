package pruebas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asignatura.Asignatura;
import persona.Alumno;
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
	
	@Before
	public void setUp() throws Exception {
		mates = new Asignatura("Mates");
		nacho = Alumno.CreaAlumno("2", "Nacho", "Password", "nacho@gmail.com");
		sol1 = new Solicitud(nacho, mates);
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

	
	
}
