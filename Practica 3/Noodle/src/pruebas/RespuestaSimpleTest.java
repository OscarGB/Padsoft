package pruebas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import contenido.*;
import respuestas.*;

public class RespuestaSimpleTest {
	Pregunta pre;
	RespuestaPregunta res;
	@Before
	public void setUp() throws Exception {
		pre = new PreguntaRespuestaSimple("Prueba", true, -1, 4, true);
	}

	/**
	 * Prueba la funcionalidad para preguntas simples respondidas correctamente
	 */
	@Test
	public void testRespuestaPreguntaSimple() {
		res = new RespuestaSimple(pre, true);
		assertTrue(res.esCorrecta());
		assertTrue(res.CalcularNota() == 4);		
	}
	
	/**
	 * Prueba la funcionalidad para preguntas simples respondidas erróneamente
	 */
	@Test
	public void testRespuestaPreguntaSimple2() {
		res = new RespuestaSimple(pre, false);
		assertFalse(res.esCorrecta());
		assertTrue(res.CalcularNota() == -1);		
	}

	

}
