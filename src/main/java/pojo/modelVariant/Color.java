package pojo.modelVariant;

public class Color {

	private String colorCode;
	private String colorDesc;
	private String colorIcon;
	private String variantImage;
	private Integer priority;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Color() {
	}

	/**
	 *
	 * @param colorIcon
	 * @param colorCode
	 * @param priority
	 * @param colorDesc
	 * @param variantImage
	 */
	public Color(String colorCode, String colorDesc, String colorIcon, String variantImage, Integer priority) {
		super();
		this.colorCode = colorCode;
		this.colorDesc = colorDesc;
		this.colorIcon = colorIcon;
		this.variantImage = variantImage;
		this.priority = priority;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public String getColorDesc() {
		return colorDesc;
	}

	public void setColorDesc(String colorDesc) {
		this.colorDesc = colorDesc;
	}

	public String getColorIcon() {
		return colorIcon;
	}

	public void setColorIcon(String colorIcon) {
		this.colorIcon = colorIcon;
	}

	public String getVariantImage() {
		return variantImage;
	}

	public void setVariantImage(String variantImage) {
		this.variantImage = variantImage;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

}
