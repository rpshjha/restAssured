package pojo.vehiclePaymentDetails;

import java.util.List;

public class DiscountDetails {

	private String itemType;
	private String itemDesc;
	private List<Discount> discount = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public DiscountDetails() {
	}

	/**
	 *
	 * @param itemType
	 * @param discount
	 * @param itemDesc
	 */
	public DiscountDetails(String itemType, String itemDesc, List<Discount> discount) {
		super();
		this.itemType = itemType;
		this.itemDesc = itemDesc;
		this.discount = discount;
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

	public List<Discount> getDiscount() {
		return discount;
	}

	public void setDiscount(List<Discount> discount) {
		this.discount = discount;
	}

}
