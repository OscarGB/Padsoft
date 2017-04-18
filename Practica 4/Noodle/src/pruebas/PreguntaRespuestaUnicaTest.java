package pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import contenido.Opciones;
import contenido.PreguntaRespuestaUnica;
import plataforma.Plataforma;

public class PreguntaRespuestaUnicaTest {
	
	private PreguntaRespuestaUnica preg;
	private String enunciado;
	private Opciones true1;
	
	@Before
	public void setUp() throws Exception{
		File file = new File("./data/plataforma");
		file.delete();
		Plataforma.openPlataforma();
		Plataforma.login(Plataforma.profesor().getNia(), Plataforma.profesor().getPassword());
		enunciado = "Elige una opcion";
		preg = new PreguntaRespuestaUnica(enunciado,
				 true, 0.f, 1);
		true1 = new Opciones("1", true);
	}
	
	/**
	 * Test para preguntaRespuestaUnica
	 */
	@Test
	public void testPreguntaUnica1(){
		PreguntaRespuestaUnica preg1 = new PreguntaRespuestaUnica(enunciado,
				 true, 0.f, 1);
		
		assertEquals(preg1.getEnunciado(), enunciado);
		assertTrue(preg1.getPenalizacion() == 0.f);
		assertTrue(preg1.getValorPregunta() == 1);
		assertTrue(preg1.getOpciones().isEmpty());
		assertTrue(preg1.getNumCorrectas() == 0);
		assertTrue(preg1.getNumRespuestas() == 0);
		assertTrue(preg1.getOpciones().isEmpty());
		assertTrue(preg1.getAleatorio() == true);
				
	}
	
	/**
	 * Test para preguntaRespuestaUNica
	 */
	@Test
	public void testPreguntaUnica2(){
		PreguntaRespuestaUnica preg1 = new PreguntaRespuestaUnica(enunciado,
				 true, 1);
		
		assertEquals(preg1.getEnunciado(), enunciado);
		assertTrue(preg1.getPenalizacion() == preg.getPenalizacionDefecto());
		assertTrue(preg1.getValorPregunta() == 1);
		assertTrue(preg1.getOpciones().isEmpty());
		assertTrue(preg1.getNumCorrectas() == 0);
		assertTrue(preg1.getNumRespuestas() == 0);
		assertTrue(preg1.getOpciones().isEmpty());
		assertTrue(preg1.getAleatorio() == true);
				
	}
	
	/**
	 * Test para añadir opciones
	 */
	@Test
	public void testAddOpcion1(){
		assertTrue(preg.addOpcion(true1));
		assertTrue(preg.getOpciones().contains(true1));
	}
	
	/**
	 * Test para añadir opciones null
	 */
	@Test
	public void testAddOpcion2(){
		assertFalse(preg.addOpcion((Opciones)null));
		assertTrue(preg.getOpciones().isEmpty());
	}
	
	/**
	 * Test para añadir opciones string
	 */
	@Test
	public void testAddOpcion3(){
		assertFalse(preg.addOpcion(enunciado));
		assertTrue(preg.getOpciones().isEmpty());
	}
	
	/**
	 * Test para borrar opcion
	 */
	@Test
	public void testRemoveOpcion(){
		preg.addOpcion(true1);
		preg.removeOpcion(true1);
		assertFalse(preg.getOpciones().contains(true1));
	}
	
	/**
	 * Test para bienFormada
	 */
	@Test
	public void testBienFormada1(){
		preg.addOpcion(true1);
		assertTrue(preg.bienFormada());
	}
	
	/**
	 * Test para bienFormada con todas falsas
	 */
	@Test
	public void testBienFormada2(){
		Opciones falsa = new Opciones("5", false);
		preg.addOpcion(falsa);
		assertFalse(preg.bienFormada());
	}
	
	/**
	 * Test para bienFormada con opciones vacío
	 */
	@Test
	public void testBienFormada3(){
		assertFalse(preg.bienFormada());
	}
	
	/**
	 * Test para bienFormada con dos verdaderas
	 */
	@Test
	public void testBienFormada4(){
		Opciones true2 = new Opciones("2", true);
		
		preg.addOpcion(true1);
		preg.addOpcion(true2);
		
		assertTrue(preg.getOpciones().size() == 2);
		assertFalse(preg.bienFormada());
	}
	
	
}
