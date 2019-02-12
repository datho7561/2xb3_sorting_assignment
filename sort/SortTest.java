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

//	private Product[] arrayOfProducts;
//	private final int NUMBER_OF_PRODUCTS = 10;
//	private Random random;
	private final int[] ARRAY_SIZES = {16, 64, 256, 1024, 4096};
	
	private Product[][] testData;
	
	
	// FIXME: Reading from file is currently broken, probably try in a separate method to get entire error message
	@Before
	public void setup() throws IOException {
		
//		random = new Random();		
//		arrayOfProducts = new Product[NUMBER_OF_PRODUCTS];
//
//		for (int i = 0; i < NUMBER_OF_PRODUCTS; i++) {
//			arrayOfProducts[i] = new Product(makeProductID(), random.nextInt());	
//		}
		
		// READING DATA FROM FILE PART //
		
		testData = new Product[ARRAY_SIZES.length][];
		
		BufferedReader br = new BufferedReader(new FileReader(new File("data/a1_in.txt")));
		
		String line;
		
		// Keep track of which array is being populated
		int arrayNum = 0;
		
		// While there is still a line to read
		while((line = br.readLine()) != null) {
			
			testData[arrayNum] = new Product[ARRAY_SIZES[arrayNum]];
			
			// Strip of beginning and end of arrays
			Scanner lineScanner = new Scanner(line.substring(1, line.length() - 1));
			
			// Delimit by end of pairs
			lineScanner.useDelimiter("\\},\\{");
			
			for (int i = 0; i < testData[arrayNum].length; i++) {
				
				// Split by the comma, then parse the tokens as a Product
				String[] data = lineScanner.next().split(",");
				testData[arrayNum][i] = new Product(data[0], Integer.parseInt(data[1]));
				
			}
			
			// Finish reading from the line
			lineScanner.close();
			
			// Go to the next list of products
			arrayNum++;
				
		}
		
		// When done with file close it
		br.close();
		
	}
	
	@After
	public void tearDown() {
//		arrayOfProducts = null;
		testData = null;
	}
	
	@Test
	public void testMergeTD() {
		
		for (Product[] productList: testData) {
			Merge.sortMergeTD(productList, productList.length);
			for (int i = 0; i < productList.length - 1; i++) {
				assert productList[i].compareTo(productList[i + 1]) <= 0;
			}
		}
		
	}
	
	@Test
	public void testMergeBU() {
		
		for (Product[] productList: testData) {
			Merge.sortMergeBU(productList, productList.length);
			for (int i = 0; i < productList.length - 1; i++) {
				assert productList[i].compareTo(productList[i + 1]) <= 0;
			}
		}
		
	}
	
	@Test
	public void testSortInsert() {
		
		for (Product[] productList: testData) {
			Insertion.sortInsert(productList);
			for (int i = 0; i < productList.length - 1; i++) {
				assert productList[i].compareTo(productList[i + 1]) <= 0;
			}
		}
		
	}
	
	@Test
	public void testInsertComparable() {
		
		for (Product[] productList: testData) {
			Insertion.sortComparable(productList, productList.length);
			for (int i = 0; i < productList.length - 1; i++) {
				assert productList[i].compareTo(productList[i + 1]) <= 0;
			}
		}
		
	}
	
	@Test
	public void testInsertBinary() {
		
		for (Product[] productList: testData) {
			Insertion.sortBinary(productList, productList.length);
			for (int i = 0; i < productList.length - 1; i++) {
				assert productList[i].compareTo(productList[i + 1]) <= 0;
			}
		}
		
	}
	
	@Test
	public void testBasicQuick() {
		
		for (Product[] productList: testData) {
			Quick.sortBasicQuick(productList);
			for (int i = 0; i < productList.length - 1; i++) {
				assert productList[i].compareTo(productList[i + 1]) <= 0;
			}
		}
		
	}
	
	@Test
	public void testThreePartition() {
		
		for (Product[] productList: testData) {
			Quick.sortThreePartition(productList, productList.length);
			for (int i = 0; i < productList.length - 1; i++) {
				assert productList[i].compareTo(productList[i + 1]) <= 0;
			}
		}
		
	}
	
	@Test
	public void testHeap() {
		
		for (Product[] productList: testData) {
			Heap.sortHeap(productList, productList.length);
			for (int i = 0; i < productList.length - 1; i++) {
				assert productList[i].compareTo(productList[i + 1]) <= 0;
			}
		}
		
	}
	
//	/**
//	 * Make a random product ID
//	 * @return a String product ID
//	 */
//	private String makeProductID() {
//		
//		String s = "";
//		
//		for (int i = 0; i < 5; i++) {
//			s += (char)((int)('a') + (Math.abs(random.nextInt()) % 25));
//		}
//		
//		return s;
//		
//	}

}
