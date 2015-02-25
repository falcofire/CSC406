import java.util.*;
public class ALDG extends G{
	
	@SuppressWarnings("unchecked")
	private static List<Node>[] unweightedList = new List[Tester.size];
	
	public ALDG (){
	}

	protected boolean existsEdge(int i, int j) {
		if (unweightedList[i].contains(j))
			return true;
		return false;
	}

	protected void putEdge(int i, int j) {
		Node node2 = new Node(j);
		unweightedList[i].add(node2);
		G.degrees[i]++;
		G.degrees[j]++;
		G.inDegrees[j]++;
		G.outDegrees[i]++;
	}

	protected void putEdge(int i, int j, int k) {
		Node node2 = new Node(j,k);
		unweightedList[i].add(node2);
		G.degrees[i]++;
		G.degrees[j]++;
		G.inDegrees[j]++;
		G.outDegrees[i]++;
	}

	protected void removeEdge(int i, int j) {
		Iterator<Node> marker = unweightedList[i].iterator();
		while (marker.hasNext()){
			Node node = marker.next();
			if (node.getNodeValue() == j){
				unweightedList[i].remove(node);
				break;
			}	
		}
	}
	
	protected static List<Node> adjacentVertices(Node i) {
		printAdj(i.getNodeValue(), unweightedList[i.getNodeValue()]);
		return unweightedList[i.getNodeValue()];
	}

	protected List<Node> adjacentVertices(int i) {
		printAdj(i, unweightedList[i]);
		return unweightedList[i];
	}

	protected static boolean areAdjacent(Node i, Node j) {
	
		
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

	public String toString() {
		for (int i = 1; i < unweightedList.length; i++){
			Tester.writer.print(i + ": ");
			Iterator<Node> marker = unweightedList[i].iterator();
			while (marker.hasNext())
				Tester.writer.print(marker.next().getNodeValue() + " ");
			Tester.writer.println();
		}
		return "";
	}
	
	protected static void printAdj(int j, List<Node> i) {
		Iterator<Node> marker = i.iterator();
		while (marker.hasNext())
			Tester.writer.print(marker.next().getNodeValue() + " ");
	}

	@Override
	protected void toposort() {
		// TODO Auto-generated method stub
		
	}
}//End ALDG
