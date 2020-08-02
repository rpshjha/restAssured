package pojo.vehicleAttributeMaster;

public class Model {
	private String modelCode;
	private String modelDesc;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Model() {
	}

	/**
	 *
	 * @param modelCode
	 * @param modelDesc
	 */
	public Model(String modelCode, String modelDesc) {
		super();
		this.modelCode = modelCode;
		this.modelDesc = modelDesc;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getModelDesc() {
		return modelDesc;
	}

	public void setModelDesc(String modelDesc) {
		this.modelDesc = modelDesc;
	}

}
