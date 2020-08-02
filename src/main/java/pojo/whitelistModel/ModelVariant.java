package pojo.whitelistModel;

import java.util.List;

public class ModelVariant {
	private String make;
	private String makeCode;
	private String modelCode;
	private String modelDesc;
	private List<Variant> variants = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ModelVariant() {
	}

	/**
	 *
	 * @param modelCode
	 * @param makeCode
	 * @param modelDesc
	 * @param variants
	 * @param make
	 */
	public ModelVariant(String make, String makeCode, String modelCode, String modelDesc, List<Variant> variants) {
		super();
		this.make = make;
		this.makeCode = makeCode;
		this.modelCode = modelCode;
		this.modelDesc = modelDesc;
		this.variants = variants;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getMakeCode() {
		return makeCode;
	}

	public void setMakeCode(String makeCode) {
		this.makeCode = makeCode;
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

	public List<Variant> getVariants() {
		return variants;
	}

	public void setVariants(List<Variant> variants) {
		this.variants = variants;
	}
}
