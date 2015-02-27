import java.util.ArrayList;
import java.util.Iterator;

public class AMDG extends G{

	private static Node[][] unweightedMatrix = new Node[Tester.size][Tester.size];
	
	public AMDG (){
	}
	
	protected boolean existsEdge(int i, int j){
		return (unweightedMatrix[i][j] != null);
	}
	
	protected void putEdge(int i, int j){
		Node node = new Node(j, 1);
		unweightedMatrix[i][j] = node;
		G.degrees[i]++;
		G.degrees[j]++;
		G.inDegrees[j]++;
		G.outDegrees[i]++;
	}
	
	protected void putEdge(int i, int j, int k) {
		Node node = new Node(j, k);
		unweightedMatrix[i][j] = node;
		G.degrees[i]++;
		G.degrees[j]++;
		G.inDegrees[j]++;
		G.outDegrees[i]++;
	}
	
	protected void removeEdge(int i, int j){
		unweightedMatrix[i][j] = null;
	}
	
	protected static ArrayList<Node> adjacentVertices(Node i){
		ArrayList<Node> adjNodes= new ArrayList<Node>();
		for (int j = 1; j < unweightedMatrix.length; j++){
			if (unweightedMatrix[i.getNodeValue()][j] != null)
				adjNodes.add(unweightedMatrix[i.getNodeValue()][j]);
		}
		printAdj(i.getNodeValue(), adjNodes);
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
		if (unweightedMatrix[j.getNodeValue()][i.getNodeValue()] != null)
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
	public String toString() {
		for (int i = 1; i < unweightedMatrix.length; i++){
			for (int j = 1; j < unweightedMatrix.length; j++){
				if (unweightedMatrix[i][j] != null)
					Tester.writer.print("1 ");
				else
					Tester.writer.print("0 ");
			}
			Tester.writer.println();
		}
		return "\n";
	}
	//Helper method to print adjacent vertices.
	protected static void printAdj(int j, ArrayList<Node> i) {
		Iterator<Node> marker = i.iterator();
		while (marker.hasNext())
			Tester.writer.print(marker.next().getNodeValue() + " ");
	}

	protected void toposort() {
		@SuppressWarnings("unused")
		TopoSort t = new TopoSort(unweightedMatrix);
	}

	protected void kruskalMST() {
		System.out.println("Cannot construct MST - not a weighted graph.");
		Tester.writer.println("Cannot construct MST - not a weighted graph.");
	}
}//End AMDG