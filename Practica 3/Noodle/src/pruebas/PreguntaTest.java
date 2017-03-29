package pruebas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import contenido.*;

public class PreguntaTest {

	Pregunta pre;
	
	@Before
	public void setUp() throws Exception {
		pre = new PreguntaRespuestaSimple("Hola", false, -2, 5, true);
	}

	@Test
	public void testCreador() {
		
		
	}

}
