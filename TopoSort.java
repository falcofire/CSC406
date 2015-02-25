import java.util.*;

public class TopoSort {
	G g;
	//Constructor for matrix graph representations.
	public TopoSort(Node[][] graph){
		//Step 1 of TopoSort, create stack of Nodes and push Nodes on if their in degree is 0.
		Stack<Node> s = new Stack<Node>();
		for (int i = 1; i < graph.length; i++){
			int indegree = G.inDegree(i);
			if (indegree == 0){
				Node node = new Node(i);
				s.push(node);
			}	
		}
		//Step 2 of TopoSort.
		int i = 1;
		while (!s.isEmpty()){
			Node check = s.pop();
			i++;
			int index = check.getNode();
			for (int j = 1; j < graph.length; j++){
				if (graph[index][j] != null){
					G.inDegrees[j]--;
					if (G.inDegree(j) == 0 && j != index)
						s.push(graph[index][j]);
				}	
			}
				
		}
		//Step 3 of TopoSort
		if (i > graph.length-1)
			System.out.println("GRAPH IS CYCLIC");
		else
			System.out.println("GRAPH SORT SUCCESSFUL");
		
	}
	//Constructor for list graph representations.
	public TopoSort(List<Node>[] graph, int numNodes){
		
	}
	
}
