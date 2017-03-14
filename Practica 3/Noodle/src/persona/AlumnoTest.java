package persona;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asignatura.Asignatura;

/**
 * Test de Alumno
 * @author �scar G�mez Borzdynski
 * @author Jose Ignacio G�mez Garc�a
 * @date 07/03/2017
 */
public class AlumnoTest {

	Alumno alumno1;
	Asignatura asignatura1;
	Asignatura asignatura2;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		alumno1 = new Alumno("1", "Fulanito", "1234", "12/05/2015", "Hola@gmail.com");
		asignatura1 = new Asignatura();
		asignatura2 = new Asignatura();
	}

	/**
	 * Comprueba el m�todo addAsignatura
	 */
	@Test
	public void testAddAsignatura() {
		alumno1.addAsignatura(asignatura1);
		int num = alumno1.getAsignaturas().size();
		//Ha a�adidido correctamente
		assertEquals(1, num);
		alumno1.addAsignatura(asignatura2);
		num = alumno1.getAsignaturas().size();
		//Ha a�adidido correctamente
		assertEquals(2, num);
		alumno1.addAsignatura(asignatura2);
		num = alumno1.getAsignaturas().size();
		//No deber�a haberla a�adido.
		assertEquals(2, num);
	}
	
	/**
	 * Comprueba el m�todo eraseAsignatura
	 */
	@Test
	public void testEraseAsignatura() {
		int num = alumno1.getAsignaturas().size();
		//Comprueba que el n�mero inicial de asignaturas es 0
		assertEquals(0, num);
		alumno1.eraseAsignatura(asignatura1);
		num = alumno1.getAsignaturas().size();
		//No puede eliminar una asignatura en la que no est� matriculado
		assertEquals(0, num);
		alumno1.addAsignatura(asignatura1);
		num = alumno1.getAsignaturas().size();
		alumno1.eraseAsignatura(asignatura1);
		//Comprobamos que el tama�o ha disminuido
		assertEquals(num-1, alumno1.getAsignaturas().size());
	}
	
	// TODO A�adir los tests para estadisticas
	

}
