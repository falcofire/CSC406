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
		
		//Switch here creates appropriate graph object and manipulates with test method calls from this class.
		switch (gT){
			case AMWDG: AMWDG AMWDgraph = new AMWDG();
					
					//***********************ASSIGNMENT 2 ADDITION*****************************************
					AMWDgraph.toposort();
					AMWDgraph.kruskalMST();
					//***********************ASSIGNMENT 2 ADDITION*****************************************
					
					break;
			case AMDG: AMDG AMDgraph = new AMDG();
					AMDgraph.toposort();
					break;
			case AMWG: AMWG AMWgraph = new AMWG();
					AMWgraph.toposort();
					break;
			case ALWDG: ALWDG ALWDgraph = new ALWDG();
					ALWDgraph.toposort();
					ALWDgraph.kruskalMST();
					break;
			case ALDG: ALDG ALDgraph = new ALDG();
					ALDgraph.toposort();
					break;
			case ALWG: ALWG ALWgraph = new ALWG();
					ALWgraph.toposort();
					break;
		}
		
		
		System.out.println("Processing complete. See 'graph_data.txt'.");
		scanner.close();
		fileScanner.close();	
		writer.close();
		System.exit(0);
	}//End testMain,
	
	public void testFailure() throws Exception {
	    fail();
	}
}//End Tester