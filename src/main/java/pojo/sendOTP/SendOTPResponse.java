package pojo.sendOTP;

import java.util.List;

import pojo.common.Error;

public class SendOTPResponse {
	private Boolean error;
	private List<Error> errors = null;
	private Object data;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public SendOTPResponse() {
	}

	/**
	 *
	 * @param data
	 * @param error
	 * @param errors
	 */
	public SendOTPResponse(Boolean error, List<Error> errors, Object data) {
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

	public List<pojo.common.Error> getErrors() {
		return errors;
	}

	public void setErrors(List<pojo.common.Error> errors) {
		this.errors = errors;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}