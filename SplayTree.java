//This class constructs a splay tree structure and
//manipulates it appropriately for insertions, deletions
//and searches.
public class SplayTree {

	private Node rootNode;
	
	public void put(int n){
		//Create a node object with given integer.
		Node node = new Node(n);
		//Check if root already exists, if not, this node is the root.
		if (rootNode == null){
			rootNode = node;
			return;
		}
		insert(node, rootNode);
		splay(node, node.getParent());
		
		
	}
	
	//Standard binary search tree insert method.
	public void insert(Node n, Node root){
		if (n.getNodeValue() > root.getNodeValue()){
			if (root.getRight() == null){
				root.setRight(n);
				return;
			}	
			insert(n, root.getRight());
		}
		else{
			if (root.getLeft() == null){
				root.setLeft(n);
				return;
			}
			insert(n, root.getLeft());
		}
	}
	
	public void remove(){
		
	}
	
	private void rightRotate(Node n){
		
	}
	
	private void leftRotate(Node n){
		
	}
	//splay method accepts the inserted/accessed node and its parent as
	//"root" to determine if we are at the top of the tree or not.
	public void splay(Node node, Node root){
		//There are only three different cases to account for to
		//ensure proper splaying.
		Node parent = node.getParent();
		Node grandParent = node.getParent();
		//Case 1: Zig zag (left child of right child or vice versa)
		if (grandParent.getLeft().getRight() == node){
			parent.setParent(node);
			parent.setLeft(node.getRight());
			node.setRight(parent);
		}
		else if (grandParent.getRight().getLeft() == node){
			parent.setParent(node);
			parent.setRight(node.getLeft());
			node.setLeft(parent);
		}
		
		//Case 2: Zig zig (right child of right child or vice versa)
		
		//Case 3: Zig (left or right child of root)
		if (root == rootNode){
			
		}
		
	}
	//Standard binary search tree find method to determine locations
	//of nodes in tree.
	public Node find(Node n, Node root){
		if (n.getNodeValue() != root.getNodeValue()){
			if (n.getNodeValue() > root.getNodeValue()){
				find(n, root.getRight());
			}
			else{
				find(n, root.getLeft());
			}
		}
		return root;
	}
	
}
