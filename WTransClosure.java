import java.util.*;

public class WTransClosure {
	protected static int[][] R;
	protected static int[][] Warshalls(Node[][] graph) {
		Tester.writer.println("Transitive closure implementing Warshall's algorithm.\n");
		//Initialize R to the adjacency matrix.
		R = new int[Tester.size][Tester.size];
		for (int i = 1; i < graph.length; i++){
			for (int j = 1; j < graph.length; j++){
				if (graph[i][j] != null)
					R[i][j] = 1;
				else
					R[i][j] = 0;
			}
		}
		Tester.writer.println("Initial adjacency matrix: \n");
		Tester.printMatrix(R);
		//For loop limits the iterations of the algorithm to the number of nodes in the graph.
		for (int k = 1; k < graph.length - 1; k++){
			for (int i = 1; i < graph.length; i++){
				for (int j = 1; j < graph.length; j++){
					if (R[i][k] == 1 && R[k][j] == 1)
						R[i][j] = 1;
				}
			}
		}
		Tester.writer.println("\nFinal matrix: \n");
		return R;
	}
	
	//This method prepares data from a List representation to be processed in Warshall's Algorithm.
	protected static int[][] WarshallsList(List<Node>[] graph){
		Node[][] matrixRep = new Node[graph.length][graph.length];
		for (int i = 1; i < graph.length; i++){
			Iterator<Node> marker = graph[i].iterator();
			while (marker.hasNext()){
				Node node = marker.next();
				matrixRep[i][node.getNodeValue()] = node;
			}
		}
		return Warshalls(matrixRep);
	}
}
