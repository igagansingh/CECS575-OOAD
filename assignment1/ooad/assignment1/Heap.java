package ooad.assignment1;

/**
 * Heap is a special tree-based data structure in which the tree is a complete binary tree.
 * 
 * @author Gagandeep Singh, Roshan Gardi
 */
public interface Heap {

	/**
	 * This function returns if heap is empty or not.
	 * */
	boolean isEmpty();
	
	/**
	 * This function returns the first element from heap.
	 * */
	int peek();
	
	/**
	 * This function adds an element to the heap
	 * */
	void add(int element);
	
	/**
	 * This function removes the element from the heap.
	 * */
	int remove();
	
	/**
	 * This function returns a string of <b>odd numbers</b> in the heap in <b>pre-order</b>.
	 */
	String getOddNumbersInPreOrder();
}
