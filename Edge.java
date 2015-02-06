
public class Edge {

	Node vertex1;
	Node vertex2;
	int weight1;
	
	public Edge (int i, int j){
		Node node1 = new Node(i);
		Node node2 = new Node(j);
		setVertex1(node1);
		setVertex2(node2);
	}
	
	//Constructor for unweighted graph edges.
	public Edge (Node i, Node j){
		setVertex1(i);
		setVertex2(j);
	}
	
	//Constructor for weighted graph edges.
	public Edge (Node i, Node j, int weight){
		setVertex1(i);
		setVertex2(j);
		setWeight(weight);
	}
	
	private void setWeight(int weight){
		this.weight1 = weight;
	}
	
	public int getWeight(){
		return weight1;
	}
	
	private void setVertex1(Node v1){
		this.vertex1 = v1;
	}
	
	private void setVertex2(Node v2){
		this.vertex2 = v2;
	}
	
	public Node getVertex1(){
		return vertex1;
	}
	
	public Node getVertex2(){
		return vertex2;
	}
}
