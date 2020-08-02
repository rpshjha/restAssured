package pojo.carListing;

import java.util.List;
import pojo.common.Error;

public class VehicleListResponse {
	private Boolean error;
	private List<Error> errors = null;
	private Data data;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public VehicleListResponse() {
	}

	/**
	 *
	 * @param data
	 * @param error
	 * @param errors
	 */
	public VehicleListResponse(Boolean error, List<Error> errors, Data data) {
		super();
		this.error = error;
		this.errors = errors;
		this.data = data;
	}

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public Object getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

}
