package sort;

/**
 * A collection of functions for heapsort
 * @author David Thompson
 */
public class Heap {
	
	/**
	 * heap sort using Comparable
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortHeap(Comparable[] x, int n) {
		
		// Build the heap
		for (int i = n/2; i >= 1; i--) {
			sink(x, i, n);
		}
		
		// While there is still more than one element to extract
		// from the heap
		while (n > 1) {
			
			// Swap top with bottom
			Comparable temp = x[0];
			x[0] = x[n - 1];
			x[n - 1] = temp;
			
			// Decrease endpoint of heap
			n--;
			
			// Sink new top into heap
			sink(x, 1, n);
			
		}
		
	}
	
	/**
	 * Sink a given element in a heap to fix the heap.
	 * The heap should be stored starting at 0 in the given array
	 * @param x The array where the heap is stored
	 * @param elem The index of the element to sink, where 1 is the top of the heap
	 * @param n The size of the heap
	 */
	private static void sink(Comparable[] x, int elem, int n) {
		
		// If the second child index is in bounds of the heap
		if (2*elem + 1 <= n) {
			
			// The element has two children. Find the index of the max of the children
			int maxChild = x[2*elem - 1].compareTo(x[2*elem]) < 0? 2*elem + 1: 2*elem;
			
			// If one of the children is larger, swap it in, then sink the element
			// in the corresponding subheap recursively
			if (x[elem - 1].compareTo(x[maxChild - 1]) < 0) {
				Comparable temp = x[elem - 1];
				x[elem - 1] = x[maxChild - 1];
				x[maxChild - 1] = temp;
				sink(x, maxChild, n);
			}
		
		// If only the first child's index is in bounds and that child is larger
		} else if (2*elem <= n && x[elem - 1].compareTo(x[2*elem - 1]) < 0) {
			
			// Swap the child in place
			Comparable temp = x[elem - 1];
			x[elem - 1] = x[2*elem - 1];
			x[2*elem - 1] = temp;
			
		}
		
	}
	
}
