package ooad.assignment1;

/**
 * Min-Heap the key present at the root node must be minimum among the keys present at all of it’s children.
 * The same property must be recursively true for all sub-trees in that Binary Tree.
 * 
 * @author Gagandeep Singh, Roshan Gardi
 */
public class MinHeap implements Heap {
	
	/**
	 * A class used to represent each element in the heap.
	 * */
	private class Node {
		int val;
		Node left, right;
		
		Node(int val) {
			this.val = val;
		}
		
		Node(int val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	/**
	 * The root node of this min-heap contains the smallest value in the heap.
	 * If you pick any node in the heap it has a value that is equal to or less than 
	 * all the nodes in either the left or right sub-heaps of the node.
	 */
	private Node root;
	
	public MinHeap() {
		
	}
	
	/**
	 * Checks if the heap is empty or not.
	 * 
	 * @return a boolean which returns if the heap is empty.
	 * */
	@Override
	public boolean isEmpty() {
		return root == null;
	}
	
	/**
	 * This method returns the smallest element from the heap if the heap is not empty, else @throws {@link HeapException()} 
	 * 
	 * @return the node's value.
	 * */
	@Override
	public int peek() {
		if(isEmpty()) 
			throw new HeapException("Accessing empty heap.");
		return root.val;
	}
	
	/**
	 * This method adds a element to the heap.
	 * Addition of a new node in the heap is implemented using {@link MinHeap#heapify(Node)} 
	 * */
	@Override
	public void add(int element) {
		Node newElement = new Node(element);
		heapify(newElement);
	}
	
	/**
	 * This method removes the smallest element from the min-heap.
	 * This method is not yet implemented.
	 * 
	 * @throws {@link HeapException}
	 * */
	@Override
	public int remove() {
		throw new HeapException("Method 'remove' not implemented.");
	}
	
	@Override
	public String getOddNumbersInPreOrder() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		printOddNumbersInPreOrderHelper(root, sb);
		sb.append("]");
		return sb.toString();
	}
	
	/**
	 * When the object of this class is printed, it'll print the pre-order traversal of the min-heap.
	 * 
	 * @return A String containing a pre-order traversal of min-heap
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		postorder(root, sb);
		sb.append("]");
		return sb.toString();
	}
	
	/**
	 * If the heap is empty the newNode becomes the root.
	 * Else we call the {@link MinHeap#heapify(Node, Node) method to add the newNode in the min-heap.
	 * 
	 * @param newNode Node to add in the min-heap.
	 * */
	private void heapify(Node newNode) {
		if(isEmpty()) {
			root = newNode;
		} else {
			heapify(root, newNode);
		}
	}
	
	/**
	 * This method is implemented based using the below algorithm:
	 * If heap is not empty than the smaller of the two values (current value in heap and the new value) is kept in the root. 
	 * The larger of the two values is added to the sub-heap with the smallest height.
	 * If both sub-heaps have the same height then the larger of the two values is added to the left heap.
	 * The process is repeated until the new node is added to the bottom of the heap.
	 * If the bottom node is a leaf node, the new node is added to the left heap.
	 * Else to right of the node.
	 * 
	 * @param root The root node of the current sub-heap
	 * @param newNode Node to add in the min-heap.
	 * */
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

	private void postorder(Node node, StringBuilder sb) {
		if(node == null) return;
		
		postorder(node.left, sb);
		postorder(node.right, sb);
		
		sb.append(node.val);
		sb.append(" ");
	}
		
	private void printOddNumbersInPreOrderHelper(Node node, StringBuilder sb) {
		if(node == null) return;
		
		printOddNumbersInPreOrderHelper(node.left, sb);
		printOddNumbersInPreOrderHelper(node.right, sb);
		
		if(node.val%2 == 1) {
			sb.append(node.val);
			sb.append(" ");
		}
	}
}