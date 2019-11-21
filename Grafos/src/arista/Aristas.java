package arista;


public class Aristas {
	int id, start, end, weight;
	
	public Aristas(int id,int start, int end, int weight){
		this.id = id;
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	public int get_id(){
		return this.id;
	}
	public int get_start(){
		return this.start;
	}
	public int get_end(){
		return this.end;
	}
	public int get_weight(){
		return this.weight;
	}
	public void setStart(int start){
		this.start = start;
	}
	public void setEnd(int end){
		this.end = end;
	}
	public void setWeight(int weight){
		this.weight = weight;
	}
}
