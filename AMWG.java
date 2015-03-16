import java.util.*;

public class AMWG extends G{

	private static Node[][] undirectedMatrix = new Node[Tester.size][Tester.size];
	
	public AMWG(){
	}
	
	protected boolean existsEdge(int i, int j) {
		return (undirectedMatrix[i][j] != null);
	}
	
	protected void putEdge(int i, int j) {
		Node node = new Node(j, 1);
		undirectedMatrix[i][j] = node;
		G.degrees[i]++;
		G.degrees[j]++;
		G.inDegrees[j]++;
		G.outDegrees[i]++;
	}

	protected void putEdge(int i, int j, int k) {
		Node node = new Node(j, k);
		undirectedMatrix[i][j] = node;
		G.degrees[i]++;
		G.degrees[j]++;
		G.inDegrees[j]++;
		G.outDegrees[i]++;
	}
	
	protected void removeEdge(int i, int j) {
		undirectedMatrix[i][j] = null;
	}
	
	protected List<Node> adjacentVertices(int i) {
		List<Node> adjNodes = new ArrayList<Node>();
		for (int j = 1; j < undirectedMatrix[i].length; j++){
			adjNodes.add(undirectedMatrix[i][j]);
		}
		return adjNodes;
	}
	
	protected boolean areAdjacent(int i, int j) {
		if (undirectedMatrix[i][j] != null || undirectedMatrix[j][i] != null)
			return true;
		return false;
	}
	
	protected void initializeList() {
	}
	//Helper method to print contents of matrix in readable format.
	public String toString() {
		for (int i = 1; i < undirectedMatrix.length; i++){
			for (int j = 1; j < undirectedMatrix.length; j++){
				if (undirectedMatrix[i][j] != null)
					Tester.writer.print(undirectedMatrix[i][j].getNodeValue() + " ");
				else
					Tester.writer.print("0 ");
			}
			Tester.writer.println();
		}
		return "";
	}

	protected void toposort() {
		@SuppressWarnings("unused")
		TopoSort t = new TopoSort(undirectedMatrix);
	}

	protected void kruskalMST() {
		@SuppressWarnings("unused")
		KruskalMST minSpanTree = new KruskalMST(undirectedMatrix);
	}
	
	protected void warshalls() throws GraphExceptions{
		throw new GraphExceptions("Cannot implement Warshall's algorithm on an undirected graph.");
	}
}//END AMWG
