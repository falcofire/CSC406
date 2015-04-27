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
	
	@Before public static void setUp() throws GraphExceptions{
		scanner = new Scanner(System.in);
		//Prompt for file.
		System.out.println("Enter file name.");
		path = scanner.next();
		try {
			fileScanner = new Scanner(new FileReader(path));
		} catch (FileNotFoundException e) {
			throw new GraphExceptions("Cannot find that file.");
		}
		//Reads in first string from file to determine the graph type.
		//type = fileScanner.next();
		//Reads in first integer from file to determine how many nodes are in graph (add 1 to account for not ever referencing a 0th node).
		//size = fileScanner.nextInt() + 1;
		//Reads in next integer from file to determine how many edges are in the graph.
		//numEdges = fileScanner.nextInt();
	}//End setUp
	
	public static void main(String[] args) throws GraphExceptions{
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
		
//		for (GraphTypes graph: GraphTypes.values()){
//			if (type.equals(graph.getValue())){
//				gT = graph;
//				break;
//			}
//		}
		
		String message = new String();
		while (fileScanner.hasNextLine()){
			message += (fileScanner.nextLine());
		}
		HuffmanEncode huff = new HuffmanEncode(message);
		
//		RedBlack RBTree = new RedBlack();
//		Tester.writer.println("'--' denotes a right child, '\\_' denotes a left child.\n");
//		while (fileScanner.hasNextInt()){
//			RBTree.put(fileScanner.nextInt());
//		}
//		RBTree.printTree(RBTree.rootNode);
		
		
		//Switch here creates appropriate graph object and manipulates with test method calls from this class.
//		switch (gT){
//			case AMWDG: AMWDG AMWDgraph = new AMWDG();
//					break;
//			case AMDG: AMDG AMDgraph = new AMDG();
//					break;
//			case AMWG: AMWG AMWgraph = new AMWG();
//					break;
//			case ALWDG: ALWDG ALWDgraph = new ALWDG();
//					break;
//			case ALDG: ALDG ALDgraph = new ALDG();
//					break;
//			case ALWG: ALWG ALWgraph = new ALWG();
//					break;
//		}
		
		
		System.out.println("Processing complete. See 'graph_data.txt'.");
		scanner.close();
		fileScanner.close();	
		writer.close();
		System.exit(0);
	}//End testMain,
	
	public void testFailure() throws Exception {
	    fail();
	}
	
	protected static void printMatrix(int[][] matrix){
		String string = "\t";
		for (int i = 1; i < Tester.size; i++){
			string += "[" + i + "]\t";
		}
		for (int i = 1; i < Tester.size; i++){
			string += "\n[" + i + "] \t";
			for (int j = 1; j < Tester.size; j++){
				if (matrix[i][j] != Integer.MAX_VALUE)
					string += matrix[i][j] + "\t";
				else
					string += "INF\t";
			}
		}
		Tester.writer.println(string);
	}
}//End Tester