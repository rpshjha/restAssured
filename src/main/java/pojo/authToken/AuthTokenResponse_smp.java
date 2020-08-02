package pojo.authToken;

public class AuthTokenResponse_smp {
	private String access_token;
	private Integer expires_in;
	private String token_type;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public AuthTokenResponse_smp() {
	}

	/**
	 *
	 * @param expires_in
	 * @param access_token
	 * @param token_type
	 */
	public AuthTokenResponse_smp(String access_token, Integer expires_in, String token_type) {
		super();
		this.access_token = access_token;
		this.expires_in = expires_in;
		this.token_type = token_type;
	}

	public String getAccessToken() {
		return access_token;
	}

	public void setAccessToken(String access_token) {
		this.access_token = access_token;
	}

	public Integer getExpiresIn() {
		return expires_in;
	}

	public void setExpiresIn(Integer expires_in) {
		this.expires_in = expires_in;
	}

	public String getTokenType() {
		return token_type;
	}

	public void setTokenType(String token_type) {
		this.token_type = token_type;
	}
}
