import java.util.*;
public abstract class G {
	protected static int size = Tester.size;
	protected static GraphTypes type = Tester.gT;
	protected static int edgeCount = 0;
	protected static int[] degrees = new int[size];
	protected static int[] outDegrees = new int[size + 1];
	protected static int[] inDegrees = new int[size + 1];
	public G () {
		//Checks if structure is a list and if so, initializes the list.
		if (type == GraphTypes.ALDG || type == GraphTypes.ALWDG || type == GraphTypes.ALWG)
			initializeList();
		//While loop checks when to stop processing data as Nodes.
		while (edgeCount < Tester.numEdges){
			int firstNode = Tester.fileScanner.nextInt();
			int weight = 0;
			int secondNode = Tester.fileScanner.nextInt();
			if (type == GraphTypes.ALWDG || type == GraphTypes.ALWG || type == GraphTypes.AMWDG || type == GraphTypes.AMWG){
				weight = Tester.fileScanner.nextInt();
			}	
			
			//Store nodes in appropriate graph data structure at this point according to value of type.
			putEdge(firstNode, secondNode, weight);
			edgeCount++;
			
		}//End while loop
		System.out.println("Graph constructed successfully.");
		
	}//End G constructor
	
	//Methods that are implemented uniformly across all graph classes.
	protected static int degree(Node i){
		return degrees[i.getNodeValue()];
	}
	
	protected static int degree(int i){
		return degrees[i];
	}
	
	protected static int inDegree(Node i){
		return inDegrees[i.getNodeValue()];
	}
	
	protected static int inDegree(int i){
		return inDegrees[i];
	}
	
	protected static int outDegree(Node i){
		return outDegrees[i.getNodeValue()];
	}
	
	protected static int outDegree(int i){
		return outDegrees[i];
	}
	
	protected static void rangeCheck(int i){
		if (i > Tester.size || i < 0){
			System.out.println("Node value (" + i + ") out of range.");
			System.exit(1);
		}		
	}
	
	protected void removeEdge(Node i, Node j1){
		int v1 = i.getNodeValue();
		int v2 = i.getNodeValue();
		removeEdge(v1, v2);
	}
	
	protected void putEdge(Edge e){
		Node v1 = e.getVertex1();
		Node v2 = e.getVertex2();
		putEdge(v1.getNodeValue(),v2.getNodeValue());
	}
	
	protected boolean existEdge(Edge e){
		Node v1 = e.getVertex1();
		Node v2 = e.getVertex2();
		return existsEdge(v1.getNodeValue(),v2.getNodeValue());
	}
	
	//Methods that depend on the class to process.
	protected abstract void initializeList();
	protected abstract boolean areAdjacent(int i, int j);
	protected abstract List<Node> adjacentVertices(int i);
	protected abstract boolean existsEdge(int i, int j);
	protected abstract void removeEdge(int i, int j);
	protected abstract void putEdge(int i, int j);
	protected abstract void putEdge(int i, int j, int k);
	public abstract String toString();
	//******************************ASSIGNMENT 2 ADDITION**************************
	protected abstract void toposort();
	protected abstract void kruskalMST();
	//******************************ASSIGNMENT 2 ADDITION**************************
}//End G