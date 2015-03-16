import java.util.*;
public class ALWDG extends G{
	
	@SuppressWarnings("unchecked")
	private static List<Node>[] weightedList = new List[Tester.size];
	
	protected ALWDG (){	
	}
	
	protected boolean existsEdge(int i, int j) {
		return (weightedList[i].contains(j));
	}

	protected void putEdge(int i, int j) {
		Node node = new Node(j, 1);
		weightedList[i].add(node);
		G.degrees[i]++;
		G.degrees[j]++;
		G.inDegrees[j]++;
		G.outDegrees[i]++;
	}
	
	protected void putEdge(int i, int j, int k) {
		Node node = new Node(j,k);
		weightedList[i].add(node);
		G.degrees[i]++;
		G.degrees[j]++;
		G.inDegrees[j]++;
		G.outDegrees[i]++;
	}

	protected void removeEdge(int i, int j) {
		if (existsEdge(i, j)){
			Iterator<Node> marker = weightedList[i].iterator();
			while (marker.hasNext()){
				Node check = marker.next();
				if (check.getNodeValue() == j){
					weightedList[i].remove(check);
					break;
				}	
			}
		}
	}
	
	protected static List<Node> adjacentVertices(Node i) {
		List<Node> adjNodes = new ArrayList<Node>();
		Iterator<Node> marker = weightedList[i.getNodeValue()].iterator();
		while (marker.hasNext()){
			adjNodes.add(marker.next());
		}
		printAdj(i.getNodeValue(), adjNodes);
		return adjNodes;
	}

	protected List<Node> adjacentVertices(int i) {
		List<Node> adjNodes = new ArrayList<Node>();
		Iterator<Node> marker = weightedList[i].iterator();
		while (marker.hasNext()){
			Node check = marker.next();
			adjNodes.add(check);
		}
		printAdj(i, adjNodes);
		return adjNodes;
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
		return weightedList;
	}
		
	protected void initializeList() {
	    for (int i = 1; i < Tester.size; i++){
	        List<Node> list = new ArrayList<Node>();
	        weightedList[i] = list;
	    }
	}

	public String toString() {
		for (int i =1; i < weightedList.length; i++){
			Tester.writer.print(i + ": ");
			Iterator<Node> marker = weightedList[i].iterator();
			while (marker.hasNext())
				Tester.writer.print(marker.next().getNodeValue() + " ");
			Tester.writer.println();
		}
		return "";
	}
	//Helper method that prints out list of adjacent Nodes for specified Node.
	protected static void printAdj(int j, List<Node> i) {
		Iterator<Node> marker = i.iterator();
		while (marker.hasNext())
			Tester.writer.print(marker.next().getNodeValue() + " ");
	}

	protected void toposort() {
		@SuppressWarnings("unused")
		TopoSort t = new TopoSort(weightedList);
	}

	protected void kruskalMST() {
		@SuppressWarnings("unused")
		KruskalMST minSpanTree = new KruskalMST(weightedList);
	}
	
	protected void warshalls() {
		WTransClosure.WarshallsList(weightedList);
	}
}//End ALWDG
