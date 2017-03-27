package main;

import asignatura.Asignatura;
import contenido.Apuntes;
import contenido.Tema;

public class test_tema {

	public static void main(String[] args) {
		
		Asignatura mates = new Asignatura("Mates");
		
		//Crea un tema en el directorio raiz
		Tema tema1 = new Tema("Tema 1", true, mates);
		
		System.out.println(mates);
		
		//Crea un subtema en tema 1
		Tema tema11 = new Tema("Tema 1.1", true, mates, tema1);
		
		if(tema1.getSubcontenido().contains(tema11)){
			System.out.println("SIIIIIIIIIIIIIIIIIIII\n");
		}
		
		System.out.println(mates);
		
		//Crea otro tema en la raiz
		Tema tema2 = new Tema("Tema 2", true, mates);
		
		//Añade apuntes al tema 1
		Apuntes apuntes1 = new Apuntes("Estos son los apuntes", "Apuntes 1", true, mates, tema1);
		
		System.out.println(mates);
		
		//Borra un subtema del tema 1
		tema1.eraseSubcontenido(tema11);
		
		System.out.println(tema1);
		
		mates.eraseContenido(tema1);
		
		System.out.println(tema1);
		

	}

}
