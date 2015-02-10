import java.util.*;

public class AMWDG extends G{
	
	private static Edge[][] weightedMatrix = new Edge[Tester.size][Tester.size];
	
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
	
	protected static boolean existEdge(int i, int j){
		if (weightedMatrix[i][j] != null)
			return true;
		else
			return false;
	}
	
	
	protected void putEdge(Edge edge){
		if (!existEdge(edge)){
			Node node1 = edge.getVertex1();
			Node node2 = edge.getVertex2();
			int dim1 = node1.getNode();
			int dim2 = node2.getNode();
			weightedMatrix[dim1][dim2] = edge;
		}
	}

	protected static void putEdge(int i, int j) {
		if (!existEdge(i, j)){
			Node node1 = new Node(i);
			Node node2 = new Node(j);
			Edge e = new Edge(node1, node2);
			weightedMatrix[i][j] = e;
		}
	}

	protected static void removeEdge(Edge e) {
		if (existEdge(e)){
			Node node1 = e.getVertex1();
			Node node2 = e.getVertex2();
			weightedMatrix[node1.getNode()][node2.getNode()] = null;
		}	
	}

	protected static void removeEdge(int i, int j) {
		Edge e = new Edge(i, j);
		if (existEdge(e)){
			weightedMatrix[i][j] = null;
		}
		
	}
	
	protected static ArrayList<Node> adjacentVertices(Node i){
		ArrayList<Node> adjNodes = new ArrayList<Node>();
		for (int j = 0; j < weightedMatrix.length; j++){
			if (weightedMatrix[j][i.getNode()] != null)
				adjNodes.add(weightedMatrix[j][i.getNode()].getVertex2());
		}
		return adjNodes;
	}
	
	protected static ArrayList<Node> adjacentVertices(int i){
		ArrayList<Node> adjNodes = new ArrayList<Node>();
		for (int j = 0; j < weightedMatrix.length; j++){
			if (weightedMatrix[j][i] != null)
				adjNodes.add(weightedMatrix[j][i].getVertex2());
		}
		return adjNodes;
	}
	
	protected static boolean areAdjacent(Node i, Node j){
		if (weightedMatrix[i.getNode()][j.getNode()] != null || weightedMatrix[j.getNode()][i.getNode()] != null)
			return true;
		else
			return false;
	}
	
	protected static boolean areAdjacent(int i, int j){
		if (weightedMatrix[i][j] != null || weightedMatrix[j][i] != null)
			return true;
		return false;
	}
	
	protected static Edge[][] getMatrix(){
		return weightedMatrix;
	}

	protected void initializeList() {
	}
	
}//End AMWDG