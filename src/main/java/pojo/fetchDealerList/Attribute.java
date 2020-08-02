package pojo.fetchDealerList;

public class Attribute {

	private String attribute;
	private String value;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Attribute() {
	}

	/**
	 *
	 * @param attribute
	 * @param value
	 */
	public Attribute(String attribute, String value) {
		super();
		this.attribute = attribute;
		this.value = value;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
