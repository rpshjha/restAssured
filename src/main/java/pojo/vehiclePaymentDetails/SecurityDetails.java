package pojo.vehiclePaymentDetails;

import java.util.List;

public class SecurityDetails {

	private String itemType;
	private String itemDesc;
	private List<Security> security = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public SecurityDetails() {
	}

	/**
	 *
	 * @param itemType
	 * @param security
	 * @param itemDesc
	 */
	public SecurityDetails(String itemType, String itemDesc, List<Security> security) {
		super();
		this.itemType = itemType;
		this.itemDesc = itemDesc;
		this.security = security;
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

	public List<Security> getSecurity() {
		return security;
	}

	public void setSecurity(List<Security> security) {
		this.security = security;
	}

}
