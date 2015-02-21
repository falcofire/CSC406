import java.util.*;
public class ALWDG extends G{
	
	@SuppressWarnings("unchecked")
	private static List<Node>[] weightedList = new List[Tester.size];
	
	protected ALWDG (){	
	}

	protected static boolean existEdge(Edge e) {
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

	protected boolean existEdge(int i, int j) {
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
		Node node1 = e.getVertex1();
		if (node1.getNode() < Tester.size){
			weightedList[node1.getNode()].add(e.getVertex2());
		}
	}

	protected void putEdge(int i, int j) {
		Node node = new Node(j, 1);
		weightedList[i].add(node);
	}
	
	protected void putEdge(int i, int j, int k) {
		Node node = new Node(j,k);
		weightedList[i].add(node);
	}

	protected static void removeEdge(Edge e) {
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

	protected void removeEdge(int i, int j) {
		if (existEdge(i, j)){
			Iterator<Node> marker = weightedList[i].iterator();
			while (marker.hasNext()){
				Node check = marker.next();
				if (check.getNode() == j){
					weightedList[i].remove(check);
					break;
				}	
			}
		}
		
	}
	
	protected static List<Integer> adjacentVertices(Node i) {
		List<Integer> adjNodes = new ArrayList<Integer>();
		Iterator<Node> marker = weightedList[i.getNode()].iterator();
		while (marker.hasNext()){
			adjNodes.add(marker.next().getNode());
		}
		printAdj(i.getNode(), adjNodes);
		return adjNodes;
	}

	protected List<Integer> adjacentVertices(int i) {
		List<Integer> adjNodes = new ArrayList<Integer>();
		Iterator<Node> marker = weightedList[i].iterator();
		while (marker.hasNext()){
			Node check = marker.next();
			adjNodes.add(check.getNode());
		}
		printAdj(i, adjNodes);
		return adjNodes;
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
		return weightedList;
	}
		
	protected void initializeList() {
	    for (int i = 1; i < Tester.size; i++){
	        List<Node> list = new ArrayList<Node>();
	        weightedList[i] = list;
	    }
	}

	protected void print() {
		for (int i =1; i < weightedList.length; i++){
			Tester.writer.print(i + ": ");
			Iterator<Node> marker = weightedList[i].iterator();
			while (marker.hasNext())
				Tester.writer.print(marker.next().getNode() + " ");
			Tester.writer.println();
		}
	}

	protected static void printAdj(int j, List<Integer> i) {
		Iterator<Integer> marker = i.iterator();
		while (marker.hasNext())
			Tester.writer.print(marker.next() + " ");
	}
	
}//End ALWDG
