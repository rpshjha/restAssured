package pojo.modelVariant;

import java.util.ArrayList;
import java.util.List;

public class ModelVariantRequest {

	private List<String> modelCodes = new ArrayList<String>();
	private List<String> variantCodes = new ArrayList<String>();
	private List<String> bodyTypes = new ArrayList<String>();
	private List<String> enginTypes = new ArrayList<String>();
	private List<String> channelTypes = new ArrayList<String>();
	private List<String> colorCodes = new ArrayList<String>();
	private Boolean isColorsRequired;
	private Boolean isBodyTypesRequired;
	private Boolean isEnginTypesRequired;
	private Boolean isChannelTypesRequired;
	private Boolean isTransmissionTypesRequired;
	private Boolean isFuelTypesRequired;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ModelVariantRequest() {
	}

	/**
	 *
	 * @param enginTypes
	 * @param isColorsRequired
	 * @param bodyTypes
	 * @param colorCodes
	 * @param isEnginTypesRequired
	 * @param isChannelTypesRequired
	 * @param variantCodes
	 * @param isTransmissionTypesRequired
	 * @param modelCodes
	 * @param channelTypes
	 * @param isFuelTypesRequired
	 * @param isBodyTypesRequired
	 */
	public ModelVariantRequest(String modelCodes, String variantCodes, String bodyTypes, String enginTypes,
			String channelTypes, String colorCodes, Boolean isColorsRequired, Boolean isBodyTypesRequired,
			Boolean isEnginTypesRequired, Boolean isChannelTypesRequired, Boolean isTransmissionTypesRequired,
			Boolean isFuelTypesRequired) {
		super();
		this.modelCodes.add(modelCodes);
		this.variantCodes.add(variantCodes);
		this.bodyTypes.add(bodyTypes);
		this.enginTypes.add(enginTypes);
		this.channelTypes.add(channelTypes);
		this.colorCodes.add(colorCodes);
		this.isColorsRequired = isColorsRequired;
		this.isBodyTypesRequired = isBodyTypesRequired;
		this.isEnginTypesRequired = isEnginTypesRequired;
		this.isChannelTypesRequired = isChannelTypesRequired;
		this.isTransmissionTypesRequired = isTransmissionTypesRequired;
		this.isFuelTypesRequired = isFuelTypesRequired;
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

}
