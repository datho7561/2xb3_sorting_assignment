package sort;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortTest {

	private Product[] arrayOfProducts;
	private final int NUMBER_OF_PRODUCTS = 10;
	private Random random;
	
	@Before
	public void setup() throws Exception {
		
		random = new Random();		
		arrayOfProducts = new Product[NUMBER_OF_PRODUCTS];

		for (int i = 0; i < NUMBER_OF_PRODUCTS; i++) {
			arrayOfProducts[i] = new Product(makeProductID(), random.nextInt());	
		}
		
	}
	
	@After
	public void tearDown() {
		arrayOfProducts = null;
	}
	
	@Test
	public void testMergeTD() {
		
		Merge.sortMergeTD(arrayOfProducts, arrayOfProducts.length);
		
		for (int i = 0; i < NUMBER_OF_PRODUCTS - 1; i++) {
			assert arrayOfProducts[i].compareTo(arrayOfProducts[i+1]) <= 0;
		}
		
	}
	
	@Test
	public void testMergeBU() {
		
		// TODO: fix the mergesort code
		
		Merge.sortMergeBU(arrayOfProducts, arrayOfProducts.length);
		
		for (int i = 0; i < NUMBER_OF_PRODUCTS - 1; i++) {
			assert arrayOfProducts[i].compareTo(arrayOfProducts[i+1]) <= 0;
		}
		
	}
	
	@Test
	public void testInsertionRegular() {
		
		Insertion.sortInsert(arrayOfProducts);
		
		for (int i = 0; i < NUMBER_OF_PRODUCTS - 1; i++) {
			assert arrayOfProducts[i].compareTo(arrayOfProducts[i+1]) <= 0;
		}
		
	}
	
	@Test
	public void testInsertionComparable() {
		
		Insertion.sortComparable(arrayOfProducts, arrayOfProducts.length);
		
		for (int i = 0; i < NUMBER_OF_PRODUCTS - 1; i++) {
			assert arrayOfProducts[i].compareTo(arrayOfProducts[i+1]) <= 0;
		}
		
	}
	
	@Test
	public void testInsertionBinary() {
		
		Insertion.sortBinary(arrayOfProducts, arrayOfProducts.length);
		
		for (int i = 0; i < NUMBER_OF_PRODUCTS - 1; i++) {
			assert arrayOfProducts[i].compareTo(arrayOfProducts[i+1]) <= 0;
		}
		
	}
	
	/**
	 * Make a random product ID
	 * @return a String product ID
	 */
	private String makeProductID() {
		
		String s = "";
		
		for (int i = 0; i < 5; i++) {
			s += (char)(33 + random.nextInt() % 93);
		}
		
		return s;
		
	}

}
