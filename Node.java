public class Node {
	
	private int value;
	private int weight;
	private int frequency;
	private Node left;
	private Node right;
	private Node parent;
	private NodeColor color;
	private char character;
	
	//Constructor that is used to create Nodes in the weighted graphs.
	protected Node(int nextNode, int weight){
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
	}
	
	protected void setNode(int value){
		this.value = value;
	}
	
	protected void setChar(char c){
		this.character = c;
	}
	
	protected void setColor(NodeColor nodeColor){
		this.color = nodeColor;
	}
	
	protected void setFreq(int i){
		this.frequency = i;
	}
	
	protected void setParent(Node n){
		this.parent = n;
	}
	
	protected void setRight(Node n){
		this.right = n;
	}
	
	private void setWeight(int value){
		this.weight = value;
	}
	
	protected char getChar(){
		return this.character;
	}
	
	protected NodeColor getColor(){
		return this.color;
	}
	
	protected int getFreq(){
		return this.frequency;
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

	//Enums used to set and determine Node color.
	public enum NodeColor{
		Red("red"),Black("black");
		private String color;
		private NodeColor(String color){
			this.color = color;
		}
		public String getColor(){
			return this.color;
		}
	}
}//End Node