package PRACTICE;

import PRACTICE.EX_4.Node;

public class EX_6 {
	
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
	public EX_6() {
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
	
	public int findMinimum() {
		if(root == null) {
			return -1;
		}
		Node current = this.root;
		while(current.left!=null) {
			current = current.left;
		}
		return (current.data);
	}
	
	public static void main(String[] args) {
		long start4 = System.currentTimeMillis();
		EX_6 bst = new EX_6();
		bst.insert(8);
		bst.insert(5);
		bst.insert(3);
		bst.insert(7);
		bst.insert(9); 
		System.out.println(bst.findMinimum());
		long end4 = System.currentTimeMillis();
		long execution4 = end4 - start4;
	    System.out.println("Execution time: " + execution4 + " miliseconds ");
	}

}
