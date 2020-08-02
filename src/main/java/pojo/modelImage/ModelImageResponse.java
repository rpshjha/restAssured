package pojo.modelImage;

public class ModelImageResponse {
	private Boolean error;
	private Object errors;
	private Data data;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ModelImageResponse() {
	}

	/**
	 *
	 * @param data
	 * @param error
	 * @param errors
	 */
	public ModelImageResponse(Boolean error, Object errors, Data data) {
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

	public void setErrors(Object errors) {
		this.errors = errors;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
}
