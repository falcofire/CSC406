import java.util.*;

public class KruskalMST {
	
	@SuppressWarnings("unchecked")
	//Step 1 of Kruskal's algorithm, make a set for each vertex v in the graph.
	Set<Integer>[] theSets = new Set[Tester.size];
	Set<Edge> msTree;
	public KruskalMST(List<Node>[] weightedList) {
		//Initialize sets.
		makeSets(Tester.size);
		
		//Step 2, initialize a priority queue containing edges with weights as keys.
		Queue<Edge> pQueue = new PriorityQueue<Edge>(Tester.size, weightComparator);
		Edge e = null;
		for (int i = 1; i < weightedList.length; i++){
			Iterator<Node> marker = weightedList[i].iterator();
			while (marker.hasNext()){
				Node node = marker.next();
				e = new Edge(i, node.getNodeValue(), node.getWeight());
				pQueue.add(e);
			}
		}
		//Step 3, set T to null and while pQueue has less than (n-1) edges:
		msTree = new HashSet<Edge>();
		while (msTree.size() < Tester.size - 2){
			//Remove minimum weight edge from Q.
			e = pQueue.poll();
			//Derive Nodes and their values from Edge object.
			int u = e.getVertex1().getNodeValue();
			int v = e.getVertex2().getNodeValue();
			int setU = find(u);
			int setV = find(v);
			//If find(u) != find(v):
			if (setU != setV){
				//Add edge to tree.
				msTree.add(e);
				//Union set(u), set(v).
				theSets[setU].addAll(theSets[setV]);
			}
		}
		toString();
	}

	public KruskalMST(Node[][] weightedMatrix) {
		
		makeSets(Tester.size);
		Queue<Edge> pQueue = new PriorityQueue<Edge>(Tester.size, weightComparator);
		Edge e = null;
		for (int i = 1; i < weightedMatrix.length; i++){
			for (int j = 1; j < weightedMatrix[i].length; j++){
				if (weightedMatrix[i][j] != null){
					Node node = weightedMatrix[i][j];
					e = new Edge(i, node.getNodeValue(), node.getWeight());
					pQueue.add(e);
				}
			}
		}
		msTree = new HashSet<Edge>();
		while (msTree.size() < Tester.size - 2){
			e = pQueue.poll();
			int u = e.getVertex1().getNodeValue();
			int v = e.getVertex2().getNodeValue();
			int setU = find(u);
			int setV = find(v);
			if (setU != setV){
				msTree.add(e);
				theSets[setU].addAll(theSets[setV]);
			}
		}
		toString();
	}

	//Comparator method to compare edges.
	private static Comparator<Edge> weightComparator = new Comparator<Edge>(){
		public int compare(Edge e1, Edge e2) {
			return (e1.getWeight() - e2.getWeight());
		}
	};
	//Method initializes the sets.
	private void makeSets(int j){
		for (int i = 1; i < j; i++){
			theSets[i] = new HashSet<Integer>();
			theSets[i].add(i);
		}
	}
	//Method prints the contents of the tree in human-readable format to file.
	public String toString(){
		Iterator<Edge> marker = msTree.iterator();
		Tester.writer.println("\n\nMinimum spanning tree: ");
		while (marker.hasNext()){
			Edge e = marker.next();
			Tester.writer.println(e.getVertex1().getNodeValue() + " -> " + e.getVertex2().getNodeValue());
		}
		System.out.println("Minimum spanning tree constructed.");
		return "";
	}
	//Accepts an integer (representing a node) and finds the set to which it belongs. Returns the index of that set.
	private int find(int x){
		for (int i = 1; i < theSets.length; i++){
			if (theSets[i].contains(x))
				return i;
		}
		return 0;
	}
}//End KruskalMST
