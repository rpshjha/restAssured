package pojo.vehiclePaymentDetails;

public class Discount {

	private Integer tenure;
	private String discountType;
	private Float discountValue;
	private String validFrom;
	private String validTo;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Discount() {
	}

	/**
	 *
	 * @param discountType
	 * @param validFrom
	 * @param discountValue
	 * @param tenure
	 * @param validTo
	 */
	public Discount(Integer tenure, String discountType, Float discountValue, String validFrom, String validTo) {
		super();
		this.tenure = tenure;
		this.discountType = discountType;
		this.discountValue = discountValue;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public Float getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(Float discountValue) {
		this.discountValue = discountValue;
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
