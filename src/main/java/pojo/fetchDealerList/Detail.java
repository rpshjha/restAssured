package pojo.fetchDealerList;

import java.util.List;

public class Detail {
	private String stateCode;
	private String stateName;
	private List<City> cities = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Detail() {
	}

	/**
	 *
	 * @param cities
	 * @param stateName
	 * @param stateCode
	 */
	public Detail(String stateCode, String stateName, List<City> cities) {
		super();
		this.stateCode = stateCode;
		this.stateName = stateName;
		this.cities = cities;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
}
