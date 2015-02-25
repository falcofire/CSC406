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
	
	protected Node (Node i){
		setNode(i.getNodeValue());
	}
	
	private void setNode(int value){
		this.value = value;
	}
	
	private void setWeight(int value){
		this.weight = value;
	}
	
	protected int getNodeValue(){
		return value; 
	}
	
	protected int getWeight(){
		return weight;
	}
	
	protected boolean equals(Node i, Node j){
		if (i.getNodeValue() == j.getNodeValue())
			return true;
		return false;
	}

}//End Node