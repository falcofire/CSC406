import java.util.*;
public class ALDG extends G{
	
	@SuppressWarnings("unchecked")
	private static List<Node>[] unweightedList = new List[Tester.size];
	
	public ALDG (){
	}

	public static boolean existEdge(Edge e) {
		Node node1 = e.getVertex1();
		Node node2 = e.getVertex2();
		Iterator<Node> marker = unweightedList[node1.getNode()].iterator();
			//While loop checks over all nodes in list to ensure the specified node is not alreay present.
			while (marker.hasNext()){
				Node check = marker.next();
				if (check.getNode() == node2.getNode())
					return true;
			}
		return false;
	}

	public static boolean existEdge(int i, int j) {
		if (i < Tester.size){
			Iterator<Node> marker = unweightedList[i].iterator();
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
			int dim1 = node1.getNode();
			if (dim1 < Tester.size){
				unweightedList[dim1].add(node2);
			}
		}
	}

	protected static void putEdge(int i, int j) {
		if (!existEdge(i,j)){
			Node node2 = new Node(j);
			unweightedList[i].add(node2);
		}
		
	}

	public static void removeEdge(Edge e) {
		if (existEdge(e)){
			Node node1 = e.getVertex1();
			Node node2 = e.getVertex2();
			int dim1 = node1.getNode();
			Iterator<Node> marker = unweightedList[dim1].iterator();
			while (marker.hasNext()){
				Node check = marker.next();
				if (check.getNode() == node2.getNode())
					unweightedList[dim1].remove(check);
			}
		}
	}

	public static void removeEdge(int i, int j) {
		if (existEdge(i, j)){
			Iterator<Node> marker = unweightedList[i].iterator();
			while (marker.hasNext()){
				Node node = marker.next();
				if (node.getNode() == j){
					unweightedList[i].remove(node);
					break;
				}	
			}
		}
		
	}
	
	public static List<Node> adjacentVertices(Node i) {
		return unweightedList[i.getNode()];
	}

	public static List<Node> adjacentVertices(int i) {
		return unweightedList[i];
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
		return unweightedList;
	}
	
	protected void initializeList() {
	    for (int i = 1; i < Tester.size; i++){
	        List<Node> list = new ArrayList<Node>();
	        unweightedList[i] = list;
	    }
	}

}//End ALDG
