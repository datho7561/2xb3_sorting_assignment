package sort;

/**
 * Data type representing an item that is being sold
 * @author David Thompson
 */
public class Product implements Comparable<Product> {
	
	private final String id;
	private int salesAmt;
	
	/**
	 * Make a new Product object.
	 * @param id The string identifier of the product
	 * @param sales The number of sales this product has
	 */
	public Product(String id, int sales) {
		this.id = id;
		this.salesAmt = sales;
	}
	
	/**
	 * Get the ID of this product
	 * @return The string ID of the product
	 */
	public String getID() {
		return this.id;
	}
	
	/**
	 * Get the number of sales for this product.
	 * @return The number of sales, as an integer
	 */
	public int getSalesAmt() {
		return this.salesAmt;
	}
	
	/**
	 * Set a new amount of sales for this Product
	 * @param salesAmt The new amount of sales
	 */
	public void setSalesAmt(int salesAmt) {
		this.salesAmt = salesAmt;
	}
	
	@Override
	public int compareTo(Product that) {
		
		int salesDiff = this.salesAmt - that.salesAmt;
		
		// If the sales aren't the same, indicate whidch is larger
		if (salesDiff != 0) {
			return salesDiff;
		}
		
		// If the sales are the same, indicate which comes alphabetically first
		return this.id.compareTo(that.id);
		
	}
	
	@Override
	public String toString() {
		return "Product: " + this.id;
	}
	
}
