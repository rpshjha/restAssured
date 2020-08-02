package pojo.authToken;

public class AuthTokenRequest {

	private String appId;
	private String mobileNo;
	private String otp;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public AuthTokenRequest() {
	}

	/**
	 *
	 * @param appId
	 * @param otp
	 * @param mobileNo
	 */
	public AuthTokenRequest(String appId, String mobileNo, String otp) {
		this.appId = appId;
		this.mobileNo = mobileNo;
		this.otp = otp;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

}