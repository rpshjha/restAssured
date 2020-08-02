package pojo.common;

public class Error {

	private String errorCode;
	private String errorMessage;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Error() {
	}

	/**
	 *
	 * @param errorMessage
	 * @param errorCode
	 */
	public Error(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
