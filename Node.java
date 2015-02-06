public class Node {
	
	private int value;
	
	//This constructor handles unweighted graphs.
	public Node(int nextNode) {	
		setNode(nextNode);
		G.nodeCount++;
	}
	
	private void setNode(int value){
		this.value = value;
	}
	
	public int getNode(){
		return value; 
	}

}//End Node
