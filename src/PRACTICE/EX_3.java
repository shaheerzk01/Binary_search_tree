package PRACTICE;

import PRACTICE.EX_2.Node;

public class EX_3 {
	
	static class Node{
		public int data;
		public Node left;
		public Node right;
		
		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
	}
	public Node root;
	public EX_3() {
		this.root = null;
	}
	
	public void insert(int newData) {
		this.root = insert(root, newData);
	}
	
	public Node insert(Node root, int newData) {
		
		if(root == null) {
			root = new Node(newData);
			return root;
		}
		else if(root.data >= newData) {
			root.left = insert(root.left, newData);
		}
		else {
			root.right = insert(root.right, newData);
		}
		return root;
	}
	
	public void deleteNode(Node node) {
		deleteNode(this.root, node);
	}
	
	public Node deleteNode(Node root, Node node) {
		if(root==null) {
			return null;
		}
		else if(node.data<root.data) {
			root.left = deleteNode(root.left, node);
		}
		else if(node.data>root.data) {
			root.right = deleteNode(root.right,node);
		}
		else if(node.data==root.data) {
			if(root.left != null && root.right !=null) {
				int lmax = findmaxData(root.left);
				root.data = lmax;
				root.left = deleteNode(root.left, new Node(lmax));
				return root;
			}
			else if(root.left != null) {
				return root.left;
			}
			else if(root.right != null) {
				return root.right;
			}
			else {
				return null;
			}
		}
		return root;	
	}
	public int findmaxData(Node root) {
		if(root.right!=null) {
			return findmaxData(root.right);
		}else {
			return root.data;
		}
	}
	
	public void preOrder() {
		preOrder(root);
		System.out.println();
	}
	
	public void preOrder(Node node) {
		if(node!=null) {
			System.out.print(node.data + " "); 
			preOrder(node.left); 
			preOrder(node.right);
		}
		
	}
	
	public static void main(String[] args) {
		long start4 = System.currentTimeMillis();
		// Creating the object of BinarySearchTree class 
		EX_3 bst = new EX_3(); // call the method insert
		bst.insert(8);
		bst.insert(5);
		bst.insert(9);
		bst.insert(3);
		bst.insert(7);
		bst.preOrder();
		bst.deleteNode(new Node(9));
		bst.preOrder();
		long end4 = System.currentTimeMillis();
		long execution4 = end4 - start4;
	    System.out.println("Execution time: " + execution4 + " miliseconds ");
		}

}
