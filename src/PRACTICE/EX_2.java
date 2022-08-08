package PRACTICE;

import PRACTICE.EX_1.Node;

public class EX_2 {
	
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
	public EX_2() {
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
	
	public void preOrder() {
		preOrder(root);
	}
	
	public void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " "); 
		preOrder(root.left); 
		preOrder(root.right);

	}
	
	public static void main(String[] args) {
		long start4 = System.currentTimeMillis();
		EX_2 bst = new EX_2();
		bst.insert(2);
		bst.insert(4);
		bst.insert(1); 
		bst.insert(3); 
		bst.insert(5); 
		bst.preOrder();
		long end4 = System.currentTimeMillis();
		long execution4 = end4 - start4;
	    System.out.println("Execution time: " + execution4 + " miliseconds ");
	}

}
