package pruebas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import contenido.Pregunta;
import contenido.PreguntaRespuestaSimple;
import respuestas.RespuestaPregunta;
import respuestas.RespuestaSimple;

public class RespuestaPreguntaTest {

	Pregunta pre;
	RespuestaPregunta res;
	
	@Before
	public void setUp() throws Exception {
		pre = new PreguntaRespuestaSimple("Prueba", true, -1, 4, true);
	}

	/**
	 * Comprobar que se actualizan los campos de pregunta correcta
	 */
	@Test
	public void testRespuestaPregunta() {
		res = new RespuestaSimple(pre, true);
		res.CalcularNota();
		assertTrue(pre.getNumCorrectas() == 1);
		assertTrue(pre.getNumRespuestas() == 1);
	}
	
	/**
	 * Comprobar que se actualizan los campos de pregunta errónea
	 */
	@Test
	public void testRespuestaPregunta2() {
		res = new RespuestaSimple(pre, false);
		res.CalcularNota();
		assertTrue(pre.getNumCorrectas() == 0);
		assertTrue(pre.getNumRespuestas() == 1);		
	}
	
	/**
	 * Comprobar que no se actualizan los campos de pregunta correcta dos veces
	 */
	@Test
	public void testRespuestaPregunta3() {
		res = new RespuestaSimple(pre, true);
		res.CalcularNota();
		res.CalcularNota();
		assertTrue(pre.getNumCorrectas() == 1);
		assertTrue(pre.getNumRespuestas() == 1);
	}
	
	/**
	 * Comprobar que no se actualizan los campos de pregunta errónea dos veces
	 */
	@Test
	public void testRespuestaPregunta4() {
		res = new RespuestaSimple(pre, false);
		res.CalcularNota();
		res.CalcularNota();
		assertTrue(pre.getNumCorrectas() == 0);
		assertTrue(pre.getNumRespuestas() == 1);		
	}

}
