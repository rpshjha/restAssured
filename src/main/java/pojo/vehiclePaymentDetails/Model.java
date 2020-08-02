package pojo.vehiclePaymentDetails;

public class Model {

	private String modelCode;
	private String variantCode;
	private PriceDetails priceDetails;
	private SecurityDetails securityDetails;
	private DiscountDetails discountDetails;
	private Object gstDetails;

	/**
	* No args constructor for use in serialization
	*
	*/
	public Model() {
	}
	
	public Model(String modelCode, String variantCode) {
		super();
		this.modelCode = modelCode;
		this.variantCode = variantCode;
	}

	/**
	*
	* @param securityDetails
	* @param variantCode
	* @param modelCode
	* @param discountDetails
	* @param priceDetails
	* @param gstDetails
	*/
	public Model(String modelCode, String variantCode, PriceDetails priceDetails, SecurityDetails securityDetails, DiscountDetails discountDetails, Object gstDetails) {
	super();
	this.modelCode = modelCode;
	this.variantCode = variantCode;
	this.priceDetails = priceDetails;
	this.securityDetails = securityDetails;
	this.discountDetails = discountDetails;
	this.gstDetails = gstDetails;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getVariantCode() {
		return variantCode;
	}

	public void setVariantCode(String variantCode) {
		this.variantCode = variantCode;
	}

	public PriceDetails getPriceDetails() {
		return priceDetails;
	}

	public void setPriceDetails(PriceDetails priceDetails) {
		this.priceDetails = priceDetails;
	}

	public SecurityDetails getSecurityDetails() {
		return securityDetails;
	}

	public void setSecurityDetails(SecurityDetails securityDetails) {
		this.securityDetails = securityDetails;
	}

	public DiscountDetails getDiscountDetails() {
		return discountDetails;
	}

	public void setDiscountDetails(DiscountDetails discountDetails) {
		this.discountDetails = discountDetails;
	}

	public Object getGstDetails() {
		return gstDetails;
	}

	public void setGstDetails(Object gstDetails) {
		this.gstDetails = gstDetails;
	}

}
