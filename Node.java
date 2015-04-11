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
	
	protected void setLeft(Node n){
		this.left = n;
		n.setParent(this);
	}
	
	protected void setNode(int value){
		this.value = value;
	}
	
	protected void setParent(Node n){
		this.parent = n;
	}
	
	protected void setRight(Node n){
		this.right = n;
		n.setParent(this);
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