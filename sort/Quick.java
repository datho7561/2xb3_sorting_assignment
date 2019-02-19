package sort;

import java.util.Random;

/**
 * A collection of functions for quicksort
 * @author David Thompson
 */
public class Quick {
	
	private static Random random = new Random();
	
	/**
	 * basic quick sort
	 * @param x - the input array containing products that need to be sorted.
	 */
	public static void sortBasicQuick(Product[] x) {
		quicksort(x, 0, x.length);
	}
	
	/**
	 * Quick sorts the given subarray
	 * @param x The array from which to get a subarray
	 * @param begin The begin point of the subarray
	 * @param end The end point of the subarray
	 */
	private static void quicksort(Comparable[] x, int begin, int end) {
		
		// If the subarray is one or zero long, it is sorted
		if (end - 1 <= begin) return;
		
		// Partition the array
		int pivot = partition(x, begin, end);
		
		// Recursively quicksort the bottom part
		quicksort(x, begin, pivot);
		
		// Recursively quicksort the top part
		quicksort(x, pivot + 1, end);
		
	}
	
	/**
	 * Quick sort the given subarray using median of 3 partitioning
	 * @param x The array from which to get a subarray
	 * @param begin The begin point of the subarray
	 * @param end The end point of the subarray
	 */
	private static void quicksort3(Comparable[] x, int begin, int end) {
		
		// If the subarray is one or zero long, it is sorted
		if (end - 1 <= begin) return;
		
		// Partition the array
		int pivot = partition3(x, begin, end);
		
		// Recursively quicksort the bottom part
		quicksort(x, begin, pivot);
		
		// Recursively quicksort the top part
		quicksort(x, pivot + 1, end);
		
	}
	
	/**
	 * Partitions the array, returning the final index of the pivot.
	 * @param x The array from which to grab the subarray
	 * @param begin The begin point of the subarray
	 * @param end The end point of the subarray
	 * @return The index of the pivot after partitioning is complete
	 */
	private static int partition(Comparable[] x, int begin, int end) {
		
		Comparable temp;
		
		// TODO: be less salty
		// I am stuck with bandaid code cause bandaid stuck on me
		// Just check for a swap in this case
		if (begin + 2 == end) {
			
			if (x[begin].compareTo(x[begin + 1]) > 0) {
				temp = x[begin];
				x[begin] = x[begin + 1];
				x[begin + 1] = temp;
			}
			
			// This should stop the algorithm from doing more harm
			return begin + 1;
			
		}
		
		int pivotIndex = begin + random.nextInt(end - begin);
		
		temp = x[pivotIndex];
		x[pivotIndex] = x[begin];
		x[begin] = temp;
		
		// The pivot is not at begin
		
		int bottom = begin + 1;
		int top = end - 1;
		
		while (bottom < top) {
			
			// Move the bottom until it reaches an out of place element
			while (bottom < end && x[bottom].compareTo(x[begin]) < 0) {
				bottom++;
			}
			
			// Keep equal elements in the top partition
			while (top > begin && x[top].compareTo(x[begin]) >= 0) {
				top--;
			}
			
			// If the bottom and top haven't intersected yet, swap 'em
			if (bottom < top) {
				temp = x[top];
				x[top] = x[bottom];
				x[bottom] = temp;
			}
			
		}
		
		// Swap the pivot into place
		temp = x[begin];
		x[begin] = x[top];
		x[top] = temp;
		
		return top;
		
	}
	
	/**
	 * Partitions the array using median of 3 partitioning, returning the
	 * final index of the pivot.
	 * @param x The array from which to grab the subarray
	 * @param begin The begin point of the subarray
	 * @param end The end point of the subarray
	 * @return The index of the pivot after partitioning is complete
	 */
	private static int partition3(Comparable[] x, int begin, int end) {
		
		Comparable temp;
		
		// TODO: be less salty
		// I am stuck with bandaid code cause bandaid stuck on me
		// Just check for a swap in this case
		if (begin + 2 == end) {
			
			if (x[begin].compareTo(x[begin + 1]) > 0) {
				temp = x[begin];
				x[begin] = x[begin + 1];
				x[begin + 1] = temp;
			}
			
			// This should stop the algorithm from doing more harm
			return begin + 1;
			
		}
		
		int pivotA = random.nextInt(end- begin);
		int pivotB = random.nextInt(end- begin);
		int pivotC = random.nextInt(end- begin);
		int pivotIndex;
		
		if (x[pivotA].compareTo(x[pivotB]) < 0) {
			if (x[pivotB].compareTo(x[pivotC]) < 0) {
				pivotIndex = pivotB;
			} else if (x[pivotA].compareTo(x[pivotC]) < 0) {
				pivotIndex = pivotC;
			} else {
				pivotIndex = pivotA;
			}
		} else {
			if (x[pivotA].compareTo(x[pivotC]) < 0) {
				pivotIndex = pivotA;
			} else if (x[pivotB].compareTo(x[pivotC]) < 0) {
				pivotIndex = pivotC;
			} else {
				pivotIndex = pivotB;
			}
		}
		
		temp = x[pivotIndex];
		x[pivotIndex] = x[begin];
		x[begin] = temp;
		
		// The pivot is not at begin
		
		int bottom = begin + 1;
		int top = end - 1;
		
		while (bottom < top) {
			
			// Move the bottom until it reaches an out of place element
			while (bottom < end && x[bottom].compareTo(x[begin]) < 0) {
				bottom++;
			}
			
			// Keep equal elements in the top partition
			while (top > begin && x[top].compareTo(x[begin]) >= 0) {
				top--;
			}
			
			// If the bottom and top haven't intersected yet, swap 'em
			if (bottom < top) {
				temp = x[top];
				x[top] = x[bottom];
				x[bottom] = temp;
			}
			
		}
		
		// Swap the pivot into place
		temp = x[begin];
		x[begin] = x[top];
		x[top] = temp;
		
		return top;
		
	}
	
	/**
	 * three partition quick sort using Comparable
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortThreePartition (Comparable[] x, int n) {
		quicksort3(x, 0, n);
	}

}
