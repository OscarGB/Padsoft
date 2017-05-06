package interfaz.asignatura.asignaturaGUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import asignatura.Asignatura;
import contenido.Apuntes;
import contenido.Contenido;
import contenido.Ejercicio;
import contenido.Tema;
import interfaz.genericos.NoodleFrame;
import persona.Alumno;
import persona.Profesor;
import plataforma.Plataforma;

class SelectionListener implements TreeSelectionListener {

	  public void valueChanged(TreeSelectionEvent se) {
	    JTree tree = (JTree) se.getSource();
	    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
	        .getLastSelectedPathComponent();
	    Object obj = selectedNode.getUserObject();
	    if(selectedNode.isRoot() == true){
	    	AsignaturaGUI padre = NoodleFrame.getInstance().getAsignaturaGUI();
	    	padre.escondeLateral();
	    }
	    if(obj instanceof Tema){
	    	if(Plataforma.loggedAs() instanceof Profesor){
		    	AsignaturaGUI padre = NoodleFrame.getInstance().getAsignaturaGUI();
		    	padre.showLateral((Tema) obj);
	    	}
	    }
	    else if (selectedNode.isLeaf()) {
	    	if(obj instanceof Apuntes){
	    		NoodleFrame.getInstance().showApuntes(true, (Apuntes)obj);
	    	}
	    	if(obj instanceof Ejercicio){
	    		NoodleFrame.getInstance().showEjercicioGUI(true, (Ejercicio)obj, ((Ejercicio) obj).getPadre());
	    	}
	    	
	    }
	  }
	}

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

	/**
	 * Constructor de TreeContent
	 * @param frame
	 * @param asignatura
	 */
	public TreeContent(NoodleFrame frame, Asignatura asignatura) {
		this.frame = frame;
		this.setBackground(Color.WHITE);
		
		this.raiz = asignatura.getRaiz();
		
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(asignatura.getNombre());
		createNodes(top, this.raiz);
		arbol = new JTree(top);
		
		 arbol.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		 arbol.addTreeSelectionListener(new SelectionListener());
		
		JScrollPane treeView = new JScrollPane(arbol);
		
		
		this.add(treeView);
		
		treeView.setPreferredSize(new Dimension(200,300));
	}
	
	private void createNodes(DefaultMutableTreeNode top, ArrayList<Contenido> sub){
		DefaultMutableTreeNode contenido;
		
		if(Plataforma.loggedAs() instanceof Alumno){
			for(Contenido cont:sub){
				if(cont.getVisibilidad() == true){
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

	}
	
	

}
