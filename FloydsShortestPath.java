import java.util.Iterator;
import java.util.List;


public class FloydsShortestPath {
	
	private static int[][] D = new int[Tester.size][Tester.size];
	
	protected static int[][] Floyds(Node[][] graph){
		Tester.writer.println("Shortest paths implementing Floyd's algorithm: \n");
		for (int i = 1; i < graph.length; i++){
			for (int j = 1; j < graph.length; j++){
				//Initialize all non-diagonal zeros to infinity.
				if (graph[i][j] != null){
					if (i != j && graph[i][j].getWeight() == 0)
						D[i][j] = Integer.MAX_VALUE;
					else
						D[i][j] = graph[i][j].getWeight();
				}
				
				else {
					if (i != j)	
						D[i][j] = Integer.MAX_VALUE;
					else
						D[i][j] = 0;
				}	
				
			}
		}
		Tester.writer.println("Initial adjacency matrix: \n");
		Tester.printMatrix(D);
		for (int k = 1; k < graph.length; k++){
			for (int i = 1; i < graph.length; i++){
				for (int j = 1; j < graph.length; j++){
					//This statement checks for the presence of infinity and processes appropriately as adding any value to
					//Integer.MAX_VALUE results in a negative integer.
					if (!(D[i][k] == Integer.MAX_VALUE || D[k][j] == Integer.MAX_VALUE)){
						if (D[i][j] > D[i][k] + D[k][j])
							D[i][j] = D[i][k] + D[k][j];
					}
				}
			}
		}
		Tester.writer.println("\nFinal matrix: \n");
		return D;
	}
	
	//This method prepares data from a List representation to be processed in Warshall's Algorithm.
	protected static int[][] FloydsList(List<Node>[] graph){
		Node[][] matrixRep = new Node[graph.length][graph.length];
		for (int i = 1; i < graph.length; i++){
			Iterator<Node> marker = graph[i].iterator();
			while (marker.hasNext()){
				Node node = marker.next();
				matrixRep[i][node.getNodeValue()] = node;
			}
		}
		return Floyds(matrixRep);
	}
}
