package pojo.vehiclePaymentDetails;

import java.util.List;

public class Category {

	private String id;
	private List<Model> models = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Category() {
	}

	/**
	 *
	 * @param models
	 * @param id
	 */
	public Category(String id, List<Model> models) {
		super();
		this.id = id;
		this.models = models;
	}
	
	public Category(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Model> getModels() {
		return models;
	}

	public void setModels(List<Model> models) {
		this.models = models;
	}

}
