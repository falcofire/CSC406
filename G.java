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
		
		while (nodes.size() < Tester.size-1 && edgeCount < Tester.numEdges){
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
		
		Tester.writer.println("Graph statistics: ");
		print();
		
		Tester.writer.println();
		Tester.writer.println("Number of nodes: " + nodes.size());
		Tester.writer.println("Number of edges: " + edgeCount);
		Tester.writer.println();
		
		Tester.writer.println("***TEST FOR EXISTING EDGE***");
		int first = Tester.fileScanner.nextInt();
		int second = Tester.fileScanner.nextInt();
		Tester.writer.println("Exists edge from " + first + " to " + second + ": " + existEdge(first, second));
		Tester.writer.println();
		
		Tester.writer.println("***TEST FOR DEGREES***");
		first = Tester.fileScanner.nextInt();
		Tester.writer.println("Degrees for node " + first + ":");
		Tester.writer.println("Degree: " + G.degree(first));
		Tester.writer.println("In degree: " + G.inDegree(first));
		Tester.writer.println("Out degree: " + G.outDegree(first) + "\n");
		
		Tester.writer.println("***TEST FOR ADJACENCY***");
		first = Tester.fileScanner.nextInt();
		second = Tester.fileScanner.nextInt();
		Tester.writer.println("Adjacency exists for Nodes " + first + " " + second + ": " + areAdjacent(first, second) + "\n");
		
		Tester.writer.print("***TEST FOR ADJACENT NODES***\n");
		first = Tester.fileScanner.nextInt();
		Tester.writer.print("Adjacencies for Node " + first + ": ");
		printAdj(first);
		
		Tester.writer.print("***TEST FOR EDGE REMOVAL***");
		first = Tester.fileScanner.nextInt();
		second = Tester.fileScanner.nextInt();
		removeEdge(first, second);
		Tester.writer.println("\n After edge removal (" + first + ", " + second + "): ");
		print();
		
		Tester.writer.print("***TEST FOR EDGE PLACEMENT***");
		first = Tester.fileScanner.nextInt();
		second = Tester.fileScanner.nextInt();
		if (Tester.type == 0 || Tester.type == 2){
			int weight = Tester.fileScanner.nextInt();
			putEdge(first, second, weight);
		}
		putEdge(first, second, 0);
		Tester.writer.println("\n After edge placement (" + first + ", " + second + "): ");
		print();
	}//End G
	
	//Methods that are implemented uniformly and ubiquitously across all graph classes.
	protected static Node existNode(int i){
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
	protected abstract boolean areAdjacent(int i, int j);
	protected abstract List<Integer> adjacentVertices(int i);
	protected abstract boolean existEdge(int i, int j);
	protected abstract void removeEdge(int i, int j);
	protected abstract void putEdge(int i, int j, int k);
	protected abstract void print();
	protected abstract void printAdj(int i);
}//End G
