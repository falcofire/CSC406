import java.util.*;

public class AMWDG extends G{
	
	private static Node[][] weightedMatrix = new Node[Tester.size][Tester.size];
	
	public AMWDG(){
	}
	
	protected boolean existsEdge(int i, int j){
		if (weightedMatrix[i][j] != null)
			return true;
		else
			return false;
	}

	protected void putEdge(int i, int j) {
		Node node = new Node(j, 1);
		weightedMatrix[i][j] = node;
		G.degrees[i]++;
		G.degrees[j]++;
		G.inDegrees[j]++;
		G.outDegrees[i]++;
	}
	
	protected void putEdge(int i, int j, int k) {
		Node node = new Node(j, k);
		weightedMatrix[i][j] = node;
		G.degrees[i]++;
		G.degrees[j]++;
		G.inDegrees[j]++;
		G.outDegrees[i]++;
	}

	protected void removeEdge(int i, int j) {
		weightedMatrix[i][j] = null;
	}
	
	protected static ArrayList<Node> adjacentVertices(Node i){
		ArrayList<Node> adjNodes = new ArrayList<Node>();
		for (int j = 1; j < weightedMatrix.length; j++){
			if (weightedMatrix[i.getNodeValue()][j] != null)
				adjNodes.add(weightedMatrix[i.getNodeValue()][j]);
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
		if (weightedMatrix[i.getNodeValue()][j.getNodeValue()] != null || weightedMatrix[j.getNodeValue()][i.getNodeValue()] != null)
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
	public String toString() {
		for (int i = 1; i < weightedMatrix.length; i++){
			for (int j = 1; j < weightedMatrix.length; j++){
				if (weightedMatrix[i][j] != null)
					Tester.writer.print(weightedMatrix[i][j].getWeight() + " ");
				else
					Tester.writer.print("0 ");
			}
			Tester.writer.println();
		}
		return "";
	}
	//Helper method to print adjacent Nodes.
	protected void printAdj(int j, ArrayList<Node> i) {
		Iterator<Node> marker = i.iterator();
		while (marker.hasNext())
			Tester.writer.print(marker.next().getNodeValue() + " ");
	}

	protected void toposort() {
		@SuppressWarnings("unused")
		TopoSort t = new TopoSort(weightedMatrix);
	}
}//End AMWDG