package pojo.modelImage;

public class ModelImageDTOList {

	private Integer id;
	private Integer modelId;
	private Color color;
	private String imageUrl;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ModelImageDTOList() {
	}

	/**
	 *
	 * @param color
	 * @param modelId
	 * @param imageUrl
	 * @param id
	 */
	public ModelImageDTOList(Integer id, Integer modelId, Color color, String imageUrl) {
		super();
		this.id = id;
		this.modelId = modelId;
		this.color = color;
		this.imageUrl = imageUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
