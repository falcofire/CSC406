import java.util.*;

public class TopoSort {
	
	private static int[] sortedNodes= new int[Tester.size];
	
	//Constructor for matrix graph representations.
	public TopoSort(Node[][] graph){
		//Step 1 of TopoSort, create stack of Nodes and push Nodes on if their in degree is 0.
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 1; i < graph.length; i++){
			int indegree = G.inDegree(i);
			if (indegree == 0){
				Node node = new Node(i);
				s.push(node.getNodeValue());
			}	
		}
		//Step 2 of TopoSort.
		int i = 1;
		while (!s.isEmpty()){
			int check = s.pop();
			sortedNodes[i-1] = check;
			i++;
			for (int j = 1; j < graph.length; j++){
				if (graph[check][j] != null){
					G.inDegrees[j]--;
					if (G.inDegree(j) == 0 && j != check)
						s.push(graph[check][j].getNodeValue());
				}	
			}
		}
		//Step 3 of TopoSort
		if (i > graph.length-1)
			System.out.println("GRAPH IS CYCLIC");
		else
			System.out.println(sortedNodes.toString());
		
	}
	//Constructor for list graph representations.
	public TopoSort(List<Node>[] graph, int numNodes){
		
	}
	
}
