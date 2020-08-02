package pojo.vehicleAttributeMaster;

public class Color {
	private String ecolorCd;
	private String name;
	private String image;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Color() {
	}

	/**
	 *
	 * @param ecolorCd
	 * @param image
	 * @param name
	 */
	public Color(String ecolorCd, String name, String image) {
		super();
		this.ecolorCd = ecolorCd;
		this.name = name;
		this.image = image;
	}

	public String getEcolorCd() {
		return ecolorCd;
	}

	public void setEcolorCd(String ecolorCd) {
		this.ecolorCd = ecolorCd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
