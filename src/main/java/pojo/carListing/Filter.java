package pojo.carListing;

import java.util.List;

import org.apache.commons.collections.iterators.FilterListIterator;

public class Filter {
	private Integer cityId;
	private Integer tenureId;
	private Boolean isNew;
	private Object fromDate;
	private Object fuelType;
	private Object transmissionType;
	private Object fromPrice;
	private Object toPrice;
	private Object categoryIds;
	private String resolution;
	private Object bodyType;
	private List<String> modelCode = null;
	private List<String> variantCode = null;
	private Object colorCode;
	private Object channelType;
	private Object registrationType;
	private Boolean withBreakUp;
	private Boolean withoutGst;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Filter() {
	}

	/**
	 *
	 * @param bodyType
	 * @param fromPrice
	 * @param channelType
	 * @param cityId
	 * @param isNew
	 * @param resolution
	 * @param fromDate
	 * @param categoryIds
	 * @param fuelType
	 * @param variantCode
	 * @param registrationType
	 * @param modelCode
	 * @param withoutGst
	 * @param toPrice
	 * @param transmissionType
	 * @param colorCode
	 * @param tenureId
	 * @param withBreakUp
	 */
	public Filter(Integer cityId, Integer tenureId, Boolean isNew, Object fromDate, Object fuelType,
			Object transmissionType, Object fromPrice, Object toPrice, Object categoryIds, String resolution,
			Object bodyType, List<String> modelCode, List<String> variantCode, Object colorCode, Object channelType,
			Object registrationType, Boolean withBreakUp, Boolean withoutGst) {
		super();
		this.cityId = cityId;
		this.tenureId = tenureId;
		this.isNew = isNew;
		this.fromDate = fromDate;
		this.fuelType = fuelType;
		this.transmissionType = transmissionType;
		this.fromPrice = fromPrice;
		this.toPrice = toPrice;
		this.categoryIds = categoryIds;
		this.resolution = resolution;
		this.bodyType = bodyType;
		this.modelCode = modelCode;
		this.variantCode = variantCode;
		this.colorCode = colorCode;
		this.channelType = channelType;
		this.registrationType = registrationType;
		this.withBreakUp = withBreakUp;
		this.withoutGst = withoutGst;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getTenureId() {
		return tenureId;
	}

	public void setTenureId(Integer tenureId) {
		this.tenureId = tenureId;
	}

	public Boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	public Object getFromDate() {
		return fromDate;
	}

	public void setFromDate(Object fromDate) {
		this.fromDate = fromDate;
	}

	public Object getFuelType() {
		return fuelType;
	}

	public void setFuelType(Object fuelType) {
		this.fuelType = fuelType;
	}

	public Object getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(Object transmissionType) {
		this.transmissionType = transmissionType;
	}

	public Object getFromPrice() {
		return fromPrice;
	}

	public void setFromPrice(Object fromPrice) {
		this.fromPrice = fromPrice;
	}

	public Object getToPrice() {
		return toPrice;
	}

	public void setToPrice(Object toPrice) {
		this.toPrice = toPrice;
	}

	public Object getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(Object categoryIds) {
		this.categoryIds = categoryIds;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Object getBodyType() {
		return bodyType;
	}

	public void setBodyType(Object bodyType) {
		this.bodyType = bodyType;
	}

	public List<String> getModelCode() {
		return modelCode;
	}

	public void setModelCode(List<String> modelCode) {
		this.modelCode = modelCode;
	}

	public List<String> getVariantCode() {
		return variantCode;
	}

	public void setVariantCode(List<String> variantCode) {
		this.variantCode = variantCode;
	}

	public Object getColorCode() {
		return colorCode;
	}

	public void setColorCode(Object colorCode) {
		this.colorCode = colorCode;
	}

	public Object getChannelType() {
		return channelType;
	}

	public void setChannelType(Object channelType) {
		this.channelType = channelType;
	}

	public Object getRegistrationType() {
		return registrationType;
	}

	public void setRegistrationType(Object registrationType) {
		this.registrationType = registrationType;
	}

	public Boolean getWithBreakUp() {
		return withBreakUp;
	}

	public void setWithBreakUp(Boolean withBreakUp) {
		this.withBreakUp = withBreakUp;
	}

	public Boolean getWithoutGst() {
		return withoutGst;
	}

	public void setWithoutGst(Boolean withoutGst) {
		this.withoutGst = withoutGst;
	}
}
