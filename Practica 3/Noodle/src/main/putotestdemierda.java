package main;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import contenido.Opciones;
import contenido.Pregunta;
import contenido.PreguntaRespuestaMultiple;
import respuestas.RespuestaMultiple;
import respuestas.RespuestaPregunta;

public class putotestdemierda {
	
	public static void main(String[] args) {
		RespuestaPregunta res;
		Pregunta pre;
		Opciones o1 = new Opciones("Esta", true);
		Opciones o2 = new Opciones("Esta tambien", true);
		Opciones o3 = new Opciones("Esta no", false);
		pre = new PreguntaRespuestaMultiple("Prueba", false, -1, 4);
		((PreguntaRespuestaMultiple)pre).addOpcion(o1);
		((PreguntaRespuestaMultiple)pre).addOpcion(o2);
		((PreguntaRespuestaMultiple)pre).addOpcion(o3);
		ArrayList<Opciones> opc = new ArrayList<Opciones>();
		opc.add(o1);
		res = new RespuestaMultiple(pre, opc);
		if(!res.esCorrecta()){
			System.out.println("OK1");
		}
		if(res.CalcularNota() == -1){
			System.out.println("OK2");
		}
		opc.add(o2);
		res = new RespuestaMultiple(pre, opc);
		if(res.esCorrecta()){
			System.out.println("OK3");
		}
		if(res.CalcularNota() == 4){
			System.out.println("OK4");
		}
		opc.add(o3);
		res = new RespuestaMultiple(pre, opc);
		if(!res.esCorrecta()){
			System.out.println("OK5");
		}
		if(res.CalcularNota() == -1){
			System.out.println("OK6");
		}
	}
}
