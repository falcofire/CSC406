/*
TUBB, ZACHARY
CSC406 SPRING 2015
ASSIGNMENT 1
ASSIGNED: 26 JAN 2015
DUE: 11 FEB 2015
*/
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class Tester {
	static Scanner scanner;
	static Scanner fileScanner;
	static PrintWriter writer;
	static String path;
	static int type;
	static int weight;
	static int size;
	static int numEdges;
	private static Edge[][] matrix;
	private static List<Node>[] list;
	@SuppressWarnings("unused")
	private Node n1, n2, n3, n4, n5, n6, n7, n8;
	@SuppressWarnings("unused")
	private Edge e1, e2, e3, e4, e5, e6, e7, e8;
	
	@Before public void setUp(){
		scanner = new Scanner(System.in);
		//Prompt for file.
		System.out.println("Enter file name.");
		path = scanner.next();
		try {
			fileScanner = new Scanner(new FileReader(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		type = fileScanner.nextInt();
		size = fileScanner.nextInt() + 1;
		numEdges = fileScanner.nextInt();
	}//End setUp
	
	@SuppressWarnings({ "unused" })
	@Test
	public void testMain() {
		try {
			writer = new PrintWriter("graph_data.txt", "UTF-8");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		writer.println("Graph Statistics: ");
		
		//Switch here creates appropriate graph object and manipulates with test objects from this class.
		switch (type){
			case 0: AMWDG AMWDgraph = new AMWDG();
					matrix = AMWDG.getMatrix();
					printMatrix();
					break;
			case 1: AMDG AMDgraph = new AMDG();
					matrix = AMDG.getMatrix();
					printMatrix();
					break;
			case 2: ALWDG ALWDgraph = new ALWDG();
					list = ALWDG.getList();
					printListArray();
					break;
			case 3: ALDG ALDgraph = new ALDG();
					list = ALDG.getList();
					printListArray();
					break;
		}
		
		writer.println();
		writer.println("Declared number of nodes: " + (size - 1));
		writer.println("Actual number of nodes: " + G.numNodes());
		writer.println("Declared number of edges: " + numEdges);
		writer.println("Actual number of edges: " + G.numEdges());
		writer.println();
		
		System.out.println("***TEST FOR EXISTING EDGE*** \n Input two integer representing nodes separated by a space in range 1 - " + (Tester.size - 1));
		int first = scanner.nextInt();
		int second = scanner.nextInt();
		writer.println("Exists edge from " + first + " to " + second + ": " + G.existEdge(first, second));
		writer.println();
		
		System.out.println("***TEST FOR DEGREES*** \n Input node for which to calculate degree statistcs of.");
		first = scanner.nextInt();
		writer.println("Degrees for node " + first + ":");
		writer.println("Degree: " + G.degree(first));
		writer.println("In degree: " + G.inDegree(first));
		writer.println("Out degree: " + G.outDegree(first) + "\n");
		
		System.out.println("***TEST FOR ADJACENCY*** \n Input two integers representing nodes separated by a space to check for adjacency.");
		first = scanner.nextInt();
		second = scanner.nextInt();
		writer.println("Adjacency exists for Nodes " + first + " " + second + ": " + G.areAdjacent(first, second));
		
		System.out.println("***TEST FOR ADJACENT NODES*** \n Input integer representing node to check adjacencies for.");
		first = scanner.nextInt();
		writer.print("Adjacencies for Node " + first + ": ");
		printList(G.adjacentVertices(first));
		
		System.out.println("***TEST FOR EDGE REMOVAL*** \n Input two integers representing nodes connected by an edge to remove that edge.");
		first = scanner.nextInt();
		second = scanner.nextInt();
		G.removeEdge(first, second);
		writer.println("\n After edge removal: ");
		if (type == 0 || type == 1)
			printMatrix();
		else
			printListArray();
		
		System.out.println("***TEST FOR EDGE PLACEMENT*** \n Input two integers representing nodes to place an edge between them.");
		scanner.close();
		fileScanner.close();
		
		
		writer.close();
		System.exit(0);
	}//End testMain,

	//This method prints out the contents of adjacency matrices.
	private void printMatrix(){
		for (int i = 1; i < matrix.length; i++){
			for (int j = 1; j < matrix.length; j++){
				if (matrix[i][j] != null)
					writer.print("1 ");
				else
					writer.print("0 ");
			}
			writer.println();
		}
	}//End printMatrix.
	
	private void printListArray(){
		writer.println();
		writer.println();
		for (int i = 1; i < Tester.size; i++){
			Iterator<Node> marker = list[i].iterator();
			Node node;
			writer.print(i + ": ");
			while (marker.hasNext()){
				node = marker.next();
				writer.print(node.getNode() + " ");
			}
			writer.println();
		}
	}
	
	private void printList(List<Node> l){
		Iterator<Node> marker = l.iterator();
		Node node;
		if (marker.hasNext()){
			while (marker.hasNext()){
				node = marker.next();
				writer.print(node.getNode() + " ");
			}
		}
		else
			writer.print("No adjacent nodes.");
		writer.println();
	}
	
	public void testFailure() throws Exception {
	    fail();
	}
	
}
