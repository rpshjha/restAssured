package pojo.modelVariant;

import java.util.List;

public class Data {
	private List<ModelVariant> modelVariants = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Data() {
	}

	/**
	 *
	 * @param modelVariants
	 */
	public Data(List<ModelVariant> modelVariants) {
		super();
		this.modelVariants = modelVariants;
	}

	public List<ModelVariant> getModelVariants() {
		return modelVariants;
	}

	public void setModelVariants(List<ModelVariant> modelVariants) {
		this.modelVariants = modelVariants;
	}
}
