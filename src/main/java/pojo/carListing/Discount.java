package pojo.carListing;

public class Discount {

	private String type;
	private Float value;
	private Object gst;
	private String desc;
	private Float valueWithGST;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Discount() {
	}

	/**
	 *
	 * @param type
	 * @param value
	 */
	public Discount(String type, Float value, Object gst, String desc, Float valueWithGST) {
		super();
		this.type = type;
		this.value = value;
		this.gst = gst;
		this.desc = desc;
		this.valueWithGST = valueWithGST;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Object getGst() {
		return gst;
	}

	public void setGst(Object gst) {
		this.gst = gst;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Float getValueWithGST() {
		return valueWithGST;
	}

	public void setValueWithGST(Float valueWithGST) {
		this.valueWithGST = valueWithGST;
	}

}