public class Node {
	
	private int value;
	private int weight;
	
	//Constructor that is used to create Nodes in the weighted graphs.
	protected Node (int nextNode, int weight){
		setNode(nextNode);
		setWeight(weight);
	}
	
	protected Node(int nextNode) {	
		setNode(nextNode);
	}
	
	private void setNode(int value){
		this.value = value;
	}
	
	private void setWeight(int value){
		this.weight = value;
	}
	
	protected int getNode(){
		return value; 
	}
	
	protected int getWeight(){
		return weight;
	}

}//End Node