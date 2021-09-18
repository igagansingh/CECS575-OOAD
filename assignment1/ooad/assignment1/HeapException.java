package ooad.assignment1;

/**
 * An exception class to augment the Heap exception while running a program.
 * 
 * @author Gagandeep Singh, Roshan Gardi
 */
@SuppressWarnings("serial")
public class HeapException extends RuntimeException {

	public HeapException(String message) {
		super(message);
	}
}
