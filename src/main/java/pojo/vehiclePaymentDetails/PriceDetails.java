package pojo.vehiclePaymentDetails;

import java.util.List;

public class PriceDetails {

	private String itemType;
	private String itemDesc;
	private List<Price> price = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public PriceDetails() {
	}

	/**
	 *
	 * @param itemType
	 * @param price
	 * @param itemDesc
	 */
	public PriceDetails(String itemType, String itemDesc, List<Price> price) {
		super();
		this.itemType = itemType;
		this.itemDesc = itemDesc;
		this.price = price;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public List<Price> getPrice() {
		return price;
	}

	public void setPrice(List<Price> price) {
		this.price = price;
	}

}
