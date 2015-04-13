/*
TUBB, ZACHARY
CSC406 SPRING 2015
ASSIGNMENT 4
ASSIGNED: 27 MARCH 2015
DUE: 15 APRIL 2015
*/
import java.util.*;
//This class constructs a splay tree structure and
//manipulates it appropriately for insertions, deletions
//and searches.
public class SplayTree {
	
	protected static ArrayList<Node> splayTree = new ArrayList<Node>();
	protected static Node rootNode;
	protected static int sizeN = 1;
	
	public void put(int n){
		//Create a node object with given integer.
		Node node = new Node(n);
		//Check if root already exists, if not, this node is the root.
		if (rootNode == null){
			rootNode = node;
			return;
		}
		//Find returns the last node it touched if the specified
		//node wasn't found.
		if (find(node, rootNode).getNodeValue() != node.getNodeValue()){
			//Add node to collection.
			splayTree.add(node);
			//Perform binary search tree insert.
			insert(node, rootNode);
			//Print
			Tester.writer.println("After inserting " + node.getNodeValue());
			printTree(node.getParent());
			Tester.writer.println("n(" + node.getNodeValue() + ") =" + findSize(node));
			Tester.writer.println("r(" + node.getNodeValue() + ") =" + findRank(node));
			Tester.writer.println();
			//Splay the inserted node.
			splay(node, node.getParent());
			//Print
			Tester.writer.println("After splaying  " + node.getNodeValue());
			printTree(node);
			Tester.writer.println("n'(" + node.getNodeValue() + ") =" + findSize(node));
			Tester.writer.println("r'(" + node.getNodeValue() + ") =" + findRank(node));
			Tester.writer.println("------------------------------------");
		}
	}
	//Standard binary search tree insert method.
	public void insert(Node n, Node root){
		if (n.getNodeValue() > root.getNodeValue()){
			if (root.getRight() == null){
				root.setRight(n);
				n.setParent(root);
				return;
			}	
			insert(n, root.getRight());
		}
		else{
			if (root.getLeft() == null){
				root.setLeft(n);
				n.setParent(root);
				return;
			}
			insert(n, root.getLeft());
		}
	}
	
