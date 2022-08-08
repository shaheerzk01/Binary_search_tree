package PRACTICE;

import PRACTICE.EX_4.Node;

public class EX_5 {
	
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
	public EX_5() {
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
	
	public boolean search(int data) {
		return search(this.root, data);
	}
	
	public boolean search(Node root, int data) {
		if(root==null) {
			return false;
		}
		else if(root.data==data) {
			return true;
		}
		else if(root.data > data) {
			return search(root.left, data);
		}
		return search(root.right, data);
	}
	public void preOrder() {
		preOrder(root);
		System.out.println();
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
		EX_5 bst = new EX_5();
		bst.insert(8);
		bst.insert(5);
		bst.insert(9);
		bst.insert(3);
		bst.insert(7);
		bst.preOrder(); 
		System.out.println(bst.search(7));
		long end4 = System.currentTimeMillis();
		long execution4 = end4 - start4;
	    System.out.println("Execution time: " + execution4 + " miliseconds ");
	}

}
