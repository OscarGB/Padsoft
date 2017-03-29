package pruebas;

import static org.junit.Assert.*;

import java.io.File;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import asignatura.Asignatura;
import contenido.Ejercicio;
import contenido.Pregunta;
import contenido.PreguntaRespuestaSimple;
import estadisticas.EstadisticasAlumno;
import persona.Alumno;
import plataforma.Plataforma;
import respuestas.RespuestaEjercicio;
import respuestas.RespuestaPregunta;
import respuestas.RespuestaSimple;

/**
 * Test EstadisticasAlumno
 * @author Jose Ignacio Gomez
 * @author Oscar Gomez
 * @date 28/03/2017
 */
public class EstadisticasAlumnoTest {
	Alumno al;
	Asignatura asig;
	EstadisticasAlumno est;
	RespuestaEjercicio res;
	RespuestaEjercicio res2;
	Pregunta pregunta;
	Pregunta pregunta2;
	Ejercicio ej;
	Ejercicio ej2;
	RespuestaPregunta pre;
	RespuestaPregunta pre2;
	
	@Before
	public void setUp() throws Exception {
		al = Alumno.CreaAlumno("1234", "Pedro", "Pe12", "pedro@gmail.com");
		asig = new Asignatura("mates");
		Plataforma.openPlataforma();
	}
	
	@After
	public void close() throws Exception {
		Plataforma.closePlataforma();
	}

	/**
	 * Comporobar que se crea correctamente
	 */
	@Test
	public void EstadisticasTest1() {
		asig.addAlumno(al);
		est = EstadisticasAlumno.newEstadisticasAlumno(asig, al);
		assertTrue(est != null);
	}
	
	/**
	 * Comporobar que no se crea si el alumno no esta en la asignatura
	 */
	@Test
	public void EstadisticasTest2() {
		est = EstadisticasAlumno.newEstadisticasAlumno(asig, al);
		assertTrue(est == null);
	}
	
	/**
	 * Comporobar que no se crea si alguno de los parametros es null
	 */
	@Test
	public void EstadisticasTest3() {
		asig.addAlumno(al);
		est = EstadisticasAlumno.newEstadisticasAlumno(null, al);
		assertTrue(est == null);
		est = EstadisticasAlumno.newEstadisticasAlumno(asig, null);
		assertTrue(est == null);
	}
	
	/**
	 * Añadir una respuesta a un ejercicio y comprobar que se actualiza la nota media
	 */
	@Test
	public void EstadisticasTest4() {
		asig.addAlumno(al);
		est = EstadisticasAlumno.newEstadisticasAlumno(asig, al);
		pregunta = new PreguntaRespuestaSimple("Prueba", false, -4, 4, true);
		ej = new Ejercicio(8, false, Plataforma.getFechaActual(), Plataforma.getFechaActual().plusDays(3), "titulo", true, asig);
		ej.addPregunta(pregunta);
		res = new RespuestaEjercicio(ej);
		pre = new RespuestaSimple(pregunta, true);
		res.addRespuesta(pre);
		assertTrue(res.calcularNota() == 10);
		est.addRespuestaEjercicio(res);
		assert(est.getNotaMedia() == 10);
		
	}
	
	/**
	 * Añadir mas de una respuesta a un ejercicio y comprobar que se actualiza la nota media
	 */
	@Test
	public void EstadisticasTest5() {
		asig.addAlumno(al);
		est = EstadisticasAlumno.newEstadisticasAlumno(asig, al);
		pregunta = new PreguntaRespuestaSimple("Prueba", false, -4, 4, true);
		pregunta2 = new PreguntaRespuestaSimple("Prueba2", false, -8, 6, false);
		ej = new Ejercicio(6, false, Plataforma.getFechaActual(), Plataforma.getFechaActual().plusDays(3), "titulo", true, asig);
		ej.addPregunta(pregunta);
		ej2 = new Ejercicio(4, false, Plataforma.getFechaActual(), Plataforma.getFechaActual().plusDays(3), "titulo", true, asig);
		ej2.addPregunta(pregunta2);
		res = new RespuestaEjercicio(ej);
		res2 = new RespuestaEjercicio(ej2);
		//Correcta
		pre = new RespuestaSimple(pregunta, true);
		res.addRespuesta(pre);
		//Erronea
		pre2 = new RespuestaSimple(pregunta2, true);
		res2.addRespuesta(pre2);
		assertTrue(res2.calcularNota() == 0);
		assertTrue(res.calcularNota() == 10);
		est.addRespuestaEjercicio(res2);
		est.addRespuestaEjercicio(res);
		assertTrue(est.getNotaMedia() == 6);		
	}

}
