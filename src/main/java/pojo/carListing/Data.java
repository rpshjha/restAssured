package pojo.carListing;

import java.util.List;

public class Data {

	private List<Vehicle> vehicles = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Data() {
	}

	/**
	 *
	 * @param vehicles
	 */
	public Data(List<Vehicle> vehicles) {
		super();
		this.vehicles = vehicles;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