	public void remove(int n){
		Node node = new Node(n);
		//Find operation splays the specified node to the root.
		node = find(node, rootNode);
		//There are four cases that need to be accounted for for
		//node removal.
		
		//Case 1: Node is not present in the tree.
		if (node.getNodeValue() != n)
			return;
		//Case 2: Node has no children.
		if (node.getLeft() == null && node.getRight() == null)
			node = null;
		//Case 3: Node has exactly one child.
		else if (node.getLeft() != null){
			node.getLeft().setParent(null);
			rootNode.setNode(node.getLeft().getNodeValue());
			node = null;
		}
		else if (node.getRight() != null){
			node.getRight().setParent(null);
			rootNode.setNode(node.getRight().getNodeValue());
			node = null;
		}
		//Case 4: Node has two children.
		else if (node.getRight() != null && node.getLeft() != null){
			//Find the smallest node that is bigger than node selected
			//for deletion.
			Node successor = findSuccessor(node);
			//Copy successor node into deleted node.
			node.setNode(successor.getNodeValue());
			//If successor had a right child (it can't have a left if it was
			//the smallest node), attach it to its grandparent.
			if (successor.getRight() != null){
				successor.getRight().setParent(successor.getParent());
				successor.getParent().setLeft(successor.getRight());
			}
			//Finally, splay the parent of the node that was removed to 
			//balance out the tree.
			splay(successor.getParent(), successor.getParent().getParent());
			successor = null;
		}
	}
	//splay method accepts the inserted/accessed node and its parent as
	//"root" to determine if we are at the top of the tree or not.
	public void splay(Node node, Node root){
		//There are only three different cases to account for to
		//ensure proper splaying.
		Node parent = node.getParent();
		Node grandParent = parent.getParent();
		//Case 3: Zig (left or right child of root)
		if (root == rootNode){
			if (root.getLeft() == node){
				parent.setParent(node);
				parent.setLeft(node.getRight());
				node.setRight(parent);
				node.setParent(null);
				rootNode = node;
			}
			else if (root.getRight() == node){
				parent.setParent(node);
				parent.setRight(node.getLeft());
				node.setLeft(parent);
				node.setParent(null);
				rootNode = node;
			}
		}
		//Case 1: Zig zag (left child of right child or vice versa)
		else if (grandParent.getLeft() != null && grandParent.getLeft().getRight() == node){
			node.setParent(grandParent);
			grandParent.setLeft(node);
			parent.setRight(node.getLeft());
			if (node.getLeft() != null)
				node.getLeft().setParent(parent);
			node.setLeft(parent);
			parent.setParent(node);
			splay(node, node.getParent());
		}
		else if (grandParent.getRight() != null && grandParent.getRight().getLeft() == node){
			node.setParent(grandParent);
			grandParent.setRight(node);
			parent.setLeft(node.getRight());
			if (node.getRight() != null)
				node.getRight().setParent(parent);
			node.setRight(parent);
			parent.setParent(node);
			splay(node, node.getParent());
		}
		
		//Case 2: Zig zig (right child of right child or vice versa)
		//Note that the parent must be manipulated before the designated
		//splay node is manipulated in this case.
		else if (grandParent.getRight() != null && grandParent.getRight().getRight() == node){
			if (grandParent.getParent() != null){
				parent.setParent(grandParent.getParent());
				grandParent.getParent().setRight(parent);
			}	
			else{
				parent.setParent(null);
				rootNode = parent;
			}
			grandParent.setParent(parent);
			if (parent.getLeft() != null)
				parent.getLeft().setParent(grandParent);
			grandParent.setRight(parent.getLeft());
			parent.setLeft(grandParent);
			splay(node, node.getParent());
		}
		else if (grandParent.getLeft() != null && grandParent.getLeft().getLeft() == node){
			if (grandParent.getParent() != null){
				parent.setParent(grandParent.getParent());
				grandParent.getParent().setLeft(parent);
			}
			else{
				parent.setParent(null);
				rootNode = parent;
			}	
			grandParent.setParent(parent);
			if (parent.getRight() != null)
				parent.getRight().setParent(grandParent);
			grandParent.setLeft(parent.getRight());
			parent.setRight(grandParent);
			splay(node, node.getParent());
		}
	}
	//Standard binary search tree find method to determine locations
	//of nodes in tree.
	public Node find(Node n, Node root){
		if (root != null && (n.getNodeValue() == root.getNodeValue())){
			//Once the node is found, splay it to make it more accessible.
			splay(root, root.getParent());
			return root;
		}	
		else if (root != null){
			if (n.getNodeValue() > root.getNodeValue()){
				if (root.getRight() == null)
					return root;
				return find(n, root.getRight());
			}
			else{
				if (root.getLeft() == null)
					return root;
				return find(n, root.getLeft());
			}
		}
		//Note that find() splays on the last node it touched and then
		//returns that node if it doesn't find the node requested.
		return null;
	}
	//This is a helper method to aid with Case 3 in 
	//removing a node.
	public Node findSuccessor(Node root){
		root = root.getRight();
		while (root.getLeft() != null){
			root = root.getLeft();
		}
		return root;
	}
	//This method determines the number of nodes in a specified node's
	//subtree (including the specified node).
	protected static int findSize(Node n){
		if (n.getLeft() != null){
			sizeN++;
			return findSize(n.getLeft());
		}
		if (n.getRight() != null){
			sizeN++;
			return findSize(n.getRight());
		}
		int size = sizeN;
		sizeN = 1;
		return size;
	}
	//This method finds the rank of the specified node in the tree.
	protected static int findRank(Node n){
		int size = findSize(n);
		float rank = (float) Math.ceil(Math.log10(size));
		return (int)rank;
	}
	
	protected static void printTree(Node root){
		if (root.getLeft() != null || root.getRight() != null)
			Tester.writer.print("\n" + root.getNodeValue());
		if (root.getRight() != null){
			Tester.writer.print("--" + root.getRight().getNodeValue());
		}
		if (root.getLeft() != null){
			Tester.writer.println();
			Tester.writer.print(" \\_" + root.getLeft().getNodeValue());
		}
		Tester.writer.println();
		if (root.getLeft() != null)
			printTree(root.getLeft());
		if (root.getRight() != null)
			printTree(root.getRight());
	}
}
