package pojo.vehiclePaymentDetails;

import java.util.List;

public class Data {

	private List<Category> categories = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Data() {
	}

	/**
	 *
	 * @param categories
	 */
	public Data(List<Category> categories) {
		super();
		this.categories = categories;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
