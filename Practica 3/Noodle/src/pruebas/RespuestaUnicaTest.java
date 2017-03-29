package pruebas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import contenido.*;
import respuestas.*;

public class RespuestaUnicaTest {
	
	Pregunta pre;
	RespuestaPregunta res;
	Opciones op;

	@Before
	public void setUp() throws Exception {
		pre = new PreguntaRespuestaUnica("Ej", false, 3, 6);
		pre.addOpcion(new Opciones("1", true));
		pre.addOpcion(new Opciones("2", false));
	}

	/**
	 * Prueba la funcionalidad para preguntas unicas contestadas correctamente
	 */
	@Test
	public void testRespuestaPreguntaUnica() {
		op = new Opciones("1", false);
		res = new RespuestaUnica(pre, op);
		assertTrue(res.esCorrecta());
		assertTrue(res.CalcularNota() == 6);
	}
	
	/**
	 * Prueba la funcionalidad para preguntas unicas contestadas erróneamente
	 */
	@Test
	public void testRespuestaPreguntaUnica2() {
		op = new Opciones("2", false);
		res = new RespuestaUnica(pre, op);
		assertFalse(res.esCorrecta());
		assertTrue(res.CalcularNota() == -3);
	}

}
