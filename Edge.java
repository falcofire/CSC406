
public class Edge {

	private Node vertex1;
	private Node vertex2;
	private int weight1;
	
	//Constructor for unweighted graph edges.
	protected Edge (int i, int j){
		Node node1 = new Node(i);
		Node node2 = new Node(j);
		setVertex1(node1);
		setVertex2(node2);
	}
	
	//Constructor for unweighted graph edges.
	protected Edge (Node i, Node j){
		setVertex1(i);
		setVertex2(j);
	}
	
	//Constructor for weighted graph edges.
	protected Edge (Node i, Node j, int weight){
		setVertex1(i);
		setVertex2(j);
		setWeight(weight);
	}
	
	//Constructor for weighted graph edges.
	protected Edge (int i, int j, int weight){
		Node node1 = new Node(i);
		Node node2 = new Node(j);
		setVertex1(node1);
		setVertex2(node2);
		setWeight(weight);
	}
	
	protected void setWeight(int weight){
		this.weight1 = weight;
	}
	
	protected int getWeight(){
		return weight1;
	}
	
	protected void setVertex1(Node v1){
		this.vertex1 = v1;
	}
	
	protected void setVertex2(Node v2){
		this.vertex2 = v2;
	}
	
	protected Node getVertex1(){
		return vertex1;
	}
	
	protected Node getVertex2(){
		return vertex2;
	}
}//End Edge
