package pojo.fetchDealerList;

import java.util.List;

public class Data {

	private Integer cityGroupId;
	private List<Detail> details = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Data() {
	}

	/**
	 *
	 * @param cityGroupId
	 * @param details
	 */
	public Data(Integer cityGroupId, List<Detail> details) {
		super();
		this.cityGroupId = cityGroupId;
		this.details = details;
	}

	public Integer getCityGroupId() {
		return cityGroupId;
	}

	public void setCityGroupId(Integer cityGroupId) {
		this.cityGroupId = cityGroupId;
	}

	public List<Detail> getDetails() {
		return details;
	}

	public void setDetails(List<Detail> details) {
		this.details = details;
	}

}
