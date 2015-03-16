import java.util.*;


public class WTransClosure {
	
	protected static Node[][] Warshalls(Node[][] graph) {
		//Initialize R to the adjacency matrix.
		Node[][] R = graph;
		Node node = new Node(1);
		//For loop limits the iterations of the algorithm to the number of nodes in the graph.
		for (int i = 0; i < graph.length; i++){
			for (int j = 0; j < graph.length; j++){
				for (int k = 0; k < graph.length; k++){
					if (R[i][k].getNodeValue() == 1 && R[k][j].getNodeValue() == 1){
						R[i][j] = node;
					}
				}
			}
		}
		return R;
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
