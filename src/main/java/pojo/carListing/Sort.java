package pojo.carListing;

public class Sort {

	private String price;
	private String popularity;
	private String newAddition;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Sort() {
	}

	/**
	 *
	 * @param newAddition
	 * @param price
	 * @param popularity
	 */
	public Sort(String price, String popularity, String newAddition) {
		super();
		this.price = price;
		this.popularity = popularity;
		this.newAddition = newAddition;
	}

	public Sort(String price) {
		super();
		this.price = price;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPopularity() {
		return popularity;
	}

	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}

	public String getNewAddition() {
		return newAddition;
	}

	public void setNewAddition(String newAddition) {
		this.newAddition = newAddition;
	}
}
