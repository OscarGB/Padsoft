package pruebas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asignatura.Asignatura;
import persona.Alumno;
import persona.Profesor;
import solicitud.Solicitud;

public class SolicitudTest {
	private Alumno nacho;
	private Asignatura mates;
	

	/**
	 * Creamos los objetos básicos de los tests
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		nacho = new Alumno("2", "Nacho", "password", "nacho@email.com");
		
		mates = new Asignatura("Mates");	
		
	}
	
	
	/**
	 * Test para comprobar que la solicitud se crea correctamente y que sus campos
	 * son los correctos
	 */
	@Test
	public void testSolicitarAcceso1(){
		Solicitud sol1 = new Solicitud(nacho, mates);
		assertEquals(sol1.getAlumno(), nacho);
		assertEquals(sol1.getAsignatura(), mates);
		assertNotEquals(null, sol1);
	}
}
	