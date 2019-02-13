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
		if (end - begin <= 1) return;
		
		// Partition the array
		int pivot = partition(x, begin, end);
		
		// Recursively quicksort the bottom part
		quicksort(x, begin, pivot - 1);
		
		// Recursively quicksort the top part
		quicksort(x, pivot - 1, end);
		
	}
	
	/**
	 * Partitions the array, returning the final index of the pivot.
	 * @param x The array from which to grab the subarray
	 * @param begin The begin point of the subarray
	 * @param end The end point of the subarray
	 * @return The index of the pivot after partitioning is complete
	 */
	private static int partition(Comparable[] x, int begin, int end) {
		
		int pivotIndex = begin + random.nextInt(end - begin);
		
		// TODO: code me
		
		return pivotIndex;
		
	}
	
	/**
	 * three partition quick sort using Comparable
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortThreePartition (Comparable[] x, int n) {
		
	}

}
