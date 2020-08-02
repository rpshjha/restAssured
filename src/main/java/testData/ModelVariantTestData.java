package testData;

import com.opencsv.bean.CsvBindByName;

public class ModelVariantTestData {
	
	public ModelVariantTestData() {
		// TODO Auto-generated constructor stub
	}

	@CsvBindByName
	private String modelCodes = null;
	@CsvBindByName
	private String variantCodes = null;
	@CsvBindByName
	private String bodyTypes = null;
	@CsvBindByName
	private String enginTypes = null;
	@CsvBindByName
	private String channelTypes = null;
	@CsvBindByName
	private String colorCodes = null;
	@CsvBindByName
	private Boolean isColorsRequired;
	@CsvBindByName
	private Boolean isBodyTypesRequired;
	@CsvBindByName
	private Boolean isEnginTypesRequired;
	@CsvBindByName
	private Boolean isChannelTypesRequired;
	@CsvBindByName
	private Boolean isTransmissionTypesRequired;
	@CsvBindByName
	private Boolean isFuelTypesRequired;

	public String getModelCodes() {
		return modelCodes;
	}

	public String getVariantCodes() {
		return variantCodes;
	}

	public String getBodyTypes() {
		return bodyTypes;
	}

	public String getEnginTypes() {
		return enginTypes;
	}

	public String getChannelTypes() {
		return channelTypes;
	}

	public String getColorCodes() {
		return colorCodes;
	}

	public Boolean getIsColorsRequired() {
		return isColorsRequired;
	}

	public Boolean getIsBodyTypesRequired() {
		return isBodyTypesRequired;
	}

	public Boolean getIsEnginTypesRequired() {
		return isEnginTypesRequired;
	}

	public Boolean getIsChannelTypesRequired() {
		return isChannelTypesRequired;
	}

	public Boolean getIsTransmissionTypesRequired() {
		return isTransmissionTypesRequired;
	}

	public Boolean getIsFuelTypesRequired() {
		return isFuelTypesRequired;
	}

}
