package pruebas;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import asignatura.Asignatura;
import persona.*;
import plataforma.Plataforma;

/**
 * Test Plataforma
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 28/03/2017
 */
public class PlataformaTest {

	@Before
	public void setUp() throws Exception {
		File file = new File("./data/plataforma");
		file.delete();
		Plataforma.openPlataforma();
		Plataforma.login(Plataforma.profesor().getNia(), Plataforma.profesor().getPassword());
	}
	
	@After
	public void end() throws Exception {
		Plataforma.closePlataforma();
	}

	/**
	 * Comprueba que la plataforma se carga correctamente
	 */
	@Test
	public void testOpen() {
		assertTrue(Plataforma.plat != null);
		assertTrue(Plataforma.alumnos() != null);
		assertTrue(Plataforma.alumnos().size() != 0);
		assertTrue(Plataforma.getAsignaturas() != null);
		assertTrue(Plataforma.getAsignaturas().size() == 0);
	}
	
	/**
	 * Comprueba que la plataforma se carga y se guarda correctamente
	 * También comprueba que se añaden asignaturas de manera correcta
	 */
	@Test
	public void testOpen1() {
		Plataforma.addAsignatura(new Asignatura("mates"));
		Plataforma.closePlataforma();
		assertTrue(Plataforma.plat == null);
		Plataforma.openPlataforma();
		assertTrue(Plataforma.plat != null);
		assertTrue(Plataforma.alumnos() != null);
		assertTrue(Plataforma.alumnos().size() != 0);
		assertTrue(Plataforma.getAsignaturas() != null);
		assertTrue(Plataforma.getAsignaturas().size() == 1);
		// Si salta excepción está mal, no pasa nada por intentar cerrarla dos veces
		Plataforma.closePlataforma();
		Plataforma.closePlataforma();
	}
	
	/**
	 * Comprueba que las asignaturas se añaden y eliminan correctamente
	 */
	@Test
	public void testAsignaturas() {
		Asignatura asig = new Asignatura("mates");
		Plataforma.addAsignatura(asig);
		assertTrue(Plataforma.getAsignaturas().size() == 1);
		Plataforma.addAsignatura(asig);
		assertTrue(Plataforma.getAsignaturas().size() == 1);
		Plataforma.eraseAsignatura(asig);
		assertTrue(Plataforma.getAsignaturas().size() == 0);
		Plataforma.eraseAsignatura(asig);
		assertTrue(Plataforma.getAsignaturas().size() == 0);
	}
	
	/**
	 * Comprueba que el login y el logout es correcto
	 */
	@Test
	public void testLogin(){
		Plataforma.logout();
		assertTrue(Plataforma.loggedAs == null);
		assertTrue(Plataforma.login(Plataforma.profesor().getNia(), Plataforma.profesor().getPassword()));
		assertTrue(Plataforma.loggedAs.getClass() == Profesor.class);
		Plataforma.logout();
		assertTrue(Plataforma.loggedAs == null);
		assertTrue(Plataforma.login(Plataforma.alumnos().get(0).getNia(), Plataforma.alumnos().get(0).getPassword()));
		assertFalse(Plataforma.login(Plataforma.alumnos().get(0).getNia(), Plataforma.alumnos().get(0).getPassword()));
		assertTrue(Plataforma.loggedAs.getClass() == Alumno.class);
		assertFalse(Plataforma.login("Hola", "Adios"));
	}
}
