package PRACTICE;

import PRACTICE.EX_3.Node;

public class EX_4 {
	
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
	public EX_4() {
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
	
	public int findMaximum() {
		if(root==null) {
			return -1;
		}
		
		Node current = this.root;
		while(current.right!=null) {
			current = current.right;
		}
		return (current.data);
	}
	
	public static void main(String[] args) {
		
		EX_4 bst = new EX_4();
		long start4 = System.currentTimeMillis();
		bst.insert(8);
		bst.insert(5);
		bst.insert(3);
		bst.insert(7);
		bst.insert(9); System.out.println(bst.findMaximum());
		long end4 = System.currentTimeMillis();
		long execution4 = end4 - start4;
	    System.out.println("Execution time: " + execution4 + " miliseconds ");
	}

}
