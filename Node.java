public class Node {
	
	private int value;
	
	protected Node(int nextNode) {	
		setNode(nextNode);
	}
	
	private void setNode(int value){
		this.value = value;
	}
	
	protected int getNode(){
		return value; 
	}

}//End Node