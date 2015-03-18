import java.util.Iterator;
import java.util.List;


public class FloydsShortestPath {
	
	private static int[][] D = new int[Tester.size][Tester.size];
	
	protected static int[][] Floyds(Node[][] graph){
		
		for (int i = 1; i < graph.length; i++){
			for (int j = 1; j < graph.length; j++){
				if (i == j && graph[i][j].getWeight() == 0)
					D[i][j] = graph[i][j].getWeight();
					//D[i][j] = Integer.MAX_VALUE;
				else{
					if (graph[i][j] != null)
						D[i][j] = graph[i][j].getWeight();
					else
						D[i][j] = Integer.MAX_VALUE;
				}
			}
		}
	
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
