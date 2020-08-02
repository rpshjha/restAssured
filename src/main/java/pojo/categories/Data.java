package pojo.categories;

public class Data {

	private VehicleCategoryAndAttributesResponseTO vehicleCategoryAndAttributesResponseTO;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Data() {
	}

	/**
	 *
	 * @param vehicleCategoryAndAttributesResponseTO
	 */
	public Data(VehicleCategoryAndAttributesResponseTO vehicleCategoryAndAttributesResponseTO) {
		super();
		this.vehicleCategoryAndAttributesResponseTO = vehicleCategoryAndAttributesResponseTO;
	}

	public VehicleCategoryAndAttributesResponseTO getVehicleCategoryAndAttributesResponseTO() {
		return vehicleCategoryAndAttributesResponseTO;
	}

	public void setVehicleCategoryAndAttributesResponseTO(
			VehicleCategoryAndAttributesResponseTO vehicleCategoryAndAttributesResponseTO) {
		this.vehicleCategoryAndAttributesResponseTO = vehicleCategoryAndAttributesResponseTO;
	}

}
