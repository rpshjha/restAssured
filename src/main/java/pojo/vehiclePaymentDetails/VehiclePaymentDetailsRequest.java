package pojo.vehiclePaymentDetails;

import java.util.List;

public class VehiclePaymentDetailsRequest {

	private Integer cityId;
	private String tenure;
	private List<Category> categories = null;
	private String startDate;
	private String endDate;
	private Boolean isPriceRequired;
	private Boolean isDiscountRequired;
	private Boolean isSecurityRequired;
	private Boolean isGSTRequired;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public VehiclePaymentDetailsRequest() {
	}

	/**
	 *
	 * @param isSecurityRequired
	 * @param isPriceRequired
	 * @param endDate
	 * @param isGSTRequired
	 * @param cityId
	 * @param categories
	 * @param isDiscountRequired
	 * @param tenure
	 * @param startDate
	 */
	public VehiclePaymentDetailsRequest(Integer cityId, String tenure, List<Category> categories, String startDate,
			String endDate, Boolean isPriceRequired, Boolean isDiscountRequired, Boolean isSecurityRequired,
			Boolean isGSTRequired) {
		super();
		this.cityId = cityId;
		this.tenure = tenure;
		this.categories = categories;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isPriceRequired = isPriceRequired;
		this.isDiscountRequired = isDiscountRequired;
		this.isSecurityRequired = isSecurityRequired;
		this.isGSTRequired = isGSTRequired;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getTenure() {
		return tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Boolean getIsPriceRequired() {
		return isPriceRequired;
	}

	public void setIsPriceRequired(Boolean isPriceRequired) {
		this.isPriceRequired = isPriceRequired;
	}

	public Boolean getIsDiscountRequired() {
		return isDiscountRequired;
	}

	public void setIsDiscountRequired(Boolean isDiscountRequired) {
		this.isDiscountRequired = isDiscountRequired;
	}

	public Boolean getIsSecurityRequired() {
		return isSecurityRequired;
	}

	public void setIsSecurityRequired(Boolean isSecurityRequired) {
		this.isSecurityRequired = isSecurityRequired;
	}

	public Boolean getIsGSTRequired() {
		return isGSTRequired;
	}

	public void setIsGSTRequired(Boolean isGSTRequired) {
		this.isGSTRequired = isGSTRequired;
	}

}
