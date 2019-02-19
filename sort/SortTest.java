package sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for all the sorting methods. The tests also time the runtime
 * of the algorithms.
 * @author David Thompson
 */
public class SortTest {

	// The sizes of the test arrays
	private final int[] ARRAY_SIZES = {16, 64, 256, 1024, 4096};
	
	// To store the test data
	private Product[][] testData;
	
	// To get runtime of the algorithms
	private StopWatch sw = new StopWatch();
	
	/**
	 * Reads the data from file and sets it up in testData.
	 * @throws IOException if the file isn't found
	 */
	@Before
	public void setup() throws IOException {
		
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
	
	/**
	 * Set the testData to be empty
	 */
	@After
	public void tearDown() {
		testData = null;
	}
	
	@Test
	public void testMergeTD() {
		
		for (Product[] productList: testData) {
			sw.tick();
			Merge.sortMergeTD(productList, productList.length);
			sw.tock();
			System.out.println("MergeTD with " + productList.length + " elements: " + sw.getRuntimeNanos() + "ns");
			for (int i = 0; i < productList.length - 1; i++) {
				assert productList[i].compareTo(productList[i + 1]) <= 0;
			}
		}
		
	}
	
	@Test
	public void testMergeBU() {
		
		for (Product[] productList: testData) {
			sw.tick();
			Merge.sortMergeBU(productList, productList.length);
			sw.tock();
			System.out.println("MergeBU with " + productList.length + " elements: " + sw.getRuntimeNanos() + "ns");
			for (int i = 0; i < productList.length - 1; i++) {
				assert productList[i].compareTo(productList[i + 1]) <= 0;
			}
		}
		
	}
	
	@Test
	public void testSortInsert() {
		
		for (Product[] productList: testData) {
			sw.tick();
			Insertion.sortInsert(productList);
			sw.tock();
			System.out.println("InsertNormal with " + productList.length + " elements: " + sw.getRuntimeNanos() + "ns");
			for (int i = 0; i < productList.length - 1; i++) {
				assert productList[i].compareTo(productList[i + 1]) <= 0;
			}
		}
		
	}
	
	@Test
	public void testInsertComparable() {
		
		for (Product[] productList: testData) {
			sw.tick();
			Insertion.sortComparable(productList, productList.length);
			sw.tock();
			System.out.println("InsertComparable with " + productList.length + " elements: " + sw.getRuntimeNanos() + "ns");
			for (int i = 0; i < productList.length - 1; i++) {
				assert productList[i].compareTo(productList[i + 1]) <= 0;
			}
		}
		
	}
	
	@Test
	public void testInsertBinary() {
		
		for (Product[] productList: testData) {
			sw.tick();
			Insertion.sortBinary(productList, productList.length);
			sw.tock();
			System.out.println("InsertBinary with " + productList.length + " elements: " + sw.getRuntimeNanos() + "ns");
			for (int i = 0; i < productList.length - 1; i++) {
				assert productList[i].compareTo(productList[i + 1]) <= 0;
			}
		}
		
	}
	
	@Test
	public void testBasicQuick() {
		
		for (Product[] productList: testData) {
			sw.tick();
			Quick.sortBasicQuick(productList);
			sw.tock();
			System.out.println("QuickBasic with " + productList.length + " elements: " + sw.getRuntimeNanos() + "ns");
			for (int i = 0; i < productList.length - 1; i++) {
				assert productList[i].compareTo(productList[i + 1]) <= 0;
			}
		}
		
	}
	
	@Test
	public void testThreePartition() {
		
		for (Product[] productList: testData) {
			sw.tick();
			Quick.sortThreePartition(productList, productList.length);
			sw.tock();
			System.out.println("Quick3 with " + productList.length + " elements: " + sw.getRuntimeNanos() + "ns");
			for (int i = 0; i < productList.length - 1; i++) {
				assert productList[i].compareTo(productList[i + 1]) <= 0;
			}
		}
		
	}
	
	@Test
	public void testHeap() {
		
		for (Product[] productList: testData) {
			sw.tick();
			Heap.sortHeap(productList, productList.length);
			sw.tock();
			System.out.println("Heap with " + productList.length + " elements: " + sw.getRuntimeNanos() + "ns");
			for (int i = 0; i < productList.length - 1; i++) {
				assert productList[i].compareTo(productList[i + 1]) <= 0;
			}
		}
		
	}
	
}
