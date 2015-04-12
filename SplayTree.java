
import java.util.*;
//This class constructs a splay tree structure and
//manipulates it appropriately for insertions, deletions
//and searches.
public class SplayTree {
	
	protected static ArrayList<Node> splayTree = new ArrayList<Node>();
	protected static Node rootNode;
	
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
			splayTree.add(node);
			insert(node, rootNode);
			splay(node, node.getParent());
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
			node = successor;
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
		else if (grandParent.getLeft().getRight() == node){
			node.setParent(grandParent);
			grandParent.setLeft(node);
			parent.setRight(node.getLeft());
			if (node.getLeft() != null)
				node.getLeft().setParent(parent);
			node.setLeft(parent);
			parent.setParent(node);
			splay(node, node.getParent());
		}
		else if (grandParent.getRight().getLeft() == node){
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
		else if (grandParent.getRight().getRight() == node){
			grandParent.setParent(parent);
			parent.getLeft().setParent(grandParent);
			parent.setLeft(grandParent);
			splay(node, node.getParent());
		}
		else if (grandParent.getLeft().getLeft() == node){
			grandParent.setParent(parent);
			parent.getRight().setParent(grandParent);
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
	
	protected static void printTree(Node root){
		if (root == null)
			return;
		Tester.writer.print(root.getNodeValue() + "-->");
		if (root.getLeft() != null)
			Tester.writer.print(root.getLeft().getNodeValue());
		if (root.getRight() != null)
			Tester.writer.print(root.getRight().getNodeValue());
		Tester.writer.println();
		printTree(root.getLeft());
		printTree(root.getRight());
		return;
	}
	
}
