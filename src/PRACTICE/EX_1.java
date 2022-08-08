package PRACTICE;

public class EX_1 {
	
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
	public EX_1() {
		this.root = null;
	}
	
	public boolean isBSTornot() {
		return isBSTornot(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBSTornot(Node root, int minValue, int maxValue) {
		if(root == null) {
			return true;
		}
		
		if(root.data >= minValue && root.data <= maxValue && isBSTornot(root.left,minValue, root.data)
				 && isBSTornot(root.right, root.data, maxValue)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		EX_1 bt = new EX_1();
		bt.root= new Node(100);
		bt.root.left= new Node(90); 
		bt.root.right= new Node(110); 
		bt.root.left.left= new Node(80); 
		bt.root.left.right= new Node(95); 
		System.out.println(bt.isBSTornot());
	}

}
