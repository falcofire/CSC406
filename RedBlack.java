/*
TUBB, ZACHARY
CSC406 SPRING 2015
ASSIGNMENT 5
ASSIGNED: 18 APRIL 2015
DUE: 29 APRIL 2015
*/

//This class reads in integers and creates Node objects.
//It then stores them in a self-balancing Red-Black tree.
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
		
		insert(node, rootNode);
		updateTree(node, node.getParent());
			
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
		if (find(n, rootNode) == null){
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
	}
	
	protected void printTree(Node root){
		if (root.getLeft() != null || root.getRight() != null)
			Tester.writer.print("\n" + root.getNodeValue() + "(" + root.getColor() + ")");
		if (root.getRight() != null){
			Tester.writer.print("--" + root.getRight().getNodeValue() + "(" + root.getColor() + ")");
		}
		if (root.getLeft() != null){
			Tester.writer.println();
			Tester.writer.print(" \\_" + root.getLeft().getNodeValue() + "(" + root.getColor() + ")");
		}
		Tester.writer.println();
		if (root.getLeft() != null)
			printTree(root.getLeft());
		if (root.getRight() != null)
			printTree(root.getRight());
	}
	
	protected void remove(int n){
		
	}
	//Update method checks for violations after the the node
	//has been inserted and performs operations to correct the
	//violation if there is one.
	private void updateTree(Node n, Node parent){
		if (parent != null){
			Node grandParent = parent.getParent();
			//Violation 2: red-red violation.
			if ((parent.getColor() == Node.NodeColor.Red) && (n.getColor() == Node.NodeColor.Red)){
				//parent is the right child of grandparent.
				if (grandParent.getRight() == parent){
					//Case 1: uncle node is red - RECOLOR
					if ((grandParent.getLeft() != null) && (grandParent.getLeft().getColor() == Node.NodeColor.Red)){
						grandParent.setColor(Node.NodeColor.Red);
						parent.setColor(Node.NodeColor.Black);
						grandParent.getLeft().setColor(Node.NodeColor.Black);
					}
					//Case 2: uncle node is black or null - RESTRUCTURE
					else{
						n.setColor(Node.NodeColor.Black);
						grandParent.setColor(Node.NodeColor.Red);
						//n is left child of root. Do RL rotation.
						if (parent.getLeft() == n){
							n.setParent(grandParent);
							grandParent.setRight(n);
							parent.setLeft(n.getRight());
							if (n.getRight() != null)
								n.getRight().setParent(parent);
							n.setRight(parent);
							parent.setParent(n);
						}
						//n is right child of root. Do RR rotation.
						else{
							parent.setRight(n.getLeft());
							if (n.getLeft() != null)
								n.getLeft().setParent(parent);
							parent.setParent(n);
							n.setLeft(parent);
							n.setParent(grandParent);
							grandParent.setRight(n);
						}
						if (parent == rootNode)
							n = rootNode;
					}
				}
				//parent is the left child of grandparent.
				else if (grandParent.getLeft() == parent){
					//Case 1 - RECOLOR
					if ((grandParent.getRight() != null) && (grandParent.getRight().getColor() == Node.NodeColor.Red)){
						grandParent.setColor(Node.NodeColor.Red);
						parent.setColor(Node.NodeColor.Black);
						grandParent.getRight().setColor(Node.NodeColor.Black);
					}
					//Case 2 - RESTRUCTURE
					else{
						n.setColor(Node.NodeColor.Black);
						grandParent.setColor(Node.NodeColor.Red);
						//n is left child of root. Do LL rotation.
						if (parent.getLeft() == n){
							parent.setLeft(n.getRight());
							if (n.getRight() != null)
								n.getRight().setParent(parent);
							parent.setParent(n);
							n.setRight(parent);
							n.setParent(grandParent);
							grandParent.setLeft(n);
						}
						//n is right child of root. Do LR rotation.
						else{
							n.setParent(grandParent);
							grandParent.setLeft(n);
							parent.setRight(n.getLeft());
							if (n.getLeft() != null)
								n.getLeft().setParent(parent);
							n.setLeft(parent);
							parent.setParent(n);
						}
						if (parent == rootNode)
							n = rootNode;
					}
				}
				
			}
			//Violation 1: rootNode is red.
			if (rootNode.getColor() == Node.NodeColor.Red){
				rootNode.setColor(Node.NodeColor.Black);
			}
			if (grandParent != null && grandParent.getParent() != null)
				updateTree(grandParent, grandParent.getParent());
		}
		return;
	}//End updateTree
	
	
	
}
