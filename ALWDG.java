import java.util.*;


public class ALWDG extends G{
	
	@SuppressWarnings("unchecked")
	private static List<Node>[] weightedList = new List[Tester.size];
	
	public ALWDG (){	
	}

	public static boolean existEdge(Edge e) {
		Node node1 = e.getVertex1();
		Node node2 = e.getVertex2();
		Iterator<Node> marker = weightedList[node1.getNode()].iterator();
		//While loop checks over all nodes in list to ensure the specified node is not already present.
		while (marker.hasNext()){
			Node check = marker.next();
			if (check.getNode() == node2.getNode())
				return true;
		}	
		return false;
	}

	public static boolean existEdge(int i, int j) {
		if (i < Tester.size){
			Iterator<Node> marker = weightedList[i].iterator();
			while (marker.hasNext()){
				Node check = marker.next();
				if (check.getNode() == j)
					return true;
			}
		}
		return false;
	}

	protected void putEdge(Edge e) {
		if (!existEdge(e)){
			Node node1 = e.getVertex1();
			Node node2 = e.getVertex2();
			if (node1.getNode() < Tester.size){
				weightedList[node1.getNode()].add(node2);
			}
		}
	}

	protected static void putEdge(int i, int j) {
		if (!existEdge(i,j)){
			Node node2 = new Node(j);
			weightedList[i].add(node2);
		}
		
	}

	public static void removeEdge(Edge e) {
		if (existEdge(e)){
			Node node1 = e.getVertex1();
			Node node2 = e.getVertex2();
			int dim1 = node1.getNode();
			Iterator<Node> marker = weightedList[dim1].iterator();
			while (marker.hasNext()){
				Node check = marker.next();
				if (check.getNode() == node2.getNode())
					weightedList[dim1].remove(check);
			}
		}
	}

	public static void removeEdge(int i, int j) {
		if (existEdge(i, j)){
			Iterator<Node> marker = weightedList[i].iterator();
			while (marker.hasNext()){
				Node node = marker.next();
				if (node.getNode() == j){
					weightedList[i].remove(node);
					break;
				}	
			}
		}
		
	}
	
	public static List<Node> adjacentVertices(Node i) {
		return weightedList[i.getNode()];
	}

	public static List<Node> adjacentVertices(int i) {
		return weightedList[i];
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
	
	public static List<Node>[] getList(){
		return weightedList;
	}
		
	protected void initializeList() {
	    for (int i = 1; i < Tester.size; i++){
	        List<Node> list = new ArrayList<Node>();
	        weightedList[i] = list;
	    }
	}

	
}//End ALWDG
