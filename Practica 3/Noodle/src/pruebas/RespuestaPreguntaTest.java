package pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import contenido.*;
import respuestas.*;


/**
 * Test Respuesta a Pregunta
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 28/03/2017
 */
public class RespuestaPreguntaTest {
	RespuestaPregunta res;
	Pregunta pre;

	/**
	 * Prueba la funcionalidad para preguntas simples
	 */
	@Test
	public void testRespuestaPreguntaSimple() {
		pre = new PreguntaRespuestaUnica("Prueba", true, -1, 4);
		Opciones correcta = new Opciones("Es", true);
		pre.addOpcion(correcta);
		if(pre.getClass() == PreguntaRespuestaUnica.class){
			assertTrue(true);
		}
		else{
			assertTrue(false);
		}
		res = new RespuestUnica(pre, correcta);
		assertTrue(res.esCorrecta());
		assertTrue(res.CalcularNota() == 4);
		res = new RespuestUnica(pre, new Opciones("Pre", false));
		assertFalse(res.esCorrecta());
		assertTrue(res.CalcularNota() == -1);		
	}
	
	/**
	 * Prueba la funcionalidad para preguntas unicas
	 */
	@Test
	public void testRespuestaPreguntaUnica() {
		pre = new PreguntaRespuestaSimple("Prueba", true, -1, 4, true);
		res = new RespuestaSimple(pre, false);
		assertFalse(res.esCorrecta());
		assertTrue(res.CalcularNota() == -1);
		res = new RespuestaSimple(pre, true);
		assertTrue(res.esCorrecta());
		assertTrue(res.CalcularNota() == 4);		
	}
	
	/**
	 * Prueba la funcionalidad para preguntas abiertas
	 */
	@Test
	public void testRespuestaPreguntaAbierta() {
		pre = new PreguntaRespuestaAbierta("Prueba", true, -1, 4);
		pre.addOpcion("Mola");
		res = new RespuestaAbierta(pre, "Moli");
		assertFalse(res.esCorrecta());
		assertTrue(res.CalcularNota() == -1);
		res = new RespuestaAbierta(pre, "Mola");
		assertTrue(res.esCorrecta());
		assertTrue(res.CalcularNota() == 4);		
	}
	
	/**
	 * Prueba la funcionalidad para preguntas multiples
	 */
	@Test
	public void testRespuestaPreguntaMultiple() {
		Opciones o1 = new Opciones("Esta", true);
		Opciones o2 = new Opciones("Esta tambien", true);
		Opciones o3 = new Opciones("Esta no", false);
		pre = new PreguntaRespuestaMultiple("Prueba", true, -1, 4);
		pre.addOpcion(o1);
		pre.addOpcion(o2);
		pre.addOpcion(o3);
		ArrayList<Opciones> opc = new ArrayList<Opciones>();
		opc.add(o1);
		res = new RespuestaMultiple(pre, opc);
		assertFalse(res.esCorrecta());
		assertTrue(res.CalcularNota() == -1);
		opc.add(o2);
		res = new RespuestaMultiple(pre, opc);
		assertTrue(res.esCorrecta());
		assertTrue(res.CalcularNota() == 4);
		opc.add(o3);
		res = new RespuestaMultiple(pre, opc);
		assertFalse(res.esCorrecta());
		assertTrue(res.CalcularNota() == -1);
	}

}
