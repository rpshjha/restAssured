package apiEngine;

import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.addTestStepLog;

import java.util.List;

import org.apache.log4j.Logger;

import enums.RequestType;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

	private static RequestSpecification request;
	private static Logger log = Logger.getLogger(RequestBuilder.class);

	private static RequestSpecification getRequest() {
		if (request == null)
			request = RestAssured.given().filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		return request;
	}

	/**
	 * 
	 * @param token
	 * @return
	 */
	public static RequestSpecification setAuthHeader(String token) {
		log.info("setting Authorization token as : " + token);
		addTestStepLog("setting Authorization token as : " + token);
		return getRequest().header(new Header("Authorization", token));
	}

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return {@link RequestSpecification}
	 */
	public static RequestSpecification setBasicAuthCredentials(String userName, String password) {
		log.info("setting basic authentication credentials");
		addTestStepLog("setting basic authentication credentials");
		return getRequest().auth().preemptive().basic(userName, password);
	}

	public static RequestSpecification setContentTypeAsJson() {
		log.info("setting content type as JSON");
		addTestStepLog("setting content type as JSON");
		return getRequest().header(new Header("Content-Type", "application/json"));
	}

	public static RequestSpecification setContentTypeAs(String value) {
		log.info("setting content type as " + value);
		addTestStepLog("setting content type as " + value);
		return getRequest().header(new Header("Content-Type", value));
	}

	public static RequestSpecification setAppID(String appID) {
		log.info("setting x-app-id as " + appID);
		addTestStepLog("setting x-app-id as " + appID);
		return getRequest().header(new Header("x-app-id", appID));
	}

	public static RequestSpecification setHeader(String key, String value) {
		log.info("setting header : " + key + "=" + value);
		addTestStepLog("setting header : " + key + "=" + value);
		return getRequest().header(new Header(key, value.trim()));
	}

	public static RequestSpecification setHeader(Header header) {
		log.info("setting header : " + header);
		addTestStepLog("setting header : " + header);
		return getRequest().header(header);
	}

	public static RequestSpecification setQueryParams(String key, Object value) {
		log.info("setting query params : " + key + "=" + value);
		addTestStepLog("setting query params : " + key + "=" + value);
		return getRequest().queryParam(key, value);
	}

	public static RequestSpecification setParams(String parameterName, Object parameterValues) {
		log.info("setting params : " + parameterName + "=" + parameterValues);
		addTestStepLog("setting params : " + parameterName + "=" + parameterValues);
		return getRequest().param(parameterName, parameterValues);
	}

	public static RequestSpecification withBody(Object value) {
		log.info("setting body : " + value);
		addTestStepLog("setting body : " + value);
		return getRequest().body(value);
	}

	/**
	 * reset request
	 */
	public static void resetRequest() {
		request = null;
	}

	/**
	 * 
	 * @param requestType
	 * @param url
	 * @param pojo
	 * @return {@link Response}
	 */
	public static Response createRequest(RequestType requestType, String url, Object pojo) {
		Response response = null;

		log.info("creating " + requestType + " request");
		addTestStepLog("creating " + requestType + " request");

		// Add the Json to the body of the request
		if (null != pojo) {
			log.info("setting " + pojo.getClass().getSimpleName() + " as body");
			addTestStepLog("setting " + pojo.getClass().getSimpleName() + " as body");
			getRequest().body(pojo);
		}

//		setContentTypeAsJson();

		// need to add a switch based on request type
		switch (requestType) {
		case GET:
			response = getRequest().get(url);
			break;
		case POST:
			response = getRequest().post(url);
			break;
		case DELETE:
			response = getRequest().delete(url);
			break;
		case PUT:
			response = getRequest().put(url);
			break;
		default:
			response = getRequest().post(url);
			break;
		}
		return response;
	}

	/**
	 * 
	 * @param requestType
	 * @param url
	 * @param pojo
	 * @param headerlist
	 * @return @return {@link Response}
	 */
	public static Response createRequest(RequestType requestType, String url, Object pojo, List<Header> headerlist) {
		Response response = null;

		log.info("creating " + requestType + " request");
		addTestStepLog("creating " + requestType + " request");

		// Add the Json to the body of the request
		if (null != pojo) {
			log.info("setting " + pojo.getClass().getSimpleName() + " as body");
			addTestStepLog("setting " + pojo.getClass().getSimpleName() + " as body");
			getRequest().body(pojo);
		}

//		setContentTypeAsJson();

		for (Header temp : headerlist)
			setHeader(temp);

		// need to add a switch based on request type
		switch (requestType) {
		case GET:
			response = getRequest().get(url);
			break;
		case POST:
			response = getRequest().post(url);
			break;
		case DELETE:
			response = getRequest().delete(url);
			break;
		case PUT:
			response = getRequest().put(url);
			break;
		default:
			response = getRequest().post(url);
			break;
		}
		return response;
	}

	/**
	 * 
	 * @param requestType
	 * @param url
	 * @return {@link Response}
	 */
	public static Response createRequest(RequestType requestType, String url) {
		Response response = null;

		log.info("creating " + requestType + " request");
		addTestStepLog("creating " + requestType + " request");

//		setContentTypeAsJson();

		// need to add a switch based on request type
		switch (requestType) {
		case GET:
			response = getRequest().get(url);
			break;
		case POST:
			response = getRequest().urlEncodingEnabled(false).post(url);
			break;
		case DELETE:
			response = getRequest().delete(url);
			break;
		case PUT:
			response = getRequest().put(url);
			break;
		default:
			response = getRequest().post(url);
			break;
		}
		return response;
	}

}
