import java.util.Iterator;
import java.util.List;


public class FloydsShortestPath {
	
	private static double[][] D = new double[Tester.size][Tester.size];
	private static double inf = Double.POSITIVE_INFINITY;
	
	protected static Node[][] Floyds(Node[][] graph){
		
		for (int i = 0; i < graph.length; i++){
			for (int j = 0; j < graph.length; j++){
				if (i == j && graph[i][j].getWeight() == 0)
					D[i][j] = inf;
				else{
					D[i][j] = graph[i][j].getWeight();
				}
			}
		}
	
		for (int i = 0; i < graph.length; i++){
			for (int j = 0; j < graph.length; j++){
				for (int k = 0; k < graph.length; k++){
					if (D[i][j] > (D[j][k] + D[k][j]))
						D[i][j] = D[j][k] + D[k][j];
				}
			}
		}
		printFloyds();
		return graph;
	}
	
	//This method prepares data from a List representation to be processed in Warshall's Algorithm.
	protected static void FloydsList(List<Node>[] graph){
		Node[][] matrixRep = new Node[graph.length][graph.length];
		for (int i = 1; i < graph.length; i++){
			Iterator<Node> marker = graph[i].iterator();
			while (marker.hasNext()){
				Node node = marker.next();
				matrixRep[i][node.getNodeValue()] = node;
			}
		}
		Floyds(matrixRep);
	}
	
	protected static String printFloyds(){
		String string = "Shortest paths: ";
		string += "\n   [1][2][3][4][5]";
		for (int i = 1; i < Tester.size; i++){
			string += "\n[" + i + "] ";
			for (int j = 1; j < Tester.size; j++){
				string += D[i][j];
			}
		}
		return string;
	}
}
