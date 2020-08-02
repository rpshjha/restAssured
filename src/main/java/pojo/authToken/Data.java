package pojo.authToken;

public class Data {

	private String idToken;
	private String accessToken;
	private String refreshToken;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Data() {
	}

	/**
	 *
	 * @param idToken
	 * @param accessToken
	 * @param refreshToken
	 */
	public Data(String idToken, String accessToken, String refreshToken) {
		super();
		this.idToken = idToken;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

	public String getIdToken() {
		return idToken;
	}

	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}
