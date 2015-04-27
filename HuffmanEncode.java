/*
TUBB, ZACHARY
CSC406 SPRING 2015
ASSIGNMENT 5
ASSIGNED: 18 APRIL 2015
DUE: 29 APRIL 2015
*/

import java.util.*;

//This class receives text and conduct Huffman encoding on it.
public class HuffmanEncode {

	private static PriorityQueue<Node> theSet;
	private static char[] charTable;
	private static String[] codeTable;
	private int tableCount = 0;
	protected static Node rootNode;
	private static String msg;
	private static char[] msgArray;
	
	protected HuffmanEncode(String message){
		theSet = new PriorityQueue<Node>(freqComparator);
		msg = message;
		msgArray = msg.toCharArray();
		buildSet();
		Tester.writer.println("Received text: " + message);
		Tester.writer.println("Huffman encoding tree: ");
		printTree(HuffmanEncode.rootNode);
		printTables();
		encode();
	}
	//This method constructs the set of characters received and their frequencies.
	private void buildSet(){
		for (int i = 0; i < msgArray.length; i++){
			Node charNode = findCharNodeInSet(msgArray[i]);
			if (charNode == null){
				charNode = new Node(0);
				charNode.setChar(msgArray[i]);
				charNode.setFreq(1);
				theSet.add(charNode);
			}	
			else
				charNode.setFreq(charNode.getFreq() + 1);
		}
		charTable = new char[theSet.size()];
		codeTable = new String[theSet.size()];
		buildTree();
	}
	//Method to build the Huffman tree data structure.
	private void buildTree(){
		while(!theSet.isEmpty()){
			Node n1 = theSet.poll();
			Node n2 = theSet.poll();
			if (n2 != null){
				int freq = n1.getFreq() + n2.getFreq();
				Node joint = new Node(freq);
				joint.setFreq(freq);
				joint.setLeft(n1);
				n1.setParent(joint);
				joint.setRight(n2);
				n2.setParent(joint);
				theSet.add(joint);
			}
			else{
				rootNode = n1;
			}
		}
		buildTable(rootNode, "");
	}
	//Method to construct the tables for characters and their
	//corresponding Huffman codes.
	private void buildTable(Node root, String charCode){
		
		if (root.getLeft() == null && root.getRight() == null){
			charTable[tableCount] = root.getChar();
			codeTable[tableCount] = charCode;
			tableCount++;
		}
		
		if (root.getLeft() != null){
			charCode += "0";
			buildTable(root.getLeft(), charCode);
		}
		if (root.getRight() != null){
			charCode = charCode.substring(0, charCode.length()-1) + "1";
			buildTable(root.getRight(), charCode);
		}
	}
	//Method to apply the Huffman coding to the recevied text. 
	private void encode(){
		String encodedMsg = "";
		for (int i = 0; i < msgArray.length; i++){
			for (int j = 0; j < charTable.length; j++){
				if (msgArray[i] == charTable[j]){
					encodedMsg += codeTable[j];
				}
			}
		}
		Tester.writer.println("Encoded text: " + encodedMsg);
	}
	
	private static Comparator<Node> freqComparator = new Comparator<Node>(){
		public int compare(Node n1, Node n2) {
			return (int) (n1.getFreq() - n2.getFreq());
		}
	};
	//Helper method to find characters in the set.
	private Node findCharNodeInSet(char c){
		Iterator<Node> marker = theSet.iterator();
		while (marker.hasNext()){
			Node n = marker.next();
			if (n.getChar() == c)
				return n;
		}
		return null;
	}
	
	protected void printTables(){
		Tester.writer.println("Character codes: ");
		for (int i = 0; i < charTable.length; i++){
			Tester.writer.println(charTable[i] + ": " + codeTable[i]);
		}
	}
	
	protected void printTree(Node root){
		if (root.getLeft() == null && root.getRight() == null){
			Tester.writer.print(root.getParent().getFreq());
			if (root.getParent().getLeft() == root)
				Tester.writer.print("--");
			else{
				Tester.writer.print("\n \\_");
			}	
			Tester.writer.println(root.getChar() + "," + root.getFreq());
			return;
		}
		Tester.writer.print(root.getFreq());
		if (root.getRight() != null){
			Tester.writer.print("--" + root.getRight().getFreq());
		}
		if (root.getLeft() != null){
			Tester.writer.println();
			Tester.writer.print(" \\_" + root.getLeft().getFreq());
		}
		Tester.writer.println();
		if (root.getLeft() != null)
			printTree(root.getLeft());
		if (root.getRight() != null)
			printTree(root.getRight());
	}
}