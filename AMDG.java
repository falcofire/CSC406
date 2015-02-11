import java.util.ArrayList;


public class AMDG extends G{

	private static Edge[][] unweightedMatrix = new Edge[Tester.size][Tester.size];
	
	public AMDG (){
	}
	
	protected static boolean existEdge(Edge e){
		Node node1 = e.getVertex1();
		Node node2 = e.getVertex2();
		if (unweightedMatrix[node1.getNode()][node2.getNode()] != null)
			return true;
		else
			return false;
	}
	
	protected static boolean existEdge(int i, int j){
		if (unweightedMatrix[i][j] != null)
			return true;
		else
			return false;
	}
	
	protected void putEdge(Edge edge){
		if (!existEdge(edge)){
			Node node1 = edge.getVertex1();
			Node node2 = edge.getVertex2();
			unweightedMatrix[node1.getNode()][node2.getNode()] = edge;
		}
	}
	
	protected static void putEdge(int i, int j){
		if (!existEdge(i, j)){
			Node node1 = new Node(i);
			Node node2 = new Node(j);
			Edge edge = new Edge(node1, node2);
			unweightedMatrix[i][j] = edge;
		}	
	}
	
	protected static void removeEdge(Edge edge){
		Node node1 = edge.getVertex1();
		Node node2 = edge.getVertex2();
		unweightedMatrix[node1.getNode()][node2.getNode()] = null;
	}
	
	protected static void removeEdge(int i, int j){
		unweightedMatrix[i][j] = null;
	}
	
	protected static ArrayList<Node> adjacentVertices(Node i){
		ArrayList<Node> adjNodes= new ArrayList<Node>();
		for (int j = 1; j < unweightedMatrix.length; j++){
			if (unweightedMatrix[i.getNode()][j] != null)
				adjNodes.add(unweightedMatrix[i.getNode()][j].getVertex2());
		}
		return adjNodes;
	}
	
	protected static ArrayList<Node> adjacentVertices(int i){
		ArrayList<Node> adjNodes = new ArrayList<Node>();
		for (int j = 1; j < unweightedMatrix.length; j++){
			if (unweightedMatrix[i][j] != null)
				adjNodes.add(unweightedMatrix[i][j].getVertex2());
		}
		return adjNodes;
	}
	
	protected static boolean areAdjacent(Node i, Node j){
		if (unweightedMatrix[j.getNode()][i.getNode()] != null)
			return true;
		else
			return false;
	}
	
	protected static boolean areAdjacent(int i, int j){
		if (unweightedMatrix[j][i] != null)
			return true;
		else
			return false;
	}
	
	protected static Edge[][] getMatrix(){
		return unweightedMatrix;
	}

	protected void initializeList() {
		
	}

}//End AMDG