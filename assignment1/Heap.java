package ooad.assignment1;

/**
 * <p>Min-Heap is a complete binary tree wi
 * 
 * <p>The <em>head</em> of this queue is the <em>least</em> element
 * with respect to the specified ordering.  If multiple elements are
 * tied for least value, the head is one of those elements -- ties are
 * broken arbitrarily.  The queue retrieval operations {@code poll},
 * {@code remove}, {@code peek}, and {@code element} access the
 * element at the head of the queue.
 *
 * <p>A priority queue is unbounded, but has an internal
 * <i>capacity</i> governing the size of an array used to store the
 * elements on the queue. It is always at least as large as the queue
 * size.  As elements are added to a priority queue, its capacity
 * grows automatically. The details of the growth policy are not
 * specified.
 *
 * <p>Implementation note: this implementation provides
 * O(log(n)) time for the enqueuing and dequeuing methods
 * ({@code offer}, {@code poll}, {@code remove()} and {@code add});
 * linear time for the {@code remove(Object)} and {@code contains(Object)}
 * methods; and constant time for the retrieval methods
 * ({@code peek}, {@code element}, and {@code size}).
 * 
 * @author Gagandeep Singh, Roshan Gardi
 */
public interface Heap {

	/**
	 * 
	 * O(1)
	 * */
	boolean isEmpty();
	/**
	 * 
	 * O(1)
	 * */
	int peek();
	/**
	 * 
	 * O(log(n))
	 * */
	void add(int element);
	/**
	 * 
	 * O(log(n))
	 * */
	int remove();
}
