package pruebas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import contenido.Opciones;
import contenido.Pregunta;
import contenido.PreguntaRespuestaSimple;

/**
 * Test de PreguntaRespuestaSimple
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 28/03/2017
 */
public class PreguntaRespuestaSimpleTest {

	private String enunciado;
	
	@Before
	public void setUp() throws Exception{
		enunciado = "2 + 2 son 4?";
	}
	
	/**
	 * Test para comprobar la creación de una pregunta
	 */
	@Test
	public void testPregunta1() {
		PreguntaRespuestaSimple preg = new PreguntaRespuestaSimple(enunciado, 
				true, 0, 1, true);
		assertEquals(preg.getEnunciado(), enunciado);
		assertTrue(preg.getPenalizacion() == 0.f);
		assertTrue(preg.getValorPregunta() == 1);
		assertTrue(preg.getRespuesta());
		assertTrue(preg.getNumCorrectas() == 0);
		assertTrue(preg.getNumRespuestas() == 0);
		assertTrue(preg.getOpciones().isEmpty());
		assertTrue(preg.getAleatorio() == true);
	}
	
	/**
	 * Test para comprobar la creacion sin penalizacion (por defecto)
	 */
	@Test
	public void testPregunta2(){
		PreguntaRespuestaSimple preg = new PreguntaRespuestaSimple(enunciado, 
				true, 1, true);
		assertTrue(preg.getPenalizacion() == preg.getPenalizacionDefecto());
		assertEquals(preg.getEnunciado(), enunciado);
		assertTrue(preg.getValorPregunta() == 1);
		assertTrue(preg.getRespuesta());
		assertTrue(preg.getNumCorrectas() == 0);
		assertTrue(preg.getNumRespuestas() == 0);
		assertTrue(preg.getOpciones().isEmpty());
		assertTrue(preg.getAleatorio() == true);
	}
	
	/**
	 * Test para penalización positiva
	 */
	@Test
	public void testPregunta3(){
		PreguntaRespuestaSimple preg = new PreguntaRespuestaSimple(enunciado, 
				true, 2, 1, true);
		
		assertTrue(preg.getPenalizacion() <= 0);
	}
	
	/**
	 * Test para valor pregunta negativo
	 */
	@Test
	public void testPregunta4(){
		PreguntaRespuestaSimple preg = new PreguntaRespuestaSimple(enunciado, 
				true, -1, -1, true);
		
		assertTrue(preg.getValorPregunta() >= 0);
	}
	
	/**
	 * Test para comprobar que no se pueden añadir opciones
	 */
	@Test
	public void testPreguntaAddOpcion(){
		PreguntaRespuestaSimple preg = new PreguntaRespuestaSimple(enunciado, 
				true, -1, 1, true);
		Opciones op = new Opciones("Si", true);
		
		assertFalse(preg.addOpcion(op));
		assertFalse(preg.addOpcion("Si"));
	}
	
	/**
	 * Test para addRespondida
	 */
	@Test
	public void testPreguntaAddRespondida(){
		PreguntaRespuestaSimple preg = new PreguntaRespuestaSimple(enunciado, 
				true, -1, 1, true);
		
		preg.addRespondida();
		assertTrue(preg.getNumRespuestas() == 1);
		assertTrue(preg.getNumCorrectas() == 0);
	}
	
	/**
	 * Test para addCorrecta
	 */
	@Test
	public void testPreguntaAddCorrecta(){
		PreguntaRespuestaSimple preg = new PreguntaRespuestaSimple(enunciado, 
				true, -1, 1, true);
		
		preg.addCorrecta();
		assertTrue(preg.getNumRespuestas() == 1);
		assertTrue(preg.getNumCorrectas() == 1);
	}
	
	
}
