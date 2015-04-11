
import java.util.*;
//This class constructs a splay tree structure and
//manipulates it appropriately for insertions, deletions
//and searches.
public class SplayTree {
	
	private ArrayList<Node> splayTree = new ArrayList<Node>();
	private Node rootNode;
	
	public void put(int n){
		//Create a node object with given integer.
		Node node = new Node(n);
		//Check if root already exists, if not, this node is the root.
		if (rootNode == null){
			rootNode = node;
			return;
		}
		if (find(node, rootNode) == null){
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
	
	public void remove(){
		
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
				rootNode = node;
		//		parent.setParent(node);
			}
			else if (root.getRight() == node){
				parent.setParent(node);
				parent.setRight(node.getLeft());
				node.setLeft(parent);
				rootNode = node;
		//		parent.setParent(node);;
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
		if (root != null && (n.getNodeValue() == root.getNodeValue()))
			return root;
		else if (root != null){
			if (n.getNodeValue() > root.getNodeValue()){
				return find(n, root.getRight());
			}
			else{
				return find(n, root.getLeft());
			}
		}
		return null;
	}
}
