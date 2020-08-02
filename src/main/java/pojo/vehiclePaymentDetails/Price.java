package pojo.vehiclePaymentDetails;

public class Price {

	private Integer tenure;
	private Float price;
	private String validFrom;
	private String validTo;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Price() {
	}

	/**
	 *
	 * @param price
	 * @param validFrom
	 * @param tenure
	 * @param validTo
	 */
	public Price(Integer tenure, Float price, String validFrom, String validTo) {
		super();
		this.tenure = tenure;
		this.price = price;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}

	public String getValidTo() {
		return validTo;
	}

	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}

}
