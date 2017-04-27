package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import asignatura.Asignatura;
import contenido.Contenido;
import contenido.Tema;
import persona.Alumno;
import plataforma.Plataforma;

public class TreeContent extends JPanel{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Arbol de contenidos
	 */
	private JTree arbol;
	
	/**
	 * Contenido almacenado en la raiz de la asignatura
	 */
	private ArrayList<Contenido> raiz;
	
	/**
	 * Frame
	 */
	private NoodleFrame frame;

	public TreeContent(NoodleFrame frame, Asignatura asignatura) {
		this.frame = frame;
		this.setBackground(Color.WHITE);
		
		this.raiz = asignatura.getRaiz();
		
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(asignatura.getNombre());
		createNodes(top, this.raiz);
		arbol = new JTree(top);
		
		JScrollPane treeView = new JScrollPane(arbol);
		
		this.add(treeView);
		
		treeView.setPreferredSize(new Dimension(200,300));
		
		
	}
	
	private void createNodes(DefaultMutableTreeNode top, ArrayList<Contenido> sub){
		DefaultMutableTreeNode contenido;
//		DefaultMutableTreeNode prueba;
//
//		prueba = new DefaultMutableTreeNode(new Tema("Tema 1", true, new Asignatura("Mates")));
//		
//		
//		contenido = new DefaultMutableTreeNode("Tema 2");
//		prueba.add(contenido);
//		top.add(prueba);
		
		System.out.println(sub);
		
		if(Plataforma.loggedAs() instanceof Alumno){
			for(Contenido cont:sub){
				if(cont.getVisibilidad() == true){
					contenido = new DefaultMutableTreeNode(cont);
					if(cont instanceof Tema){
						sub = ((Tema) cont).getSubcontenido();
						if(sub.size() > 1){
							createNodes(contenido, sub);
						}
					}
					
					top.add(contenido);
				}
			}
		}
		else{
			for(Contenido cont:sub){
				contenido = new DefaultMutableTreeNode(cont);
				if(cont instanceof Tema){
					sub = ((Tema) cont).getSubcontenido();
					if(sub.size() > 0){
						createNodes(contenido, sub);
					}
				}
				
				top.add(contenido);
			}
		}

//TODO Listeners para abrir los contenidos (ejercicios y apuntes)
//TODO al hacer login como alumno no muestra nada. Comprobar el visibility false		
	}

}
