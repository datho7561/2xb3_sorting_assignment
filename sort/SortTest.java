package sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortTest {

	private Product[] arrayOfProducts;
	private final int NUMBER_OF_PRODUCTS = 10;
	private Random random;
	private final int[] ARRAY_SIZES = {16, 64, 256, 1024, 4096};
	
	private Product[][] testData;
	
	
	// FIXME: Reading from file is currently broken, probably try in a separate method to get entire error message
	@Before
	public void setup() throws IOException {
		
		random = new Random();		
		arrayOfProducts = new Product[NUMBER_OF_PRODUCTS];

		for (int i = 0; i < NUMBER_OF_PRODUCTS; i++) {
			arrayOfProducts[i] = new Product(makeProductID(), random.nextInt());	
		}
		
		// READING DATA FROM FILE PART //
		
		testData = new Product[ARRAY_SIZES.length][];
		
		BufferedReader br = new BufferedReader(new FileReader(new File("data/a1_in.txt")));
		
		String line;
		
		// Keep track of which array is being populated
		int arrayNum = 0;
		
		// While there is still a line to read
		while((line = br.readLine()) != null) {
			
			testData[arrayNum] = new Product[ARRAY_SIZES[arrayNum]];
			
			Scanner lineScanner = new Scanner(line);
			
			// Ignore leading curly brace
			lineScanner.nextByte();
			
			// Delimit by end of pairs
			lineScanner.useDelimiter("},{");
			
			for (int i = 0; i < testData[arrayNum].length; i++) {
				
				String[] data = lineScanner.next().split(",");
				testData[arrayNum][i] = new Product(data[0], Integer.parseInt(data[1]));
				
			}
			
			lineScanner.close();
				
		}
		
		// When done with file close it
		br.close();
		
	}
	
	@Before
	public void setup_test() throws IOException {
		
		
		
	}
	
	@After
	public void tearDown() {
		arrayOfProducts = null;
		testData = null;
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
		
		Merge.sortMergeBU(arrayOfProducts, arrayOfProducts.length);
		
		for (int i = 0; i < NUMBER_OF_PRODUCTS - 1; i++) {
			assert arrayOfProducts[i].compareTo(arrayOfProducts[i+1]) <= 0;
		}
		
	}
	
	@Test
	public void testSortInsert() {
		
		Insertion.sortInsert(arrayOfProducts);
		
		for (int i = 0; i < NUMBER_OF_PRODUCTS - 1; i++) {
			assert arrayOfProducts[i].compareTo(arrayOfProducts[i+1]) <= 0;
		}
		
	}
	
	@Test
	public void testInsertComparable() {
		
		Insertion.sortComparable(arrayOfProducts, arrayOfProducts.length);
		
		for (int i = 0; i < NUMBER_OF_PRODUCTS - 1; i++) {
			assert arrayOfProducts[i].compareTo(arrayOfProducts[i+1]) <= 0;
		}
		
	}
	
	@Test
	public void testInsertBinary() {
		
		Insertion.sortBinary(arrayOfProducts, arrayOfProducts.length);
		
		for (int i = 0; i < NUMBER_OF_PRODUCTS - 1; i++) {
			assert arrayOfProducts[i].compareTo(arrayOfProducts[i+1]) <= 0;
		}
		
	}
	
	@Test
	public void testBasicQuick() {
		// TODO
	}
	
	@Test
	public void testThreePartition() {
		// TODO
	}
	
	@Test
	public void testHeap() {
		// TODO
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
