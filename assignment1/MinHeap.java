package ooad.assignment1;

public class MinHeap implements Heap {
	
	class Node {
		int val;
		Node left, right;
		
		public Node(int val) {
			this.val = val;
		}
		
		public Node(int val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	private Node root;
	
	public MinHeap() {
		
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public int peek() {
		if(isEmpty()) 
			throw new HeapException("Accessing empty heap.");
		return root.val;
	}

	@Override
	public void add(int element) {
		if(root == null) {
			root = new Node(element);
		} else {
			Node newElement = new Node(element);
			heapify(newElement);
		}
	}

	@Override
	public int remove() {
		throw new HeapException("Method 'remove' not implemented.");
	}
	
	@Override
	public String toString() {
		postorder(root);
		System.out.println();
		return "";
	}
	
	private void heapify(Node newNode) {
		heapify(root, newNode);
	}
	
	private void heapify(Node root, Node newNode) {
		// if leaf node add least value to root and new value to left node
		if(newNode.val < root.val) {
			int temp = root.val;
			root.val = newNode.val;
			newNode.val = temp;
		}
		if(isLeafNode(root)) {
			root.left = newNode;
		} else if(root.right == null){
			root.right = newNode;
		} else {
			int lHeight = getHeight(root.left);
			int rHeight = getHeight(root.right);
			
			if(lHeight<=rHeight) heapify(root.left, newNode);
			else heapify(root.right, newNode);
		}
	}
	
	private boolean isLeafNode(Node root) {
		return (root.left==null && root.right==null);
	}
	
	private int getHeight(Node root) {
		if(root == null) return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	private void inorder(Node node) {
		if(node == null) return;
		inorder(node.left);
		System.out.print(node.val + " ");
		inorder(node.right);
	}
	
	private void postorder(Node node) {
		if(node == null) return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.val + " ");
	}
	
	private void preorder(Node node) {
		if(node == null) return;
		preorder(node.left);
		preorder(node.right);
		System.out.print(node.val + " ");
	}

}