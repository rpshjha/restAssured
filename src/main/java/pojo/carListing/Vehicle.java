package pojo.carListing;

import java.util.List;

public class Vehicle {
	private Integer categoryId;
	private String registrationType;
	private String channelType;
	private String channelDescription;
	private String bodyType;
	private String desc;
	private String modelCode;
	private String variantCode;
	private String colorType;
	private String transmissionType;
	private String fuelType;
	private BasePrice basePrice;
	private Discount discount;
	private Float netPrice;
	private Float netPriceWithGST;
	private Boolean isTvCertified;
	private List<ColorOption> colorOptions = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Vehicle() {
	}

	/**
	 *
	 * @param bodyType
	 * @param isTvCertified
	 * @param discount
	 * @param netPrice
	 * @param channelType
	 * @param colorType
	 * @param channelDescription
	 * @param colorOptions
	 * @param fuelType
	 * @param registrationType
	 * @param variantCode
	 * @param modelCode
	 * @param transmissionType
	 * @param netPriceWithGST
	 * @param categoryId
	 * @param desc
	 * @param basePrice
	 */
	public Vehicle(Integer categoryId, String registrationType, String channelType, String channelDescription,
			String bodyType, String desc, String modelCode, String variantCode, String colorType,
			String transmissionType, String fuelType, BasePrice basePrice, Discount discount, Float netPrice,
			Float netPriceWithGST, Boolean isTvCertified, List<ColorOption> colorOptions) {
		super();
		this.categoryId = categoryId;
		this.registrationType = registrationType;
		this.channelType = channelType;
		this.channelDescription = channelDescription;
		this.bodyType = bodyType;
		this.desc = desc;
		this.modelCode = modelCode;
		this.variantCode = variantCode;
		this.colorType = colorType;
		this.transmissionType = transmissionType;
		this.fuelType = fuelType;
		this.basePrice = basePrice;
		this.discount = discount;
		this.netPrice = netPrice;
		this.netPriceWithGST = netPriceWithGST;
		this.isTvCertified = isTvCertified;
		this.colorOptions = colorOptions;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getRegistrationType() {
		return registrationType;
	}

	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getChannelDescription() {
		return channelDescription;
	}

	public void setChannelDescription(String channelDescription) {
		this.channelDescription = channelDescription;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public String getColorType() {
		return colorType;
	}

	public void setColorType(String colorType) {
		this.colorType = colorType;
	}

	public String getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public BasePrice getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BasePrice basePrice) {
		this.basePrice = basePrice;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Float getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(Float netPrice) {
		this.netPrice = netPrice;
	}

	public Float getNetPriceWithGST() {
		return netPriceWithGST;
	}

	public void setNetPriceWithGST(Float netPriceWithGST) {
		this.netPriceWithGST = netPriceWithGST;
	}

	public Boolean getIsTvCertified() {
		return isTvCertified;
	}

	public void setIsTvCertified(Boolean isTvCertified) {
		this.isTvCertified = isTvCertified;
	}

	public List<ColorOption> getColorOptions() {
		return colorOptions;
	}

	public void setColorOptions(List<ColorOption> colorOptions) {
		this.colorOptions = colorOptions;
	}
}
