package pojo.sendOTP;

public class SendOTPRequest {

	private String mobileNo;
	private String appId;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public SendOTPRequest() {
	}

	/**
	 *
	 * @param appId
	 * @param mobileNo
	 */
	public SendOTPRequest(String mobileNo, String appId) {
		super();
		this.mobileNo = mobileNo;
		this.appId = appId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

}
