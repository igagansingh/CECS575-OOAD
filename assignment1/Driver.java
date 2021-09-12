package ooad.assignment1;

public class Driver {

	public static void main(String[] args) {
		Heap heap = new MinHeap();
		heap.add(45);
		heap.add(65);
		heap.add(72);
		heap.add(90);
		heap.add(81);
		heap.add(82);
		heap.add(96);
		heap.add(99);
		heap.add(95);
		heap.add(50);
		System.out.println(heap.peek());
	}
}
