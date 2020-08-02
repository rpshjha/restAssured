package pojo.carListing;

public class ColorOption {
	private String colorCode;
	private String colorIcon;
	private String vehicleImage;
	private Integer modelId;
	private Object availableFrom;
	private Integer listingPriority;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ColorOption() {
	}

	/**
	 *
	 * @param colorIcon
	 * @param listingPriority
	 * @param vehicleImage
	 * @param modelId
	 * @param colorCode
	 * @param availableFrom
	 */
	public ColorOption(String colorCode, String colorIcon, String vehicleImage, Integer modelId, Object availableFrom,
			Integer listingPriority) {
		super();
		this.colorCode = colorCode;
		this.colorIcon = colorIcon;
		this.vehicleImage = vehicleImage;
		this.modelId = modelId;
		this.availableFrom = availableFrom;
		this.listingPriority = listingPriority;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public String getColorIcon() {
		return colorIcon;
	}

	public void setColorIcon(String colorIcon) {
		this.colorIcon = colorIcon;
	}

	public String getVehicleImage() {
		return vehicleImage;
	}

	public void setVehicleImage(String vehicleImage) {
		this.vehicleImage = vehicleImage;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public Object getAvailableFrom() {
		return availableFrom;
	}

	public void setAvailableFrom(Object availableFrom) {
		this.availableFrom = availableFrom;
	}

	public Integer getListingPriority() {
		return listingPriority;
	}

	public void setListingPriority(Integer listingPriority) {
		this.listingPriority = listingPriority;
	}
}
