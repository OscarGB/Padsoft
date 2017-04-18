package pruebas;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import contenido.*;
import plataforma.Plataforma;
import respuestas.*;

/**
 * Test RespuestaUnica
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 07/03/2017
 */

public class RespuestaUnicaTest {
	
	Pregunta pre;
	RespuestaPregunta res;
	Opciones op;

	@Before
	public void setUp() throws Exception {
		File file = new File("./data/plataforma");
		file.delete();
		Plataforma.openPlataforma();
		Plataforma.login(Plataforma.profesor().getNia(), Plataforma.profesor().getPassword());
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
