package pojo.vehicleAttributeMaster;

public class Variant {

	private String variantCode;
	private String variantDesc;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Variant() {
	}

	/**
	 *
	 * @param variantDesc
	 * @param variantCode
	 */
	public Variant(String variantCode, String variantDesc) {
		super();
		this.variantCode = variantCode;
		this.variantDesc = variantDesc;
	}

	public String getVariantCode() {
		return variantCode;
	}

	public void setVariantCode(String variantCode) {
		this.variantCode = variantCode;
	}

	public String getVariantDesc() {
		return variantDesc;
	}

	public void setVariantDesc(String variantDesc) {
		this.variantDesc = variantDesc;
	}

}
