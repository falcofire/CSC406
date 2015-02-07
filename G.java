import java.util.*;
public abstract class G {
	private static int edgeCount = 0;
	private static int[] degrees = new int[Tester.size + 1];
	private static int[] outDegrees = new int[Tester.size + 1];
	private static int[] inDegrees = new int[Tester.size + 1];
	private static Set<Node> nodes = new HashSet<Node>();
//	Iterator marker = list.listIterator();
	
	public G () {
		
		if (Tester.type == 2 || Tester.type == 3)
			initializeList();
		
		while (Tester.fileScanner.hasNextInt()){
			//Get next node from file.
			int nextNode = Tester.fileScanner.nextInt();
			Node node, node2;
			int weight;
			Edge edge;
			
			//This creates the Node objects and then checks for weighted graph and process data further appropriately.
			//Need to check for previously existing nodes before creating new ones.
			node = existNode(nextNode);
			if (node == null){
				node = new Node(nextNode);
				nodes.add(node);
			}
			degrees[nextNode]++;
			outDegrees[nextNode]++;
			nextNode = Tester.fileScanner.nextInt();
			node2 = existNode(nextNode);
			if (node2 == null){
				node2 = new Node(nextNode);
				nodes.add(node2);
			}
			degrees[nextNode]++;
			inDegrees[nextNode]++;
			if (Tester.type == 0 || Tester.type == 2){
				weight = Tester.fileScanner.nextInt();
				edge = new Edge(node, node2, weight);
			}	
			else
				edge = new Edge(node, node2);
			
			//Store nodes in appropriate graph data structure at this point according to value of type.
			switch (Tester.type){
				case 0: putEdge(edge);
						break;
				case 1: putEdge(edge);
						break;
				case 2: putEdge(edge);
						break;
				case 3: putEdge(edge);
						break;
			}
			edgeCount++;
			
		}//End while looop
		System.out.println("Graph constructed successfully.");
		
	}//End G
	
	//Methods that are implemented uniformly and ubiquitously across all graph classes.
	protected static int numNodes(){
		return nodes.size();
	}
	
	protected static int numEdges(){
		return edgeCount;
	}
	
	protected Node existNode(int i){
		Iterator<Node> marker = nodes.iterator();
		while(marker.hasNext()){
			Node test = marker.next();
			if (test.getNode() == i){
				return test;
			}
		}
		return null;
	}
	
	protected static int degree(Node i){
		return degrees[i.getNode()];
	}
	
	protected static int degree(int i){
		return degrees[i];
	}
	
	protected static int inDegree(Node i){
		return inDegrees[i.getNode()];
	}
	
	protected static int inDegree(int i){
		return inDegrees[i];
	}
	
	protected static int outDegree(Node i){
		return outDegrees[i.getNode()];
	}
	
	protected static int outDegree(int i){
		return outDegrees[i];
	}
	
	//Methods that depend on the class to process.
	protected abstract void initializeList();
	protected abstract void putEdge(Edge e);
	protected static boolean areAdjacent(int i, int j) {
		switch (Tester.type){
			case 0: return AMWDG.areAdjacent(i, j);
			case 1: return AMDG.areAdjacent(i, j);
			case 2: return ALWDG.areAdjacent(i, j);
			case 3: return ALDG.areAdjacent(i, j);
			default: return false;
		}
	}
	protected static List<Node> adjacentVertices(int i){
		switch (Tester.type){
			case 0: return AMWDG.adjacentVertices(i);
			case 1: return AMDG.adjacentVertices(i);
			case 2: return ALWDG.adjacentVertices(i);
			case 3: return ALDG.adjacentVertices(i);
			default: return null;
		}
	}
	protected static boolean existEdge(int i, int j){
		switch (Tester.type){
			case 0: return AMWDG.existEdge(i, j);
			case 1: return AMDG.existEdge(i, j);
			case 2: return ALWDG.existEdge(i, j);
			case 3: return ALDG.existEdge(i, j);
			default: return false;
		}
	}
	protected static void removeEdge(int i, int j){
		switch (Tester.type){
			case 0: AMWDG.removeEdge(i, j);
					break;
			case 1: AMDG.removeEdge(i, j);
					break;
			case 2: ALWDG.removeEdge(i, j);
					break;
			case 3: ALDG.removeEdge(i, j);
					break;
		}
	}
	protected static void putEdge(int i, int j){
		switch (Tester.type){
			case 0: AMWDG.putEdge(i, j);
					break;
			case 1: AMDG.putEdge(i, j);
					break;
			case 2: ALWDG.putEdge(i, j);
					break;
			case 3: ALDG.putEdge(i, j);
					break;
		}
	}
}//End G
