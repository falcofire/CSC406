import java.util.*;

public class ALWG extends G{

	@SuppressWarnings("unchecked")
	private static List<Node>[] undirectedList = new List[Tester.size];
	
	public ALWG(){
	}
	
	protected boolean existsEdge(int i, int j) {
		return (undirectedList[i].contains(j));
	}
	
	protected void putEdge(int i, int j) {
		Node node = new Node(j, 1);
		undirectedList[i].add(node);
		G.degrees[i]++;
		G.degrees[j]++;
		G.inDegrees[j]++;
		G.outDegrees[i]++;
	}

	protected void putEdge(int i, int j, int k) {
		Node node = new Node(j, k);
		undirectedList[i].add(node);
		G.degrees[i]++;
		G.degrees[j]++;
		G.inDegrees[j]++;
		G.outDegrees[i]++;
	}
	
	protected void removeEdge(int i, int j) {
		Iterator<Node> marker = undirectedList[i].iterator();
		Node check;
		int node;
		while (marker.hasNext()){
			check = marker.next();
			node = check.getNodeValue();
			if (node == j)
				undirectedList[i].remove(check);
		}
	}
	
	protected List<Node> adjacentVertices(int i) {
		List<Node> adjNodes = new ArrayList<Node>();
		Iterator<Node> marker = undirectedList[i].iterator();
		while (marker.hasNext()){
			adjNodes.add(marker.next());
		}
		return adjNodes;
	}
	
	protected boolean areAdjacent(int i, int j) {
		return false;
	}
	
	protected void initializeList() {
		for (int i = 1; i < Tester.size; i++){
	        List<Node> list = new ArrayList<Node>();
	        undirectedList[i] = list;
	    }
	}

	public String toString() {
		return "";
	}

	protected void toposort() {
		@SuppressWarnings("unused")
		TopoSort t = new TopoSort(undirectedList);
	}

	protected void kruskalMST() {
		@SuppressWarnings("unused")
		KruskalMST minSpanTree = new KruskalMST(undirectedList);
	}
	
	protected void warshalls() throws GraphExceptions {
		throw new GraphExceptions("Cannot implement Warshall's algorithm on an undirected graph.");
	}
	
	protected int[][] floyds() {
		return FloydsShortestPath.FloydsList(undirectedList);
	}
} //End ALWG
