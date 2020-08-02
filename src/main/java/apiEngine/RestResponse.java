package apiEngine;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.addTestStepLog;

import org.apache.log4j.Logger;

import io.restassured.response.Response;

public class RestResponse<T> {

	private T data;
	private static Response response;
	private static Exception e;
	private static Logger log = Logger.getLogger(RestResponse.class);

	public RestResponse(Class<T> t, Response response) {
		RestResponse.response = response;
		try {
			this.data = t.newInstance();
		} catch (Exception e) {
			throw new RuntimeException("There should be a default constructor in the Response POJO");
		}
	}

	public String getContent() {
		return response.getBody().asString();
	}

	public int getStatusCode() {
		return response.getStatusCode();
	}

	public static boolean isSuccessful() {
		int code = response.getStatusCode();
		log.info("response status code is " + code);
		addTestStepLog("response status code is " + code);
		if (code == 200 || code == 201 || code == 202 || code == 203 || code == 204 || code == 205)
			return true;
		return false;
	}

	public String getStatusDescription() {
		return response.getStatusLine();
	}

	public Response getResponse() {
		return response;
	}

	public T getBody() {
		try {
			data = (T) response.getBody().as(data.getClass());
		} catch (Exception e) {
			this.e = e;
		}
		return data;
	}

	public Exception getException() {
		return e;
	}

	public void verifyResponseKeyValues(String key, String val, Response r) {
		String keyValue = r.jsonPath().getString(key);
		assertThat(keyValue, is(val));
	}

	public void verifyResponseStatusValue(Response response, int expectedCode) {
		assertThat(response.getStatusCode(), is(expectedCode));
	}

}
