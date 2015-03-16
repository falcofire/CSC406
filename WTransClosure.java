import java.util.*;

public class WTransClosure {
	protected static Node[][] R;
	protected static Node[][] Warshalls(Node[][] graph) {
		//Initialize R to the adjacency matrix.
		R = graph;
		Node node = new Node(1);
		//For loop limits the iterations of the algorithm to the number of nodes in the graph.
		for (int i = 0; i < graph.length; i++){
			for (int j = 0; j < graph.length; j++){
				for (int k = 0; k < graph.length; k++){
					if (R[i][k] != null && R[k][j] != null){
						R[i][j] = node;
					}
				}
			}
		}
		Tester.writer.println(printWarshalls());
		return R;
	}
	
	//This method prepares data from a List representation to be processed in Warshall's Algorithm.
	protected static void WarshallsList(List<Node>[] graph){
		Node[][] matrixRep = new Node[graph.length][graph.length];
		for (int i = 1; i < graph.length; i++){
			Iterator<Node> marker = graph[i].iterator();
			while (marker.hasNext()){
				Node node = marker.next();
				matrixRep[i][node.getNodeValue()] = node;
			}
		}
		Warshalls(matrixRep);
	}
	
	protected static String printWarshalls(){
		String string = "Transitive closure: ";
		string += "\n   [1][2][3][4][5]";
		for (int i = 1; i < Tester.size; i++){
			string += "\n[" + i + "] ";
			for (int j = 1; j < Tester.size; j++){
				if (R[i][j] != null){
					string += "1  ";
				}
				else
					string += "0  ";
			}
		}
		return string;
	}
}
