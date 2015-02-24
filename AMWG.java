import java.util.*;

public class AMWG extends G{

	private static Node[][] undirectedMatrix = new Node[Tester.size][Tester.size];
	
	public AMWG(){
	}
	
	protected boolean existEdge(int i, int j) {
		if (undirectedMatrix[i][j] != null)
			return true;
		return false;
	}
	
	protected void putEdge(int i, int j) {
		Node node = new Node(j, 1);
		undirectedMatrix[i][j] = node;
	}

	protected void putEdge(int i, int j, int k) {
		Node node = new Node(j, k);
		undirectedMatrix[i][j] = node;
	}

	protected void putEdge(Edge e) {
		Node node1 = e.getVertex1();
		Node node2 = e.getVertex2();
		undirectedMatrix[node1.getNode()][node2.getNode()] = node2;
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
	protected void print() {
		for (int i = 1; i < undirectedMatrix.length; i++){
			for (int j = 1; j < undirectedMatrix.length; j++){
				if (undirectedMatrix[i][j] != null)
					Tester.writer.print(undirectedMatrix[i][j].getNode() + " ");
				else
					Tester.writer.print("0 ");
			}
			Tester.writer.println();
		}
	}
}//END AMWG
