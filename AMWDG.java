import java.util.*;

public class AMWDG extends G{
	
	private static Node[][] weightedMatrix = new Node[Tester.size][Tester.size];
	
	public AMWDG(){
	}
	
	protected static boolean existEdge(Edge e){
		Node node1 = e.getVertex1();
		Node node2 = e.getVertex2();
		if (node1.getNode() < Tester.size && node2.getNode() < Tester.size){
			if (weightedMatrix[node1.getNode()][node2.getNode()] != null)
				return true;
			else
				return false;
		}	
		else
			return false;
	}
	
	protected boolean existEdge(int i, int j){
		if (weightedMatrix[i][j] != null)
			return true;
		else
			return false;
	}
	
	protected void putEdge(Edge edge){
		if (!existEdge(edge)){
			Node node1 = edge.getVertex1();
			Node node2 = edge.getVertex2();
			weightedMatrix[node1.getNode()][node2.getNode()] = node2;
		}
	}

	protected void putEdge(int i, int j) {
		Node node = new Node(j, 1);
		weightedMatrix[i][j] = node;
	}
	
	protected void putEdge(int i, int j, int k) {
		Node node = new Node(j, k);
		weightedMatrix[i][j] = node;
	}

	protected static void removeEdge(Edge e) {
		if (existEdge(e)){
			Node node1 = e.getVertex1();
			Node node2 = e.getVertex2();
			weightedMatrix[node1.getNode()][node2.getNode()] = null;
		}	
	}

	protected void removeEdge(int i, int j) {
		weightedMatrix[i][j] = null;
	}
	
	protected static ArrayList<Node> adjacentVertices(Node i){
		ArrayList<Node> adjNodes = new ArrayList<Node>();
		for (int j = 1; j < weightedMatrix.length; j++){
			if (weightedMatrix[i.getNode()][j] != null)
				adjNodes.add(weightedMatrix[i.getNode()][j]);
		}
		return adjNodes;
	}
	
	protected ArrayList<Node> adjacentVertices(int i){
		ArrayList<Node> adjNodes = new ArrayList<Node>();
		for (int j = 1; j < weightedMatrix.length; j++){
			if (weightedMatrix[i][j] != null)
				adjNodes.add(weightedMatrix[i][j]);
		}
		printAdj(i, adjNodes);
		return adjNodes;
	}
	
	protected static boolean areAdjacent(Node i, Node j){
		if (weightedMatrix[i.getNode()][j.getNode()] != null || weightedMatrix[j.getNode()][i.getNode()] != null)
			return true;
		else
			return false;
	}
	
	protected boolean areAdjacent(int i, int j){
		if (weightedMatrix[i][j] != null || weightedMatrix[j][i] != null)
			return true;
		return false;
	}
	
	protected static Node[][] getMatrix(){
		return weightedMatrix;
	}

	protected void initializeList() {
	}
	//Helper method to print contents of matrix in readable format.
	protected void print() {
		for (int i = 1; i < weightedMatrix.length; i++){
			for (int j = 1; j < weightedMatrix.length; j++){
				if (weightedMatrix[i][j] != null)
					Tester.writer.print(weightedMatrix[i][j].getWeight() + " ");
				else
					Tester.writer.print("0 ");
			}
			Tester.writer.println();
		}
	}
	//Helper method to print adjacent Nodes.
	protected void printAdj(int j, ArrayList<Node> i) {
		Iterator<Node> marker = i.iterator();
		while (marker.hasNext())
			Tester.writer.print(marker.next().getNode() + " ");
	}
}//End AMWDG