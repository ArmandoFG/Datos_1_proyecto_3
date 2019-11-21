package main;
import java.util.List;

import org.json.JSONObject;

import arista.Aristas;
import grafo.Grafo;
import nodo.Nodo;
public class Prueba {

	public static void main(String[] args) {
		Grafo graph = new Grafo(74253);
		// Prueba de los nodos
		JSONObject json = new JSONObject();
		json.put("id",17563);
		graph.post_node(json);
		JSONObject j = new JSONObject();
		j.put("id",7583);
		graph.post_node(j);
		JSONObject j1 = new JSONObject();
		j1.put("id",7583);
		graph.put_node(j1,17563);
		JSONObject j2 = new JSONObject();
		j2.put("id",927);
		graph.post_node(j2);
		//graph.delete_node(17563);
		//graph.delete_nodes();
		List<Nodo> aux = graph.get_node();
		System.out.println("nodos");
		System.out.println(aux);
		
		//prueba de las aristas
		graph.post_edges(7583,17563,60,4);
		graph.post_edges(17563,7583,20,7);
		graph.put_edges(7,17563,927,5);
		//graph.delete_edge(7);
		//graph.delete_edges();
		List<Aristas> a1 = graph.get_edges();
		System.out.println("aristas");
		System.out.println(a1);
		
		//prueba de degrees
		List<Nodo> a2 =graph.get_degrees("ASC");
		System.out.println("degrees");
		System.out.println(a2);
		
		//prueba de dijkstra
		List<Nodo> a3 = graph.get_dikjstra(7583,927);
		System.out.println("dijkstra");
		System.out.println(a3);
		for (int i=0; i<a3.size();i++) {
			System.out.println(a3.get(i).get_id());
		}
	}

}
