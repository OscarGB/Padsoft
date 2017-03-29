package pruebas;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import persona.*;
import plataforma.Plataforma;
import solicitud.Solicitud;
import asignatura.Asignatura;

/**
 * Test Profesor
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 28/03/2017
 */
public class ProfesorTest {
	Profesor profe;
	Solicitud sol;
	Alumno al;
	Asignatura asig1;
	
	@Before
	public void setUp() throws Exception {
		File file = new File("./data/plataforma");
		file.delete();
		Plataforma.openPlataforma();
		profe = Profesor.newProfesor();
		al = Plataforma.alumnos.get(0);
		asig1 = new Asignatura("mates");
		sol = new Solicitud(al, asig1);
	}
	
	@After
	public void end() throws Exception {
		Plataforma.closePlataforma();
		Profesor.profesor = null;
	}

	/**
	 * Prueba que el profesor se crea correctamente
	 */
	@Test
	public void testCreaciónProfesor() {
		assertTrue(Profesor.profesor != null);
	}
	
	/**
	 * Prueba que la solicitud se acepta correctamente
	 */
	@Test
	public void testsolicitud1() {
		assertTrue(profe.aceptarSolicitud(sol));
		assertTrue(asig1.getAlumnos().contains(al));
		assertTrue(al.getAsignaturas().contains(asig1));
	}
	
	/**
	 * Prueba que no se puede aceptar una solicitud nula
	 */
	@Test
	public void testsolicitud2(){
		assertFalse(profe.aceptarSolicitud(null));
	}
	
	/**
	 * Prueba que la solicitud se deniega correctamente
	 */
	@Test
	public void testsolicitud3() {
		profe.denegarSolicitud(sol);
		assertFalse(asig1.getAlumnos().contains(al));
		assertFalse(al.getAsignaturas().contains(asig1));
	}
	
	/**
	 * Prueba que se puede expulsar a un alumno de una asignatura
	 */
	@Test
	public void testsolicitud4() {
		assertTrue(profe.aceptarSolicitud(sol));
		assertTrue(asig1.getAlumnos().contains(al));
		assertTrue(al.getAsignaturas().contains(asig1));
		profe.expulsarAlumno(asig1, al);
		assertFalse(asig1.getAlumnos().contains(al));
		assertFalse(al.getAsignaturas().contains(asig1));
	}
	
	/**
	 * Prueba que se puede readmitir a un alumno de una asignatura
	 */
	@Test
	public void testsolicitud5() {
		assertTrue(profe.aceptarSolicitud(sol));
		assertTrue(asig1.getAlumnos().contains(al));
		assertTrue(al.getAsignaturas().contains(asig1));
		profe.expulsarAlumno(asig1, al);
		assertFalse(asig1.getAlumnos().contains(al));
		assertFalse(al.getAsignaturas().contains(asig1));
		profe.readmitirAlumno(asig1, al);
		assertTrue(asig1.getAlumnos().contains(al));
		assertTrue(al.getAsignaturas().contains(asig1));
	}
	
	/**
	 * Prueba que no se puede denegar una solicitud nula
	 */
	@Test
	public void testsolicitud6() {
		//No debe saltar excepcion
		profe.denegarSolicitud(null);
	}
	
	/**
	 * Prueba que no se puede readmitir a un alumno nulo o a una asignatura nula
	 */
	@Test
	public void testsolicitud7() {
		assertFalse(profe.readmitirAlumno(null, al));
		assertFalse(profe.readmitirAlumno(asig1, null));
	}
	
}
