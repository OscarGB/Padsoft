package pruebas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import contenido.*;
import respuestas.*;

public class RespuestaAbiertaTest {
	
	Pregunta pre;
	RespuestaPregunta res;
	
	@Before
	public void setUp() throws Exception {
		pre = new PreguntaRespuestaAbierta("Prueba", true, -1, 4);
		pre.addOpcion("1");
		pre.addOpcion("uno");
	}
	
	/**
	 * Prueba la funcionalidad para preguntas abiertas contestada correctamente
	 */
	@Test
	public void testRespuestaPreguntaAbierta() {
		res = new RespuestaAbierta(pre, "uno");
		assertTrue(res.esCorrecta());
		assertTrue(res.CalcularNota() == 4);	
	}
	
	/**
	 * Prueba la funcionalidad para preguntas abiertas contestada erróneamente
	 */
	@Test
	public void testRespuestaPreguntaAbierta2() {
		res = new RespuestaAbierta(pre, "Mola");
		assertFalse(res.esCorrecta());
		assertTrue(res.CalcularNota() == -1);		
	}

}
