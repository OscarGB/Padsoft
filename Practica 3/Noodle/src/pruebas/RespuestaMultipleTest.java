package pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import contenido.Opciones;
import contenido.Pregunta;
import contenido.PreguntaRespuestaMultiple;
import respuestas.RespuestaMultiple;
import respuestas.RespuestaPregunta;

public class RespuestaMultipleTest {

	Pregunta pre;
	RespuestaPregunta res;

	Opciones o1;
	Opciones o2;
	Opciones o3;
	
	@Before
	public void setUp() throws Exception {
		o1 = new Opciones("Esta", true);
		o2 = new Opciones("Esta tambien", true);
		o3 = new Opciones("Esta no", false);
		pre = new PreguntaRespuestaMultiple("Prueba", true, -1, 4);
		pre.addOpcion(o1);
		pre.addOpcion(o2);
		pre.addOpcion(o3);
	}

	/**
	 * Prueba la funcionalidad para preguntas multiples que se contestan parcialmente
	 */
	@Test
	public void testRespuestaPreguntaMultiple() {
		ArrayList<Opciones> opc = new ArrayList<Opciones>();
		opc.add(o1);
		res = new RespuestaMultiple(pre, opc);
		assertFalse(res.esCorrecta());
		assertTrue(res.CalcularNota() == -1);
	}
	
	/**
	 * Prueba la funcionalidad para preguntas multiples que se contestan correctamente
	 */
	@Test
	public void testRespuestaPreguntaMultiple2() {
		ArrayList<Opciones> opc = new ArrayList<Opciones>();
		opc.add(o1);		
		opc.add(o2);
		res = new RespuestaMultiple(pre, opc);
		assertTrue(res.esCorrecta());
		assertTrue(res.CalcularNota() == 4);
		opc.add(o3);
		res = new RespuestaMultiple(pre, opc);
		assertFalse(res.esCorrecta());
		assertTrue(res.CalcularNota() == -1);
	}
	
	/**
	 * Prueba la funcionalidad para preguntas multiples que se contestan con exceso
	 */
	@Test
	public void testRespuestaPreguntaMultiple3() {
		ArrayList<Opciones> opc = new ArrayList<Opciones>();
		opc.add(o1);		
		opc.add(o2);
		opc.add(o3);
		res = new RespuestaMultiple(pre, opc);
		assertFalse(res.esCorrecta());
		assertTrue(res.CalcularNota() == -1);
	}
}
