import java.util.*;

public class TopoSort {
	
	private static int[] sortedNodes= new int[Tester.size];
	private static Stack<Integer> s = new Stack<Integer>();
	//Constructor for matrix graph representations.
	public TopoSort(Node[][] graph){
		//Step 1 of TopoSort, create stack of Nodes and push Nodes on if their in degree is 0.
		s = new Stack<Integer>();
		for (int i = 1; i < graph.length; i++){
			int indegree = G.inDegree(i);
			if (indegree == 0){
				s.push(i);
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
		//Step 3 of TopoSort.
		if (i > graph.length){
			Tester.writer.println("\n\nNodes after topological sorting: ");
			for (int k = 0; k < sortedNodes.length; k++){
				Tester.writer.print(sortedNodes[k] + " ");
			}
			System.out.println("Topological sort successful.");
		}	
		else{
			Tester.writer.println("GRAPH IS CYCLIC.");
			System.out.println("Topological sort not viable - graph is cyclic.");
		}
	}
	//Constructor for list graph representations.
	public TopoSort(List<Node>[] graph){
		//Step 1 of TopoSort.
		for (int i = 1; i < graph.length; i++){
			int indegree = G.inDegree(i);
			if (indegree == 0)
				s.push(i);
		}
		//Step 2 of TopoSort.
		int i = 1;
		while (!s.isEmpty()){
			int check = s.pop();
			sortedNodes[i-1] = check;
			i++;
			for (int j = 1; j < graph.length; j++){
				Iterator<Node> marker = graph[check].iterator();
				while (marker.hasNext()){
					Node checkNode = marker.next();
					int value = checkNode.getNodeValue();
					G.inDegrees[value]--;
					if (G.inDegree(value) == 0 && value != check)
						s.push(value);
				}
			}
		}
		//Step 3 of TopoSort.
		if (i > graph.length-1){
			Tester.writer.println("Nodes after topological sorting: \n");
			for (int k = 0; k < sortedNodes.length; k++){
				Tester.writer.print(sortedNodes[k] + " ");
			}
			System.out.println("Topological sort successful.");
		}
		else{
			System.out.println("GRAPH IS CYCLIC.");
			Tester.writer.println("Topological sort not viable - graph is cyclic.");
		}	
	}
	
}//End TopoSort
