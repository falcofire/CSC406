import java.util.*;
public class ALDG extends G{
	
	@SuppressWarnings("unchecked")
	private static List<Node>[] unweightedList = new List[Tester.size];
	
	public ALDG (){
	}

	protected static boolean existEdge(Edge e) {
		Node node1 = e.getVertex1();
		Node node2 = e.getVertex2();
		Iterator<Node> marker = unweightedList[node1.getNode()].iterator();
		//While loop checks over all nodes in list to ensure the specified node is not already present.
		while (marker.hasNext()){
			Node check = marker.next();
			if (check.getNode() == node2.getNode())
				return true;
		}
		return false;
	}

	protected boolean existEdge(int i, int j) {
		if (unweightedList[i].contains(j))
			return true;
		return false;
	}

	protected void putEdge(Edge e) {
		Node node1 = e.getVertex1();
		Node node2 = e.getVertex2();
		unweightedList[node1.getNode()].add(node2);
	}

	protected void putEdge(int i, int j) {
		Node node2 = new Node(j);
		unweightedList[i].add(node2);
	}

	protected static void removeEdge(Edge e) {
		if (existEdge(e)){
			Node node1 = e.getVertex1();
			Node node2 = e.getVertex2();
			Iterator<Node> marker = unweightedList[node1.getNode()].iterator();
			while (marker.hasNext()){
				Node check = marker.next();
				if (check.getNode() == node2.getNode())
					unweightedList[node1.getNode()].remove(check);
			}
		}
	}

	protected void removeEdge(int i, int j) {
		Iterator<Node> marker = unweightedList[i].iterator();
		while (marker.hasNext()){
			Node node = marker.next();
			if (node.getNode() == j){
				unweightedList[i].remove(node);
				break;
			}	
		}
	}
	
	protected static List<Node> adjacentVertices(Node i) {
		printAdj(i.getNode(), unweightedList[i.getNode()]);
		return unweightedList[i.getNode()];
	}

	protected List<Node> adjacentVertices(int i) {
		printAdj(i, unweightedList[i]);
		return unweightedList[i];
	}

	protected static boolean areAdjacent(Node i, Node j) {
		Edge e = new Edge(i, j);
		if (existEdge(e))
			return true;
		return false;
	}

	protected boolean areAdjacent(int i, int j) {
		Edge e = new Edge(i, j);
		if (existEdge(e))
			return true;
		return false;
	}
	
	protected static List<Node>[] getList(){
		return unweightedList;
	}
	
	protected void initializeList() {
	    for (int i = 1; i < Tester.size; i++){
	        List<Node> list = new ArrayList<Node>();
	        unweightedList[i] = list;
	    }
	}

	protected void putEdge(int i, int j, int k) {
	}

	protected void print() {
		for (int i = 1; i < unweightedList.length; i++){
			Tester.writer.print(i + ": ");
			Iterator<Node> marker = unweightedList[i].iterator();
			while (marker.hasNext())
				Tester.writer.print(marker.next().getNode() + " ");
			Tester.writer.println();
		}
	}
	
	protected static void printAdj(int j, List<Node> i) {
		Iterator<Node> marker = i.iterator();
		while (marker.hasNext())
			Tester.writer.print(marker.next().getNode() + " ");
	}

	@Override
	protected void toposort() {
		// TODO Auto-generated method stub
		
	}
}//End ALDG
