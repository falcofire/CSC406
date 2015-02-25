import java.util.*;


public class TopoSort {
	G g;
	//Constructor for matrix graph representations.
	public TopoSort(Node[][] graph){
		//Step 1 of TopoSort, create stack of Nodes and push Nodes on if their in degree is 0.
		Stack<Node> s = new Stack<Node>();
		for (int i = 1; i < graph.length; i++){
			for (int j = 1; j < graph.length; j++){
				if (graph[i][j] != null){
					int inDegree = G.inDegree(graph[i][j].getNode());
					if (inDegree == 0)
						s.push(graph[i][j]);
				}
			}
		}
		//Step 2 of TopoSort.
		int i = 1;
		while (!s.isEmpty()){
			Node check = s.pop();
			int index = check.getNode();
			for (Node test: g.adjacentVertices(index)){
				System.out.println("Nodes adjacent to " + index + ": " + test.getNode());
				
			}
			i++;
			
		}
		
	}
	//Constructor for list graph representations.
	public TopoSort(List<Node>[] graph, int numNodes){
		
	}
	
}
