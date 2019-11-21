package nodo;

import org.json.JSONObject;

//estructura del nodo
public class Nodo {
	private int id, inDegree, outDegree;
	private JSONObject entity = new JSONObject();
	public int root;
	
	public Nodo(JSONObject entity, int id){
		this.entity = entity;
		this.id = id;
	}
	public int get_id(){
		return this.id;
	}
	public JSONObject get_entity(){
		return this.entity;
	}
	public void setEntity(JSONObject entity){
		this.entity = entity;
	}
	public void setoutDegree(int outDegree) {
		this.outDegree = this.outDegree + outDegree;
	}
	public void setinDegree(int inDegree) {
		this.inDegree = this.inDegree + inDegree;
	}
	public int getprom() {
		return ((this.inDegree + this.outDegree)/2);
	}
}
