import java.util.ArrayList;
import java.util.Iterator;

public class AMDG extends G{

	private static Node[][] unweightedMatrix = new Node[Tester.size][Tester.size];
	
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
	
	protected boolean existEdge(int i, int j){
		if (unweightedMatrix[i][j] != null)
			return true;
		return false;
	}
	
	protected void putEdge(Edge edge){
		if (!existEdge(edge)){
			Node node1 = edge.getVertex1();
			Node node2 = edge.getVertex2();
			unweightedMatrix[node1.getNode()][node2.getNode()] = node2;
		}
	}
	
	protected void putEdge(int i, int j){
		Node node = new Node(j, 1);
		unweightedMatrix[i][j] = node;
	}
	
	protected void putEdge(int i, int j, int k) {
	}
	
	protected static void removeEdge(Edge edge){
		Node node1 = edge.getVertex1();
		Node node2 = edge.getVertex2();
		unweightedMatrix[node1.getNode()][node2.getNode()] = null;
	}
	
	protected void removeEdge(int i, int j){
		unweightedMatrix[i][j] = null;
	}
	
	protected static ArrayList<Node> adjacentVertices(Node i){
		ArrayList<Node> adjNodes= new ArrayList<Node>();
		for (int j = 1; j < unweightedMatrix.length; j++){
			if (unweightedMatrix[i.getNode()][j] != null)
				adjNodes.add(unweightedMatrix[i.getNode()][j]);
		}
		printAdj(i.getNode(), adjNodes);
		return adjNodes;
	}
	
	protected ArrayList<Node> adjacentVertices(int i){
		ArrayList<Node> adjNodes = new ArrayList<Node>();
		for (int j = 1; j < unweightedMatrix.length; j++){
			if (unweightedMatrix[i][j] != null)
				adjNodes.add(unweightedMatrix[i][j]);
		}
		printAdj(i, adjNodes);
		return adjNodes;
	}
	
	protected static boolean areAdjacent(Node i, Node j){
		if (unweightedMatrix[j.getNode()][i.getNode()] != null)
			return true;
		else
			return false;
	}
	
	protected boolean areAdjacent(int i, int j){
		if (unweightedMatrix[j][i] != null)
			return true;
		else
			return false;
	}
		
	protected static Node[][] getMatrix(){
		return unweightedMatrix;
	}

	protected void initializeList() {	
	}
	//Helper method to print contents of matrix in readable format.
	protected void print() {
		for (int i = 1; i < unweightedMatrix.length; i++){
			for (int j = 1; j < unweightedMatrix.length; j++){
				if (unweightedMatrix[i][j] != null)
					Tester.writer.print("1 ");
				else
					Tester.writer.print("0 ");
			}
			Tester.writer.println();
		}
	}
	//Helper method to print adjacent vertices.
	protected static void printAdj(int j, ArrayList<Node> i) {
		Iterator<Node> marker = i.iterator();
		while (marker.hasNext())
			Tester.writer.print(marker.next().getNode() + " ");
	}

	@Override
	protected void toposort() {
		// TODO Auto-generated method stub
		
	}
}//End AMDG