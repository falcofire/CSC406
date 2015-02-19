import java.util.*;
public class ALDG extends G{
	
	@SuppressWarnings("unchecked")
	private static List<Integer>[] unweightedList = new List[Tester.size];
	
	public ALDG (){
	}

	protected static boolean existEdge(Edge e) {
		Node node1 = e.getVertex1();
		Node node2 = e.getVertex2();
		Iterator<Integer> marker = unweightedList[node1.getNode()].iterator();
		//While loop checks over all nodes in list to ensure the specified node is not alreay present.
		while (marker.hasNext()){
			Integer check = marker.next();
			if (check == node2.getNode())
				return true;
		}
		return false;
	}

	protected boolean existEdge(int i, int j) {
		if (i < Tester.size){
			Iterator<Integer> marker = unweightedList[i].iterator();
			while (marker.hasNext()){
				Integer check = marker.next();
				if (check == j)
					return true;
			}
		}
		return false;
	}

	protected void putEdge(Edge e) {
		Node node1 = e.getVertex1();
		Node node2 = e.getVertex2();
		int dim1 = node1.getNode();
		if (dim1 < Tester.size){
			unweightedList[dim1].add(node2.getNode());
		}
	}

	protected static void putEdge(int i, int j) {
		Node node2 = new Node(j);
		unweightedList[i].add(node2.getNode());
	}

	protected static void removeEdge(Edge e) {
		if (existEdge(e)){
			Node node1 = e.getVertex1();
			Node node2 = e.getVertex2();
			int dim1 = node1.getNode();
			Iterator<Integer> marker = unweightedList[dim1].iterator();
			while (marker.hasNext()){
				Integer check = marker.next();
				if (check == node2.getNode())
					unweightedList[dim1].remove(check);
			}
		}
	}

	protected void removeEdge(int i, int j) {
		Iterator<Integer> marker = unweightedList[i].iterator();
		while (marker.hasNext()){
			Integer node = marker.next();
			if (node == j){
				unweightedList[i].remove(node);
				break;
			}	
		}
	}
	
	protected static List<Integer> adjacentVertices(Node i) {
		return unweightedList[i.getNode()];
	}

	protected List<Integer> adjacentVertices(int i) {
		return unweightedList[i];
	}

	protected static boolean areAdjacent(Node i, Node j) {
		Edge e = new Edge(i, j);
		if (existEdge(e))
			return true;
		return false;
	}

	protected boolean areAdjacent(int i, int j) {
		Edge e = new Edge(i, j);
		if (existEdge(e))
			return true;
		return false;
	}
	
	protected static List<Integer>[] getList(){
		return unweightedList;
	}
	
	protected void initializeList() {
	    for (int i = 1; i < Tester.size; i++){
	        List<Integer> list = new ArrayList<Integer>();
	        unweightedList[i] = list;
	    }
	}

	@Override
	protected void putEdge(int i, int j, int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void printAdj(int i) {
		// TODO Auto-generated method stub
		
	}

}//End ALDG
