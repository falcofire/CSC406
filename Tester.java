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
	static List<Node>[] list;
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
	
		writer.println("Processing complete.");
		scanner.close();
		fileScanner.close();	
		writer.close();
		System.exit(0);
	}//End testMain,

	//This method prints out the contents of adjacency matrices.
	static void printMatrix(){
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
	static void printListArray(List<Node>[] l){
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
	
	static void printList(List<Node> l){
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