package pojo.vehicleAttributeMaster;

import java.util.List;

public class Data {

	private List<Model> model;
	private List<Variant> variant;
	private List<Color> color;
	private List<BodyType> bodyType;
	private List<ChannelType> channelType;
	private List<RegistrationType> registrationType;
	private List<TransmissionType> transmissionType;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Data() {
	}

	/**
	 *
	 * @param bodyType
	 * @param color
	 * @param registrationType
	 * @param variant
	 * @param model
	 * @param channelType
	 * @param transmissionType
	 */
	public Data(List<Model> model, List<Variant> variant, List<Color> color, List<BodyType> bodyType,
			List<ChannelType> channelType, List<RegistrationType> registrationType,
			List<TransmissionType> transmissionType) {
		super();
		this.model = model;
		this.variant = variant;
		this.color = color;
		this.bodyType = bodyType;
		this.channelType = channelType;
		this.registrationType = registrationType;
		this.transmissionType = transmissionType;
	}

	public Data(List<ChannelType> channelType) {
		super();
		this.channelType = channelType;
	}

	public List<Model> getModel() {
		return model;
	}

	public void setModel(List<Model> model) {
		this.model = model;
	}

	public List<Variant> getVariant() {
		return variant;
	}

	public void setVariant(List<Variant> variant) {
		this.variant = variant;
	}

	public List<Color> getColor() {
		return color;
	}

	public void setColor(List<Color> color) {
		this.color = color;
	}

	public List<BodyType> getBodyType() {
		return bodyType;
	}

	public void setBodyType(List<BodyType> bodyType) {
		this.bodyType = bodyType;
	}

	public List<ChannelType> getChannelType() {
		return channelType;
	}

	public void setChannelType(List<ChannelType> channelType) {
		this.channelType = channelType;
	}

	public List<RegistrationType> getRegistrationType() {
		return registrationType;
	}

	public void setRegistrationType(List<RegistrationType> registrationType) {
		this.registrationType = registrationType;
	}

	public List<TransmissionType> getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(List<TransmissionType> transmissionType) {
		this.transmissionType = transmissionType;
	}

}
