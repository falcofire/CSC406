import java.util.*;

public class ALWG extends G{

	@SuppressWarnings("unchecked")
	private static List<Node>[] undirectedList = new List[Tester.size];
	
	public ALWG(){
	}
	
	protected boolean existEdge(int i, int j) {
		if (undirectedList[i].contains(j))
			return true;
		return false;
	}
	
	protected void putEdge(int i, int j) {
		Node node = new Node(j, 1);
		undirectedList[i].add(node);
	}

	protected void putEdge(int i, int j, int k) {
		Node node = new Node(j, k);
		undirectedList[i].add(node);
	}

	protected void putEdge(Edge e) {
		Node node1 = e.getVertex1();
		Node node2 = e.getVertex2();
		int weight = e.getWeight();
		Node node = new Node(node2.getNode(), weight);
		undirectedList[node1.getNode()].add(node);
	}
	
	protected void removeEdge(int i, int j) {
		Iterator<Node> marker = undirectedList[i].iterator();
		Node check;
		int node;
		while (marker.hasNext()){
			check = marker.next();
			node = check.getNode();
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
	}

	protected void print() {
		
	}

	@Override
	protected void toposort() {
		// TODO Auto-generated method stub
		
	}
} //End ALWG
