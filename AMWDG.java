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
			int dim1 = node1.getNode();
			int dim2 = node2.getNode();
			weightedMatrix[dim1][dim2] = edge;
		}
	}

	protected void putEdge(int i, int j) {
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

	protected void removeEdge(int i, int j) {
		Edge e = new Edge(i, j);
		if (existEdge(e)){
			weightedMatrix[i][j] = null;
		}
		
	}
	
	protected static ArrayList<Node> adjacentVertices(Node i){
		ArrayList<Node> adjNodes = new ArrayList<Node>();
		for (int j = 1; j < weightedMatrix.length; j++){
			if (weightedMatrix[i.getNode()][j] != null)
				adjNodes.add(weightedMatrix[i.getNode()][j].getVertex2());
		}
		return adjNodes;
	}
	
	protected ArrayList<Node> adjacentVertices(int i){
		ArrayList<Node> adjNodes = new ArrayList<Node>();
		for (int j = 1; j < weightedMatrix.length; j++){
			if (weightedMatrix[i][j] != null)
				adjNodes.add(weightedMatrix[i][j].getVertex2());
		}
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
	
	protected static Edge[][] getMatrix(){
		return weightedMatrix;
	}

	protected void initializeList() {
	}

	@Override
	protected void putEdge(int i, int j, int k) {
		// TODO Auto-generated method stub
		
	}
	
}//End AMWDG