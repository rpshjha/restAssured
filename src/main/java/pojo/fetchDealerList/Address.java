package pojo.fetchDealerList;

public class Address {

	private String addressLine1;
	private String addressLine2;
	private String cityCode;
	private String cityName;
	private String stateCode;
	private String stateName;
	private String pincode;
	private Boolean standard;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Address() {
	}

	/**
	 *
	 * @param standard
	 * @param pincode
	 * @param cityName
	 * @param stateName
	 * @param cityCode
	 * @param addressLine1
	 * @param addressLine2
	 * @param stateCode
	 */
	public Address(String addressLine1, String addressLine2, String cityCode, String cityName, String stateCode,
			String stateName, String pincode, Boolean standard) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.stateCode = stateCode;
		this.stateName = stateName;
		this.pincode = pincode;
		this.standard = standard;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Boolean getStandard() {
		return standard;
	}

	public void setStandard(Boolean standard) {
		this.standard = standard;
	}

}
