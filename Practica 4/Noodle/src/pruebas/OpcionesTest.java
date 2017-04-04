package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import contenido.Opciones;

/**
 * Test Opciones
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public class OpcionesTest {
	
	/**
	 * Test de Opciones
	 */
	@Test
	public void testOpciones(){
		String respuesta = "4";
		
		Opciones op = new Opciones(respuesta, true);
		assertEquals(op.getRespuesta(), respuesta);
		assertEquals(op.esCorrecta(), true);
	}
	
	/**
	 * Test de Opciones
	 */
	@Test
	public void testOpciones1(){		
		Opciones op = new Opciones(null, true);
		assertEquals(op.getRespuesta(),null);
		assertEquals(op.esCorrecta(), true);
	}
	

}
