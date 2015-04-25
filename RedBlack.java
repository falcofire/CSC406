
public class RedBlack {

	protected static Node rootNode;
	
	protected void put(int n){
		
		Node node = new Node (n);
		node.setColor(Node.NodeColor.Red);
		if (rootNode == null){
			rootNode = node;
			rootNode.setColor(Node.NodeColor.Black);
			return;
		}
		
		if (find(node, rootNode) == null){
			insert(node, rootNode);
			updateTree(node, node.getParent());
		}
			
	}
	//Find method returns null if the node is not already present in the tree, if
	//it is, it returns that node.
	protected Node find(Node n, Node root){
		if (root != null && (n.getNodeValue() == root.getNodeValue())){
			return root;
		}	
		else if (root != null){
			if (n.getNodeValue() > root.getNodeValue()){
				if (root.getRight() == null)
					return null;
				return find(n, root.getRight());
			}
			else{
				if (root.getLeft() == null)
					return null;
				return find(n, root.getLeft());
			}
		}
		return null;
	}
	//Standard binary search tree insert.
	private void insert(Node n, Node root){
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
	
	protected void printTree(Node n){
		
	}
	
	protected void remove(int n){
		
	}
	//Update method checks for violations after the the node
	//has been inserted and performs operations to correct the
	//violation if there is one.
	private void updateTree(Node n, Node root){
		if (root != null){
			//Violation 1: rootNode is red.
			if (rootNode.getColor() == Node.NodeColor.Red){
				rootNode.setColor(Node.NodeColor.Black);
			}
			//Violation 2: red-red violation.
			if ((root.getColor() == Node.NodeColor.Red) && (n.getColor() == Node.NodeColor.Red)){
				//root is the right child of grandparent.
				if (root.getParent().getRight() == root){
					//Case 1: uncle node is red - RECOLOR
					if (root.getParent().getLeft().getColor() == Node.NodeColor.Red){
						root.getParent().setColor(Node.NodeColor.Red);
						root.setColor(Node.NodeColor.Black);
						root.getParent().getLeft().setColor(Node.NodeColor.Black);
					}
					//Case 2: uncle node is black or null - RESTRUCTURE
					else{
						n.setColor(Node.NodeColor.Black);
						root.getParent().setColor(Node.NodeColor.Red);
						//n is left child of root. Do RL rotation.
						if (root.getLeft() == n){
							
						}
						//n is right child of root. Do RR rotation.
						else{
							
						}
					}
				}
				//root is the left child of grandparent.
				else if (root.getParent().getLeft() == root){
					//Case 1
					if (root.getParent().getLeft().getColor() == Node.NodeColor.Red){
						root.getParent().setColor(Node.NodeColor.Red);
						root.setColor(Node.NodeColor.Black);
						root.getParent().getRight().setColor(Node.NodeColor.Black);
					}
					//Case 2
					else{
						n.setColor(Node.NodeColor.Black);
						root.getParent().setColor(Node.NodeColor.Red);
						//n is left child of root. Do LL rotation.
						if (root.getLeft() == n){
							
						}
						//n is right child of root. Do LR rotation.
						else{
							
						}
					}
				}
				
			}//End Violation 2
			return;
		}
		return;
	}//End updateTree
	
	
	
}
