package pruebas;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import contenido.Opciones;
import contenido.PreguntaRespuestaMultiple;
import plataforma.Plataforma;

/**
 * Test PreguntaRespuestaMultiple
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 28/03/2017
 */
public class PreguntaRespuestaMultipleTest {
	private PreguntaRespuestaMultiple preg;
	private String enunciado;
	private Opciones op1;
	
	@Before
	public void setUp() throws Exception{
		File file = new File("./data/plataforma");
		file.delete();
		Plataforma.openPlataforma();
		Plataforma.login(Plataforma.profesor().getNia(), Plataforma.profesor().getPassword());
		enunciado = "Elige una opcion";
		preg = new PreguntaRespuestaMultiple(enunciado,
				 true, 0.f, 1);
		op1 = new Opciones("1", true);
	}
	
	/**
	 * Test para preguntaRespuestaMultiple
	 */
	@Test
	public void testPreguntaMultiple1(){
		PreguntaRespuestaMultiple preg1 = new PreguntaRespuestaMultiple(enunciado,
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
	 * Test para preguntaRespuestaMultiple
	 */
	@Test
	public void testPreguntaMultiple2(){
		PreguntaRespuestaMultiple preg1 = new PreguntaRespuestaMultiple(enunciado,
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
		assertTrue(preg.addOpcion(op1));
		assertTrue(preg.getOpciones().contains(op1));
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
		preg.addOpcion(op1);
		preg.removeOpcion(op1);
		assertFalse(preg.getOpciones().contains(op1));
	}
	
	/**
	 * Test para bienFormada
	 */
	@Test
	public void testBienFormada1(){
		preg.addOpcion(op1);
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
}
