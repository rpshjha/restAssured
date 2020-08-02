package pojo.fetchDealerList;

import java.util.List;

public class City {

	private String cityCode;
	private String cityName;
	private List<DealerList> dealerList = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public City() {
	}

	/**
	 *
	 * @param dealerList
	 * @param cityName
	 * @param cityCode
	 */
	public City(String cityCode, String cityName, List<DealerList> dealerList) {
		super();
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.dealerList = dealerList;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<DealerList> getDealerList() {
		return dealerList;
	}

	public void setDealerList(List<DealerList> dealerList) {
		this.dealerList = dealerList;
	}

}
