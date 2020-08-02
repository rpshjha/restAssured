package pojo.vehiclePaymentDetails;

public class Security {

	private Integer tenure;
	private String securityType;
	private Float securityValue;
	private String validFrom;
	private String validTo;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Security() {
	}

	/**
	 *
	 * @param securityType
	 * @param validFrom
	 * @param tenure
	 * @param securityValue
	 * @param validTo
	 */
	public Security(Integer tenure, String securityType, Float securityValue, String validFrom, String validTo) {
		super();
		this.tenure = tenure;
		this.securityType = securityType;
		this.securityValue = securityValue;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public String getSecurityType() {
		return securityType;
	}

	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}

	public Float getSecurityValue() {
		return securityValue;
	}

	public void setSecurityValue(Float securityValue) {
		this.securityValue = securityValue;
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
