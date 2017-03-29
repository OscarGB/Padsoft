package pruebas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import contenido.Opciones;
import contenido.PreguntaRespuestaAbierta;

public class PreguntaRespuestaAbiertaTest {
	private PreguntaRespuestaAbierta preg;
	private String resp1;
	private String enunciado;
	
	@Before
	public void setUp() throws Exception{
		enunciado = "Introduce tu nombre: ";
		resp1 = "Nacho";
		preg = new PreguntaRespuestaAbierta(enunciado, true, 0.f, 1);
		
	}
	
	/**
	 * Test creación preguntaAbierta
	 */
	@Test
	public void testPreguntaAbierta1(){
		PreguntaRespuestaAbierta preg1 = new PreguntaRespuestaAbierta(enunciado, true, 0.f, 1);
		
		assertEquals(preg1.getEnunciado(), enunciado);
		assertTrue(preg1.getPenalizacion() == 0.f);
		assertTrue(preg1.getValorPregunta() == 1);
		assertTrue(preg1.getRespuestas().isEmpty());
		assertTrue(preg1.getAleatorio() == true);
	}
	
	/**
	 * Test creación preguntaAbierta con penalización por defecto
	 */
	@Test
	public void testPreguntaAbierta2(){
		PreguntaRespuestaAbierta preg1 = new PreguntaRespuestaAbierta(enunciado, true, 1);
		
		assertEquals(preg1.getEnunciado(), enunciado);
		assertTrue(preg1.getPenalizacion() == preg.getPenalizacionDefecto());
		assertTrue(preg1.getValorPregunta() == 1);
		assertTrue(preg1.getRespuestas().isEmpty());
		assertTrue(preg1.getAleatorio() == true);
	}
	
	/**
	 * Test para addOpcion
	 */
	@Test
	public void testAddOpcion1(){
		assertTrue(preg.addOpcion(resp1));
		assertFalse(preg.addOpcion((String)null));
	}
	
	/**
	 * Test para addOpcion con una opcion
	 */
	@Test
	public void testAddOpcion2(){
		Opciones op = new Opciones("2", true);
		assertFalse(preg.addOpcion((String)null));
		assertTrue(preg.getRespuestas().isEmpty());
	}
	
	@Test
	public void testRemoveOpcion(){
		preg.addOpcion(resp1);
		preg.removeOpcion(resp1);
		assertTrue(preg.getRespuestas().isEmpty());
	}
	
	/**
	 * Test para bienFormada
	 */
	@Test
	public void testBienFormada1(){
		preg.addOpcion(resp1);
		assertTrue(preg.bienFormada());
	}
	
	/**
	 * Test para bienFormada sin opciones
	 */
	@Test
	public void testBienFormada2(){
		assertFalse(preg.bienFormada());
	}
}
