import java.util.*;
public class ALWDG extends G{
	
	@SuppressWarnings("unchecked")
	private static List<Edge>[] weightedList = new List[Tester.size];
	
	public ALWDG (){	
	}

	public static boolean existEdge(Edge e) {
		Node node1 = e.getVertex1();
		Node node2 = e.getVertex2();
		Iterator<Edge> marker = weightedList[node1.getNode()].iterator();
		//While loop checks over all nodes in list to ensure the specified node is not already present.
		while (marker.hasNext()){
			Edge check = marker.next();
			if (check.getVertex2().getNode() == node2.getNode())
				return true;
		}	
		return false;
	}

	public static boolean existEdge(int i, int j) {
		if (i < Tester.size){
			Iterator<Edge> marker = weightedList[i].iterator();
			while (marker.hasNext()){
				Edge check = marker.next();
				if (check.getVertex2().getNode() == j)
					return true;
			}
		}
		return false;
	}

	protected void putEdge(Edge e) {
		if (!existEdge(e)){
			Node node1 = e.getVertex1();
			if (node1.getNode() < Tester.size){
				weightedList[node1.getNode()].add(e);
			}
		}
	}

	protected static void putEdge(int i, int j, int k) {
		if (!existEdge(i,j)){
			Node node1 = G.existNode(i);
			if (node1 == null)
				node1 = new Node(i);
			Node node2 = G.existNode(j);
			if (node2 == null)
				node2 = new Node(j);
			Edge e = new Edge(node1, node2, k);
			weightedList[i].add(e);
		}
		
	}

	public static void removeEdge(Edge e) {
		if (existEdge(e)){
			Node node1 = e.getVertex1();
			Node node2 = e.getVertex2();
			int dim1 = node1.getNode();
			Iterator<Edge> marker = weightedList[dim1].iterator();
			while (marker.hasNext()){
				Edge check = marker.next();
				if (check.getVertex2().getNode() == node2.getNode())
					weightedList[dim1].remove(check);
			}
		}
	}

	public static void removeEdge(int i, int j) {
		if (existEdge(i, j)){
			Iterator<Edge> marker = weightedList[i].iterator();
			while (marker.hasNext()){
				Edge e = marker.next();
				if (e.getVertex2().getNode() == j){
					weightedList[i].remove(e);
					break;
				}	
			}
		}
		
	}
	
	public static List<Edge> adjacentVertices(Node i) {
		return weightedList[i.getNode()];
	}

	public static List<Node> adjacentVertices(int i) {
		List<Node> adjNodes = new ArrayList<Node>();
		Iterator<Edge> marker = weightedList[i].iterator();
		while (marker.hasNext()){
			Edge e = marker.next();
			adjNodes.add(e.getVertex2());
		}
		return adjNodes;
	}

	public static boolean areAdjacent(Node i, Node j) {
		Edge e = new Edge(i, j);
		if (existEdge(e))
			return true;
		return false;
	}

	public static boolean areAdjacent(int i, int j) {
		Edge e = new Edge(i, j);
		if (existEdge(e))
			return true;
		return false;
	}
	
	public static List<Edge>[] getList(){
		return weightedList;
	}
		
	protected void initializeList() {
	    for (int i = 1; i < Tester.size; i++){
	        List<Edge> list = new ArrayList<Edge>();
	        weightedList[i] = list;
	    }
	}

	
}//End ALWDG
