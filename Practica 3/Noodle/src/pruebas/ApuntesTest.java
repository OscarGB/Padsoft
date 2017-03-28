package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import asignatura.Asignatura;
import contenido.Apuntes;
import contenido.Tema;

/**
 * Test de Apuntes
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 28/03/2017
 */
public class ApuntesTest {
	
	Asignatura mates = new Asignatura("Mates");
	Tema tema1 = new Tema("Tema 1", true, mates);
	String texto = "Estos son los apuntes";
	String titulo = "Apuntes tema 1";

	/**
	 * Test para crear unos apuntes en la raiz
	 */
	@Test
	public void testCrearApuntesRaiz(){
		Apuntes apuntes = new Apuntes(texto, titulo, true, mates);
		
		assertTrue(mates.getRaiz().contains(apuntes));
		assertEquals(apuntes.getTexto(), texto);
		assertEquals(apuntes.getTitulo(),titulo);
	}
	
	/**
	 * Test para crear unos apuntes en un tema
	 */
	@Test
	public void testCrearApuntesTema(){
		Apuntes apuntes = new Apuntes(texto, titulo, true, mates, tema1);
		
		assertTrue(tema1.getSubcontenido().contains(apuntes));
		assertEquals(apuntes.getTexto(), texto);
		assertEquals(apuntes.getTitulo(), titulo);
	}
	
}
