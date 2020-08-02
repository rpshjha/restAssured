package pojo.carListing;

public class BreakUp {

	private String type;
	private String desc;
	private Float value;
	private Float gst;
	private Float valueWithGST;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public BreakUp() {
	}

	/**
	 *
	 * @param valueWithGST
	 * @param gst
	 * @param type
	 * @param value
	 * @param desc
	 */
	public BreakUp(String type, String desc, Float value, Float gst, Float valueWithGST) {
		super();
		this.type = type;
		this.desc = desc;
		this.value = value;
		this.gst = gst;
		this.valueWithGST = valueWithGST;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Float getGst() {
		return gst;
	}

	public void setGst(Float gst) {
		this.gst = gst;
	}

	public Float getValueWithGST() {
		return valueWithGST;
	}

	public void setValueWithGST(Float valueWithGST) {
		this.valueWithGST = valueWithGST;
	}

}
