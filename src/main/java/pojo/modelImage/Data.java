package pojo.modelImage;

import java.util.List;

public class Data {
	private List<ModelImageDTOList> modelImageDTOList = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Data() {
	}

	/**
	 *
	 * @param modelImageDTOList
	 */
	public Data(List<ModelImageDTOList> modelImageDTOList) {
		super();
		this.modelImageDTOList = modelImageDTOList;
	}

	public List<ModelImageDTOList> getModelImageDTOList() {
		return modelImageDTOList;
	}

	public void setModelImageDTOList(List<ModelImageDTOList> modelImageDTOList) {
		this.modelImageDTOList = modelImageDTOList;
	}
}
