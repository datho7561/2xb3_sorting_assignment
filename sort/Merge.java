package sort;

/**
 * Implementation of sortMergeTD heavily inspired by the version in Algorithms by Sedgewick and Wayne.
 * @author David Thompson
 */
public class Merge {
	
	private static Comparable[] aux;
	
	/**
	 * top-down merge sort using Comparable
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortMergeTD (Comparable[] x, int n) {
		aux = new Comparable[n];
		sortMergeTD(x, 0, n - 1);
	}
	
	/**
	 * Sort the subarray in the given bounds.
	 * @param x The array from which to get the subarray
	 * @param begin The beginning bound of the subarray
	 * @param end The end bound of the subarray (exclusive)
	 */
	private static void sortMergeTD(Comparable[] x, int begin, int end) {
		
		if (end <= begin) return;
		
		int middle = begin + (end-begin)/2;
		
		sortMergeTD(x, begin, middle);
		sortMergeTD(x, middle + 1, end);
		
		mergeTD(x, begin, middle, end);
		
	}
	
	/**
	 * bottom-up merge sort using Comparable
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortMergeBU (Comparable[] x, int n) {
		
		aux = new Comparable[n];
		
		// Increase the subarray size by a factor of two each iteration (so log(n) iterations)
		for (int subarraySize = 1; subarraySize < n; subarraySize *= 2) {
			
			// Go through groups of two subarrays
			for (int subarrayStart = 0; subarrayStart < n; subarrayStart += 2*subarraySize) {
				
				// If the second subarray would start past the end of the array,
				// move to the next subarray size
				if (subarrayStart + subarraySize > n) {
					continue;
				}
				
				// Make the end of the second subarray the minimum of the last index
				// and the index before the next subarray
				int endOfSecondSubarray = subarrayStart + 2*subarraySize > n? n - 1:
					subarrayStart + 2*subarraySize - 1;
				
				// Merge!
				mergeTD(x, subarrayStart, subarrayStart + subarraySize - 1, endOfSecondSubarray);
				
			}
			
		}
		
	}
	
	/**
	 * Merge two subarrays. I used the method from Algorithms by Sedgewick and Wayne on page 271.
	 * @param x The array from which to pull the subarrays
	 * @param begin The beginning of the first subarray
	 * @param middle The last element of the first subarray
	 * @param end The end of the second subarray
	 */
	private static void mergeTD(Comparable[] x, int begin, int middle, int end) {
		
		// Maintain pointers to the first element of each list
		int pointer1 = begin;
		int pointer2 = middle + 1;
		
		// Copy to auxiliary array
		for (int i = begin; i <= end; i++) {
			aux[i] = x[i];
		}
		
		for (int auxIndex = begin; auxIndex <= end; auxIndex++) {
			
			if (pointer1 > middle) {
				x[auxIndex] = aux[pointer2];
				pointer2++;
			} else if (pointer2 > end) {
				x[auxIndex] = aux[pointer1];
				pointer1++;
			} else if (aux[pointer1].compareTo(aux[pointer2]) <= 0) {
				x[auxIndex] = aux[pointer1];
				pointer1++;
			} else {
				x[auxIndex] = aux[pointer2];
				pointer2++;
			}
			
		}
		
	}
	
}
