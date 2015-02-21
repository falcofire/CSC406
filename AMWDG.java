import java.util.*;

public class AMWDG extends G{
	
	private static Integer[][] weightedMatrix = new Integer[Tester.size][Tester.size];
	
	public AMWDG(){
	}
	
	protected static boolean existEdge(Edge e){
		Node node1 = e.getVertex1();
		Node node2 = e.getVertex2();
		if (node1.getNode() < Tester.size && node2.getNode() < Tester.size){
			if (weightedMatrix[node1.getNode()][node2.getNode()] != null)
				return true;
			else
				return false;
		}	
		else
			return false;
	}
	
	protected boolean existEdge(int i, int j){
		if (weightedMatrix[i][j] != null)
			return true;
		else
			return false;
	}
	
	
	protected void putEdge(Edge edge){
		if (!existEdge(edge)){
			Node node1 = edge.getVertex1();
			Node node2 = edge.getVertex2();
			int dim1 = node1.getNode();
			int dim2 = node2.getNode();
			int weight = edge.getWeight();
			weightedMatrix[dim1][dim2] = weight;
		}
	}

	protected void putEdge(int i, int j) {
		if (!existEdge(i, j)){
			weightedMatrix[i][j] = (Integer) 1;
		}
	}

	protected static void removeEdge(Edge e) {
		if (existEdge(e)){
			Node node1 = e.getVertex1();
			Node node2 = e.getVertex2();
			weightedMatrix[node1.getNode()][node2.getNode()] = null;
		}	
	}

	protected void removeEdge(int i, int j) {
		weightedMatrix[i][j] = null;
	}
	
	protected static ArrayList<Integer> adjacentVertices(Node i){
		ArrayList<Integer> adjNodes = new ArrayList<Integer>();
		for (int j = 1; j < weightedMatrix.length; j++){
			if (weightedMatrix[i.getNode()][j] != null)
				adjNodes.add(weightedMatrix[i.getNode()][j]);
		}
		return adjNodes;
	}
	
	protected ArrayList<Integer> adjacentVertices(int i){
		ArrayList<Integer> adjNodes = new ArrayList<Integer>();
		for (int j = 1; j < weightedMatrix.length; j++){
			if (weightedMatrix[i][j] != null)
				adjNodes.add(weightedMatrix[i][j]);
		}
		return adjNodes;
	}
	
	protected static boolean areAdjacent(Node i, Node j){
		if (weightedMatrix[i.getNode()][j.getNode()] != null || weightedMatrix[j.getNode()][i.getNode()] != null)
			return true;
		else
			return false;
	}
	
	protected boolean areAdjacent(int i, int j){
		if (weightedMatrix[i][j] != null || weightedMatrix[j][i] != null)
			return true;
		return false;
	}
	
	protected static Integer[][] getMatrix(){
		return weightedMatrix;
	}

	protected void initializeList() {
	}

	protected void putEdge(int i, int j, int k) {
		weightedMatrix[i][j] = k;
		
	}

	protected void print() {
		for (int i = 1; i < weightedMatrix.length; i++){
			for (int j = 1; j < weightedMatrix.length; j++){
				if (weightedMatrix[i][j] != null)
					Tester.writer.print(weightedMatrix[i][j] + " ");
				else
					Tester.writer.print("0 ");
			}
			Tester.writer.println();
		}
	}

	@Override
	protected void printAdj(int i) {
		// TODO Auto-generated method stub
		
	}
	
}//End AMWDG