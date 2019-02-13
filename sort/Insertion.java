package sort;

/**
 * A collection of functions for insertion sort
 * @author David Thompson
 */
public class Insertion {
	
	/**
	 * regular insertion sort
	 * @param x - the input array containing products that need to be sorted.
	 */
	public static void sortInsert(Product[] x) {
		
		// For all the items in the array
		for (int i = 0; i < x.length; i++) {
			
			// Used to keep track of the current item to insert is
			int itemToInsert = i;
			
			// While the item is not at the bottom and it is less than the item beneath it
			while (itemToInsert != 0 && isLesser(x[itemToInsert], x[itemToInsert - 1])) {
				
				// Swap the item with the item beneath it
				Product temp = x[itemToInsert];
				x[itemToInsert] = x[itemToInsert - 1];
				x[itemToInsert - 1] = temp;
				
				// Now the item has moved one down. Update variable to reflect that
				itemToInsert--;
				
			}
			
		}
		
	}
	
	/**
	 * Compare two Products and return if the first is 'lesser' by the definition in the assignment
	 * @param a The first item to compare
	 * @param b The second item to compare
	 * @return A boolean representing if the first item is lesser
	 */
	private static boolean isLesser(Product a, Product b) {
		
		int salesDiff = a.getSalesAmt() - b.getSalesAmt();
		
		// If the sales aren't the same, indicate which is larger
		if (salesDiff != 0) {
			return a.getSalesAmt() < b.getSalesAmt();
		}
		
		// If the sales are the same, indicate which comes alphabetically first
		return a.getID().compareTo(b.getID()) < 0;
		
	}
	
	/**
	 * insertion sort using Comparable
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortComparable(Comparable[] x, int n) {
		
		// For all the items in the array
		for (int i = 0; i < x.length; i++) {
			
			// Used to keep track of the current item to insert is
			int itemToInsert = i;
			
			// While the item is not at the bottom and it is less than the item beneath it
			while (itemToInsert != 0
					&& x[itemToInsert].compareTo(x[itemToInsert - 1]) < 0) {
				
				// Swap the item with the item beneath it
				Comparable temp = x[itemToInsert];
				x[itemToInsert] = x[itemToInsert - 1];
				x[itemToInsert - 1] = temp;
				
				// Now the item has moved one down. Update variable to reflect that
				itemToInsert--;
				
			}
			
		}

	}
	
	/**
	 * optimized insertion sort
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortBinary(Comparable[] x, int n) {
		
		// For all the items in the array
		for (int i = 0; i < x.length; i++) {
			
			int swapLocation = binSearch(x, x[i], 0, i);
			
			Comparable temp = x[i];
			
			// Shift starting at the swap location, right up to the item to inserts location
			for (int c = i; c > swapLocation; c--) {
				
				// Shift the item below up
				x[c] = x[c - 1];
				
			}
			
			// Put the item to insert in place
			x[swapLocation] = temp;
			
		}
	
	}
	
	/**
	 * Binary search to find where to put an item into an array to keep it sorted
	 * @param array The array to search in
	 * @param element The element to look for
	 * @param bottom The bottom element of the array to search, inclusive
	 * @param top The top element of the array to search, inclusive
	 * @return The index of where the item should be placed
	 */
	private static int binSearch(Comparable[] array, Comparable element, int bottom, int top) {
		
		if (bottom == top) return bottom;
		
		int middle = bottom + (top-bottom)/2;
		
		int compareResult = element.compareTo(array[middle]);
		
		if (compareResult <= 0) {
			return binSearch(array, element, bottom, middle);
		} else {
			return binSearch(array, element, middle + 1, top);
		}
		
	}
	
}
