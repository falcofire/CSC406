public class Node {
	
	private int value;
	private int weight;
	private Node left;
	private Node right;
	private Node parent;
	
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
	
	@SuppressWarnings("unused")
	private void setLeft(Node n){
		this.left = n;
	}
	
	private void setNode(int value){
		this.value = value;
	}
	
	@SuppressWarnings("unused")
	private void setParent(Node n){
		this.parent = n;
	}
	
	@SuppressWarnings("unused")
	private void setRight(Node n){
		this.right = n;
	}
	
	private void setWeight(int value){
		this.weight = value;
	}
	
	protected Node getLeft(){
		return left;
	}
	
	protected int getNodeValue(){
		return value; 
	}
	
	protected Node getParent(){
		return parent;
	}
	
	protected Node getRight(){
		return right;
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