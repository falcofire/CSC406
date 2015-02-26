/*
TUBB, ZACHARY
CSC406 SPRING 2015
ASSIGNMENT 1
ASSIGNED: 26 JAN 2015
DUE: 11 FEB 2015
*/
import java.io.*;
import java.util.*;

import org.junit.Before;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tester {
	static Scanner scanner;
	static Scanner fileScanner;
	static PrintWriter writer;
	static String path;
	static String type;
	static int weight;
	static int size;
	static int numEdges;
	static GraphTypes gT;
	
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
		type = fileScanner.next();
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
		
		for (GraphTypes graph: GraphTypes.values()){
			if (type.equals(graph.getValue())){
				gT = graph;
				break;
			}
		}
		
		//Switch here creates appropriate graph object and manipulates with test objects from this class.
		switch (gT){
			case AMWDG: AMWDG AMWDgraph = new AMWDG();
					//Processing for testing the various methods for the data structures.
					Tester.writer.println("Graph statistics: ");
					//Print graph with initial contents.
					AMWDgraph.toString();
					
					Tester.writer.println();
					Tester.writer.println("Number of nodes: " + (Tester.size-1));
					Tester.writer.println("Number of edges: " + G.edgeCount);
					Tester.writer.println();
					
					Tester.writer.println("***TEST FOR EXISTING EDGE***");
					int first = Tester.fileScanner.nextInt();
					int second = Tester.fileScanner.nextInt();
					Tester.writer.println("Exists edge from " + first + " to " + second + ": " + AMWDgraph.existsEdge(first, second));
					Tester.writer.println();
					
					Tester.writer.println("***TEST FOR DEGREES***");
					first = Tester.fileScanner.nextInt();
					Tester.writer.println("Degrees for node " + first + ":");
					Tester.writer.println("Degree: " + G.degree(first));
					Tester.writer.println("In degree: " + G.inDegree(first));
					Tester.writer.println("Out degree: " + G.outDegree(first) + "\n");
					
					Tester.writer.println("***TEST FOR ADJACENCY***");
					first = Tester.fileScanner.nextInt();
					second = Tester.fileScanner.nextInt();
					Tester.writer.println("Adjacency exists for Nodes " + first + " " + second + ": " + AMWDgraph.areAdjacent(first, second) + "\n");
					
					Tester.writer.print("***TEST FOR ADJACENT NODES***\n");
					first = Tester.fileScanner.nextInt();
					Tester.writer.print("Adjacencies for Node " + first + ": ");
					AMWDgraph.adjacentVertices(first);
					
					//***********************ASSIGNMENT 2 ADDITION*****************************************
					AMWDgraph.toposort();
					//***********************ASSIGNMENT 2 ADDITION*****************************************
					
					break;
			case AMDG: AMDG AMDgraph = new AMDG();
					break;
			case AMWG: AMWG AMWgraph = new AMWG();
					break;
			case ALWDG: ALWDG ALWDgraph = new ALWDG();
					break;
			case ALDG: ALDG ALDgraph = new ALDG();
					break;
			case ALWG: ALWG ALWgraph = new ALWG();
					break;
		}
		
		
		System.out.println("Processing complete.");
		scanner.close();
		fileScanner.close();	
		writer.close();
		System.exit(0);
	}//End testMain,
	
	public void testFailure() throws Exception {
	    fail();
	}
}//End Tester