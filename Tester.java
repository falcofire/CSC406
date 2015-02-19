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
	
	@Before public static void setUp(){
		scanner = new Scanner(System.in);
		//Prompt for file.
		System.out.println("Enter file name.");
		path = scanner.next();
		try {
			fileScanner = new Scanner(new FileReader(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		type = fileScanner.nextInt();
		size = fileScanner.nextInt() + 1;
		numEdges = fileScanner.nextInt();
	}//End setUp
	
	public static void main(String[] args){
		setUp();
		testMain();
	}
	
	@SuppressWarnings({ "unused" })
	@Test
	public static void testMain() {
		try {
			writer = new PrintWriter("graph_data.txt", "UTF-8");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		writer.println("Graph Statistics: \n");
		
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
			ALWDG.getList();
					printListArray(list);
					break;
			case 3: ALDG ALDgraph = new ALDG();
					list = ALDG.getList();
					printListArray(list);
					break;
		}
		
		writer.println();
		writer.println("Number of nodes: " + G.numNodes());
		writer.println("Number of edges: " + G.numEdges());
		writer.println();
		
		writer.println("***TEST FOR EXISTING EDGE***");
		int first = fileScanner.nextInt();
		int second = fileScanner.nextInt();
		writer.println("Exists edge from " + first + " to " + second + ": " + G.existEdge(first, second));
		writer.println();
		
		writer.println("***TEST FOR DEGREES***");
		first = fileScanner.nextInt();
		writer.println("Degrees for node " + first + ":");
		writer.println("Degree: " + G.degree(first));
		writer.println("In degree: " + G.inDegree(first));
		writer.println("Out degree: " + G.outDegree(first) + "\n");
		
		writer.println("***TEST FOR ADJACENCY***");
		first = fileScanner.nextInt();
		second = fileScanner.nextInt();
		writer.println("Adjacency exists for Nodes " + first + " " + second + ": " + G.areAdjacent(first, second) + "\n");
		
		writer.print("***TEST FOR ADJACENT NODES***\n");
		first = fileScanner.nextInt();
		writer.print("Adjacencies for Node " + first + ": ");
		printList(G.adjacentVertices(first));
		
		writer.print("***TEST FOR EDGE REMOVAL***");
		first = fileScanner.nextInt();
		second = fileScanner.nextInt();
		G.removeEdge(first, second);
		writer.println("\n After edge removal (" + first + ", " + second + "): ");
		if (type == 0 || type == 1)
			printMatrix();
		else if (type == 2)
			printListArray(list);
		else
			printListArray(list);
		
		writer.print("***TEST FOR EDGE PLACEMENT***");
		first = fileScanner.nextInt();
		second = fileScanner.nextInt();
		if (type == 0 || type == 2){
			int weight = fileScanner.nextInt();
			G.putEdge(first, second, weight);
		}
		G.putEdge(first, second, 0);
		writer.println("\n After edge placement (" + first + ", " + second + "): ");
		if (type == 0 || type == 1)
			printMatrix();
		else if (type == 2)
			printListArray(list);
		else
			printListArray(list);
		writer.println("Processing complete.");
		scanner.close();
		fileScanner.close();	
		writer.close();
		System.exit(0);
	}//End testMain,

	//This method prints out the contents of adjacency matrices.
	private static void printMatrix(){
		for (int i = 1; i < matrix.length; i++){
			for (int j = 1; j < matrix.length; j++){
				if (matrix[i][j] != null)
					writer.print("1 ");
				else
					writer.print("0 ");
			}
			writer.println();
		}
		writer.println();
	}
	//Method to print list structures.
	private static void printListArray(List<Node>[] l){
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
		writer.println();
	}
	
	private static void printList(List<Node> l){
		writer.println();
		Iterator<Node> marker = l.iterator();
		Node node;
		while (marker.hasNext()){
			node = marker.next();
			writer.print(node.getNode() + " ");
		}
		
		writer.println();
	}

	public void testFailure() throws Exception {
	    fail();
	}
	
}//End Tester