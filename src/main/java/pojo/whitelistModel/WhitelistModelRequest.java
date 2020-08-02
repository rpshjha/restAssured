package pojo.whitelistModel;

import java.util.List;

public class WhitelistModelRequest {

	private List<String> modelCodes = null;
	private List<String> variantCodes = null;
	private List<String> bodyTypes = null;
	private List<String> enginTypes = null;
	private List<String> channelTypes = null;
	private List<String> colorCodes = null;
	private Boolean isColorsRequired;
	private Boolean isBodyTypesRequired;
	private Boolean isEnginTypesRequired;
	private Boolean isChannelTypesRequired;
	private Boolean isTransmissionTypesRequired;
	private Boolean isFuelTypesRequired;
	private String resolution;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public WhitelistModelRequest() {
	}

	/**
	 *
	 * @param enginTypes
	 * @param isColorsRequired
	 * @param bodyTypes
	 * @param isEnginTypesRequired
	 * @param isChannelTypesRequired
	 * @param variantCodes
	 * @param isTransmissionTypesRequired
	 * @param channelTypes
	 * @param isFuelTypesRequired
	 * @param isBodyTypesRequired
	 * @param resolution
	 * @param colorCodes
	 * @param modelCodes
	 */
	public WhitelistModelRequest(List<String> modelCodes, List<String> variantCodes, List<String> bodyTypes,
			List<String> enginTypes, List<String> channelTypes, List<String> colorCodes, Boolean isColorsRequired,
			Boolean isBodyTypesRequired, Boolean isEnginTypesRequired, Boolean isChannelTypesRequired,
			Boolean isTransmissionTypesRequired, Boolean isFuelTypesRequired, String resolution) {
		super();
		this.modelCodes = modelCodes;
		this.variantCodes = variantCodes;
		this.bodyTypes = bodyTypes;
		this.enginTypes = enginTypes;
		this.channelTypes = channelTypes;
		this.colorCodes = colorCodes;
		this.isColorsRequired = isColorsRequired;
		this.isBodyTypesRequired = isBodyTypesRequired;
		this.isEnginTypesRequired = isEnginTypesRequired;
		this.isChannelTypesRequired = isChannelTypesRequired;
		this.isTransmissionTypesRequired = isTransmissionTypesRequired;
		this.isFuelTypesRequired = isFuelTypesRequired;
		this.resolution = resolution;
	}

	public WhitelistModelRequest(Boolean isColorsRequired, Boolean isBodyTypesRequired, Boolean isEnginTypesRequired,
			Boolean isChannelTypesRequired, Boolean isTransmissionTypesRequired, Boolean isFuelTypesRequired,
			String resolution) {
		super();

		this.isColorsRequired = isColorsRequired;
		this.isBodyTypesRequired = isBodyTypesRequired;
		this.isEnginTypesRequired = isEnginTypesRequired;
		this.isChannelTypesRequired = isChannelTypesRequired;
		this.isTransmissionTypesRequired = isTransmissionTypesRequired;
		this.isFuelTypesRequired = isFuelTypesRequired;
		this.resolution = resolution;
	}

	public List<String> getModelCodes() {
		return modelCodes;
	}

	public void setModelCodes(List<String> modelCodes) {
		this.modelCodes = modelCodes;
	}

	public List<String> getVariantCodes() {
		return variantCodes;
	}

	public void setVariantCodes(List<String> variantCodes) {
		this.variantCodes = variantCodes;
	}

	public List<String> getBodyTypes() {
		return bodyTypes;
	}

	public void setBodyTypes(List<String> bodyTypes) {
		this.bodyTypes = bodyTypes;
	}

	public List<String> getEnginTypes() {
		return enginTypes;
	}

	public void setEnginTypes(List<String> enginTypes) {
		this.enginTypes = enginTypes;
	}

	public List<String> getChannelTypes() {
		return channelTypes;
	}

	public void setChannelTypes(List<String> channelTypes) {
		this.channelTypes = channelTypes;
	}

	public List<String> getColorCodes() {
		return colorCodes;
	}

	public void setColorCodes(List<String> colorCodes) {
		this.colorCodes = colorCodes;
	}

	public Boolean getIsColorsRequired() {
		return isColorsRequired;
	}

	public void setIsColorsRequired(Boolean isColorsRequired) {
		this.isColorsRequired = isColorsRequired;
	}

	public Boolean getIsBodyTypesRequired() {
		return isBodyTypesRequired;
	}

	public void setIsBodyTypesRequired(Boolean isBodyTypesRequired) {
		this.isBodyTypesRequired = isBodyTypesRequired;
	}

	public Boolean getIsEnginTypesRequired() {
		return isEnginTypesRequired;
	}

	public void setIsEnginTypesRequired(Boolean isEnginTypesRequired) {
		this.isEnginTypesRequired = isEnginTypesRequired;
	}

	public Boolean getIsChannelTypesRequired() {
		return isChannelTypesRequired;
	}

	public void setIsChannelTypesRequired(Boolean isChannelTypesRequired) {
		this.isChannelTypesRequired = isChannelTypesRequired;
	}

	public Boolean getIsTransmissionTypesRequired() {
		return isTransmissionTypesRequired;
	}

	public void setIsTransmissionTypesRequired(Boolean isTransmissionTypesRequired) {
		this.isTransmissionTypesRequired = isTransmissionTypesRequired;
	}

	public Boolean getIsFuelTypesRequired() {
		return isFuelTypesRequired;
	}

	public void setIsFuelTypesRequired(Boolean isFuelTypesRequired) {
		this.isFuelTypesRequired = isFuelTypesRequired;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

}
