package pojo.modelVariant;

public class FuelType {

	private String id;
	private String name;
	private String image1;
	private String image2;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public FuelType() {
	}

	/**
	 *
	 * @param name
	 * @param id
	 * @param image1
	 * @param image2
	 */
	public FuelType(String id, String name, String image1, String image2) {
		super();
		this.id = id;
		this.name = name;
		this.image1 = image1;
		this.image2 = image2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

}
