public class Node {
	
	private int value;
	private int weight;
	
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

}//End Node