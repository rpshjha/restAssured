package pojo.carListing;

import java.util.List;

public class BasePrice {
	
	private List<BreakUp> breakUp = null;
	private String desc;
	private Float total;
	private Float totalWithGST;

	/**
	* No args constructor for use in serialization
	*
	*/
	public BasePrice() {
	}

	/**
	*
	* @param breakUp
	* @param total
	* @param totalWithGST
	* @param desc
	*/
	public BasePrice(List<BreakUp> breakUp, String desc, Float total, Float totalWithGST) {
	super();
	this.breakUp = breakUp;
	this.desc = desc;
	this.total = total;
	this.totalWithGST = totalWithGST;
	}

	public List<BreakUp> getBreakUp() {
	return breakUp;
	}

	public void setBreakUp(List<BreakUp> breakUp) {
	this.breakUp = breakUp;
	}

	public String getDesc() {
	return desc;
	}

	public void setDesc(String desc) {
	this.desc = desc;
	}

	public Float getTotal() {
	return total;
	}

	public void setTotal(Float total) {
	this.total = total;
	}

	public Float getTotalWithGST() {
	return totalWithGST;
	}

	public void setTotalWithGST(Float totalWithGST) {
	this.totalWithGST = totalWithGST;
	}


}
