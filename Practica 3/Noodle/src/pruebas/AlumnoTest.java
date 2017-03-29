package pruebas;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import asignatura.Asignatura;
import estadisticas.EstadisticasAlumno;
import persona.Alumno;
import plataforma.Plataforma;
import solicitud.Solicitud;

/**
 * Test de Alumno
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public class AlumnoTest {
	Alumno al;
	Asignatura asig;
	EstadisticasAlumno es;
	@Before
	public void setUp() throws Exception {
		File file = new File("./data/plataforma");
		file.delete();
		Plataforma.openPlataforma();
		Plataforma.login(Plataforma.profesor.getNia(), Plataforma.profesor.getPassword());
		this.al = Alumno.CreaAlumno("1234", "Pepito", "pep1234", "pepito@gmail.com");
		this.asig = new Asignatura("Lengua");
	}
	
	@After
	public void close() throws Exception {
		Plataforma.closePlataforma();
	}

	/**
	 * Comprueba que la asignatura se añade correctamente
	 */
	@Test
	public void testAddAsignatura() {
		al.addAsignatura(asig);
		assertTrue(al.getAsignaturas().contains(asig));
		al.addAsignatura(asig);
		assertEquals(1, al.getAsignaturas().size());
	}
	
	/**
	 * Comprueba que la asignatura se borra correctamente
	 */
	@Test
	public void testEraseAsignatura() {
		al.addAsignatura(asig);
		al.eraseAsignatura(asig);
		assertFalse(al.getAsignaturas().contains(asig));
		al.eraseAsignatura(asig);
		assertFalse(al.getAsignaturas().contains(asig));
	}
	
	/**
	 * Comprueba que la estadistica se ha añadido correctamente
	 */
	@Test
	public void testAddEstadistica() {
		asig.addAlumno(al);
		this.es = EstadisticasAlumno.newEstadisticasAlumno(asig, al);
		al.addEstadistica(es);
		assertTrue(al.getEstadisticas().contains(es));
		assertEquals(1, al.getEstadisticas().size());
		
	}
	
	/**
	 * Comprueba que la estadistica se borra correctamente
	 */
	@Test
	public void testEraseEstadistica() {
		asig.addAlumno(al);
		this.es = EstadisticasAlumno.newEstadisticasAlumno(asig, al);
		al.addEstadistica(es);
		assertEquals(1, al.getEstadisticas().size());		
		al.eraseEstadistica(es);
		assertFalse(al.getEstadisticas().contains(es));
	}
	
	/**
	 * Comprueba que la solicitud se genera correctamente
	 */
	@Test
	public void testSolicitud() {
		Solicitud sol = al.solicitarAcceso(asig);
		assertTrue(sol != null);
		Solicitud sol2 = al.solicitarAcceso(asig);
		assertTrue(sol2 == null);
	}
	
	
	

}
