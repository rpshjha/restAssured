package pojo.modelVariant;

import java.util.List;

public class Variant {

	private String variantCode;
	private String variantDesc;
	private String manualDesc;
	private String channelType;
	private String channelDesc;
	private String engineType;
	private BodyType bodyType;
	private TransmissionType transmissionType;
	private FuelType fuelType;
	private List<Color> colors = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Variant() {
	}

	/**
	 *
	 * @param bodyType
	 * @param variantDesc
	 * @param manualDesc
	 * @param fuelType
	 * @param variantCode
	 * @param engineType
	 * @param channelType
	 * @param transmissionType
	 * @param channelDesc
	 * @param colors
	 */
	public Variant(String variantCode, String variantDesc, String manualDesc, String channelType, String channelDesc,
			String engineType, BodyType bodyType, TransmissionType transmissionType, FuelType fuelType,
			List<Color> colors) {
		super();
		this.variantCode = variantCode;
		this.variantDesc = variantDesc;
		this.manualDesc = manualDesc;
		this.channelType = channelType;
		this.channelDesc = channelDesc;
		this.engineType = engineType;
		this.bodyType = bodyType;
		this.transmissionType = transmissionType;
		this.fuelType = fuelType;
		this.colors = colors;
	}

	public String getVariantCode() {
		return variantCode;
	}

	public void setVariantCode(String variantCode) {
		this.variantCode = variantCode;
	}

	public String getVariantDesc() {
		return variantDesc;
	}

	public void setVariantDesc(String variantDesc) {
		this.variantDesc = variantDesc;
	}

	public String getManualDesc() {
		return manualDesc;
	}

	public void setManualDesc(String manualDesc) {
		this.manualDesc = manualDesc;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getChannelDesc() {
		return channelDesc;
	}

	public void setChannelDesc(String channelDesc) {
		this.channelDesc = channelDesc;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public BodyType getBodyType() {
		return bodyType;
	}

	public void setBodyType(BodyType bodyType) {
		this.bodyType = bodyType;
	}

	public TransmissionType getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(TransmissionType transmissionType) {
		this.transmissionType = transmissionType;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

}
