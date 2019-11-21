package grafo;
import nodo.Nodo;
import arista.Aristas;
import java.util.*;

import org.json.JSONObject;

public class Grafo {
	private int id;
	private List<Nodo> nodes = new ArrayList<>();
	private List<Aristas> edges  = new ArrayList<>();
	
	public Grafo(int id){
		this.id = id;
		
	}
	public int get_id(){
		return this.id;
	}
	//crea nodo en el grafo
	public void post_node(JSONObject entity) {
		Nodo node = new Nodo(entity, entity.optInt("id")); // crea nodo con sus atributos
		this.nodes.add(node); //mete nodo al grafo

	}
	//retorna lista de nodos
	public List<Nodo> get_node() {
		return this.nodes;
		
	}
	//Actualiza el entity del nodo que posee el id
	public void put_node(JSONObject entity, int id) {
		for (int i=0; i<this.nodes.size();i++) {
			if (this.nodes.get(i).get_id() == id) {
				this.nodes.get(i).setEntity(entity);
				break;
			}
		}
			
		}
	//elimina nodo de id
	public void delete_node(int id) {
		for (int i=0; i<this.nodes.size();i++) {
			if (this.nodes.get(i).get_id() == id) {
				this.nodes.remove(i);
				break;
			}
		}
		
	}
	//elimina todos los nodos de la lista
	public void delete_nodes() {
		this.nodes.clear();
	}
	//retorna las aristas de la lista
	public List<Aristas> get_edges() {
		return this.edges;
	}
	//elimina todas las aristas del grafo
	public void delete_edges() {
		this.edges.clear();
	}
	//crea nueva arista
	public void post_edges(int startNode, int endNode, int weight, int id) {
		Aristas edge = new Aristas(id,startNode, endNode, weight); 
		for (int i=0; i<this.nodes.size();i++) {
			if (this.nodes.get(i).get_id() == startNode) {
				this.nodes.get(i).setoutDegree(1);
			}
			if (this.nodes.get(i).get_id() == endNode) {
				this.nodes.get(i).setinDegree(1);
			}
		}
		this.edges.add(edge); //mete la arista al grafo
	}
	//Actualiza el arista
	public void put_edges(int id, int startNode, int endNode, int weight) {
		for (int i=0; i<this.edges.size();i++) {
			if (this.edges.get(i).get_id() == id) {
				for (int j=0; j<this.nodes.size();j++) {
					if (this.nodes.get(j).get_id() == this.edges.get(i).get_start()) {
						this.nodes.get(j).setoutDegree(-1);
					}
					if (this.nodes.get(j).get_id() == this.edges.get(i).get_end()) {
						this.nodes.get(j).setinDegree(-1);
					}
					if (this.nodes.get(j).get_id() == startNode) {
						this.nodes.get(j).setoutDegree(1);
					}
					if (this.nodes.get(j).get_id() == endNode) {
						this.nodes.get(j).setinDegree(1);
					}
				}
				this.edges.get(i).setStart(startNode);
				this.edges.get(i).setEnd(endNode);
				this.edges.get(i).setWeight(weight);
			
				break;
			}
		}
		
	}
	//elimina el arista
	public void delete_edge(int id) {
		for (int i=0; i<this.edges.size();i++) {
			if (this.edges.get(i).get_id() == id) {
				for (int j=0; j<this.nodes.size();j++) {
					if (this.nodes.get(j).get_id() == this.edges.get(i).get_start()) {
						this.nodes.get(j).setoutDegree(-1);
					}
					if (this.nodes.get(j).get_id() == this.edges.get(i).get_end()) {
						this.nodes.get(j).setinDegree(-1);
					}
				}
				this.edges.remove(i);
				break;
			}
		}
	}
	private static void bubble_srt(List<Nodo> nodes) {
         int n = nodes.size();
         int k;
         for (int m = 0; m < n; m++) {
             for (int i = 0; i < n - 1; i++) {
                 k = i + 1;
                 if (nodes.get(i).getprom() > nodes.get(k).getprom()) {
                	 Collections.swap(nodes, i, k); 
                 }
             }
         }
     }
//array de objetos node ordenados por su grado prom en sort
	public List<Nodo> get_degrees(String sort) {
		List<Nodo> aux = nodes;
		bubble_srt(aux);
		if (sort == "DESC") {
			Collections.reverse(aux);
		}
		return aux;
		}
	public List<Nodo> get_dikjstra(int start, int end){
		List<Integer> sinvisitar = new ArrayList<>();
		List<Integer> visitado = new ArrayList<>();
		List<Nodo> path = new ArrayList<>();
		int aux = -1;
		sinvisitar.add(start);
		while (sinvisitar.size() != 0) {
			if(!(visitado.contains(sinvisitar.get(0)))) {
				if (sinvisitar.get(0) == end) {
					break;
				}
				for (int i=0; i<this.nodes.size();i++) {
					if (this.nodes.get(i).get_id() == sinvisitar.get(0)) {
						this.nodes.get(i).root = aux;
						break;
					}
				}
				for (int i=0; i<this.edges.size();i++) {
					if (this.edges.get(i).get_start() == sinvisitar.get(0)) {
						sinvisitar.add(this.edges.get(i).get_end());
					}
				}
				aux = sinvisitar.get(0);
				visitado.add(sinvisitar.get(0));
				sinvisitar.remove(0);
			}
			else {
				sinvisitar.remove(0);
			}
		}
		for (int i=0; i<this.nodes.size();i++) {
			if (this.nodes.get(i).get_id() == sinvisitar.get(0)) {
				path.add(this.nodes.get(i));
				break;
			}
		}
		while(aux != -1) {
			for (int i=0; i<this.nodes.size();i++) {
				if (this.nodes.get(i).get_id() == aux) {
					path.add(this.nodes.get(i));
					aux = this.nodes.get(i).root;
					break;
				}
			}
		}
		Collections.reverse(path);
		return path;
		
	}
}

