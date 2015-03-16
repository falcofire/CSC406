import java.util.*;


public class WTransClosure {
	
	protected static Node[][] Warshalls(Node[][] graph) {
		Node[][] transClosure = null;
		
		
		return transClosure;
	}
	
	//This method prepares data from a List representation to be processed in Warshall's Algorithm.
	protected static void WarshallsList(List<Node>[] graph){
		Node[][] matrixRep = new Node[graph.length][graph.length];
		for (int i = 1; i < graph.length; i++){
			Iterator<Node> marker = graph[i].iterator();
			int j = 0;
			while (marker.hasNext()){
				matrixRep[i][j] = marker.next();
				j++;
			}
		}
		Warshalls(matrixRep);
	}
}
