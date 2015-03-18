/*
TUBB, ZACHARY
CSC406 SPRING 2015
ASSIGNMENT 3
ASSIGNED: 5 MARCH 2015
DUE: 25 MARCH 2015
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
		//Reads in first string from file to determine the graph type.
		type = fileScanner.next();
		//Reads in first integer from file to determine how many nodes are in graph (add 1 to account for not ever referencing a 0th node.
		size = fileScanner.nextInt() + 1;
		//Reads in next integer from file to determine how many edges are in the graph.
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
					ALWDgraph.floyds();
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